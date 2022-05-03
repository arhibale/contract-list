package com.arhibale.server.http;

import com.arhibale.server.repository.ContractRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

public record Handler(Socket socket, ContractRepository contractRepository) implements Runnable {
    @Override
    public void run() {
        try (OutputStream out = socket.getOutputStream()) {
            byte[] bytes = getBytesUTF8(contractRepository.getAll());
            sendHeader(out, 200, "OK", "application/json", bytes.length);
            out.write(bytes);
        }catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private byte[] getBytesUTF8(List<?> list) throws JsonProcessingException {
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        return objectMapper.writeValueAsString(list).getBytes(StandardCharsets.UTF_8);
    }

    private void sendHeader(OutputStream out, int statusCode, String statusText, String type, long length) {
        PrintStream printStream = new PrintStream(out);
        printStream.printf("HTTP/1.1 %s %s%n", statusCode, statusText);
        printStream.printf("Content-Type: %s%n", type);
        printStream.printf("Content-Length: %s%n%n", length);
    }
}
