package com.arhibale.client.http;

import com.arhibale.client.dto.ContractDto;
import com.arhibale.client.util.deserializer.ContractDeserializer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;
import java.util.Objects;

public class HttpConnect {

    private final String URL = "http://localhost:8090/contracts";
    private final OkHttpClient httpClient;

    private final ContractDeserializer contractDeserializer;

    public HttpConnect() {
        this.httpClient = new OkHttpClient();
        this.contractDeserializer = new ContractDeserializer();
    }

    public List<ContractDto> getResponseForList() {
        Request request = new Request.Builder().url(URL).build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new RuntimeException("response error: " + response);

            return contractDeserializer.getList(Objects.requireNonNull(response.body()).string());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}