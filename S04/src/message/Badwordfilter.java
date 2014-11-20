package message;

import java.util.ArrayList;

/**
 * @author simon
 *
 */
public class Badwordfilter extends Decorator {
	private WriteAble wa;

	public Badwordfilter(WriteAble w) {
		this.wa = w;
	}

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return this.wa.toString();
	}

	public WriteAble filter() {
		ArrayList<String> badwords = new ArrayList<String>();
		badwords.add("ARSCH");
		badwords.add("SCHEI�");
		badwords.add("DUMBASS");

		String[] brav = null;

		String wd = null;

		for (int i = -1; i < badwords.size(); i++) {
			if (this.wa.getString().contains((CharSequence) badwords)) {
				wd = wd.replace(this.wa.getString(), brav.toString());
			}
		}

		WriteAble wr = new ChatMessage(wd);

		return wr;
	}

}
