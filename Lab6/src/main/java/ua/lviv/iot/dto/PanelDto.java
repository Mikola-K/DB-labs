package ua.lviv.iot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PanelDto {
    private Integer id;
    private Integer powerInHour;
    private Integer panelLife;
    private String type;
    private Integer angleOfInclination;
}