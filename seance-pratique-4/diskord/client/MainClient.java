package client;

import client.object.Client;
import java.util.Scanner;

public class MainClient {

	public static void main(String[] args) {

		String address = "127.0.0.1";
		Integer port = 1212;

		if(args.length == 2) {

			address = args[0];

			try {
				port = Integer.parseInt(args[1]);
			} catch(NumberFormatException ex) {
				port = 1212;
			}
		}

		// String userName = readUserName();
		
		@SuppressWarnings("unused")
		Client c = new Client("Caca", address, port);
	}

	@SuppressWarnings("unused")
	private static void printUsage() {
		System.out.println("java client.Client <address> <port>");
		System.out.println("\t<address>: server's ip address");
		System.out.println("\t<port>   : server's port");
	}

	@SuppressWarnings("unused")
	private static String readUserName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Entrez votre nom : ");
		String userName = "";
		while(userName.equals("")) {
			userName = scan.nextLine();
		}
		scan.close();
		return userName;
	}
}
