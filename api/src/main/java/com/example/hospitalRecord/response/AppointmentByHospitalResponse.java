package com.example.hospitalRecord.response;

import com.example.hospitalRecord.models.Appointment;
import com.example.hospitalRecord.models.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentByHospitalResponse {

    private List<Appointment> appointments;
}
