package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame {
	private JButton senden;
	private JCheckBox filter;
	private JTextField nachricht;
	private JTextArea chat;
	private JLabel leer;
	private JPanel bot;
	
	public View() {
		super("SUPER COOLER CHAT");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		
		setVisible(true);
	}
	
	//nur zum Testen
	public static void main(String[] args) {
		new View();
	}
}
