package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.dto.BatteryDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.BatteryMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.BatteryService;

@RequestMapping(value = "/battery")
@RestController
@AllArgsConstructor
public class BatteryController extends AbstractController <Battery, BatteryDto, Integer> {
    private final BatteryService batteryService;
    private final BatteryMapper batteryMapper;

    @Override
    protected AbstractService<Battery, Integer> getService() {
        return batteryService;
    }

    @Override
    protected AbstractMapper<Battery, BatteryDto> getMapper() {
        return batteryMapper;
    }
}
