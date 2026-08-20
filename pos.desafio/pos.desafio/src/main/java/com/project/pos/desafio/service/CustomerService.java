package com.project.pos.desafio.service;

import com.project.pos.desafio.builders.CustomerBuilder;
import com.project.pos.desafio.components.CustomerValidator;
import com.project.pos.desafio.models.entity.Customer;
import com.project.pos.desafio.models.requests.CustomerRequest;
import com.project.pos.desafio.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerValidator customerValidator;
    private final CustomerRepository customerRepository;

    public void create(CustomerRequest request) {
        boolean hasCustomer = customerValidator.verifyIfExists(request.getId());

        if(!hasCustomer) {
            var newCustomer = CustomerBuilder.newCustomer(request);
            log.info("Cadastrando cliente: {}", request.getId());
            customerRepository.save(newCustomer);
        } else {
            log.warn("Cliente ja cadastrado.");
        }
    }

    public void deleteById(Long customerId) {
        boolean hasCustomer = customerValidator.verifyIfExists(customerId);

        if(hasCustomer) {
            log.info("Deletando cliente: {}", customerId);
            customerRepository.deleteById(customerId);
        } else {
            log.warn("Cliente nao encontrado.");
        }
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void updateCustomer(Long customerId, CustomerRequest request) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        CustomerBuilder.updateCustomer(customer, request);
        log.info("Atualizando cliente: {}", customerId);
        customerRepository.save(customer);
    }

    public Long countCustomer() {
        return customerRepository.count();
    }

    public Customer findCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Customer> findCustomerByName(String name) {
        return customerRepository.findByName(name);
    }
}
