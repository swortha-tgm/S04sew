package message;

/**
 * @author Schober Samuel
 *
 */
public class UpperCase extends Decorator {

	private WriteAble wa;

	/*
	 * 
	 */
	public UpperCase(WriteAble w) {
		this.wa = w;
	}

	/*
	 * Macht die eingegebene Nachricht UpperCase
	 * (non-Javadoc)
	 * @see message.Decorator#getString()
	 */
	@Override
	public String getString() {
		// TODO Auto-generated method stub
		
		return this.wa.getString().toUpperCase();
	}
}
