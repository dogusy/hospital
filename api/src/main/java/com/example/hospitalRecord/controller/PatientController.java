package com.example.hospitalRecord.controller;

import com.example.hospitalRecord.models.Appointment;
import com.example.hospitalRecord.models.Patient;
import com.example.hospitalRecord.request.CreateAppointmentRequest;
import com.example.hospitalRecord.request.PatientRequest;
import com.example.hospitalRecord.response.AppointmentByHospitalResponse;
import com.example.hospitalRecord.response.PatientResponse;
import com.example.hospitalRecord.service.AppointmentService;
import com.example.hospitalRecord.service.HospitalService;
import com.example.hospitalRecord.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private AppointmentService appointmentService;
    private PatientService patientService;

    public PatientController(AppointmentService appointmentService,PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService=patientService;
    }

    @PostMapping("/appointmentListByHospitalId")
    public ResponseEntity<AppointmentByHospitalResponse> getAppointmentListByHospitalId(@RequestParam Optional<Integer>  hospitalID){
        List<Appointment> appointment = appointmentService.getAppointmentsListByHospitalID(hospitalID);
        if ( appointment==null ||appointment.isEmpty()){
            return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        AppointmentByHospitalResponse response1 = new AppointmentByHospitalResponse(appointment);
        return new ResponseEntity<>(response1,HttpStatus.CREATED);
    }

    @PostMapping("/appointmentListByTC")
    public ResponseEntity<AppointmentByHospitalResponse> getAppointmentListByTC(@RequestParam Optional<String>  tc){
        List<Appointment> appointment = appointmentService.getAppointmentListByTC(tc);
        if (appointment == null || appointment.isEmpty()){
            return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        AppointmentByHospitalResponse response = new AppointmentByHospitalResponse(appointment);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PostMapping("/makeAppointment")
    public ResponseEntity<PatientResponse> makeAppointment(@RequestBody CreateAppointmentRequest appointmentRequest){
        PatientResponse patientResponse=appointmentService.saveAppointment(appointmentRequest);
        if (patientResponse==null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(patientResponse,HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteAppointment(@RequestParam Long appointmentId){
        boolean isDeleted = appointmentService.deleteAppointment(appointmentId);
        if (!isDeleted){
            return new ResponseEntity<>(appointmentId,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(appointmentId,HttpStatus.CREATED);
    }

    @PostMapping("/updatePatientDetails")
    public ResponseEntity<Patient> updatePatientDetails(@RequestBody Patient patientRequest){
        Patient patient = patientService.updatePatientDetails(patientRequest);
        if (patient!=null){
            return new ResponseEntity<>(new Patient(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(patient,HttpStatus.CREATED);
    }



}
