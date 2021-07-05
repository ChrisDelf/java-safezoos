package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.CountAnimals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    Animal findByAnimaltype(String type);

    @Query(value = "SELECT animal.*, Count(zoo.zooid) as countanimals FROM animal LEFT JOIN zooanimals ON  animal.animalid = zooanimals.animalid LEFT JOIN zoo ON zooanimals.zooid = zoo.zooid Group by animal.animalid", nativeQuery = true)
    ArrayList<CountAnimals> getCountAnimals();
}

