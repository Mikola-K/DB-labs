package ua.lviv.iot.mapper;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.Owner;
import ua.lviv.iot.dto.OwnerDto;

@Component
public class OwnerMapper extends AbstractMapper<Owner, OwnerDto> {

    @Override
    public OwnerDto mapEntityToDto(Owner owner) {
        if (owner == null)
            return null;

        OwnerDto.OwnerDtoBuilder ownerDtoBuilder = OwnerDto.builder();
        ownerDtoBuilder.id(owner.getId());
        ownerDtoBuilder.name(owner.getName());
        ownerDtoBuilder.age(owner.getAge());

        return ownerDtoBuilder.build();
    }
}