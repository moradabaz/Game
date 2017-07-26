
package topos.elements;

/**
 *
 * The Pasive Element represents the elements that are not able to move, put contribute
 * with a bonus for the player. If the quantity is not specified, the default value
 * will be 1 .
 *
 * @author Moradisten
 *
 */
public abstract class PasiveElement extends Element {

	private static final int DEFAULT_QUANTITY = 1;
	private int quantity;

	public PasiveElement(int x, int y, int quantity) {
		super(x, y);
		this.quantity = quantity;
		
	}

	public PasiveElement(int x, int y) {
		this(x, y, DEFAULT_QUANTITY);
	}

	public int getQuantity() {
		return quantity;
	}
}
