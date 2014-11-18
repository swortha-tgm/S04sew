package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Wortha Simon
 * @version 20141118
 *
 */
public class ChatClient implements Runnable {
	String hostName;
	int portNumber;

	/**
	 * Erstellt einen neuen Client
	 * 
	 * @param hostName
	 *            Die IP Adresse des Servers mit dem eine Verbindung aufgebaut
	 *            werden soll
	 * @param portNumber
	 *            Angabe auf welchem Port die Verbindung läuft
	 */
	public ChatClient(String hostName, int portNumber) {
		this.hostName = hostName;
		this.portNumber = portNumber;
	}

	/**
	 * Es wird die Verbindung zum Server hergestellt und gleichzeitig erm�glicht
	 * run() die eingabe in die Konsole, um dem Server etwas zu schreiben.
	 * 
	 */
	@Override
	public void run() {
		try (
		// Verbindung zum Server
		Socket echoSocket = new Socket(hostName, portNumber);
				//"leitet" Nachricht an den Server
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				//liest 
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

			String userInput;
			while ((userInput = stdIn.readLine()) != null) {
				out.println(userInput);
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}

	}
}
