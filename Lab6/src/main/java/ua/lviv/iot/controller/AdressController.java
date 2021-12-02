package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Adress;
import ua.lviv.iot.dto.AdressDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.AdressMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.AdressService;

@RequestMapping(value = "/adress")
@RestController
@AllArgsConstructor
public class AdressController extends AbstractController<Adress, AdressDto, Integer> {
    private final AdressService adressService;
    private final AdressMapper adressMapper;

    @Override
    protected AbstractService<Adress, Integer> getService() {
        return adressService;
    }

    @Override
    protected AbstractMapper<Adress, AdressDto> getMapper() {
        return adressMapper;
    }
}
