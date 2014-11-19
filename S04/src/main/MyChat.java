package main;

import gui.Controller;

/**
 * @author Wortha Simon
 * @version 20141119
 *
 */
public class MyChat {
	/**
	 * @param args
	 *            Die IP mit der Verbunden werden soll und der Port
	 * 
	 *            Main Klasse fuer Chat-Programm
	 */
	public static void main(String[] args) {
		try {
			new Controller(args[0], Integer.parseInt(args[1]));
		}catch(NumberFormatException nfe) {
			System.out.println("ungueltiger Port");
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("ungueltige Eingabe");
		}
	}
}
