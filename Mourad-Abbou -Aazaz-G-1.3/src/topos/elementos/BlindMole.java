package topos.elementos;

import java.util.LinkedList;
import java.util.Random;

import topos.estructura.Direction;
import topos.juego.GestionJuego;

/**
 *
 * The Class BlindMole represents a type of mole which is an active element.
 * @author Morad
 *
 */
public class BlindMole extends ActiveElement implements Puntuable {

	private Direction last = null;					// the last direction taken.

	private Random rand = new Random();				// atribute that will help calculate next position


	public BlindMole(int x, int y) {
		super(x, y);

	}

	/**
	 * 
	 * @see ActiveElement#updateGamePoints(topos.juego.GestionJuego)
	 */
	public void updateGamePoints(GestionJuego gestionJuego) {
		gestionJuego.addPuntos(getPuntuacion());

	}

	/**
	 * 
	 * @see Element#getImage()
	 */
	public String getImage() {
		return "imagenes/topo-ciego.png";
	}

	/**
	 *
	 *
	 * This is a herited method from the class ActiveElement, responsible for the motion of the
	 * mole. The conditions that must be safisfied to move are:
	 * - If the time passed since the last time it has moved is greater than the wait time,
	 * It calculates the next direction. If the action has been executed succesfully, the last time will be
	 * stored in the atribute last.
	 * 
	 * @see ActiveElement#act()
	 */
	public void act() {
		if (super.escenario != null && canMove()) {
			if (System.currentTimeMillis() - lastMove > WAIT_TIME) {
				Direction direction = calculateDirection();
				if (super.moveElement(direction))
					lastMove = System.currentTimeMillis();
			}
		}
	}

	/**
	 * A blind mole can always move.
	 *
	 * @see ActiveElement#canMove()
	 */
	public boolean canMove() {
		return true;
	}

	/**
	 *
	 * A blinde mole can't chose a direction that makes it return to
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
		Direction aleatoria = Direction.values()[rand.nextInt(lista.size())];
		last = aleatoria;
		return aleatoria;
	}

	/**
	 * 
	 * @see topos.elementos.Puntuable#getPuntuacion()
	 */
	public int getPuntuacion() {

		return 1;
	}

}
