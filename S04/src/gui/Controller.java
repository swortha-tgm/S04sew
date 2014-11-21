package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.ChatClient;
import connection.ChatServer;

/**
 * @author Wortha Simon
 * @version 20141118
 *
 *          Implementiert den Actionlistener für View, weiters werden die View,
 *          der Server und derClient hier gestartet
 */
public class Controller implements ActionListener {
	View v;
	ChatClient cc;
	private String host;
	private int port;

	/**
	 * @param hostName
	 *            Die IP Adresse es Hosts mit dem sich verbunden werden moechte
	 * @param port
	 *            Der Port ueber dem die Verbindung laeuft
	 */
	public Controller(String hostName, int port) {
		this.port = port;
		this.host = hostName;
		v = new View(this);
		Thread server = new Thread(new ChatServer(port, v));
		server.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (v.isBSendenClick(e)) {
			cc.sendMessage(v.getMessage());
			v.changeArea("Ich: " + v.getMessage());
			v.clearTextField();
		}
		if (v.isBVerbindenClick(e)) {
			cc = new ChatClient(host, port);
			v.enableSenden();
		}
	}
}
