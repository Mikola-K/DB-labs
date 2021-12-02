package ua.lviv.iot.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "energy")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Energy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "price_per_hour")
    private Integer pricePerHour;

    @Column (name = "energy_transfer")
    private Integer energyTransfer;

    @OneToOne(mappedBy = "energy", fetch = FetchType.LAZY)
    private Panel panel;

    public Energy(Integer id, Integer pricePerHour, Integer energyTransfer) {
        this.id = id;
        this.pricePerHour = pricePerHour;
        this.energyTransfer = energyTransfer;
    }

    @Override
    public String toString() {
        return "Energy {"
                + "id =" + id + ", "
                + "Price on hour =" + pricePerHour + ", "
                + "Energy Transfer = " + energyTransfer
                + "};" + "\n";
    }
}