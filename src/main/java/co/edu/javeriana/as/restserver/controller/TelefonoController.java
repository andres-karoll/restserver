package co.edu.javeriana.as.restserver.controller;

import co.edu.javeriana.as.restserver.entity.Telefono;
import co.edu.javeriana.as.restserver.exception.PersonaNotFoundException;
import co.edu.javeriana.as.restserver.exception.TelefonoNotFoundException;
import co.edu.javeriana.as.restserver.service.PersonaService;
import co.edu.javeriana.as.restserver.service.TelefonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefono")
@RequiredArgsConstructor
public class TelefonoController {
    private final TelefonoService telefonoService;
    private final PersonaService personaService;
    @PostMapping("/createTelefono")
    public ResponseEntity<Object> createTelefono(@RequestBody Telefono t){
        if(personaService.exists(t.getDuenio())){
            telefonoService.save(t);
            return new ResponseEntity<>("Successfully created with Id = "+ t.getNumero(), HttpStatus.CREATED);
        }else{
            throw new PersonaNotFoundException();
        }
    }
    @PutMapping("/editTelefono")
    public ResponseEntity<Object> editTelefono(@RequestBody Telefono t){
        if(personaService.exists(t.getDuenio())){
            telefonoService.save(t);
            return new ResponseEntity<>("Successfully created with Id = "+ t.getNumero(), HttpStatus.ACCEPTED);
        }else{
            throw new TelefonoNotFoundException();
        }
    }
    @DeleteMapping("deleteTelefono/{id}")
    public ResponseEntity<Object> deletePersonas(@PathVariable Integer id){
        if(telefonoService.exists(id)){
            telefonoService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted with Id = "+ id, HttpStatus.ACCEPTED);
        }else {
            throw new TelefonoNotFoundException();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Telefono>> findAll(){
        return new ResponseEntity<>(telefonoService.findAll(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Telefono> findById(@PathVariable Integer id){
       if(telefonoService.exists(id)){
           return new ResponseEntity<>(telefonoService.findById(id).get(), HttpStatus.ACCEPTED);
       }else{
           throw new TelefonoNotFoundException();
       }
    }


}
