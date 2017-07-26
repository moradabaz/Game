package topos.elements;

import topos.game.GameManagement;
import topos.structure.Direction;
import topos.structure.Position;

/**
 *
 *
 * The class ActiveElement is a subclass of Element. This class represents
 * all the moving elements inside the scenery.
 * No active element can move out side the scenery surface limits.
 * 
 * An active elements always represents the moles, which are the main target. It also
 * represents a rat since it's also a moving element, even though it's not a target.
 * 
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
		Position vecina =  super.getPosition().getAdjacent(direction);
		if (scenery != null) {
			if ((scenery.isInsideSurface(vecina)) && (super.getScenery().consultElement(vecina) == null)) {
				position.move(direction);
				return true;
			}
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
	public abstract void updateGamePoints(GameManagement gestionjuego);

	/**
	 * 
	 * @return
	 *         This abstract method returns the direction that will be executed on the
	 *         move method. Each clase has its own conditions to calculate the next
	 *         direction.
	 */
	public abstract Direction calculateDirection();

}
