package ua.lviv.iot.model.entity;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "owner")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Owner {
    @Id
    @Column(name = "id")
    @NotNull
    @NotInputtable
    private Integer id;

    @Column (name = "name", length = 10)
    @NotNull
    private String name;

    @Column (name = "age")
    @NotNull
    private Integer age;
}
