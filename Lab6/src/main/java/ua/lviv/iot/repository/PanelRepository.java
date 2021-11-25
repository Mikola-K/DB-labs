package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Panel;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Integer> {
}
