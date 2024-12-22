package server.object.thread;

import common.Message;
import server.object.Server;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Runnable;
import java.io.IOException;

public class ConnectedClient implements Runnable {

	// Class Attributes
	
	private static int idCounter = 0;

	// Attributes

	private int id;

	private Server server;

	private Socket socket;

	private ObjectOutputStream out;

	private ObjectInputStream in;

	// Constructor
	
	public ConnectedClient(Server server, Socket socket) {
		this.id = ++idCounter;

		this.server = server;
		this.socket = socket;

		try {
			this.out = new ObjectOutputStream(socket.getOutputStream());
			this.in = new ObjectInputStream(socket.getInputStream());
		} catch(IOException ex) {
			ex.printStackTrace();
		}

		System.out.println("Nouvelle connexion : " + this.id);
	}

	// Getters

	public int getId() {
		return this.id;
	}

	public Server getServer() {
		return this.server;
	}

	public ObjectOutputStream getOut() {
		return this.out;
	}

	public ObjectInputStream getIn() {
		return this.in;
	}

	// Setters

	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	public void setServer(Server server) {
		if(server != null)
			this.server = server;
	}

	// Methods
	
	public void sendMessage(Message message) {
		try {
			this.out.writeObject(message);
			this.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.out.close();
			this.in.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean isActive = true;
		while(isActive) {
			try {
				Message message = (Message)this.in.readObject();
				if(message != null) {
					message.setSender(String.valueOf(this.id));
					this.server.broadcastMessage(message, this.id);
				} else {
					throw new IOException("Client déconnecté");
				}
			} catch(Exception e) {
				server.disconnectClient(this);
				System.out.println("Déconnexion : " + this.id);
				isActive = false;
			}
		}
	}
}
