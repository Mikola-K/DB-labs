package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Battery;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Integer> {
}
