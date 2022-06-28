package ua.lviv.iot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatteryDto {
    private Integer id;
    private Integer chargeLevelPerHour;
    private Integer capacity;
    private Integer occupancy;
    private Integer durationOfUseMonths;
}