package rete;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	Socket mioSocket =null;
	
	int porta=6789;
	
	DataInputStream in;
	DataOutputStream out;
	
	public Socket connetti() {
		
			System.out.println("[0]- provo a onnettermi al server");
			Socket mioSocket = null;
			try {
				mioSocket = new Socket(InetAddress.getLocalHost(),porta);
				System.out.println("[1]- connesso");
				in=new DataInputStream(mioSocket.getInputStream());
				out=new DataOutputStream(mioSocket.getOutputStream());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return mioSocket;
	}

	public static void main(String[] args) {
		Client c=new Client();
		c.connetti();

	}

}
