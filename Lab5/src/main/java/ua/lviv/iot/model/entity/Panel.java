package ua.lviv.iot.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "panel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Panel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Integer id;

    @Column (name = "power_in_hour")
    @NotNull
    private Integer powerInHour;

    @Column (name = "panel_life")
    @NotNull
    private Integer panelLife;

    @Column(name = "type", length = 20,  nullable = false)
    @NotNull
    private String type;

    @Column (name = "angle_of_inclination")
    @NotNull
    private Integer angleOfInclination;

    @OneToOne
    @JoinColumn(name = "energy_id", referencedColumnName = "id", nullable = false)
    private Energy energy;

    @OneToMany(mappedBy = "panel", fetch = FetchType.LAZY)
    private Collection<SolarSystem> solarSystems;

    @Override
    public String toString() {
        return "Panel {"
                + "id =" + id + ", "
                + "Power in hour =" + powerInHour + ", "
                + "Pangel life = " + panelLife + ", "
                + "Type = " + type + ", "
                + "Angle of inclination = " + angleOfInclination + ", "
                + "EnergyId = " + energy.getId()
                + "};" + "\n";
    }
}
