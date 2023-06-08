package com.sat.repository;

import com.sat.entity.SATResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SATRepository extends JpaRepository<SATResult,String> {

    SATResult findByName(String name);
}
