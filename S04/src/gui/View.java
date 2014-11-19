package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import message.Badwordfilter;
import message.ChatMessage;
import message.Decorator;
import message.UpperCase;
import message.WriteAble;

/**
 * @author Wortha Simon
 * @version 20141117
 *
 *	Implementiert alle Anzeigefelder fuer die GUI
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
	private JLabel leer;
	private JPanel bot;
	private Controller c;

	/**
	 * @param c
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
		chat.setEditable(false);

		bot.setLayout(new GridLayout(1, 4));
		bot.add(nachricht);
		bot.add(senden);
		bot.add(leer);
		bot.add(filter);

		this.add(chat, BorderLayout.CENTER);
		this.add(bot, BorderLayout.SOUTH);
		
		senden.addActionListener(this.c);

		setVisible(true);
	}

	/**
	 * @param neu
	 */
	public void changeArea(String neu) {
		WriteAble message = new ChatMessage(neu);
		message = new UpperCase(message).upper();
		if (filter.isSelected())
			message = new Badwordfilter(message);
		this.chat.append(message.getString() + "\n");
	}
	
	/**
	 * @param e
	 * @return
	 */
	public boolean isBSendenClick(ActionEvent e) {
		return e.getSource() == senden;
	}
	
	/**
	 * @return
	 */
	public String getMessage() {
		return nachricht.getText();
	}
}