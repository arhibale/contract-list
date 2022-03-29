package com.arhibale.contractlistserver.service;

import com.arhibale.contractlistserver.entity.Contract;
import com.arhibale.contractlistserver.exception.ContractNotFoundException;
import com.arhibale.contractlistserver.repository.ContractRepository;
import com.arhibale.contractlistserver.util.ServerTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    public Contract getById(Long id) {
        return contractRepository.findById(id).orElseThrow(
                () -> new ContractNotFoundException("id: " + id)
        );
    }

    public void update(Contract contract) {
        Contract c = getById(contract.getId());
        contract.setDate(c.getDate())
                .setContractNumber(c.getContractNumber())
                .setLastUpdate(ServerTime.getServerTime());
        contractRepository.save(contract);
    }

    public void save(Contract contract) {
        if (contract.getLastUpdate() == null) {
            contract.setLastUpdate(ServerTime.getServerTime());
        }
        contractRepository.save(contract);
    }
}