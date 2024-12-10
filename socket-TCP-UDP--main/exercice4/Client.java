package exercice4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
   public static void main(String[] args) {
        try {
            //connect()
            Socket s = new Socket(InetAddress.getLocalHost(), 2000);
            //send()
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.println("entrer votre nom :");
            String nom = sc.next();
            out.writeUTF(nom);
            System.out.println("entrer votre prenom :");
            String prenom = sc.next();
            out.writeUTF(prenom);
            System.out.println("entrer le nombre d'article :");
            int nbr = sc.nextInt();
            out.writeInt(nbr);
            System.out.println("entrer le prix d'article d'hors taxe :");
            float prix = sc.nextFloat();
            out.writeFloat(prix);
            out.flush();
            //read()
            DataInputStream inp = new DataInputStream(s.getInputStream());
            String res = inp.readUTF();
            System.out.println(res);
            //close
            s.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
