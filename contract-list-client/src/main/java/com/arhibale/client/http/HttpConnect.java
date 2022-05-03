package com.arhibale.client.http;

import com.arhibale.client.dto.ContractDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HttpConnect {

    private final String URL = "http://localhost:8081";

    public List<ContractDto> getResponseForList() {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(URL).build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new RuntimeException("response error: " + response);

            return getList(Objects.requireNonNull(response.body()).string());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<ContractDto> getList(String json) {
        try {
            ObjectMapper objectMapper = JsonMapper.builder()
                    .addModule(new JavaTimeModule())
                    .build();
            return Arrays.asList(objectMapper.readValue(json, ContractDto[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}