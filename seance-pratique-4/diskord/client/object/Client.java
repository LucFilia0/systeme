package client.object;

import common.Message;

import java.net.InetAddress;
import java.net.Socket;

import client.object.thread.ClientReceive;
import client.object.thread.ClientSend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Thread;

public class Client {
	
	// Attributes

	private String name;
	
	private String address;

	private int port;

	private Socket socket;

	private ObjectInputStream in;

	private ObjectOutputStream out;

	// Constructor
	
	public Client(String name, String address, int port) {

		this.setName(name);
		this.setAddress(address);
		this.setPort(port);

		
		try {
			this.socket = new Socket(InetAddress.getByName(this.address), this.port);
			this.in = new ObjectInputStream(this.socket.getInputStream());
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
		} catch(IOException ex) {
			System.out.println("Connexion refusée... Fermeture de l'application");
			System.exit(0);
		}

		Thread clientReceive = new Thread(new ClientReceive(this, this.in));
		Thread clientSend =  new Thread(new ClientSend(this, this.out));

		clientReceive.start();
		clientSend.start();
	}

	// Getters

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public int getPort() {
		return this.port;
	}

	// Setters

	public void setName(String name) {
		if(name != null)
			this.name = name;
	}

	public void setAddress(String address) {
		if(address != null)
			this.address = address;
	}

	public void setPort(int port) {
		if(port >= 0)
			this.port = port;
	}

	// Methods

	public void disconnectedServer() {
		try {
			this.socket.close();
			if(this.in != null)
				this.in.close();
			if(this.out != null)
				this.out.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Fermeture de l'application");
		System.exit(0);
	}

	public void messageReceived(Message message) {
		System.out.print("\r" + message.getSender() + " : " + message.getContent() + "\n>> ");
	}
}
