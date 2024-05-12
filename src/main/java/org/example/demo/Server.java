package org.example.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static final int SERVER_PORT = 8080;
    private static final int MAX_CLIENTS = 1000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            Socket client = server.accept();
            //handle client connections
            logger.info("Client " + client.getInetAddress() + "is connecting.");
        } catch (IOException exception) {
            logger.warning("Failed to create a server: " + exception.getMessage());
        }
    }
}