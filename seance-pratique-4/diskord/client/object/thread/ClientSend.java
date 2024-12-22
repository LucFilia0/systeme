package client.object.thread;

import common.Message;
import client.object.Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.Runnable;
import java.util.Scanner;

public class ClientSend implements Runnable {
	
	// Attributes

	private Client client;

	private ObjectOutputStream out;

	// Constructor

	public ClientSend(Client client, ObjectOutputStream out) {
		this.setClient(client);
		this.setOut(out);
	}

	// Getters

	public Client getClient() {
		return this.client;
	}

	public ObjectOutputStream getOut() {
		return this.out;
	}

	// Setters

	public void setClient(Client client) {
		if(client != null)
			this.client = client;
	}

	public void setOut(ObjectOutputStream out) {
		if(out != null)
			this.out = out;
	}

	// Methods

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		String line;
		Message message;
		while(true) {
			System.out.print(">> ");
			line = scan.nextLine();
			message = new Message(this.client.getName(), line);
			try {
				this.out.writeObject(message);
				this.out.flush();
			} catch(IOException ex) {
				scan.close();
				ex.printStackTrace();
			}
		}
	}
}
