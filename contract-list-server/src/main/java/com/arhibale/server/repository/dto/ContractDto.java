package com.arhibale.server.repository.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ContractDto implements Serializable {
    private Long id;
    private LocalDateTime date;
    private Integer contractNumber;
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public ContractDto setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public ContractDto setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public ContractDto setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public ContractDto setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractDto that = (ContractDto) o;
        return id.equals(that.id) && date.equals(that.date) && contractNumber.equals(that.contractNumber) && lastUpdate.equals(that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, contractNumber, lastUpdate);
    }

    @Override
    public String toString() {
        return "ContractDto{" +
                "id=" + id +
                ", date=" + date +
                ", contractNumber=" + contractNumber +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}