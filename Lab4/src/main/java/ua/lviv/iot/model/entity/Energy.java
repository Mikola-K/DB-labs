package ua.lviv.iot.model.entity;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "energy")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Energy {
    @Id
    @Column(name = "id")
    @NotNull
    @NotInputtable
    private Integer id;

    @Column (name = "price_per_hour")
    @NotNull
    private Integer pricePerHour;

    @Column (name = "energy_transfer")
    @NotNull
    private Integer energyTransfer;
}