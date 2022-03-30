package com.arhibale.client.util.http;

import com.arhibale.client.dto.ContractDto;
import com.arhibale.client.util.deserializer.ContractDeserializer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class HttpConnect {

    private final String url;
    private final OkHttpClient httpClient;

    private final ContractDeserializer contractDeserializer;

    public HttpConnect(String url) {
        this.url = url;
        this.httpClient = new OkHttpClient();
        this.contractDeserializer = new ContractDeserializer();
    }

    public HttpConnect() {
        this.url = "http://localhost:8090/contracts";
        this.httpClient = new OkHttpClient();
        this.contractDeserializer = new ContractDeserializer();
    }

    private List<ContractDto> sendGet() {
        Request request = new Request.Builder().url(url).build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new RuntimeException("response: " + response);

            return contractDeserializer.getList(Objects.requireNonNull(response.body()).string());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ContractDto> getListContracts() {
        return sendGet();
    }
}