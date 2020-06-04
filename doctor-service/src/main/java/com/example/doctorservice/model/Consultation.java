package com.example.doctorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Consultation {
    private Doctor doc;
    private Patient pat;
    private Diagnosis diag;
}
