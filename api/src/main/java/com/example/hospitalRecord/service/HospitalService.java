package com.example.hospitalRecord.service;

import com.example.hospitalRecord.models.Hospital;
import com.example.hospitalRecord.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public Hospital findHospitalByName(String hospitalName){
        return hospitalRepository.findByHospitalName(hospitalName);
    }

    public Hospital getHospitalById(Long hospitalId) {
        return hospitalRepository.findById(hospitalId).orElse(null);
    }

    public List<String> getHospitalNames() {
        return hospitalRepository.getHospitalNames();
    }
}
