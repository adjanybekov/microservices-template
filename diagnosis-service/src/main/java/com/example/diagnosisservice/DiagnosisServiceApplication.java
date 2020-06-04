package com.example.diagnosisservice;

import com.example.diagnosisservice.model.Diagnosis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class DiagnosisServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiagnosisServiceApplication.class, args);
    }

    public static List<Diagnosis> list;
    public static List<Diagnosis> getDiagnoses(){
        if(list==null){
            list = new ArrayList<>();
            Diagnosis p1=new Diagnosis(1L,"COVID19","Flu like something");
            Diagnosis p2=new Diagnosis(2L,"Flu","Something like COVID19");
            list.add(p1);
            list.add(p2);
        }
        return list;
    }

}
