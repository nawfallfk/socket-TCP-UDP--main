package exercice4;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class Server {
   private static long calculerTTC(float prix, float nbre_article) {
        return (long) ((prix + 0.2 * prix) * (nbre_article));
    }

    public static void main(String[] args) {
        try {
            //accept()
            ServerSocket ss = new ServerSocket(2000);
            System.out.println("Attente de connexion");
            Socket client = ss.accept();
            //read()
            DataInputStream inp = new DataInputStream(client.getInputStream());
            String nom = inp.readUTF();
            String prenom = inp.readUTF();
            int nbr = inp.readInt();
            float prix_taxe = inp.readFloat();

            //send()
            float tva = (float) (prix_taxe * 0.2);
            float prix_ttc= nbr * calculerTTC(prix_taxe, nbr);
            String str = "Bonjour " + nom + " " + prenom + "\n le prix hors taxe est : " + prix_taxe + " "
                    + " nombre d'articles est : " + nbr +
                    "\n le taux de valeur ajoute est : " + tva + "\n le prix totale avec taxe est : " + prix_ttc + "\n";
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(str);

            //close()
            client.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
