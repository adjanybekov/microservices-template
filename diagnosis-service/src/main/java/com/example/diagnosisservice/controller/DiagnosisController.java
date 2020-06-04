package com.example.diagnosisservice.controller;

import com.example.diagnosisservice.DiagnosisServiceApplication;
import com.example.diagnosisservice.model.Diagnosis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/diagnosis")
public class DiagnosisController {

    @GetMapping("/list")
    public List<Diagnosis> getAll(){
        return DiagnosisServiceApplication.getDiagnoses();
    }

    @GetMapping("/{diagnosisId}")
    public Diagnosis getById(@PathVariable("diagnosisId") Long diagnosisId){
        Diagnosis diagnosis = DiagnosisServiceApplication.getDiagnoses().stream().filter(x -> x.getId() == diagnosisId).findFirst().orElse(null);
        return diagnosis;
    }
}
