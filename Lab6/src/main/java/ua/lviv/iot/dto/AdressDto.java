package ua.lviv.iot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdressDto {
    private Integer id;
    private String street;
    private String city;
    private String country;
}
