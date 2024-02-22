package com.example.hospitalRecord.controller;

import com.example.hospitalRecord.enums.HospitalTypes;
import com.example.hospitalRecord.models.Hospital;
import com.example.hospitalRecord.request.HospitalRequest;
import com.example.hospitalRecord.service.AppointmentService;
import com.example.hospitalRecord.service.HospitalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    HospitalService hospitalService;
    AppointmentService appointmentService;

    public HospitalController(HospitalService hospitalService,AppointmentService appointmentService) {
        this.hospitalService = hospitalService;
        this.appointmentService=appointmentService;
    }

    @PostMapping("/register")
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospitalRequest){

        Hospital existedHospital = hospitalService.findHospitalByName(hospitalRequest.getHospitalName());
        if (existedHospital != null) {

            appointmentService.updateHospitalNameByHospitalId(existedHospital.getId(),hospitalRequest.getHospitalName());

            return new ResponseEntity<>(existedHospital, HttpStatus.CREATED);
        }

        Hospital hospital = new Hospital();
        hospital.setHospitalName(hospitalRequest.getHospitalName());
        hospital.setAddress(hospitalRequest.getAddress());
        hospital.setHospitalType(hospitalRequest.getHospitalType());

        hospital = hospitalService.saveHospital(hospital);

        if (hospital == null){
            return new ResponseEntity<Hospital>(new Hospital(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Hospital>(hospital,HttpStatus.CREATED);
    }

    @GetMapping("/hospitalNames")
    public List<String> getHospitalNames(){
        return hospitalService.getHospitalNames();
    }
    
    @GetMapping("/{hospitalId}")
    public ResponseEntity<Hospital> getAppointments(@PathVariable Long hospitalId) {
       Hospital hospital =  hospitalService.getHospitalById(hospitalId);
       return new ResponseEntity<Hospital>(hospital, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String[]> getHospitalTypes(){
        return new ResponseEntity<>(HospitalTypes.getHospitalTypes(),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Hospital> updateHospitalDetails(@RequestBody Hospital hospitalRequest){
        Hospital hospital = hospitalService.saveHospital(hospitalRequest);
        return new ResponseEntity<>(hospital,HttpStatus.CREATED);
    }
}
