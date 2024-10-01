package io.lwcl.clientserver.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Client connected");

            String response = in.readUTF();
            System.out.println(response);

            out.writeUTF("[Server]: Hello and Welcome!");

            socket.close();
            System.out.println("Client disconnected");
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}
