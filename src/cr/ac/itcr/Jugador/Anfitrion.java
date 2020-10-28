package cr.ac.itcr.Jugador;

import java.net.InetAddress;

public class Anfitrion extends Jugador {
    private int port;
    private InetAddress IP;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetAddress getIP() {
        return IP;
    }

    public void setIP(InetAddress IP) {
        this.IP = IP;
    }
    public Anfitrion() {

        super();
    }

}
