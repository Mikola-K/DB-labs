package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "solar_system")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class SolarSystem {
    @Id
    @Column(name = "id")
    @NotNull
    private Integer id;

    @Column (name = "power")
    @NotNull
    private Integer power;

    @ManyToOne
    @JoinColumn(name = "panel_id", referencedColumnName = "id", nullable = false)
    private Panel panel;

    @ManyToOne
    @JoinColumn(name = "battery_id", referencedColumnName = "id", nullable = false)
    private Battery battery;

    @ManyToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "id", nullable = false)
    private Adress adress;

    @Override
    public String toString() {
        return "SolarSystem {"
                + "id =" + id + ", "
                + "Power =" + power + ", "
                + "PanelId = " + panel.getId() + ", "
                + "BatteryId = " + battery.getId() + ", "
                + "AddressId = " + adress.getId()
                + "};" + "\n";
    }
}
