package cr.ac.itcr.Jugador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler {
    Socket socket;
    boolean flag = true;
    DataOutputStream out;
    DataInputStream in;
    ConnectionReceiver receiver;

    public ConnectionHandler(Socket socket, String name, ConnectionReceiver receiver) throws IOException {
        this.socket = socket;
        this.out = new DataOutputStream(socket.getOutputStream());
        this.in = new DataInputStream(socket.getInputStream());
        this.receiver = receiver;

        Thread thread = new Thread(() -> {
            while(flag) {
                try {
                    String message = in.readUTF();
                    receiver.processMessage(name, message);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public void sendMessage(String message) throws IOException {

        try{
            out.writeUTF(message);
            out.flush();
        }catch (IOException e){
            throw new IOException(e);
        }

    }
}
