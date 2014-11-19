package message;

public class UpperCase extends Decorator {

	private WriteAble wa;

	public UpperCase(WriteAble w) {
		this.wa = w;
	}

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	public WriteAble upper() {
		// TODO Auto-generated method stub
		String wUpper = this.wa.toString();
		WriteAble wResult = new ChatMessage(wUpper.toUpperCase());
		
		this.wa = wResult;
		
		return wa;
	}
}
