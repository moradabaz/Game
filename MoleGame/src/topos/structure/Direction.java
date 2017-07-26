package topos.structure;

import java.util.Random;

/**
 * The values of the enum are UP, RIGHT, DOWN e LEFT.
 *
 *
 */
public enum Direction {
	
	
	/**
	 * This class has only 4 directions : UP, DOWN, LEFT,RIGHT.
	 */

	UP, DOWN, RIGHT, LEFT;
	
	/**
	 * Creates an array of directions and
	 * returns a random direction.
	 * @return	returns a random direction.
	 */
	
	public static Direction randomDirection() {
		Random random = new Random();
		return Direction.values()[random.nextInt(Direction.values().length)];
	}
}

