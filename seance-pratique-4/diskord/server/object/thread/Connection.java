package server.object.thread;

import java.io.IOException;
import java.lang.Runnable;
import java.lang.Thread;
import java.net.ServerSocket;
import java.net.Socket;

import server.object.Server;

public class Connection implements Runnable {

	// Attributes
	
	private Server server;

	private ServerSocket serverSocket;

	// Constructor

	public Connection(Server server) {
		this.server = server;
		try {
			this.serverSocket = new ServerSocket(this.server.getPort());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Methods
	
	@Override
	public void run() {
		while(true) {
			Socket sockNewClient = null;
			try {
				sockNewClient = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ConnectedClient newClient = new ConnectedClient(this.server, sockNewClient);
			this.server.addClient(newClient);
			
			try {
				Thread threadNewClient = new Thread(newClient);
				threadNewClient.start();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
