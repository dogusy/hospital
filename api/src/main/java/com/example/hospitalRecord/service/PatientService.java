package com.example.hospitalRecord.service;

import com.example.hospitalRecord.models.Patient;
import com.example.hospitalRecord.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Patient findPatientById(String tc) {
        return patientRepository.findById(tc).orElse(null);
    }

    public Patient savePatient(Patient patientRequest){
        return patientRepository.save(patientRequest);
    }

    public Patient updatePatientDetails(Patient patientDetails) {
        try {
            return patientRepository.save(patientDetails);

        }catch (Exception e ){
            return null;
        }
    }
}
