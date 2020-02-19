package com.devops.aquarium.dao;

import com.devops.aquarium.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Integer> {
}
