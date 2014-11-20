package message;

import java.util.ArrayList;

/**
 * @author Schober Samuel
 *
 */
public class Badwordfilter extends Decorator {
	private WriteAble wa;

	/**
	 * @param w
	 *            will ein ChatMessage Objekt das erweitert wird
	 */
	public Badwordfilter(WriteAble w) {
		this.wa = w;
	}

	@Override
	public String getString() {
		ArrayList<String> badwords = new ArrayList<String>();
		badwords.add("ARSCH");
		badwords.add("SCHEISS");
		badwords.add("DUMBASS");

		String message = wa.getString();
		
		for (String s : badwords) {
			message = message.replace(s, "****"); 
		}
		return message;
	}
}
