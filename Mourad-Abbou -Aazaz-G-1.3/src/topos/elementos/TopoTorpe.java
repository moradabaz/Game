package topos.elementos;

import java.util.Random;

import topos.estructura.Direction;
import topos.juego.GestionJuego;

/**
 * La clase TopoTorpe representa un tipo de topo que es un elemento activo.
 * 
 * @author Morad
 *
 */
public class TopoTorpe extends ActiveElement implements Puntuable {

	Random rand = new Random();

	public TopoTorpe(int x, int y) {
		super(x, y);

	}

	/**
	 * 
	 * @see topos.elementos.Puntuable#getPuntuacion()
	 */
	public int getPuntuacion() {
		return 2;
	}

	/**
	 * 
	 * @see ActiveElement#act()
	 */
	public void act() {
		if (super.escenario != null && canMove()) {
			
			if (System.currentTimeMillis() - lastMove > WAIT_TIME) {
				Direction dir = calculateDirection();
				if(moveElement(dir)) lastMove = System.currentTimeMillis();
			}
			

		}
	}

	/**
	 * El topo torpe puede moverse siempre que su position este visible.
	 * 
	 * @see ActiveElement#canMove()
	 */
	public boolean canMove() {

		if(super.escenario.isVisible(super.position)) return true;
		return false;
	}

	@Override
	public void updateGamePoints(GestionJuego gestionjuego) {
		gestionjuego.addPuntos(getPuntuacion());

	}

	@Override
	public Direction calculateDirection() {
		
		return Direction.randomDirection();
		
	}

	@Override
	public String getImage() {
		return "imagenes/topo-torpe.png";
	}

}