package ua.lviv.iot.mapper;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.Adress;
import ua.lviv.iot.dto.AdressDto;

@Component
public class AdressMapper extends AbstractMapper<Adress, AdressDto> {

    @Override
    public AdressDto mapEntityToDto(Adress adress) {
        if (adress == null)
            return null;

        AdressDto.AdressDtoBuilder adressDtoBuilder = AdressDto.builder();
        adressDtoBuilder.id(adress.getId());
        adressDtoBuilder.street(adress.getStreet());
        adressDtoBuilder.city(adress.getCity());
        adressDtoBuilder.country(adress.getCountry());

        return adressDtoBuilder.build();
    }
}
