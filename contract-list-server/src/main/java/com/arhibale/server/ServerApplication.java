package com.arhibale.server;

import com.arhibale.server.http.Server;

public class ServerApplication {
    public static void main(String[] args) {
        new Server(8081).start();
    }
}
