package org.example.demo;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", Server.SERVER_PORT)) {

        } catch (IOException ioException) {
            logger.warning("Failed to connect server.");
        }

    }
}
