package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.view.CountAnimals;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid", nativeQuery = true)
    void deleteZooFromZooAnimals(long zooid);

    @Query(value = "SELECT COUNT(*) as count FROM zooanimals WHERE zooid = :zooid AND animalid = :animalid", nativeQuery = true)
    CountAnimals checkZooAnimalCombo(long zooid, long animalid);

    Zoo findByZooname(String name);
}
