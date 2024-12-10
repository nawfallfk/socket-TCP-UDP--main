package exercice1;

import java.io.*;
import java.net.*;

public class Server {
    /*
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        // Création d'un serveur socket écoutant sur le port 9090
        ServerSocket listener = new ServerSocket(9090);
        System.out.println("En attente de connexion...");

        try {
            while (true) {
                // Acceptation d'une connexion entrante
                Socket socket = listener.accept();
                try {
                    // Envoi d'un message de bienvenue au client
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Vous êtes bien connecté au serveur " + socket.getLocalSocketAddress());
                } finally {
                    // Fermeture de la connexion avec le client
                    socket.close();
                }
            }
        } finally {
            // Fermeture du serveur socket
            listener.close();
        }
    }
}
