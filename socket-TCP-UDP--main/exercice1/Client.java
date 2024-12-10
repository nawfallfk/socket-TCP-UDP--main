package exercice1;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class Client {
    private static Socket s;

    public static void main(String[] args) throws IOException {
        // Demande de l'adresse IP du serveur au client
        String serverAddress = JOptionPane.showInputDialog(
                "Entrez l'adresse IP du serveur qui écoute sur le port 9090:");
        s = new Socket(serverAddress, 9090);

        // Lecture de la réponse du serveur
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();

        // Affichage de la réponse du serveur dans une boîte de dialogue
        JOptionPane.showMessageDialog(null, answer);

        // Fermeture de la connexion
        System.exit(0);
    }
}
