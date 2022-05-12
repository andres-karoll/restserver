package co.edu.javeriana.as.restserver.controller;

import co.edu.javeriana.as.restserver.entity.Persona;
import co.edu.javeriana.as.restserver.exception.PersonaNotFoundException;
import co.edu.javeriana.as.restserver.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController  {
    private final PersonaService perS;


    @PostMapping(value = "/createPersonas",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPersonas(@RequestBody Persona per) {
        perS.save(per);
        return new ResponseEntity<>(per,HttpStatus.CREATED);
    }
    @PutMapping("/editPersonas")
    public ResponseEntity<String> editPersonas(@RequestBody Persona per){
        if(perS.exists(per.getCc())){
            perS.save(per);
            return new ResponseEntity<>("Successfully updated Person with id" + per.getCc(),HttpStatus.ACCEPTED);
        }else{
            throw new PersonaNotFoundException();
        }
    }
    @DeleteMapping("/deletePersonas/{id}")
    public ResponseEntity<Object> deletePersonas(@PathVariable Integer id){
        if(perS.exists(id)){
            perS.deleteById(id);
            return new ResponseEntity<>("Successfully deleted Person with id" + id,HttpStatus.ACCEPTED);
        }else {
            throw new PersonaNotFoundException();
        }
    }

    @GetMapping("/all")
    public List<Persona> findAll(){
        return perS.findAll();
    }
    @GetMapping("/find/{id}")
    public Persona findById(@PathVariable Integer id){
        if(perS.exists(id)){
            return perS.findById(id).get();
        }else{
            throw new PersonaNotFoundException();
        }
    }
    @GetMapping("/count")
    public ResponseEntity<Object> countPersonas(){
        return new ResponseEntity<>("Number of persona in database is: " +perS.count(),HttpStatus.OK);
    }

}
