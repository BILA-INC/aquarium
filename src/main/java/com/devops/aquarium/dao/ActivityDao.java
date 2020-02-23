package com.devops.aquarium.dao;

import com.devops.aquarium.model.Activity;
import com.devops.aquarium.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Integer> {

    Activity findById(int id);
}
