
package topos.elementos;

import topos.estructura.Escenario;
import topos.estructura.Position;
import topos.juego.GestionJuego;

/**
 * The Elements represent the characters and the objects of the game. They are all hidden
 * behind the screen and the panels of the game. The main objective is to kill all the moles found behind
 * the panels. Behind the panels you can also find some helpful objects.
 *
 * The class Element is the main one. It represents the active and passive elements of the game.
 * We can find a hierachy of classes where each subclass contains a different behavior and different
 * functions. The objective of this clas is the use of abstract methods to define the hierachy.
 *
 * Each element contains a position and a scenery. It also contains a game gestor and a image route.
 *
 * @author Morad
 *
 */
public abstract class Element {

	protected Position position;
	protected Escenario escenario;

	/**
	 * Constructor that inicializes the attributes of the class Element taking
	 * two numbers as parameters to inicialize the position. The scenery of the class
	 * keeps inicialized to null value.
	 *
	 * @param x
	 * @param y
	 */
	public Element(int x, int y) {
		position = new Position(x, y);
		escenario = null;
	}

	/**
	 *
	 *
	 * @return Returns the position of the elements.
	 */
	public Position getPosition() {
		return new Position(position);
	}

	/**
	 * @return Returns the scenery attribute.
	 */
	public Escenario getEscenario() {
		return escenario;
	}

	/**
	 * This method modifies the element scenery taking an sceney object as a
	 * parameter.
	 +
	 *
	 *
	 * @param escenario The method takes the a scenery parameter to set the new scenery.
	 *
	 */
	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	/**
	 *
	 * Position setter method.
	 *
	 * @param position Parameter used to set the new position of the element.
	 *
	 *
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Metodo abstracto que añade o decrementa puntos de la partida al disparar
	 * un elemento. Este metodo se implementa en la subclase ActiveElement que
	 * hereda de esta clase.
	 *
	 * This absctract methods uptades the game, increasing or decreasing points
	 * after shooting a passive element. Its implemented in the subclass ActiveElement,
	 *
	 * @param gestionJuego
	 *						It uses a parameter of a GameManagment type. The GameManagment updates the points
	 *						of the game.
	 *
	 */
	public abstract void updateGamePoints(GestionJuego gestionJuego);

	/**
	 *
	 *
	 * Abstract method containing the route of the image.
	 *
	 * @return It returns the route of the image.
	 */
	public abstract String getImage();

}
