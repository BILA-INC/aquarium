package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.ActivityDao;
import com.devops.aquarium.model.Activity;
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

@Api( description="API for, inter allia, CRUD-related operations on activities.")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;

    @RequestMapping(value="all/activity", method= RequestMethod.GET)
    public Iterable<Activity> findAllActivities() {
        return activityDao.findAll();
    }

    @ApiOperation(value = "Send back a given activity")
    @GetMapping(value = "all/activity/{id}")
    public Activity findActivityById(@PathVariable int id) {
        Activity activity=activityDao.findById(id);
        if(activity==null) throw new IdNotFoundException("Wrong Id"); //Customized exception throwing
        return activity;
    }

    @PostMapping(value = "add/activity",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> saveActivity(@Valid @RequestBody Activity activity) {

        Activity activityAdded =  activityDao.save(activity);
        if (activityAdded == null)
            return ResponseEntity.noContent().build(); //204 No Content (in case of failure)
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/all/activity/{id}")
                .buildAndExpand(activityAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build(); //201 Code : successful operation
    }

    @DeleteMapping (value = "delete/activity/{id}")
    public void deleteActivity(@PathVariable int id) {
        activityDao.deleteById(id);
    }

    @PutMapping (value = "update/activity",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Activity updateActivity(@Valid @RequestBody Activity activity) {
        return activityDao.save(activity);
    }
}
