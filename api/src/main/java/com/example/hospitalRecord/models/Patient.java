package com.example.hospitalRecord.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @Column(nullable = false)
    private String TC;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String address;

    @OneToMany( cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}
