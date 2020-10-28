import cr.ac.itcr.Jugador.Anfitrion;
import cr.ac.itcr.Jugador.ConnectionReceiver;
import cr.ac.itcr.Jugador.ConnectionRequest;
import cr.ac.itcr.Jugador.Invitado;
import cr.ac.itcr.UI.Jugador.Window;

import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameSettings {

    public boolean onGame = true;
    Anfitrion anfitrion;


    public GameSettings() throws IOException {
        String myRol = selectingRole();
        this.anfitrion = new Anfitrion();

        if (myRol.equals("Anfitrion")){
            anfitrion.setPort(settingPort());
            ConnectionReceiver receiver = new ConnectionReceiver(anfitrion);
            System.out.println(anfitrion.getIP());
            Window window = new Window();
            onGame = true;
        }
    }
    public String selectingRole(){
        Object[] possibleValues = { "Anfitrion", "Invitado" };
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Choose one", "Choosing role..",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        return  (String) selectedValue;
    }
    public int settingPort(){
        String inputValue = JOptionPane.showInputDialog("Ingrese el puerto");
        int port =Integer.parseInt(inputValue);
        return port;
    }
}
