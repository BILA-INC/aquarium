package com.devops.aquarium.dao;

import com.devops.aquarium.model.Specy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecyDao extends JpaRepository<Specy, Integer> {

    Specy findById(int id);

    //Specy findByName(String test);

    //void update(Specy specy);
}
