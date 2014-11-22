package connection;

import gui.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import main.MyChat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Wortha Simon
 * @version 20141118
 * 
 *          Der Server der die Nachrichten des Seners empfängt
 *
 */
public class ChatServer implements Runnable {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(MyChat.class);

	int portNumber;
	String inputLine;
	private View view;

	/**
	 * @param portNumber
	 *            Angabe auf welchem Port die Verbindung laeuft
	 * @param v
	 *            Es muss die View, also die GUI uebergen werden, da sonst die
	 *            Nachricht nicht weitergegeben werden kann
	 */
	public ChatServer(int portNumber, View v) {
		this.portNumber = portNumber;
		this.view = v;
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
				view.changeArea("Partner: " + inputLine);
			}
		} catch (IOException e) {
			LOGGER.info("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
			System.exit(1);
		} catch (IllegalArgumentException e) {
			LOGGER.info("ungueltige Portnummer");
			System.exit(1);
		}
	}
	
	public int getPortNumber() {
		return portNumber;
	}
}
