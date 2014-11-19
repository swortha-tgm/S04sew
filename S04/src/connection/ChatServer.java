package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wortha Simon
 * @version 20141118
 *
 */
public class ChatServer implements Runnable, WriteAble {
	int portNumber;
	String inputLine;

	/**
	 * @param portNumber
	 *            Angabe auf welchem Port die Verbindung laeuft
	 */
	public ChatServer(int portNumber) {
		this.portNumber = portNumber;
	}

	@Override
	public void run() {
		try (
		// Verbindungs auffbau
		ServerSocket serverSocket = new ServerSocket(portNumber);
				Socket clientSocket = serverSocket.accept();
				// bekommt die Nachricht vom Client
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			while ((inputLine = in.readLine()) != null) {
				//System.out.println("Partner: " + inputLine);
				this.getString();
			}
		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public String getString() {
		return inputLine;
	}
}
