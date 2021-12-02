package ua.lviv.iot.mapper;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.dto.BatteryDto;

@Component
public class BatteryMapper extends AbstractMapper<Battery, BatteryDto> {

    @Override
    public BatteryDto mapEntityToDto(Battery battery) {
        if (battery == null)
            return null;

        BatteryDto.BatteryDtoBuilder batteryDtoBuilder = BatteryDto.builder();
        batteryDtoBuilder.id(battery.getId());
        batteryDtoBuilder.capacity(battery.getCapacity());
        batteryDtoBuilder.chargeLevelPerHour(battery.getChargeLevelPerHour());
        batteryDtoBuilder.durationOfUseMonths((battery.getDurationOfUseMonths()));
        batteryDtoBuilder.occupancy(battery.getOccupancy());

        return batteryDtoBuilder.build();
    }
}
