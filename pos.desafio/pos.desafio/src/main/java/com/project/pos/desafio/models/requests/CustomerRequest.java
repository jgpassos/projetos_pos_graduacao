package com.project.pos.desafio.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private Long id;
    private String documentNumber;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;

}
