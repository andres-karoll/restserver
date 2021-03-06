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

    @ResponseBody
    @PostMapping(value = "/createPersonas",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPersonas(@RequestBody Persona per) {
        perS.save(per);
        return new ResponseEntity<>(per,HttpStatus.CREATED);
    }
    @PutMapping(value = "/editPersonas",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editPersonas(@RequestBody Persona per){
        if(perS.exists(per.getCc())){
            perS.save(per);
            return new ResponseEntity<>("Successfully updated Person with id" + per.getCc(),HttpStatus.ACCEPTED);
        }else{
            throw new PersonaNotFoundException();
        }
    }
    @DeleteMapping(value = "/deletePersonas/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deletePersonas(@PathVariable Integer id){
        if(perS.exists(id)){
            perS.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> findAll(){
        return  new ResponseEntity<>(perS.findAll(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Object>  findById(@PathVariable Integer id){
        if(perS.exists(id)){
            return new ResponseEntity<>(perS.findById(id),HttpStatus.ACCEPTED);
        }else{
            throw new PersonaNotFoundException();
        }
    }
    @GetMapping(value = "/count",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> countPersonas(){
        return new ResponseEntity<>(perS.count(),HttpStatus.OK);
    }

}
