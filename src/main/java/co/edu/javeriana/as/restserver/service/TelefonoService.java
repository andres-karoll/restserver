package co.edu.javeriana.as.restserver.service;

import co.edu.javeriana.as.restserver.entity.Telefono;
import co.edu.javeriana.as.restserver.repository.TelefonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelefonoService {
    private final TelefonoRepository telefonoRepository;

    public void save(Telefono t) {
        telefonoRepository.save(t);
    }

    public List<Telefono> findAll() {
        return telefonoRepository.findAll();
    }

    public Optional<Telefono> findById(Integer id) {
        return telefonoRepository.findById(id);
    }

    public void deleteById(Integer id) {
        telefonoRepository.deleteById(id);
    }

    public Boolean exists(Integer id) {
        return telefonoRepository.existsById(id);
    }

}
