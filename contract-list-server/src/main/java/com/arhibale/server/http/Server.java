package com.arhibale.server.http;

import com.arhibale.server.repository.ContractRepository;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public record Server(int port) {
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable runnable = new Handler(socket, new ContractRepository());
                runnable.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
