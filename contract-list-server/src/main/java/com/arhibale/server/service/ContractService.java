package com.arhibale.server.service;

import com.arhibale.server.entity.Contract;
import com.arhibale.server.exception.ContractNotFoundException;
import com.arhibale.server.repository.ContractRepository;
import com.arhibale.server.util.ServerTime;
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