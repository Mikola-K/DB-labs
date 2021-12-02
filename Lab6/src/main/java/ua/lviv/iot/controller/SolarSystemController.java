package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.SolarSystem;
import ua.lviv.iot.dto.SolarSystemDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.SolarSystemMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.SolarSystemService;

@RequestMapping(value = "/solarSystem")
@RestController
@AllArgsConstructor
public class SolarSystemController extends AbstractController<SolarSystem, SolarSystemDto, Integer> {
    private final SolarSystemService solarSystemService;
    private final SolarSystemMapper solarSystemMapper;

    @Override
    protected AbstractService<SolarSystem, Integer> getService() {
        return solarSystemService;
    }

    @Override
    protected AbstractMapper<SolarSystem, SolarSystemDto> getMapper() {
        return solarSystemMapper;
    }
}