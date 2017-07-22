package topos.elementos;

import java.util.LinkedList;
import java.util.Random;

import topos.estructura.Direction;
import topos.juego.GestionJuego;

/**
 * La clase TopoListo representa un tipo de topo que es un elemento activo.
 * 
 * @author Morad
 *
 */
public class TopoListo extends ActiveElement implements Puntuable {

	Random rand = new Random();

	public TopoListo(int x, int y) {
		super(x, y);
	}

	@Override
	public int getPuntuacion() {

		return 3;
	}

	/**
	 * Este metodo heredado de la clase abstracta ActiveElement se encarga de
	 * que el elemenento actue siguiendo las siguientes intrucciones; Si está
	 * dentro de un escenario y puede moverse: Calcula el tiempo que ha
	 * transcurrido desde el último movimiento (último desplazamiento
	 * efectivo). Si ha pasado el tiempo de espera: Calcula una dirección de
	 * desplazamiento. Realiza el desplazamiento en esa dirección. Si el
	 * desplazamiento ha sido efectivo, almacena el instante de tiempo en el que
	 * se ha producido el desplazamiento.
	 * 
	 * @see ActiveElement#act()
	 */
	public void act() {
		if (super.escenario != null && canMove()) {
			

			if (System.currentTimeMillis() - lastMove > WAIT_TIME) {
				Direction direction = calculateDirection();
				if (moveElement(direction))
					lastMove = System.currentTimeMillis();
			}
		}

	}

	/**
	 * El Topo listo puede moverse siempre que su position este visible.
	 * 
	 * @see ActiveElement#canMove()
	 */

	public boolean canMove() {
		if (super.escenario.isVisible(super.getPosition()))
		return true;
		
		return false;
	}

	/**
	 * 
	 * @see ActiveElement#updateGamePoints(topos.juego.GestionJuego)
	 */
	public void updateGamePoints(GestionJuego gestionjuego) {
		gestionjuego.addPuntos(getPuntuacion());

	}

	/**
	 * El topo Listo siempre busca una direccion que a position oculta Si no la
	 * encuentra toma una direccion randomDirection.
	 * 
	 * @see ActiveElement#calculateDirection()
	 */
	public Direction calculateDirection() {
		LinkedList<Direction> lista = new LinkedList<Direction>();

		for (Direction dir : Direction.values()) {
			if (!super.escenario.isVisible(position.getAdyacent(dir)) && !super.escenario.hayElementos(position.getAdyacent(dir)))
				lista.add(dir);

		}

		if (!lista.isEmpty())
			return Direction.values()[rand.nextInt(lista.size())];

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
