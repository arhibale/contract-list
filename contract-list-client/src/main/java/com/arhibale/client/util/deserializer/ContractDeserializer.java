package com.arhibale.client.util.deserializer;

import com.arhibale.client.dto.ContractDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Arrays;
import java.util.List;

public class ContractDeserializer {
    private final ObjectMapper mapper;

    public ContractDeserializer() {
        mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
    }

    public List<ContractDto> getList(String json) throws JsonProcessingException {
        return Arrays.asList(mapper.readValue(json, ContractDto[].class));
    }
}