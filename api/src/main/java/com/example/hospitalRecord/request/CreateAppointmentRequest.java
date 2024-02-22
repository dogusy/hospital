package com.example.hospitalRecord.request;

import lombok.Data;

@Data
public class CreateAppointmentRequest {
    private String username;
    private String surname;
    private String sex;
    private Integer age;
    private String address;
    private String tc;
    private String hospitalName;
    private String complaint;
}
