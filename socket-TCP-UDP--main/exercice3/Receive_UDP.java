package exercice3;

import java.net.*;

public class Receive_UDP {
    public static void main(String[] args) throws Exception {
        // Création d'un socket datagramme et liaison avec le port 3000 sur localhost
        DatagramSocket ds = new DatagramSocket(3000);

        // Tableau de bytes pour stocker les données reçues
        byte[] buf = new byte[1024];

        // Création d'un paquet datagramme pour recevoir les données
        DatagramPacket dp = new DatagramPacket(buf, 1024);

        // Réception du paquet
        ds.receive(dp);

        // Conversion des données en chaîne de caractères
        String receivedMessage = new String(dp.getData(), 0, dp.getLength());

        // Affichage du message reçu
        System.out.println(receivedMessage);

        // Fermeture du socket
        ds.close();
    }
}
