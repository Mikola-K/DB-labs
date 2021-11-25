package ua.lviv.iot.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Energy;
import ua.lviv.iot.repository.EnergyRepository;

@AllArgsConstructor
@Service
public class EnergyService extends  AbstractService <Energy, Integer> {
    private final EnergyRepository energyRepository;

    @Override
    protected JpaRepository <Energy, Integer> getRepository() {
        return energyRepository;
    }
}
