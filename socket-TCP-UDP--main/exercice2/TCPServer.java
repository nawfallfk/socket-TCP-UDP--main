package exercice2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    private int port;
    private static ServerSocket serverSocket;
    private static Socket Socket;

    public TCPServer(int port) {
        this.port = port;
    }

    public void accept() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket = serverSocket.accept();
    }

    public String receiveMessage() throws IOException {
        DataInputStream in = new DataInputStream(Socket.getInputStream());
        return in.readUTF();
    }

    public void sendMessage() throws IOException {
        DataOutputStream out = new DataOutputStream(Socket.getOutputStream());
        System.out.println("entrez le message qui sera envoiyer au client :");
        Scanner sc=new Scanner(System.in);
        String message=sc.nextLine();
        out.writeUTF(message);
        out.writeUTF(message);
        out.flush();
    }


    public static void main(String[] args) {

        // Test du serveur
        TCPServer server = new TCPServer(1234);
        try {
            server.accept();
            String receivedMessage = server.receiveMessage();
            System.out.println("Message reçu du client : " + receivedMessage);
            server.sendMessage();
            serverSocket.close();
            Socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
