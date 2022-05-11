package co.edu.javeriana.as.restserver.service;


import co.edu.javeriana.as.restserver.entity.Profesion;

import co.edu.javeriana.as.restserver.repository.ProfesionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesionService {
    private final ProfesionRepository profesionRepository;

    public void save(Profesion profesion){
        profesionRepository.save(profesion);
    }
    public List<Profesion> findAll(){
        return profesionRepository.findAll();
    }
    public Optional<Profesion> findById(Integer id){
        return profesionRepository.findById(id);
    }
    public void deleteById(Integer id){
        profesionRepository.deleteById(id);
    }
    public Boolean exists(Integer id){
        return profesionRepository.existsById(id);
    }
}
