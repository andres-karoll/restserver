package co.edu.javeriana.as.restserver.controller;

import co.edu.javeriana.as.restserver.entity.Profesion;
import co.edu.javeriana.as.restserver.exception.ProfesionNotFoundException;
import co.edu.javeriana.as.restserver.service.ProfesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesion")
@RequiredArgsConstructor
public class ProfesionController {
    ProfesionService profesionService;

    @PostMapping("/createProfesion")
    public ResponseEntity<Object> createProfesion(@RequestBody Profesion p){
        profesionService.save(p);
        return new ResponseEntity<>("Successfully created with Id = "+ p.getId(), HttpStatus.CREATED);
    }
    @PutMapping("/editProfesion")
    public ResponseEntity<Object> editProfesion(@RequestBody Profesion p){
        if(profesionService.exists(p.getId())){
            profesionService.save(p);
            return new ResponseEntity<>("Successfully updated with Id = "+ p.getId(),HttpStatus.ACCEPTED);
        }else{
            throw new ProfesionNotFoundException();
        }
    }
    @DeleteMapping("/deleteProfesion")
    public ResponseEntity<Object> deleteProfesion(@PathVariable Integer id){
        if(profesionService.exists(id)){
            profesionService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted Profession with id" + id,HttpStatus.ACCEPTED);
        }else{
            throw new ProfesionNotFoundException();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Profesion>> findAllProfesion(){
        return new ResponseEntity<>(profesionService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Profesion> findProfesionById(@PathVariable Integer id){
        if(profesionService.exists(id)){
            return new ResponseEntity<>(profesionService.findById(id).get(),HttpStatus.ACCEPTED);
        }else{
            throw new ProfesionNotFoundException();
        }
    }
}
