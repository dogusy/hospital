package com.example.hospitalRecord.repository;

import com.example.hospitalRecord.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    Hospital findByHospitalName(String hospitalName);

    @Query("SELECT h.hospitalName FROM Hospital h ")
    List<String> getHospitalNames();
}
