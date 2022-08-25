package com.Veggies.Application.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;



public interface VegetableRepository extends MongoRepository<Vegetable,String> {
}
