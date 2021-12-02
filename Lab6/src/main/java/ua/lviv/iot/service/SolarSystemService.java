package ua.lviv.iot.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.SolarSystem;
import ua.lviv.iot.repository.SolarSystemRepository;

@AllArgsConstructor
@Service
public class SolarSystemService extends AbstractService<SolarSystem, Integer> {
    private final SolarSystemRepository solarSystemRepository;

    @Override
    protected JpaRepository<SolarSystem, Integer> getRepository() {
        return solarSystemRepository;
    }
}
