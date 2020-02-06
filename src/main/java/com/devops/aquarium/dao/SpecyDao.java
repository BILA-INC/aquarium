package com.devops.aquarium.dao;

import com.devops.aquarium.model.Specy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecyDao extends JpaRepository<Specy, Integer> {

    Specy findById(int id);

    List<Specy> findByIdGreaterThan(int id);

    List<Specy> findByNameLike(String s);
}
