package com.arhibale.contractlistserver.controller;

import com.arhibale.contractlistserver.entity.Contract;
import com.arhibale.contractlistserver.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public List<Contract> getAll() {
        return contractService.getAll();
    }

    @GetMapping("/{id}")
    public Contract getById(@PathVariable Long id) {
        return contractService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Contract contract) {
        contractService.save(contract);
    }

    @PutMapping
    public void update(@RequestBody Contract contract) {
        contractService.update(contract);
    }
}