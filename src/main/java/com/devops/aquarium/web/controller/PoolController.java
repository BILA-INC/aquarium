package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.PoolDao;
import com.devops.aquarium.model.Pool;
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

@Api( description="API for, inter allia, CRUD-related operations on pools.")
@RestController
public class PoolController {

    @Autowired
    private PoolDao poolDao;

    @RequestMapping(value="all/pool", method= RequestMethod.GET)
    public Iterable<Pool> findAllPools() {
        Iterable<Pool> pools= poolDao.findAll();
        return pools;
    }

    @ApiOperation(value = "Send back a given pool")
    @GetMapping(value = "all/pool/{id}")
    public Pool findPoolById(@PathVariable int id) {
        Pool pool=poolDao.findById(id);
        if(pool==null) throw new IdNotFoundException("Wrong Id"); //Customized exception throwing
        return pool;
    }

    @PostMapping(value = "add/pool",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> savePool(@Valid @RequestBody Pool pool) {

        Pool poolAdded =  poolDao.save(pool);
        if (poolAdded == null)
            return ResponseEntity.noContent().build(); //204 No Content (in case of failure)
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/all/pool/{id}")
                .buildAndExpand(poolAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build(); //201 Code : successful operation
    }

    @DeleteMapping (value = "delete/pool/{id}")
    public void deletePool(@PathVariable int id) {
        poolDao.deleteById(id);
    }

    @PutMapping (value = "update/pool",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Pool updatePool(@Valid @RequestBody Pool pool) {
        return poolDao.save(pool);
    }

}