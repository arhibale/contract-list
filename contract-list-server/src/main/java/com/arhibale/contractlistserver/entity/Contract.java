package com.arhibale.contractlistserver.entity;

import com.arhibale.contractlistserver.util.ServerTime;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "contract_number", nullable = false)
    private Integer contractNumber;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @PrePersist
    private void init() {
        date = ServerTime.getServerTime();
    }

    public Long getId() {
        return id;
    }

    public Contract setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Contract setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public Contract setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public Contract setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id.equals(contract.id) && date.equals(contract.date) && contractNumber.equals(contract.contractNumber) && lastUpdate.equals(contract.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, contractNumber, lastUpdate);
    }
}