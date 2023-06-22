package com.sat.dto.request;

import com.sat.constants.SATConstants;
import com.sat.constants.SATExceptionConstants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SATResultRequestDTO {

    @NotBlank(message= SATExceptionConstants.EMPTY_FIELD)
    private String name;

    @NotBlank(message = SATExceptionConstants.EMPTY_FIELD)
    private String address;

    @NotBlank(message = SATExceptionConstants.EMPTY_FIELD)
    private String city;

    @NotBlank(message = SATExceptionConstants.EMPTY_FIELD)
    private String country;

    @NotBlank(message = SATExceptionConstants.EMPTY_FIELD)
    private String pinCode;

    @NotNull(message = SATExceptionConstants.EMPTY_FIELD)
    private Integer satScore;

    private Boolean passed;

    public void setSatScore(int satScore) {
        this.satScore = satScore;
        calculatePassed();
    }

    private void calculatePassed() {
        double passingThreshold =  0.3 * SATConstants.MAX_SAT_SCORE;
        this.passed = (satScore > passingThreshold);
    }
}
