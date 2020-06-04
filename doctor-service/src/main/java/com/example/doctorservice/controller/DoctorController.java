package com.example.doctorservice.controller;

import com.example.doctorservice.model.Consultation;
import com.example.doctorservice.model.Diagnosis;
import com.example.doctorservice.model.Doctor;
import com.example.doctorservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public Consultation getAll(@RequestParam("patientId") Long patientId,@RequestParam("diagnosisId") Long diagnosisId){

        /*
        * getPatientById
        * getDiagnosisById
        * setAvailableDoctor and return Consultation object
        * */

        Patient patient = restTemplate.getForObject("http://patient-service/api/v1/patient/" + patientId, Patient.class);

        Diagnosis diagnosis = restTemplate.getForObject("http://diagnosis-service/api/v1/diagnosis/" + diagnosisId, Diagnosis.class);

        Consultation consultation = new Consultation();
        Doctor doctor = new Doctor(1L,"Nazaraliev");

        consultation.setPat(patient);
        consultation.setDiag(diagnosis);
        consultation.setDoc(doctor);

        return consultation;
    }

}
