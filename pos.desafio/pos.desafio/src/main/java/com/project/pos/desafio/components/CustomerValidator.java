package com.project.pos.desafio.components;

import com.project.pos.desafio.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerValidator {
    private final CustomerRepository customerRepository;

    public boolean verifyIfExists(Long customerId) {
        return customerRepository.existsById(customerId);
    }
}
