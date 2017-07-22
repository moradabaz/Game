package topos.elementos;

import topos.estructura.Direction;
import topos.estructura.Position;
import topos.juego.GestionJuego;

/**
 * La clase ActiveElement es una subclase que hereda de la clase Element. En
 * ella estan contenidos todos los elementos que se mueven por el escenario en
 * funcion de las circunstancias que se den en cada uno de ellos. Este
 * movimiento debe estar parametrizada con una dirección de desplazamiento.
 * Tras realizar el desplazamiento el elemento se habrá desplazado en una
 * unidad en la dirección establecida, siempre que la posición a la que debe
 * desplazarse no esté fuera de los límites del escenario y no esté ocupada
 * por otro elemento.
 *
 * The class ActiveElement is a subclass of Element. This class represents
 * all the moving elements inside the scenery.
 * No active element can move out side the scenery surface limits.
 * @author moradisten
 *
 */
public abstract class ActiveElement extends Element {

	protected long lastMove = System.currentTimeMillis();
	public final int WAIT_TIME = 2000;

	/**
	 *
	 * This constructor inicializes the position and the scenery using 2 coordinates.
	 *
	 * @param x
	 *
	 * @param y
	 *
	 */
	public ActiveElement(int x, int y) {
		super(x, y);

	}

	/**
	 *
	 * This method is used to move the element given a direction. The element will
	 * move as long as the direction it's going to move doesn't outpass the scenery
	 * surface limits or there's no other element in the way.
	 *
	 * @param direction
	 *            The direction the element is going to move to.
	 * @return
	 *         It'll return a true value y the displacement has been a success. In other case,
	 *         it'll return a false value.
	 */
	public boolean moveElement(Direction direction) {
		Position vecina =  super.getPosition().getAdyacent(direction);
		if ((super.escenario.isDentro(vecina)) && (super.getEscenario().consultaElemento(vecina) == null)) {
			super.position.move(direction);
			return true;
		}
		return false;
	}

	/**
	 * This method make an active element move according to its motion contidions.
	 * The method is abstract and must be implemented in the subclasses.
	 *
	 */
	public abstract void act();

	/**
	 *
	 * This method is abstract and must be implemented in the subclasses.
	 *
	 * @return
	 *         This method returns a True value if the element is able to move.
	 *
	 */
	public abstract boolean canMove();

	/**
	 *
	 * This abstract method updates the game increasing the points when an enemy
	 * is eliminated.
	 *
	 */
	public abstract void updateGamePoints(GestionJuego gestionjuego);

	/**
	 * 
	 * @return
	 *         This abstract method returns the direction that will be executed on the
	 *         move method. Each clase has its own conditions to calculate the next
	 *         direction.
	 */
	public abstract Direction calculateDirection();

}
