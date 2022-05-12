package co.edu.javeriana.as.restserver.service;

import co.edu.javeriana.as.restserver.entity.Persona;
import co.edu.javeriana.as.restserver.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService {
    private final PersonaRepository personaRep;

    public void save(Persona persona) {
        personaRep.save(persona);
    }

    public List<Persona> findAll() {
        return personaRep.findAll();
    }

    public Optional<Persona> findById(Integer id) {
        return personaRep.findById(id);
    }

    public void deleteById(Integer id) {
        personaRep.deleteById(id);
    }

    public Boolean exists(Integer id) {
        return personaRep.existsById(id);
    }

    public Long count() {
        return personaRep.count();
    }
}

