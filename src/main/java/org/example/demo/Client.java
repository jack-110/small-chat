package org.example.demo;

import java.net.Socket;

public record Client(Socket socket, String nickName) {
}
