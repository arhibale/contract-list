package com.arhibale.client.dto;

import javafx.beans.property.SimpleBooleanProperty;

import java.time.LocalDateTime;
import java.util.Objects;

public class ContractDto {
    private Long id;
    private LocalDateTime date;
    private Integer contractNumber;
    private LocalDateTime lastUpdate;
    private final SimpleBooleanProperty relevance;

    public ContractDto() {
        relevance = new SimpleBooleanProperty(false);
    }

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

        relevance.set(LocalDateTime.now().minusDays(60).isBefore(lastUpdate));

        return this;
    }

    public boolean isRelevance() {
        return relevance.get();
    }

    public SimpleBooleanProperty relevanceProperty() {
        return relevance;
    }

    public ContractDto setRelevance(boolean relevance) {
        this.relevance.set(relevance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractDto that = (ContractDto) o;
        return id.equals(that.id) && date.equals(that.date) && contractNumber.equals(that.contractNumber) && lastUpdate.equals(that.lastUpdate) && relevance.equals(that.relevance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, contractNumber, lastUpdate, relevance);
    }
}