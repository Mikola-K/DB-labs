package ua.lviv.iot.model.entity;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "solar_system")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class SolarSystem {
    @Id
    @Column(name = "id")
    @NotNull
    @NotInputtable
    private Integer id;

    @Column (name = "power")
    @NotNull
    private Integer power;

    @Column (name = "panel_id")
    @NotNull
    private Integer panelId;

    @Column (name = "battery_id")
    @NotNull
    private Integer batteryId;

    @Column (name = "adress_id")
    @NotNull
    private Integer adressId;
}
