
package topos.elements;

import topos.game.GameManagement;
import topos.structure.Scenery;
import topos.structure.Position;

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
	protected Scenery scenery;

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
		scenery = null;
	}

	/**
	 *
	 *
	 * @return Returns the position of the elements.
	 */
	public Position getPosition() {
		try {
			return position.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return position;
	}

	/**
	 * @return Returns the scenery attribute.
	 */
	public Scenery getScenery() {
		return scenery;
	}

	/**
	 * This method modifies the element scenery taking an sceney object as a
	 * argument.
	 +
	 *
	 *
	 * @param escenario The method takes the a scenery parameter to set the new scenery.
	 *
	 */
	public void setScenery(Scenery scenery) {
		this.scenery = scenery;
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
	public abstract void updateGamePoints(GameManagement gestionJuego);

	/**
	 *
	 *
	 * Abstract method containing the route of the image.
	 *
	 * @return It returns the route of the image.
	 */
	public abstract String getImage();

}
