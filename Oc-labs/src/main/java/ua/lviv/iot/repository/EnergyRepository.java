package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Energy;

@Repository
public interface EnergyRepository extends JpaRepository<Energy, Integer> {
}
