package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "battery")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Integer id;

    @Column (name = "charge_level_per_hour")
    @NotNull
    private Integer chargeLevelPerHour;

    @Column (name = "capacity")
    @NotNull
    private Integer capacity;

    @Column(name = "occupancy")
    @NotNull
    private Integer occupancy;

    @Column(name = "duration_of_use_months")
    @NotNull
    private  Integer durationOfUseMonths;

    @OneToMany(mappedBy = "battery", fetch = FetchType.LAZY)
    private Collection<SolarSystem> solarSystems;

    public Battery(Integer id, Integer chargeLevelPerHour, Integer capacity, Integer occupancy, Integer durationOfUseMonths) {
        this.id = id;
        this.chargeLevelPerHour = chargeLevelPerHour;
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.durationOfUseMonths = durationOfUseMonths;
    }

    @Override
    public String toString() {
        return "Battery {"
                + "id =" + id + ", "
                + "Charge level per hour =" + chargeLevelPerHour + ", "
                + "Capacity =" + capacity + ", "
                + "Occupancy =" + occupancy + ", "
                + "Duration of use int a moths = " + durationOfUseMonths
                + "};" + "\n";
    }
}