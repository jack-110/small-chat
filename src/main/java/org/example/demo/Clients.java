package org.example.demo;

import java.io.IOException;
import java.net.Socket;

public class Clients {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {

        } catch (IOException ignored) {

        }
    }
}
