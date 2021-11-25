package ua.lviv.iot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnergyDto {
    private Integer id;
    private Integer pricePerHour;
    private Integer energyTransfer;
}
