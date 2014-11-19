package message;

import java.util.ArrayList;

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

	/* public WriteAble filter() {
		ArrayList<String> badwords = new ArrayList<String>();
		badwords.add("ARSCH");
		badwords.add("SCHEIß");
		badwords.add("DUMBASS");

		String[] brav = null;
		
		String wd = null;

	
		if(this.wa.getString().contains((CharSequence) badwords)) {
			for(int i=0; i<this.wa.getString().length(); i++){
				brav[i] = "*";
			}
			wd = wd.replace(this.wa.getString(), brav.toString());
		}
		
		WriteAble wr = new ChatMessage(wd);

		return wr;
	} */

}
