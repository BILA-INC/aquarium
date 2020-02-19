package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.SpecyDao;
import com.devops.aquarium.model.Specy;
import com.devops.aquarium.web.exceptions.IdNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SpecyController {

    @Autowired
    private SpecyDao specyDao;

    @RequestMapping(value="/Species", method=RequestMethod.GET)
    public MappingJacksonValue findAllSpecies() {

        Iterable<Specy> specy= specyDao.findAll();

        //SimpleBeanPropertyFilter sorter = SimpleBeanPropertyFilter.serializeAllExcept("numSS");

        //FilterProvider sorterId = new SimpleFilterProvider().addFilter("Sorter", sorter);

        MappingJacksonValue spec = new MappingJacksonValue(specy);

        //emp.setFilters(sorterId);

        return spec;
    }

    @ApiOperation(value = "Send back a given specy as far as the provided Id is correct")
    @GetMapping(value = "/Species/{id}")
    public Optional<Specy> findSpecyById(@PathVariable int id) {
        Optional<Specy> specy = specyDao.findById(id);
        if(specy==null) throw new IdNotFoundException("Wrong Id"); //Customized exception throwing
        return specy;
    }

    @GetMapping(value = "/Species/GT/{id}")
    public List<Specy> findByIdGT(@PathVariable int id) {
        return specyDao.findByIdGreaterThan(id);
    }

    @GetMapping(value = "/Species/research/{search}")
    public List<Specy> findByNameLike(@PathVariable String search) {
        return specyDao.findByNameLike("%"+search+"%");
    }

    //Adding a new Employee
    @PostMapping(value = "/Species")
    public ResponseEntity<Object> saveSpecy(@Valid @RequestBody Specy specy) {

        Specy specyAdded =  specyDao.save(specy);

        if (specyAdded == null)
            return ResponseEntity.noContent().build(); //204 No Content in case of failure

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(specyAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping (value = "/Species/delete/{id}")
    public void deleteSpecy(@PathVariable int id) {
        specyDao.deleteById(id);
    }
    @PutMapping (value = "Species/update/employees")
    public void updateEmployee(@RequestBody Specy employee) {
        specyDao.save(employee);
    }
}
