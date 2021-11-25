package ua.lviv.iot.mapper;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.SolarSystem;
import ua.lviv.iot.dto.SolarSystemDto;

@Component
public class SolarSystemMapper extends AbstractMapper<SolarSystem, SolarSystemDto> {

    @Override
    public SolarSystemDto mapEntityToDto(SolarSystem solarSystem) {
        if (solarSystem == null)
            return null;

        SolarSystemDto.SolarSystemDtoBuilder solarSystemDtoBuilder = SolarSystemDto.builder();
        solarSystemDtoBuilder.id(solarSystem.getId());
        solarSystemDtoBuilder.power(solarSystem.getPower());

        return solarSystemDtoBuilder.build();
    }
}