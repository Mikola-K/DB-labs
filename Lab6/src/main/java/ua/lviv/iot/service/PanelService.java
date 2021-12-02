package ua.lviv.iot.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Panel;
import ua.lviv.iot.repository.PanelRepository;

@AllArgsConstructor
@Service
public class PanelService extends AbstractService <Panel, Integer> {
    private final PanelRepository panelRepository;

    @Override
    protected JpaRepository<Panel, Integer> getRepository() {
        return panelRepository;
    }
}
