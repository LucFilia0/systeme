package server.object;

import common.Message;
import server.object.thread.Connection;
import server.object.thread.ConnectedClient;

import java.util.ArrayList;
import java.lang.Thread;

public class Server {

	// Attributes

	private int port;

	private ArrayList<ConnectedClient> clients;

	// Constructor

	public Server(int port) {
		this.port = port;
		this.clients = new ArrayList<ConnectedClient>();

		Thread listeningConnection = new Thread(new Connection(this));

		listeningConnection.start();
	}

	// Getters

	public int getPort() {
		return this.port;
	}

	// Setters
	
	public void setPort(int port) {
		if(port >= 0)
			this.port = port;
	}

	// Methods
	
	public void addClient(ConnectedClient client) {
		this.clients.add(client);

		Message notif = new Message(String.valueOf(client.getId()), "Vient de se connecter");

		this.broadcastMessage(notif, client.getId());
	}

	public void disconnectClient(ConnectedClient client) {
		client.close();
		this.clients.remove(client);

		Message notif = new Message(String.valueOf(client.getId()), "Vient de se déconnecter");
		this.broadcastMessage(notif, client.getId());
	}

	public void broadcastMessage(Message message, int id) {
		for(ConnectedClient client : this.clients) {
			if(client.getId() != id)
				client.sendMessage(message);
		}
	}
}
