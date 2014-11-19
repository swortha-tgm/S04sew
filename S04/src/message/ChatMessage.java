package message;
/**
 * @author Wortha Simon
 * @version 20141119
 *
 */
public class ChatMessage implements WriteAble {
	private String message;
	
	public ChatMessage(String text) {
		this.message = text;
	}
	@Override
	public String getString() {
		return message;
	}

}
