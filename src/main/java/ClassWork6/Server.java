package ClassWork6;

import HomeWork6.Listener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8189;
   private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread serverThread;

    public static void main(String[] args) {
        new Server().start();
    }


    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            waitForConnection(serverSocket);
            while (true) {
                String message = in.readUTF();
                if (message.startsWith("/end")) {
                    shutdown();
                    break;
                }
                System.out.println("Received: " + message);
                out.writeUTF("Echo: " + message);
            }

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

    private void startConcoleThread() {
        serverThread = new Thread(() -> {
            try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter message for client");
                while (!Thread.currentThread().isInterrupted()) {
                    if (reader.ready()) {
                        String serverMessage = ((BufferedReader) reader).readLine();
                        out.writeUTF(serverMessage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
    }

    private void waitForConnection(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    private void shutdown() throws IOException {
        if (serverThread.isAlive()) {
            serverThread.interrupt();
        }
        if (socket != null) {
            socket.close();
        }
        System.out.println("Server stopped");
    }
}
