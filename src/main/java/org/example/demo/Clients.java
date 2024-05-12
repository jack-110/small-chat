package org.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Clients {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", Server.SERVER_PORT)) {
            while (true) {
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024]; // Buffer to store incoming data
                int bytesRead = inputStream.read(buffer);
                System.out.println(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
            }
        } catch (IOException ignored) {

        }
    }
}
