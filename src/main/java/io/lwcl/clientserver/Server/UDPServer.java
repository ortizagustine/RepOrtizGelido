package io.lwcl.clientserver.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public static void main(String[] args) {
        final int PORT = 5000;

        try (DatagramSocket datagramSocket = new DatagramSocket(PORT)) {
            System.out.println("UDP Server started on port " + PORT);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message from client: " + message);

                String response = "[Server]: Hello and Welcome!";
                byte[] responseBuffer = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length, packet.getAddress(), packet.getPort());
                System.out.println("Sending response to client.");
                datagramSocket.send(responsePacket);
            }
        } catch (IOException e) {
            System.err.println("Error communicating with client: " + e.getMessage());
        }
    }
}

