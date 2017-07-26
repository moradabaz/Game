package topos.elements;

import topos.game.GameManagement;

/**
 *
 *  A coin is sort of pasive element. It doesn't move and it's position is static.
 *  A coin helps increase the number of points.
 *  
 * 
 * @author Morad
 *
 */
public class Coin extends PasiveElement implements Pointable {

	/**
	 * 
	 * @param x
	 *            
	 * @param y
	 *            
	 */
	public Coin(int x, int y) {
		super(x, y);
	}

	/**
	 * @param x  
	 * @param y
	 *            
	 * @param cantidad
	 *           Value of quantity added  to the score once it is found.
	 */
	public Coin(int x, int y, int cantidad) {
		super(x, y, cantidad);
	}

	/**
	 * Este metodo actualiza la partida añadiendo a los puntos la quantity de
	 * monedas ya establecida, bien sea por defecto o en el constructor.
	 * 
	 */
	public void updateGamePoints(GameManagement gestionJuego) {
		gestionJuego.addPoints(getQuantity());
	}

	public String getImage() {
		return "imagenes/monedas.png";
	}

	/**
	 * 
	 * @return This method return the value of the coin
	 */
	@Override
	public int getPoints() {
		return getQuantity();
	}

}
