package com.sat.service;

import com.sat.dto.request.SATResultRequestDTO;
import com.sat.entity.SATResult;

import java.util.List;

public interface SATService {

    SATResult insertData(SATResultRequestDTO satResult);

    List<SATResult> viewAllData();

    Integer getRank(String name);

    void updateScore(String name,Integer score);

    void deleteRecord(String name);
}
