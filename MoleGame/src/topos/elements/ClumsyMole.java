package topos.elements;

import topos.game.GameManagement;
import topos.structure.Direction;

/**
 *
 * 
 * @author Moradisten
 *
 */
public class ClumsyMole extends Mole {


	public ClumsyMole(int x, int y) {
		super(x, y);

	}
 
	

	/**
	 * A clumsy mole can always move as long as its current position is visible.
	 * @see ActiveElement#canMove()
	 */
	public boolean canMove() {
		if(super.scenery.isVisible(super.position) && scenery != null) return true;
		return false;
	}

	@Override
	public void updateGamePoints(GameManagement gestionjuego) {
		gestionjuego.addPoints(getPoints());

	}

	@Override
	public Direction calculateDirection() {
		return Direction.randomDirection();
		
	}

	@Override
	public String getImage() {
		return "imagenes/topo-torpe.png";
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 3;
	}

}