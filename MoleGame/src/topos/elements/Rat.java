


package topos.elements;

import topos.structure.Direction;
import topos.structure.Position;
import topos.game.GameManagement;

/**
 * 
 * A rat is harmful. If you accidentally find a rat and shoot it, your
 * score will be decreased.
 * 
 * @author Morad
 *
 */
public class Rat extends ActiveElement {

	public static final int DECREASING_POINTS = -4;
	
	
	public Rat(int x, int y) {
		super(x, y);
	}
	

	/**
	 * 
	 */
	public void act() {
		if (super.scenery != null && canMove()) {
			Direction dir = calculateDirection();
			if (System.currentTimeMillis() - lastMove > WAIT_TIME) {
				if (moveElement(dir))
					lastMove = System.currentTimeMillis();
			}

		}
	}

	/**
	 * A rat can always move.
	 */
	public boolean canMove() {
		return (scenery != null);
	}

	/**
	 * Thiis method decreases the player score, once the rat is shot.
	 */
	public void updateGamePoints(GameManagement gameManagement) {
		gameManagement.addPoints(DECREASING_POINTS);
	}

	/**
	 *
	 * Method that calculates the next direction. A rat can move as soon as it finds
	 * a visible adjacent position. If it doesn't find any visible position, it will chose
	 * a random direction.
	 * 
	 */
	public Direction calculateDirection() {
		for (int i = 0; i < Direction.values().length; i++) {
			Direction direction = Direction.values()[i];
			Position pos = position.getAdjacent(direction);
			if (scenery.isInsideSurface(pos) && scenery.isVisible(pos)) {
				return direction;
			}
		}
		
	  return Direction.randomDirection();
	}

	public String getImage() {

		return "imagenes/rata.png";
	}
	
	public int getDecreasingPoints() {
		return DECREASING_POINTS;
	}

}