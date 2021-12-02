package ua.lviv.iot.service;


import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Adress;
import ua.lviv.iot.repository.AdressRepository;

@AllArgsConstructor
@Service
public class AdressService extends AbstractService <Adress, Integer> {
    private final AdressRepository adressRepository;

    @Override
    protected JpaRepository<Adress, Integer> getRepository() {
        return adressRepository;
    }
}
