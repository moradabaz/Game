
package topos.elementos;

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

	public int quantity;

	private static final int DefaultCantidad = 1;

	public PasiveElement(int x, int y, int quantity) {
		super(x, y);
		this.quantity = quantity;
		
	}

	public PasiveElement(int x, int y) {
		this(x, y, DefaultCantidad);
	}

}
