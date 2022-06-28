package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Owner;
import ua.lviv.iot.dto.OwnerDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.OwnerMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.OwnerService;

@RequestMapping(value = "/owner")
@RestController
@AllArgsConstructor
public class OwnerController extends AbstractController<Owner, OwnerDto, Integer> {
    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;

    @Override
    protected AbstractService<Owner, Integer> getService() {
        return ownerService;
    }

    @Override
    protected AbstractMapper<Owner, OwnerDto> getMapper() {
        return ownerMapper;
    }
}