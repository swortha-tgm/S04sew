package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import message.Badwordfilter;
import message.ChatMessage;
import message.UpperCase;
import message.WriteAble;

/**
 * @author Wortha Simon
 * @version 20141117
 *
 *          Implementiert alle Anzeigefelder fuer die GUI
 */
public class View extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton senden;
	private JCheckBox filter;
	private JTextField nachricht;
	private JTextArea chat;
	private JScrollPane scroll;
	private JLabel leer;
	private JPanel bot;
	private Controller c;

	/**
	 * @param c
	 *            Der Controller, in dem der Actionlistener ist
	 */
	public View(Controller c) {
		super("SUPER COOLER CHAT");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.c = c;

		this.setSize(750, 500);
		this.setLayout(new BorderLayout());

		this.senden = new JButton("Senden");
		this.filter = new JCheckBox("Badwordfilter");
		this.leer = new JLabel();
		this.bot = new JPanel();
		this.nachricht = new JTextField();
		this.chat = new JTextArea();
		this.scroll = new JScrollPane(chat);

		chat.setEditable(false);

		bot.setLayout(new GridLayout(1, 4));
		bot.add(nachricht);
		bot.add(senden);
		bot.add(leer);
		bot.add(filter);

		this.add(scroll, BorderLayout.CENTER);
		this.add(bot, BorderLayout.SOUTH);

		this.getRootPane().setDefaultButton(senden);

		senden.addActionListener(this.c);

		setVisible(true);
	}

	/**
	 * @param neu
	 *            der neue String, bzw. die Nachricht die der TextArea
	 *            hinzugefügt werden soll
	 */
	public void changeArea(String neu) {
		WriteAble message = new ChatMessage(neu);
		message = new UpperCase(message);
		if (filter.isSelected())
			message = new Badwordfilter(message);
		this.chat.append(message.getString() + "\n");
	}

	/**
	 * @param e
	 *            ActionEvent
	 * @return ob der Button geklickt wird
	 */
	public boolean isBSendenClick(ActionEvent e) {
		return e.getSource() == senden;
	}

	/**
	 * @return gibt die Nachricht die in das TextFiled geschrieben wird zurück
	 */
	public String getMessage() {
		return nachricht.getText();
	}

	/**
	 * Setzt das TextField auf einen leeren String zurueck
	 */
	public void clearTextField() {
		this.nachricht.setText("");
	}
}