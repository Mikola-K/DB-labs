package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Panel;
import ua.lviv.iot.dto.PanelDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.PanelMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.PanelService;

@RequestMapping(value = "/panel")
@RestController
@AllArgsConstructor
public class PanelController extends AbstractController<Panel, PanelDto, Integer> {
    private final PanelService panelService;
    private final PanelMapper panelMapper;

    @Override
    protected AbstractService<Panel, Integer> getService() {
        return panelService;
    }

    @Override
    protected AbstractMapper<Panel, PanelDto> getMapper() {
        return panelMapper;
    }
}