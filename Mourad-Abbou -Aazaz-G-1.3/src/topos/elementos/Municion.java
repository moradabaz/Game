package topos.elementos;

import topos.juego.GestionJuego;

/**
 * La municion es un tipo de elemento pasivo. Su contribucion en actualizar
 * partida es incrementar la quantity de disparos en la quantity que representa.
 * 
 * @author Morad
 *
 */
public class Municion extends PasiveElement {

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
	 *
	 */
	public Municion(int x, int y) {
		super(x, y);
	}

	/**
	 * Constructor de tres argumentos, de los cuales dos son los valores de la
	 * position la municion y el otro es el valor de la quantity que se suma la
	 * puntuacion.
	 * 
	 * @param x
	 *            El valor del eje de abcisa que forma la position X de la clase
	 *            position del elemento.
	 * @param y
	 *            El valor del eje de ordenada que forma la position Y de la
	 *            clase position del elemento.
	 * @param cantidad
	 *            El valor de la quantity que se añade a la quantity de disparos
	 *            del juego.
	 */
	public Municion(int x, int y, int cantidad) {
		super(x, y, cantidad);
	}

	/**
	 * Este metodo actualiza la partida añadiendo a los puntos la quantity de
	 * monedas ya establecida, bien sea por defecto o en el constructor.
	 */
	public void updateGamePoints(GestionJuego gestionJuego) {
		gestionJuego.addDisparos(this.quantity);
	}

	public String getImage() {
		return "imagenes/municion.png";
	}

	public int getPuntuacion() {

		return 0;
	}

}
