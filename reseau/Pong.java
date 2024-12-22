import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class Pong {
	public static void main(String[] args) throws Exception {
		try {
			int port = 2000;
			DatagramSocket socket = new DatagramSocket(port);
	
			int buf_size = 1000;
			byte[] buf = new byte[buf_size];
	
			DatagramPacket datagram = new DatagramPacket(buf, buf_size);
	
			System.out.println("Attente d'un message...");
			System.out.flush();
			socket.receive(datagram);

			System.out.println("Message reçu depuis l'adresse : " + datagram.getAddress().toString()
			+ " et port " + datagram.getPort() + " : " + new String(buf));

			System.out.flush();
		} catch(Exception ex) {
			throw ex;
		}

		System.out.println("ok");
	}
}
