package topos.elementos;

import topos.juego.GestionJuego;

/**
  * Las monedas son elementos pasivos. Su contribuci�n en �actualizar partida es
 * sumar tantos puntos como la quantity de monedas que representa.
 * 
 * @author Morad
 *
 */
public class Monedas extends PasiveElement implements Puntuable {

	/**
	 * Constructor con dos argumentos que toma valores que construyen e
	 * inicializan la position y el escenario, e inicializan el valor de la
	 * quantity por defecto.
	 * 
	 * @param x
	 *            El valor del eje de abcisa que forma la position X de la clase
	 *            position del elemento.
	 * @param y
	 *            El valor del eje de ordenada que forma la position Y de la
	 *            clase position del elemento.
	 */
	public Monedas(int x, int y) {
		super(x, y);
	}

	/**
	 * Constructor de tres argumentos, de los cuales dos son los valores de la
	 * position la moneda y el otro es el valor de la quantity que se suma la
	 * puntuacion.
	 * 
	 * @param x
	 *            El valor del eje de abcisa que forma la position X de la clase
	 *            position del elemento.
	 * @param y
	 *            El valor del eje de ordenada que forma la position Y de la
	 *            clase position del elemento.
	 * @param cantidad
	 *            El valor de la quantity que se añade a la puntuacion del
	 *            juego.
	 */
	public Monedas(int x, int y, int cantidad) {
		super(x, y, cantidad);
	}

	/**
	 * Este metodo actualiza la partida añadiendo a los puntos la quantity de
	 * monedas ya establecida, bien sea por defecto o en el constructor.
	 */
	public void updateGamePoints(GestionJuego gestionJuego) {
		gestionJuego.addPuntos(this.quantity);
	}

	public String getImage() {
		return "imagenes/monedas.png";
	}

	/**
	 * Este metodo devuelve un valor entero que representa la quantity que se ha
	 * establecido.
	 */
	public int getPuntuacion() {
		return quantity;
	}

}
