package ua.lviv.iot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "owner")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Integer id;

    @Column (name = "name", length = 10, nullable = false)
    @NotNull
    private String name;

    @Column (name = "age")
    @NotNull
    private Integer age;
/*
    public Owner(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
*/
    @Override
    public String toString() {
        return "Owner {"
                + "id =" + id + ", "
                + "Name =" + name + ", "
                + "Age =" + age
                + "};" + "\n";
    }
}
