package exercice3;

import java.net.*;

public class Send_UDP {
    public static void main(String[] args) throws Exception {
        // Création d'un socket datagramme
        DatagramSocket ds = new DatagramSocket();

        // Message à envoyer
        String str = "Welcome";

        // Adresse IP de destination (localhost)
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        // Création d'un paquet datagramme contenant le message à envoyer
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);

        // Envoi du paquet
        ds.send(dp);

        // Fermeture du socket
        ds.close();
    }
}


