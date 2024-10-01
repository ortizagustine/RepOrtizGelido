package io.lwcl.clientserver.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 5000;

        try (Socket sc = new Socket(HOST, PORT);
             DataInputStream in = new DataInputStream(sc.getInputStream());
             DataOutputStream out = new DataOutputStream(sc.getOutputStream())) {

            out.writeUTF("[Client]: Hii!");

            String response = in.readUTF();
            System.out.println(response);
        } catch (IOException e) {
            System.err.println("Error communicating with server: " + e.getMessage());
        }
    }
}