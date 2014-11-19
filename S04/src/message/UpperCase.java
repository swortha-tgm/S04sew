package message;

public class UpperCase extends Decorator {

	private WriteAble wa;

	public UpperCase(WriteAble w) {
		this.wa = w;
	}

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		
		return this.wa.toString();
	}

	public WriteAble upper() {
		// TODO Auto-generated method stub
		
		WriteAble wr = new ChatMessage(this.wa.getString().toUpperCase());
		
		return wr;
	}
}
