package com.Veggies.Application.Services;

import com.Veggies.Application.Exceptions.Vegetablenotfound;
import com.Veggies.Application.Exceptions.Veggieexists;
import com.Veggies.Application.Model.Vegetable;

import java.io.Serializable;
import java.util.List;

public interface UserService {

    Vegetable addVeg(Vegetable vegetable) throws Veggieexists;
    Vegetable updateVeg(Vegetable vegetable) throws Vegetablenotfound;
    Vegetable updateV(String veg) throws  Vegetablenotfound;
    boolean deleteVeg(String vegetable) throws Vegetablenotfound;
    Vegetable getVeg(String vegatable) throws Vegetablenotfound;
    Vegetable getVeg1(String vegatable) throws Vegetablenotfound;
    List<Vegetable> getAllVegetables();


}
