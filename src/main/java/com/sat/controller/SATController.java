package com.sat.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sat.constants.SATConstants;
import com.sat.dto.request.SATResultRequestDTO;
import com.sat.entity.SATResult;
import com.sat.service.SATService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
@Tag(name = "SAT Controller",description = "Controller for managing SAT and related operations.")
public class SATController {

    @Autowired
    private SATService satService;

    @GetMapping("/")
    public String displayHome(Model model){
        model.addAttribute(SATConstants.SAT,new SATResult());
        return SATConstants.HOME;
    }

    @PostMapping("/insert")
    @Operation(description = "This api is used to insert SAT Score.")
    public String insertSATScore(@ModelAttribute("sat") @Valid SATResultRequestDTO satResultRequestDTO) {
        log.info("SAT Score : {}",satResultRequestDTO);
        satService.insertData(satResultRequestDTO);
        return SATConstants.HOME;
    }

    @GetMapping("/view")
    @Operation(description = "This api is used to view all SAT Score in JSON format.")
    public String viewAllSATData(Model model) throws JsonProcessingException {
        List<SATResult> satResults=satService.viewAllData();
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonData=objectMapper.writeValueAsString(satResults);
        log.info("JsonData : {}",jsonData);
        model.addAttribute(SATConstants.JSON_DATA,jsonData);
        model.addAttribute(SATConstants.SAT,new SATResult());
        return SATConstants.HOME;
    }

    @PostMapping("/rank")
    @Operation(description = "This api is used to get the rank of SAT score by name.")
    public String getRank(@Param("name") String name, ModelMap modelMap,Model model) {
          log.info("Finding the rank of the name: {}",name);
          Integer rank=satService.getRank(name);
          log.info("rank : {}",rank);
          modelMap.addAttribute(SATConstants.RANK,rank);
          model.addAttribute(SATConstants.SAT,new SATResult());
          return SATConstants.HOME;
    }

    @PostMapping("/update")
    @Operation(description = "This api is used to update the SAT score for the given name.")
    public String updateSATScore(@Param("name") String name, @Param("score") Integer score,Model model) {
        log.info("Update the SAT score associated with name: {} and updated score :{}",name,score);
        satService.updateScore(name,score);
        model.addAttribute(SATConstants.SAT,new SATResult());
        return SATConstants.HOME;
    }

    @PostMapping("/delete")
    @Operation(description = "This api is used to delete the SAT score for the given name. ")
    public String deleteSATRecord(@Param("name") String name,Model model) {
        log.info("Delete Record with associated Name: {}",name);
        satService.deleteRecord(name);
        model.addAttribute(SATConstants.SAT,new SATResult());
        return SATConstants.HOME;
    }

}
