package com.example.hospitalRecord.service;

import com.example.hospitalRecord.models.Appointment;
import com.example.hospitalRecord.models.Hospital;
import com.example.hospitalRecord.models.Patient;
import com.example.hospitalRecord.repository.AppointmentRepository;
import com.example.hospitalRecord.request.CreateAppointmentRequest;
import com.example.hospitalRecord.request.PatientRequest;
import com.example.hospitalRecord.response.PatientResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private AppointmentRepository appointmentRepository;
    private PatientService patientService;
    private HospitalService hospitalService;

    public AppointmentService(AppointmentRepository appointmentRepository,PatientService patientService,HospitalService hospitalService) {
        this.appointmentRepository = appointmentRepository;
        this.hospitalService = hospitalService;
        this.patientService = patientService;
    }

    public PatientResponse saveAppointment(CreateAppointmentRequest patientRequest){
        try {
            Patient patient = patientService.findPatientById(patientRequest.getTc());
            Hospital hospital = hospitalService.findHospitalByName(patientRequest.getHospitalName());

            if (patient == null){
                patient = new Patient();
                patient.setUsername(patientRequest.getUsername());
                patient.setSurname(patientRequest.getSurname());
                patient.setAddress(patientRequest.getAddress());
                patient.setAge(patientRequest.getAge());
                patient.setTC(patientRequest.getTc());
                patient.setSex(patientRequest.getSex());
                patientService.savePatient(patient);
            }

            Appointment appointment = new Appointment();
            appointment.setComplaint(patientRequest.getComplaint());
            appointment.setHospitalName(patientRequest.getHospitalName());
            appointment.setPatient(patient);
            appointment.setHospital(hospital);
            appointmentRepository.save(appointment);

            PatientResponse patientResponse = new PatientResponse();
            patientResponse.setTC(patient.getTC());
            patientResponse.setUsername(patient.getUsername());
            patientResponse.setSurname(patient.getSurname());
            patientResponse.setAddress(patient.getAddress());
            patientResponse.setSex(patient.getSex());
            patientResponse.setAge(patient.getAge());

            return patientResponse;

        }catch (Exception e){
            return null;
        }

    }

    public boolean deleteAppointment(Long appointmentId) {
        try {
           appointmentRepository.deleteById(appointmentId);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void updateAppointmentById(Long appointmentId, PatientRequest updateAppointment) {
            appointmentRepository.findById(appointmentId);

    }

    public List<Appointment> getAppointmentsListByHospitalID(Optional<Integer> hospitalID) {
        return hospitalID.map(integer -> appointmentRepository.findAppointmentsByHospital_Id(integer)).orElse(null);
    }

    public List<Appointment> getAppointmentListByTC(Optional<String> tc) {
        return tc.map(str -> appointmentRepository.findAppointmentsByPatient_Id(str)).orElse(null);
    }

    public void updateHospitalNameByHospitalId(Long id,String newHospitalName) {
        appointmentRepository.updateHospitalNameByHospitalId(id, newHospitalName);
    }
}
