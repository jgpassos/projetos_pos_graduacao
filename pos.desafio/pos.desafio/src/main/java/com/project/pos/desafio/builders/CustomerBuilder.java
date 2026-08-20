package com.project.pos.desafio.builders;

import com.project.pos.desafio.models.entity.Customer;
import com.project.pos.desafio.models.requests.CustomerRequest;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerBuilder {

   public static Customer newCustomer(CustomerRequest request) {
       return Customer.builder()
               .id(request.getId())
               .name(request.getName())
               .documentNumber(request.getDocumentNumber())
               .birthDate(request.getBirthDate())
               .email(request.getEmail())
               .address(request.getAddress())
               .phone(request.getPhone())
               .build();
   }

    public static void updateCustomer(Customer customer, CustomerRequest request) {
        customer.setName(request.getName());
        customer.setDocumentNumber(request.getDocumentNumber());
        customer.setBirthDate(request.getBirthDate());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());
    }
}
