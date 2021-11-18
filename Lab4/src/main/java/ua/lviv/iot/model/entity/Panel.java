package ua.lviv.iot.model.entity;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "panel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Panel {
    @Id
    @Column(name = "id")
    @NotNull
    @NotInputtable
    private Integer id;

    @Column (name = "power_in_hour")
    @NotNull
    private Integer powerInHour;

    @Column (name = "panel_life")
    @NotNull
    private Integer panelLife;

    @Column(name = "type", length = 20)
    @NotNull
    private String type;

    @Column (name = "angle_of_inclination")
    @NotNull
    private Integer angleOfInclination;

    @Column (name = "energy_id")
    @NotNull
    private Integer energyId;
}
