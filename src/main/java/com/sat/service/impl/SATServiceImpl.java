package com.sat.service.impl;

import com.sat.dto.request.SATResultRequestDTO;
import com.sat.entity.SATResult;
import com.sat.repository.SATRepository;
import com.sat.service.SATService;
import com.sat.util.SATUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
public class SATServiceImpl implements SATService {

    @Autowired
    private SATRepository satRepository;

    @Override
    public SATResult insertData(SATResultRequestDTO satResultRequestDTO) {
        SATResult satResult= SATUtil.convertToEntity(satResultRequestDTO);
        return satRepository.save(satResult);
    }

    @Override
    public List<SATResult> viewAllData() {
        return satRepository.findAll();
    }

    @Override
    public Integer getRank(String name) {
        List<SATResult> allResults = satRepository.findAll();

        allResults.sort(Comparator.comparingInt(SATResult::getSatScore).reversed());

        int index = IntStream.range(0, allResults.size())
                .filter(i -> allResults.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1);

        return index != -1 ? index + 1 : 1;
    }

    @Override
    public void updateScore(String name, Integer score) {
        SATResult satResult=satRepository.findByName(name);
        satResult.setSatScore(score);
        satResult.setPassed(SATUtil.calculatePassed(score));
        satRepository.save(satResult);
    }

    @Override
    public void deleteRecord(String name) {
        SATResult satResult=satRepository.findByName(name);
        satRepository.delete(satResult);
    }
}
