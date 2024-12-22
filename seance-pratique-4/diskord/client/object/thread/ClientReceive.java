package client.object.thread;

import client.object.Client;
import common.Message;

import java.lang.Runnable;
import java.io.ObjectInputStream;

public class ClientReceive implements Runnable {
	
	// Attributes

	private Client client;

	private ObjectInputStream in;

	// Constructor

	public ClientReceive(Client client, ObjectInputStream in) {
		this.setClient(client);
		this.setIn(in);
	}

	// Getters

	public Client getClient() {
		return this.client;
	}

	public ObjectInputStream getIn() {
		return this.in;
	}

	// Settters

	public void setClient(Client client) {
		if(client != null)
			this.client = client;
	}

	public  void setIn(ObjectInputStream in) {
		if(in != null)
			this.in = in;
	}

	// Methods

	@Override
	public void run() {
		try {
			Message message = null;
			boolean isActive = true;

			while(isActive) {
				message = (Message)this.in.readObject();
				if(message == null)
					isActive = false;
				else
					this.client.messageReceived(message);
			}

			client.disconnectedServer();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
