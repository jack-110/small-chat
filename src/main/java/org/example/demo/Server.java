package org.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static final int SERVER_PORT = 8080;
    private static final int MAX_CLIENTS = 5;
    private final List<Client> clients = new ArrayList<>();

    public void start() {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = server.accept();
                Client client = createClient(socket);
                OutputStream outputStream = client.socket().getOutputStream();
                outputStream.write("welcome to my chat room".getBytes());
                outputStream.flush();
            }
        } catch (IOException exception) {
            logger.warning("Failed to create a server: " + exception.getMessage());
        }
    }

    private Client createClient(Socket socket) {
        assert clients.size() < MAX_CLIENTS;
        Client client = new Client(socket, "user" + clients.size());
        clients.add(client);
        return client;
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}