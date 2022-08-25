package com.Veggies.Application.Services;

import com.Veggies.Application.Exceptions.Vegetablenotfound;
import com.Veggies.Application.Exceptions.Veggieexists;
import com.Veggies.Application.Model.Vegetable;

import com.Veggies.Application.Repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class USImp implements UserService {

    private final PlaygroundService service;

    @Autowired
    private VegetableRepository UR;





    @Autowired
    public USImp(PlaygroundService service) {
        this.service = service;
    }


    @Override
    public Vegetable addVeg(Vegetable vegetable) throws Veggieexists {
        if(UR.findById(vegetable.getVegname()).isEmpty()){
            return UR.insert(vegetable);
        }
        else{
            throw new Veggieexists();
        }
    }

    @Override
    @CachePut(value="Vegetable", key="#p0")
    public Vegetable updateVeg(Vegetable vegetable) throws Vegetablenotfound {
        if(UR.findById(vegetable.getVegname()).isEmpty()){
            throw new Vegetablenotfound();
        }
        else
        {
            return UR.save(vegetable);
        }
    }

    @Override
    @CacheEvict(value="Vegetable", key="#vegname")
    public boolean deleteVeg(String veg) throws Vegetablenotfound {
        if(UR.findById(veg).isPresent())
        {
            UR.deleteById(veg);
            return true;
        }
        else{
            throw new Vegetablenotfound();
        }
    }

    @Override
    public Vegetable updateV(String veg) throws Vegetablenotfound {
        if(UR.findById(veg).isPresent())
        {
            Vegetable veget = new Vegetable();
            veget.setPrice(veget.getPrice());
            veget.setVegname(veget.getVegname());
            veget.setQuantity(veget.getQuantity());
            veget.setExpiry("Expired");
          return  UR.save(veget);
        }
        else{
            throw new Vegetablenotfound();
        }
    }


    @Override
    //@Cacheable(value="Vegetable", key="#p0")
    public Vegetable getVeg(String vegatable) throws Vegetablenotfound {

        Vegetable veg = UR.findById(vegatable).orElseThrow(()-> new Vegetablenotfound());
        veg.setExpiry("Processing");
        UR.save(veg);
       // service.expiry(vegatable);
      //  System.out.println(new Date());
        Vegetable v = new Vegetable();
        v.setVegname(veg.getVegname());
        v.setExpiry(veg.getExpiry());
        return v;
    }

    @Override
    @Cacheable(value="Vegetable", key="#p0")
    public Vegetable getVeg1(String vegatable) throws Vegetablenotfound {

        Vegetable vegetable = UR.findById(vegatable).orElseThrow(()-> new Vegetablenotfound());
        if(vegetable.getExpiry().equalsIgnoreCase("Processing")){
            vegetable.setExpiry("expired");
            UR.save(vegetable);
        }
      else {
            //  System.out.println(new Date());
            return vegetable;
        }
        return vegetable;
    }


    @Override
    //@Cacheable(value="Vegetable")
    public List<Vegetable> getAllVegetables() {
        return UR.findAll();
    }


}
