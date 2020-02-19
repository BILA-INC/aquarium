package com.devops.aquarium.dao;

import com.devops.aquarium.model.Pool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoolDao extends JpaRepository<Pool, Integer> {
}
