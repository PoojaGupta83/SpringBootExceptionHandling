package com.example.datajpaexceptions.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Entity
@Data
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;


}
