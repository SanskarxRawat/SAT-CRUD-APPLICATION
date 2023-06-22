package com.sat.util;

import com.sat.constants.SATConstants;
import com.sat.dto.request.SATResultRequestDTO;
import com.sat.entity.SATResult;

public class SATUtil {
    public static SATResult convertToEntity(SATResultRequestDTO satResultRequestDTO) {
        SATResult satResult = new SATResult();
        satResult.setName(satResultRequestDTO.getName());
        satResult.setAddress(satResultRequestDTO.getAddress());
        satResult.setCity(satResultRequestDTO.getCity());
        satResult.setCountry(satResultRequestDTO.getCountry());
        satResult.setPinCode(satResultRequestDTO.getPinCode());
        satResult.setSatScore(satResultRequestDTO.getSatScore());
        satResult.setPassed(satResultRequestDTO.getPassed());
        return satResult;
    }

    public static Boolean calculatePassed(Integer satScore) {
        double passingThreshold =  0.3 * SATConstants.MAX_SAT_SCORE;
        return  (satScore > passingThreshold);
    }
}
