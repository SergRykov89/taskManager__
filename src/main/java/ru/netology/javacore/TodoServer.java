package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try(Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String s = in.readLine();
                    Operation op = new Gson().fromJson(s, Operation.class);
                    if (op.getType().equals("ADD")) todos.addTask(op.getTask());
                    if (op.getType().equals("REMOVE")) todos.removeTask(op.getTask());
                    out.println(todos.getAllTasks());
                }

            }
        }

    }
}
