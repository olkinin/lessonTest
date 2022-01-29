package ClassWork6;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8189;
    private static final String HOST = "127.0.0.1";
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread clientThread;

    public static void main(String[] args) {
        new Client().start();
    }

    private void start() {
        try (Socket socket = new Socket(HOST, PORT);) {
            System.out.println("Connected to server");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            startConsoleThread();
            while (true) {
                String message = in.readUTF();
                System.out.println("Received: " + message);
            }
        } catch (SocketException e) {
            System.out.println("Connection to server has been lost");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void startConsoleThread() {
        clientThread = new Thread(() -> {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.print("Enter message for server >>>> ");
        while (!Thread.currentThread().isInterrupted()) {
                    String clientMessage = sc.nextLine();
                        if (clientMessage.equalsIgnoreCase("/quit")) {
                            out.writeUTF("/end");
                            shutdown();
                        }
                    out.writeUTF(clientMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        clientThread.start();
    }

    private void shutdown() throws IOException {
        if (clientThread.isAlive()) {
            clientThread.interrupt();
        }
        System.out.println("Client stopped");
    }
}





