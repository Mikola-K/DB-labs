package ua.lviv.iot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "adress")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NotNull
@EqualsAndHashCode(of = "id")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "street", length = 25, nullable = false)
    @NotNull
    private String street;

    @Column (name = "city", length = 25, nullable = false)
    @NotNull
    private String city;

    @Column(name = "country", length = 45, nullable = false)
    @NotNull
    private String country;

    @OneToMany(mappedBy = "adress", fetch = FetchType.LAZY)
    private Collection<SolarSystem> solarSystems;

    public Adress(Integer id, String street, String city, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address {"
                + "id =" + id + ", "
                + "street =" + street + ", "
                + "street =" + city + ", "
                + "city = " + country
                + "};" + "\n";
    }
}
