package topos.estructura;


/**
 * Un panel flash se caracteriza por restaurar su visibilidad (pasar de oculto a visible)
 * la segunda vez que el escenario solicita la acción actualizar. 
 * De este modo, una vez que es golpeado y pasa a estar oculto,
 * la región que ocupa quedaría visible durante un corto periodo de tiempo.
 * 
 * @author Morad
 *
 */

public class PanelFlash extends PanelBasico {

	private int contador = 0;
	
	public PanelFlash(int x, int y) {
		super(x, y);
		
	}

		
	/**
	 * Este constructor realiza los mismas funciones que el constructor PanelBasico usando los metodos
	 * de herencia.
	 * @see	PanelBasico#PanelBasico(int, int, boolean)
	 * @param x	 Parametro que inicializa la position del eje X.
	 * @param y	 Parametro que inicializa la position del eje Y.
	 * @param visible	Parametro booleano que hace visible u oculto  el panel.
	 */
	public PanelFlash(int x, int y, boolean visible) {
		super(x, y, visible);
		
	}

	/**
	 * Este metodo se redefine de la clase PanelBasico.
	 * Consiste basicamente en hacer que el panel sea visible cuando pasa un
	 * corto periodo de tiempo desde que se golpea hasta el momento actual.
	 * Basicamente, cuando se actualiza por segunda vez y el panel esta oculto 
	 * se vuelve a poner visible. 
	 * 
	 *	@see PanelBasico#actualizarPanel1()
	 */
	@Override
	public void actualizarPanel1() {
		
		contador++;
		if(contador >= 2)
		{	if(!isVisible()){
			setVisible(true);
			}
		  contador = 0;
		}
	}
	
	/**
	 * 
	 * @see topos.estructura.PanelBasico#getImagen()
	 */
	public String getImagen() {
		
		return "imagenes/panel-flash.gif";
	}
}