package org.example.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    private final int port;
    private final int maxClients;

    public Server(int port, int maxClients) {
        this.port = port;
        this.maxClients = maxClients;
    }

    public static void main(String[] args) {
        Server server = new Server(8080, 3);
        server.start();
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            List<Client> clients = new ArrayList<>();
            while (true) {
                Socket socket = server.accept();
                if (clients.size() >= maxClients) {
                    socket.close();
                    continue;
                }
                Client client = new Client(socket, "user" + clients.size());
                clients.add(client);
            }
        } catch (IOException exception) {
            logger.warning("Failed to create a server: " + exception.getMessage());
        }
    }
}