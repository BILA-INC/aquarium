package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.AnimalDao;
import com.devops.aquarium.model.Animal;
import com.devops.aquarium.web.exceptions.IdNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;


@Api( description="API for, inter allia, CRUD-related operations Animal type")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalController {

    @Autowired
    private AnimalDao animalDao;

    @RequestMapping(value="all/animal", method= RequestMethod.GET)
    public Iterable<Animal> findAllAnimals() {
        Iterable<Animal> animals= animalDao.findAll();
        return animals;
    }

    @ApiOperation(value = "Send back a given animal as far as the provided Id is correct")
    @GetMapping(value = "all/animal/{id}")
    public Animal findAnimalById(@PathVariable int id) {
        Animal animal=animalDao.findById(id);
        if(animal==null) throw new IdNotFoundException("Wrong Id"); //Customized exception throwing
        return animal;
    }

    @PostMapping(value = "add/animal",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> saveAnimal(@Valid @RequestBody Animal animal) {

        Animal animalAdded =  animalDao.save(animal);
        if (animalAdded == null)
            return ResponseEntity.noContent().build(); //204 No Content (in case of failure)
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/all/animal/{id}")
                .buildAndExpand(animalAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build(); //201 Code : successful operation
    }

    @DeleteMapping (value = "delete/animal/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animalDao.deleteById(id);
    }

    @PutMapping (value = "update/animal",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Animal updateAnimal(@Valid @RequestBody Animal animal) {
        return animalDao.save(animal);
    }

}
