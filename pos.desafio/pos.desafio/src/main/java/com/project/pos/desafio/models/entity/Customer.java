package com.project.pos.desafio.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private Long id;
    private String documentNumber;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;

}
