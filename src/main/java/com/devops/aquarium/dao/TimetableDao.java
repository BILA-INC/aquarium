package com.devops.aquarium.dao;

import com.devops.aquarium.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableDao extends JpaRepository<Timetable, Integer> {

        Timetable findById(int id);
}
