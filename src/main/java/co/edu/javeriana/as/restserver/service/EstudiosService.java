package co.edu.javeriana.as.restserver.service;

import co.edu.javeriana.as.restserver.entity.Estudios;
import co.edu.javeriana.as.restserver.repository.EstudiosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudiosService {
    private final EstudiosRepository estudiosRepository;

    public void save(Estudios e) {
        estudiosRepository.save(e);
    }

    public List<Estudios> findAll() {
        return estudiosRepository.findAll();
    }

    public Optional<Estudios> findById(Integer id) {
        return estudiosRepository.findById(id);
    }

    public void deleteById(Integer id) {
        estudiosRepository.deleteById(id);
    }

    public Boolean exists(Integer id) {
        return estudiosRepository.existsById(id);
    }


}
