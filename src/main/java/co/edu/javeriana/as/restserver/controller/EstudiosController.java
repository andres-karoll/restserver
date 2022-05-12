package co.edu.javeriana.as.restserver.controller;


import co.edu.javeriana.as.restserver.entity.Estudios;
import co.edu.javeriana.as.restserver.entity.Persona;
import co.edu.javeriana.as.restserver.exception.EstudioNotFoundException;
import co.edu.javeriana.as.restserver.exception.PersonaNotFoundException;
import co.edu.javeriana.as.restserver.exception.ProfesionNotFoundException;
import co.edu.javeriana.as.restserver.service.EstudiosService;
import co.edu.javeriana.as.restserver.service.PersonaService;
import co.edu.javeriana.as.restserver.service.ProfesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
@RequiredArgsConstructor
public class EstudiosController {
    private final EstudiosService estudiosService;
    private final PersonaService perS;
    private final ProfesionService profesionService;
    @PostMapping(value = "/createEstudios",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPersonas(@RequestBody Estudios est) {
        if(perS.exists(est.getCc_per())){
            if(profesionService.exists(est.getIdentificador())) {
                estudiosService.save(est);
                return new ResponseEntity<>("Successfully created with Id = " + est.getIdentificador(), HttpStatus.CREATED);
            }else{
                throw new ProfesionNotFoundException();
            }
        }else{
            throw new PersonaNotFoundException();
        }

    }
    @PutMapping("/editEstudios")
    public ResponseEntity<String> editPersonas(@RequestBody Estudios est){
        if(estudiosService.exists(est.getIdentificador())){
            estudiosService.save(est);
            return new ResponseEntity<>("Successfully updated Person with id" + est.getIdentificador(),HttpStatus.ACCEPTED);
        }else{
            throw new EstudioNotFoundException();
        }
    }
    @DeleteMapping("/deleteEstudios/{id}")
    public ResponseEntity<Object> deletePersonas(@PathVariable Integer id){
        if(estudiosService.exists(id)){
            perS.deleteById(id);
            return new ResponseEntity<>("Successfully deleted Person with id" + id,HttpStatus.ACCEPTED);
        }else {
            throw new EstudioNotFoundException();
        }
    }
    @GetMapping("/all")
    public List<Estudios> findAll(){
        return estudiosService.findAll();
    }
    @GetMapping("/find/{id}")
    public Persona findById(@PathVariable Integer id){
        if(estudiosService.exists(id)){
            return perS.findById(id).get();
        }else{
            throw new EstudioNotFoundException();
        }
    }
}
