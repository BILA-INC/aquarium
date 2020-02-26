package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.SpecyDao;
import com.devops.aquarium.model.Specy;
import com.devops.aquarium.web.exceptions.BRException;
import com.devops.aquarium.web.exceptions.ISException;
import com.devops.aquarium.web.exceptions.IdNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Api( description="API for, inter allia, CRUD-related operations on species.")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SpecyController {

    @Autowired
    private SpecyDao specyDao;

    @RequestMapping(value="all/specy", method= RequestMethod.GET)
    public Iterable<Specy> findAllSpecies() {
        List<Specy> specy = specyDao.findAll();
        if(specy == null) throw new ISException("I_S");//Customized 500
        return specy;
    }

    @ApiOperation(value = "Send back a given specy as far as the provided Id is correct")
    @GetMapping(value = "all/specy/{id}")
    public Specy findSpecyById(@PathVariable int id) {
        Specy specy=specyDao.findById(id);
        if(specy==null) throw new IdNotFoundException("Wrong Id"); //Customized exception throwing
        return specy;
    }

    @PostMapping(value = "add/specy",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> saveSpecy(@Valid @RequestBody Specy specy) {

        Specy specyAdded =  specyDao.save(specy);
        if (specyAdded == null)
            return ResponseEntity.noContent().build(); //204 No Content (in case of failure)
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/all/specy/{id}")
                .buildAndExpand(specyAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build(); //201 Code : successful operation
    }

    @DeleteMapping (value = "delete/specy/{id}")
    public void deleteSpecy(@PathVariable int id) {

        Specy specy=specyDao.findById(id);
        if(specy==null) throw new IdNotFoundException("Wrong Id"); //Customized exception encompassing '404 NOT FOUND' case
        specyDao.deleteById(id);
    }

    @PutMapping (value = "update/specy",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Specy updateSpecy(@Valid @RequestBody Specy specy) {

        Specy specyA=specyDao.findById(specy.getId());
        if (specyA==null) throw new IdNotFoundException("Wrong Id"); //Customized exception encompassing '404 NOT FOUND' case
        Specy specyT=specyDao.save(specy);
        if (specyT==null) throw new BRException("BR"); //Customized 400
        return specyT;
    }

}
