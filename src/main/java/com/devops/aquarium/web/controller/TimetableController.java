package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.TimetableDao;
import com.devops.aquarium.model.Timetable;
import com.devops.aquarium.web.exceptions.BRException;
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

@Api( description="API for, inter allia, CRUD-related operations on timetables.")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimetableController {

    @Autowired
    private TimetableDao timetableDao;

    @RequestMapping(value="all/timetable", method= RequestMethod.GET)
    public Iterable<Timetable> findAllTimetables() {
        return timetableDao.findAll();
    }

    @ApiOperation(value = "Send back a given timetable")
    @GetMapping(value = "all/timetable/{id}")
    public Timetable findTimetableById(@PathVariable int id) {
        Timetable timetable=timetableDao.findById(id);
        if(timetable==null) throw new IdNotFoundException("Wrong Id"); //Customized exception throwing
        return timetable;
    }

    @PostMapping(value = "add/timetable",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> saveTimetable(@Valid @RequestBody Timetable timetable) {

        Timetable timetableAdded =  timetableDao.save(timetable);
        if (timetableAdded == null)
            return ResponseEntity.noContent().build(); //204 No Content (in case of failure)
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/all/timetable/{id}")
                .buildAndExpand(timetableAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build(); //201 Code : successful operation
    }

    @DeleteMapping (value = "delete/timetable/{id}")
    public void deleteTimetable(@PathVariable int id) {

        Timetable timetable=timetableDao.findById(id);
        if(timetable==null) throw new IdNotFoundException("Wrong Id"); //Customized exception encompassing '404 NOT FOUND' case
        timetableDao.deleteById(id);
    }

    @PutMapping (value = "update/timetable",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Timetable updateTimetable(@Valid @RequestBody Timetable timetable) {

        Timetable timetableA=timetableDao.findById(timetable.getId());
        if (timetableA==null) throw new IdNotFoundException("Wrong Id"); //Customized exception encompassing '404 NOT FOUND' case
        Timetable timetableT=timetableDao.save(timetable);
        if (timetableT==null) throw new BRException("BR"); //Customized 400
        return timetableT;
    }
}
