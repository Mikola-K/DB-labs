package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
