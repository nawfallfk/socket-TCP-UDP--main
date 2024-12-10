package multi_Threads;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurThread{

	public static void main ( String [] args ) throws IOException {
		try // create a new ServerSocket which listens on port 4200
		(ServerSocket serverSocket =new ServerSocket (4200);){
		System.out.println (" En attent de connection ... " );
		// accept connections forever
		 while (true){
		  Socket socket = serverSocket.accept ();
		  System.out.println(" Connection ´etablie " );
		  new Thread(new ClientHandler(socket)).start ();
		}}}
}

