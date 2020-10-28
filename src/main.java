import cr.ac.itcr.Jugador.ConnectionRequest;

import java.io.IOException;
import java.net.UnknownHostException;

public class main {



    public static void main(String[] args) throws IOException {
        GameSettings gameSettings = new GameSettings();
        if (gameSettings.onGame == true){
            int gamePort = gameSettings.anfitrion.getPort();
            //ConnectionRequest request = new ConnectionRequest(gamePort);
        }
    }




}
