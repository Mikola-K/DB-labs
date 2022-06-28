package ua.lviv.iot.mapper;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.Panel;
import ua.lviv.iot.dto.PanelDto;

@Component
public class PanelMapper extends AbstractMapper<Panel, PanelDto> {

    @Override
    public PanelDto mapEntityToDto(Panel panel) {
        if (panel == null)
            return null;

        PanelDto.PanelDtoBuilder panelDtoBuilder = PanelDto.builder();
        panelDtoBuilder.id(panel.getId());
        panelDtoBuilder.powerInHour(panel.getPowerInHour());
        panelDtoBuilder.panelLife(panel.getPanelLife());
        panelDtoBuilder.type(panel.getType());
        panelDtoBuilder.angleOfInclination(panel.getAngleOfInclination());

        return panelDtoBuilder.build();
    }
}