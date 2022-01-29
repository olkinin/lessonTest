package HomeWork6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

public class Server {

    private static final int PORT = 8189;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread serverThread;
    ArrayList<Listener> listener = new ArrayList<>();

    public static void main(String[] args) {
        new Server().start();

    }


    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                listener.add(new Listener(socket));
                System.out.println("Client connected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void shutdown() {
        try {
            if (serverThread.isAlive()) {
                serverThread.interrupt();
            }
            if (socket != null) {
                socket.close();
            }
            System.out.println("Server stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
