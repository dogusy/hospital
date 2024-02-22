package com.example.hospitalRecord.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PatientResponse {
    private String TC;
    private String username;
    private String surname;
    private String sex;
    private Integer age;
    private String address;
}
