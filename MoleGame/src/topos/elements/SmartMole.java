package topos.elements;

import java.util.LinkedList;

import topos.structure.Direction;
import topos.game.GameManagement;

/**
 * 
 * The class SmartMole represents a sort of active element.
 * @author Moradisten
 *
 */
public class SmartMole extends Mole {


	public SmartMole(int x, int y) {
		super(x, y);
	}

	@Override
	public int getPoints() {

		return 5;
	}

	/**


	/**
	 * 
	 * The smart mole can always move as long as its current position is visible.
	 * 
	 * @see ActiveElement#canMove()
	 */

	public boolean canMove() {
		if (super.scenery.isVisible(super.getPosition()) && scenery != null)
		return true;
		
		return false;
	}

	/**
	 * 
	 * @see ActiveElement#updateGamePoints(topos.game.GameManagement)
	 */
	public void updateGamePoints(GameManagement gestionjuego) {
		gestionjuego.addPoints(getPoints());

	}

	/**
	 * The Smart mole always searches a direction that takes to a hidden or non visible position.
	 * If it doesn't find one, then it will chose a random direction.
	 * 
	 * 
	 * @see ActiveElement#calculateDirection()
	 */
	public Direction calculateDirection() {
		LinkedList<Direction> lista = new LinkedList<Direction>();
		for (Direction dir : Direction.values()) {
			if (!super.scenery.isVisible(position.getAdjacent(dir)) && !super.scenery.thereAreElements(position.getAdjacent(dir)))
				lista.add(dir);
		}
		if (!lista.isEmpty())
			return Direction.values()[random.nextInt(lista.size())];
		return Direction.randomDirection();

	}

	/**
	 * 
	 * @see Element#getImage()
	 */
	public String getImage() {

		return "imagenes/topo-listo.png";
	}

}
