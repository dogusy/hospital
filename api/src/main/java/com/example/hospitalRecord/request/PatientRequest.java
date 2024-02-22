package com.example.hospitalRecord.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PatientRequest {

    private String username;
    private String surname;
    private String sex;
    private Integer age;
    private String tc;
    private String address;
    private String complaint;
    private String hospitalName;

}
