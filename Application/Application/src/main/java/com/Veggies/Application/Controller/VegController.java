package com.Veggies.Application.Controller;


import com.Veggies.Application.Exceptions.Vegetablenotfound;
import com.Veggies.Application.Exceptions.Veggieexists;
import com.Veggies.Application.Model.Vegetable;
import com.Veggies.Application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addveg")
public class VegController {
    private final PlaygroundService service;

    @Autowired
    private UserService US;


    @Autowired
    public VegController(PlaygroundService service) {
        this.service = service;
    }

    // http://localhost:7300/addveg/vegetable   [get]
    @GetMapping("/vegetable")
    public ResponseEntity<List<Vegetable>> getAllVeg(){
        return new ResponseEntity<List<Vegetable>>(US.getAllVegetables(), HttpStatus.OK);
    }

    // http://localhost:7300/addveg/oneVeg/{id}  [get]
    @GetMapping("/oneVeg/{id}")
    public Vegetable getOneVeg(@PathVariable String id) throws Vegetablenotfound {
       // service.expiry(id);
        return US.getVeg(id);
    }


    // http://localhost:7300/addveg/veg   [post]
    @PostMapping("/veg")
    public ResponseEntity<Vegetable> saveProduct(@RequestBody Vegetable vegetable) throws Veggieexists {
        return new ResponseEntity<Vegetable>(US.addVeg(vegetable),HttpStatus.CREATED);
    }

    // http://localhost:7300/addveg/update/{id}   [put]
    @PutMapping("/update/{id}")
    public ResponseEntity<Vegetable> updateProduct(@PathVariable String id, @RequestBody Vegetable vegetable) throws Vegetablenotfound {
        return new ResponseEntity<Vegetable>(US.updateVeg(vegetable), HttpStatus.OK);
    }

    // http://localhost:7300/addveg/delete/{id}   [post]
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) throws Vegetablenotfound {
        return new ResponseEntity<>(US.deleteVeg(id),HttpStatus.OK);
    }
}
