package message;

/**
 * @author Schober Samuel
 *
 */
public class UpperCase extends Decorator {

	private WriteAble wa;

	/**
	 * @param w
	 *            will ein ChatMessage Objekt das erweitert wird
	 */
	public UpperCase(WriteAble w) {
		this.wa = w;
	}

	/**
	 * Macht die eingegebene Nachricht UpperCase (non-Javadoc)
	 * 
	 * @see message.Decorator#getString()
	 */
	@Override
	public String getString() {
		return this.wa.getString().toUpperCase();
	}
}
