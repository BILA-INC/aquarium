package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.ActivityDao;
import com.devops.aquarium.model.Activity;
import com.devops.aquarium.web.exceptions.BRException;
import com.devops.aquarium.web.exceptions.ISException;
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
import java.util.List;

@Api( description="API for, inter allia, CRUD-related operations on activities.")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;

    @RequestMapping(value="all/activity", method= RequestMethod.GET)
    public Iterable<Activity> findAllActivities() {

        List<Activity> activity = activityDao.findAll();
        if(activity == null) throw new ISException("I_S");//Customized 500
        return activity;
    }

    @ApiOperation(value = "Send back a given activity")
    @GetMapping(value = "all/activity/{id}")
    public Activity findActivityById(@PathVariable int id) {
        Activity activity=activityDao.findById(id);
        if(activity==null) throw new IdNotFoundException("Wrong Id"); //Customized exception encompassing '404 NOT FOUND' case
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

        Activity activity=activityDao.findById(id);
        if(activity==null) throw new IdNotFoundException("Wrong Id"); //Customized exception encompassing '404 NOT FOUND' case
        activityDao.deleteById(id);
    }

    @PutMapping (value = "update/activity",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Activity updateActivity(@Valid @RequestBody Activity activity) {

        Activity activityA=activityDao.findById(activity.getId());
        if (activityA==null) throw new IdNotFoundException("Wrong Id"); //Customized exception encompassing '404 NOT FOUND' case
        Activity activityT=activityDao.save(activity);
        if (activityT==null) throw new BRException("BR"); //Customized 400
        return activityT;
    }
}
