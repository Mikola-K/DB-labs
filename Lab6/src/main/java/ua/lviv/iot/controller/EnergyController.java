package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Energy;
import ua.lviv.iot.dto.EnergyDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.EnergyMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.EnergyService;


@RequestMapping(value = "/energy")
@RestController
@AllArgsConstructor
public class EnergyController extends AbstractController<Energy, EnergyDto, Integer> {
    private final EnergyService energyService;
    private final EnergyMapper energyMapper;

    @Override
    protected AbstractService<Energy, Integer> getService() {
        return energyService;
    }

    @Override
    protected AbstractMapper<Energy, EnergyDto> getMapper() {
        return energyMapper;
    }
}