package com.example.hospitalRecord.repository;

import com.example.hospitalRecord.models.Appointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findAppointmentsByHospital_Id(int hospitalID);

    @Query(value = "SELECT a FROM Appointment a WHERE a.patient.TC = :tc")
    List<Appointment> findAppointmentsByPatient_Id(@Param("tc") String tc);

    @Modifying
    @Query(value = "UPDATE Appointment a SET  a.hospitalName = :newHospitalName WHERE a.hospital.id=:id")
    void updateHospitalNameByHospitalId(Long id,String newHospitalName);
}
