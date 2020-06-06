package rete;


	
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {
	
	ServerSocket server=null;
	Socket socketClient =null;
	
	int porta=6789;
	
	DataInputStream in;
	DataOutputStream out;
	
	public Socket attendi() {
		
			try {
				System.out.println("[0] - Inizializzo il server ...");
				server=new ServerSocket(porta);
				
				System.out.println("[1] - Server in ascolto alla porta "+porta);
				socketClient=server.accept();
				
				System.out.println("[2] - Connessione stabilita con il client");
				
				server.close();	
				in= new DataInputStream(socketClient.getInputStream());
				out= new DataOutputStream(socketClient.getOutputStream());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return socketClient;		
		
	}
	public void comunica() {
		System.out.println("[3]-aspetto un messggio dal client");
		String letto;
		try {
			letto = in.readLine();
			System.out.println("[4]-  messaggio ricevuto: "+letto);
			String risposta=letto.toUpperCase();
			out.writeBytes(risposta +"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Server s=new Server();
		s.attendi();
		

	}

}
