
package topos.estructura;

import java.util.LinkedList;

/**
 * Un panel resistente se caracteriza por su capacidad para soportar varios
 * golpes consecutivos antes de ser derribado (quedar oculto). Esta
 * caracteristica la proporciona su propiedad dureza, que se establece en la
 * construccion y no cambia. Un panel resistente sera derribado si recibe un
 * numero de golpes consecutivos igual a su dureza en menos de un segundo.
 * 
 * @author Morad Abbou Azaz
 *
 */

/**
 * @author Morad
 *
 */
public class PanelResistente extends PanelBasico {

	public final int TIEMPO = 1000;

	private final int dureza; // Dureza que tiene el panel

	private LinkedList<Long> marcatiempo = new LinkedList<Long>();

	/**
	 * Construye el panel, solo que esta vez le anade un atributo mas, que es la
	 * dureza del panel.
	 * 
	 * @param x
	 *            Position X del Panel.
	 * @param y
	 *            Position Y del panel.
	 * @param dureza
	 *            Entero que indica la dureza del panel.
	 */
	public PanelResistente(int x, int y, int dureza) {
		super(x, y);
		this.dureza = dureza;
	}

	/**
	 * Constructor de cuatro argumentos
	 * 
	 * @param x
	 *            La position del eje X.
	 * @param y
	 *            La position del eje Y.
	 * @param visible
	 *            Establece la visibilidad del panel.
	 * @param dureza
	 *            Establece la dureza del panel resistente.
	 */
	public PanelResistente(int x, int y, boolean visible, int dureza) {
		super(x, y, visible);
		this.dureza = dureza;
	}

	/**
	 * 
	 * El tamano de esta lista sera como maximo el valor de la propiedad dureza,
	 * puesto que solo interesa tener en cuenta ese numero de golpes. En primer
	 * lugar, al recibir un golpe almacena la marca de tiempo del instante
	 * actual. A continuacion comprueba, si la lista tiene el tamano maximo
	 * (dureza) y la diferencia de tiempo entre el ultimo y el primer golpe es
	 * menor que un segundo, entonces el panel resistente se comporta como un
	 * panel basico (es derribado y se oculta). Ademas, la lista de golpes se
	 * vaciara para comenzar de nuevo el control de los golpes. En cambio, si el
	 * numero de golpes es igual a la dureza, pero ha pasado mas de un segundo
	 * entre el primer y ultimo golpe registrado en la lista, entonces el primer
	 * golpe almacenado en la lista sera eliminado.
	 * 
	 * @see topos.estructura.PanelBasico#golpear()
	 */

	public void golpear() {

		marcatiempo.add(System.currentTimeMillis());

		if (marcatiempo.size() == dureza && marcatiempo.getLast() - marcatiempo.getFirst() < TIEMPO) {

			super.golpear();
			marcatiempo.clear();
		} else if (marcatiempo.size() == dureza) {
			marcatiempo.removeFirst();
		}
	}

	/**
	 * 
	 * @see topos.estructura.PanelBasico#getImagen()
	 */
	public String getImagen() {

		return "imagenes/panel-resistente.gif";
	}

}
