package ua.lviv.iot.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Owner;
import ua.lviv.iot.repository.OwnerRepository;

@AllArgsConstructor
@Service
public class OwnerService extends AbstractService <Owner, Integer> {
    private final OwnerRepository ownerRepository;

    @Override
    protected JpaRepository <Owner, Integer> getRepository() {
        return ownerRepository;
    }
}
