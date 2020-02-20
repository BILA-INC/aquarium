package com.devops.aquarium.dao;

import com.devops.aquarium.model.Pool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolDao extends JpaRepository<Pool, Integer> {

    Pool findById(int id);
}
