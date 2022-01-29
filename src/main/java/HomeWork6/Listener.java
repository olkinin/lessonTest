package HomeWork6;

import com.sun.corba.se.pept.transport.ListenerThread;
import com.sun.xml.internal.ws.server.ServerRtException;
import sun.java2d.loops.GraphicsPrimitive;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Listener {
    private static int PORT = 8189;
    private static String HOST = "127.0.0.1";
    private Socket socket;
    private Thread listnerThread;
    DataOutputStream out;
    DataInputStream in;

    public Listener(Socket socket) {
        socket = this.socket;
    }


    public void Listener(Socket socket) {

        listnerThread =new Thread(()->{
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                while (true){
                    String message = in.readUTF();
                    System.out.println(message);
                    out.writeUTF(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        listnerThread.start();

    }


}