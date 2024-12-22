package server;

import server.object.Server;

public class MainServer {

	public static void main(String[] args) {

		Integer port = 1212;

		if(args.length == 1) {
			port = Integer.parseInt(args[0]);
		}

		@SuppressWarnings("unused")
		Server server = new Server(port);
	}

	@SuppressWarnings("unused")
	private static void printUsage() {
		System.out.println("java server.Server <port>");
		System.out.println("\t<port>: Server's port");
	}
}

