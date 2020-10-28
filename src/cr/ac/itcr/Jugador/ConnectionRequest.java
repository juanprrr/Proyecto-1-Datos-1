package cr.ac.itcr.Jugador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionRequest {
    private DataOutputStream out;
    private DataInputStream in;
    private String name;
    public boolean isConnected = false;

    public ConnectionRequest(String ip, int port) throws IOException {

        Socket request = new Socket(ip, port );
        in = new DataInputStream(request.getInputStream());
        out = new DataOutputStream(request.getOutputStream());
        out.writeUTF("guest connected");

        Thread thread = new Thread(() -> {
            boolean flag = true;
            while(flag) {
                try {
                    String message = in.readUTF();
                    processMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public void processMessage(String message) {
        System.out.println("Processing message: " + message);
        String[] components = message.split("%", 2);
        //Se agrega un nuevo usuario en caso de que no se encuentre en lista
        if (components[0].equals("Anfitrion")) {
            String[] personas = components[1].split(";");
            for (String persona : personas) {
                System.out.println(persona);
            }

        }
    }

    public String myHostAddress() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        return ip.getHostAddress();

    }
}
