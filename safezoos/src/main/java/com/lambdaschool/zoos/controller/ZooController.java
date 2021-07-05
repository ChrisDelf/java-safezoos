package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    // GET: localhost:2019/zoos
    @GetMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

// GET: localhost:2019/zoos/{id}

    @GetMapping( value = "/{id}",
    produces = {"application/json"})
    public ResponseEntity<?> findZoo( @PathVariable
                                                  Long id)
    {
        return new ResponseEntity<>(zooService.findZooById(id), HttpStatus.OK);
    }

    // get localhost:2019/zoos/byname/Gladys Porter Zoo
    @GetMapping( value = "/byname/{name}",
            produces = {"application/json"})
    public ResponseEntity<?> findZooWithName( @PathVariable
                                              String name)
    {
        return new ResponseEntity<>(zooService.findZooByName(name), HttpStatus.OK);
    }

}
