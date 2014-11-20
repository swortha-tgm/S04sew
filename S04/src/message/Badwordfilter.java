package message;

import java.util.ArrayList;

/**
 * @author Schober Samuel
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
		ArrayList<String> badwords = new ArrayList<>();
		badwords.add(0, "ARSCH");
		badwords.add(1, "SCHEISS");
		badwords.add(2, "DUMBASS");
		
		String brav = "******";
		
		WriteAble wb = null ;
		
		/* for (int i = 0; i <= badwords.size(); i++) {
			if (this.wa.getString().contains(badwords.get(badwords.indexOf(i)))) {
				wb = new ChatMessage(this.wa.getString().replace(this.wa.getString(), brav));
				System.out.println("awd");
			}else{ 
				return this.wa.getString().toLowerCase();
			}
		} */
		
		return this.wa.getString().toLowerCase();
	}

}
