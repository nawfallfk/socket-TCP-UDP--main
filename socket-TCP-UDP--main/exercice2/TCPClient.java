package exercice2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class TCPClient {
    private int serverPort;
    private String serverName;
    private static Socket clientSocket;

    public TCPClient(String serverName, int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    public void connect() throws IOException {
        clientSocket = new Socket(serverName, serverPort);
    }

    public void sendMessage() throws IOException {
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        System.out.println("entrez le message qui sera envoiyer au serveur :");
        Scanner sc=new Scanner(System.in);
        String message=sc.nextLine();
        out.writeUTF(message);
        out.flush();
    }

    public String receiveMessage() throws IOException {
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        return in.readUTF();
    }



    public static void main(String[] args) {
        // Test du client
        TCPClient client = new TCPClient("localhost",1234 );
        try {
            client.connect();
            client.sendMessage();
            String receivedMessage = client.receiveMessage();
            System.out.println("Message reçu du serveur : " + receivedMessage);
            clientSocket.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
