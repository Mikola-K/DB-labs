package ua.lviv.iot.service;


import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.repository.BatteryRepository;

@AllArgsConstructor
@Service
public class BatteryService extends  AbstractService <Battery, Integer> {
    private final BatteryRepository batteryRepository;

    @Override
    protected JpaRepository <Battery, Integer> getRepository() {
        return batteryRepository;
    }
}
