package message;

/**
 * @author simon
 *
 */
public class UpperCase extends Decorator {

	private WriteAble wa;

	public UpperCase(WriteAble w) {
		this.wa = w;
	}

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		
		return this.wa.getString().toUpperCase();
	}
}
