package ua.lviv.iot.model.entity;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "battery")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Battery {
    @Id
    @Column(name = "id")
    @NotNull
    @NotInputtable
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
}