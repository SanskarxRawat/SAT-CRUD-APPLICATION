package com.sat.service;

import com.sat.entity.SATResult;

import java.util.List;

public interface SATService {

    SATResult insertData(SATResult satResult);

    List<SATResult> viewAllData();

    Integer getRank(String name);

    void updateScore(String name,Integer score);

    void deleteRecord(String name);
}
