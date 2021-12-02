package ua.lviv.iot.mapper;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.Energy;
import ua.lviv.iot.dto.EnergyDto;

@Component
public class EnergyMapper extends AbstractMapper<Energy, EnergyDto> {

    @Override
    public EnergyDto mapEntityToDto(Energy energy) {
        if (energy == null)
            return null;

        EnergyDto.EnergyDtoBuilder energyDtoBuilder = EnergyDto.builder();
        energyDtoBuilder.id(energy.getId());
        energyDtoBuilder.pricePerHour(energy.getPricePerHour());
        energyDtoBuilder.energyTransfer(energy.getEnergyTransfer());

        return energyDtoBuilder.build();
    }
}
