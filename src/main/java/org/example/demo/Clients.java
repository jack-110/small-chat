package org.example.demo;

import java.io.IOException;
import java.net.Socket;

public class Clients {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", Server.SERVER_PORT)) {

        }
    }
}
