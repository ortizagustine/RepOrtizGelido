package io.lwcl.clientserver.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        final int PORT = 5000;
        try (ExecutorService executor = Executors.newCachedThreadPool()) {

            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("TCP Server started on port " + PORT);

                while (true) {
                    Socket sc = serverSocket.accept();
                    executor.submit(new ClientHandler(sc));
                }
            } catch (IOException e) {
                System.err.println("Error starting server: " + e.getMessage());
            }
        }
    }
}

