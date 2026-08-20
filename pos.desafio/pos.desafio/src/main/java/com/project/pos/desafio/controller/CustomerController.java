package com.project.pos.desafio.controller;

import com.project.pos.desafio.models.entity.Customer;
import com.project.pos.desafio.models.requests.CustomerRequest;
import com.project.pos.desafio.service.CustomerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(info = @Info(description = "Clientes"))
@RestController
@RequestMapping(path = "/v1/customers")
@Validated
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/create")
    @Operation(description = "Criar usuarios" , summary = "API para criar usuarios.")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CustomerRequest request) {
        service.create(request);
    }

    @DeleteMapping("/{customerId}")
    @Operation(description = "Excluir usuarios" , summary = "API para excluir usuarios.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long customerId) {
        service.deleteById(customerId);
    }

    @GetMapping
    @Operation(description = "Retornar usuarios" , summary = "API para retornar usuarios.")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll() {
        return service.getCustomers();
    }

    @PutMapping("/{customerId}")
    @Operation(description = "Atualizar usuarios" , summary = "API para atualizar usuarios.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long customerId, @RequestBody @Valid CustomerRequest request) {
        service.updateCustomer(customerId, request);
    }

    @GetMapping("/count")
    @Operation(description = "Contagem de usuarios" , summary = "API para contagem de usuarios.")
    @ResponseStatus(HttpStatus.OK)
    public Long count() {
        return service.countCustomer();
    }

    @GetMapping("/{customerId}")
    @Operation(description = "Busca usuario por ID" , summary = "API para buscar usuario por ID.")
    @ResponseStatus(HttpStatus.OK)
    public Customer findById(@PathVariable Long customerId) {
        return service.findCustomerById(customerId);
    }

    @GetMapping("/search/{name}")
    @Operation(description = "Busca usuario por nome" , summary = "API para buscar usuario por nome.")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findByName(@PathVariable String name) {
        return service.findCustomerByName(name);
    }
}
