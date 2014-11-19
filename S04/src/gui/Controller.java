package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.ChatClient;
import connection.ChatServer;

/**
 * @author Wortha Simon
 * @version 20141118
 *
 */
public class Controller implements ActionListener {
	View v;
	ChatClient cc;

	/**
	 * @param hostName
	 *            Die IP Adresse es Hosts mit dem sich verbunden werden möchte
	 * @param port
	 *            Der Port über dem die Verbindung läuft
	 */
	public Controller(String hostName, int port) {
		v = new View(this);
		Thread server = new Thread(new ChatServer(port, v));
		server.start();
		cc = new ChatClient(hostName, port);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (v.isBSendenClick(e)) {
			cc.sendMessage(v.getMessage());
			v.changeArea("Ich: " + v.getMessage());
		}
	}
}
