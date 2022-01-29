package HomeWork6;

import com.sun.corba.se.pept.transport.ListenerThread;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.sun.xml.internal.ws.server.ServerRtException;
import sun.java2d.loops.GraphicsPrimitive;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Listener {
    private Socket socket;
    private Thread listenerThread;
    DataOutputStream out;
    DataInputStream in;

    public Listener(Socket socket) {
        listenerThread = new Thread(() -> {
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String message = in.readUTF();
                    System.out.println(message);
            }} catch (IOException e) {
                e.printStackTrace();
            }
        });
        listenerThread.start();

    }


}