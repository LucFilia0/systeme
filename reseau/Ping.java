import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ping {
	public static void main(String[] args) throws Exception {
		
		try {
			InetAddress address = InetAddress.getByName("10.42.139.144");
			int port = 2000;

			String message = "Grosse merde";

			DatagramSocket socket = new DatagramSocket();

			DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, port);

			System.out.println("Envoi du message...");
			System.out.flush();
			socket.send(packet);

		} catch(Exception ex) {
			throw ex;
		}

		System.out.println("ok");
	}
}
