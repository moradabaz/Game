package topos.elements;

import java.util.LinkedList;

import topos.game.GameManagement;
import topos.structure.Direction;

/**
 *
 * The Class BlindMole represents a type of mole which is an active element.
 * @author Morad
 *
 */
public class BlindMole extends Mole{

	private Direction last = null;					// the last direction taken.



	public BlindMole(int x, int y) {
		super(x, y);

	}

	/**
	 * 
	 * @see ActiveElement#updateGamePoints(topos.game.GameManagement)
	 */
	public void updateGamePoints(GameManagement gestionJuego) {
		gestionJuego.addPoints(getPoints());

	}

	/**
	 * 
	 * @see Element#getImage()
	 */
	public String getImage() {
		return "imagenes/topo-ciego.png";
	}


	/**
	 * A blind mole can always move.
	 *
	 * @see ActiveElement#canMove()
	 */
	public boolean canMove() {
		return scenery != null;
	}

	/**
	 *
	 * A blind mole can't chose a direction that makes it return to
	 * it's previous position.
	 *
	 * @see ActiveElement#calculateDirection()
	 */
	public Direction calculateDirection() {
		LinkedList<Direction> lista = new LinkedList<Direction>();

		for (Direction dir : Direction.values()) {
			if (dir != last) {
				lista.add(dir);
			}
		}
		Direction aleatoria = Direction.values()[random.nextInt(lista.size())];
		last = aleatoria;
		return aleatoria;
	}



	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 4;
	}

}
