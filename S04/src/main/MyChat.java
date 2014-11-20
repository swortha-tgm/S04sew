package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.Controller;

/**
 * @author Wortha Simon
 * @version 20141119
 *
 *          Startet das Chat-Programm
 */
public class MyChat {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(MyChat.class);

	/**
	 * @param args
	 *            Die IP mit der Verbunden werden soll und der Port
	 * 
	 *            Main Klasse fuer Chat-Programm
	 */
	public static void main(String[] args) {
		try {
			new Controller(args[0], Integer.parseInt(args[1]));
		} catch (NumberFormatException nfe) {
			LOGGER.info("ungueltiger Port");
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			LOGGER.info("unguelite Eingabe");
		} catch (IllegalArgumentException iae) {
			LOGGER.info("unguelige Eingabe");
		} catch (Exception e) {
			LOGGER.info("FEHLER");
		}
	}
}
