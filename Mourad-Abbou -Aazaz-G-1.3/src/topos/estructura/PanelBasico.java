package topos.estructura;




public class PanelBasico {

	// Tiempo en milis que permanece oculto un panel cuando es golpeado 
	
	public static final int TIEMPO_OCULTO = 5000;
	
	// La posiciÛn no es imprescindible
	// Resulta necesario para utilizar la librerÌa gr·fica de cursos anteriores
	// Con la nueva librerÌa podrÌa quitarse
	
	private Position position;
	
	private boolean visible;
	
	private long tiempoGolpeo;
	
	
	/**
	 * Contruye la clase PanelBasico. Inicializa sus posiciones con los valores que se 
	 * le pasan como parametro y lo hace visible. 
	 * @param x	Parametro que inicializa la position del eje X.
	 * @param y	Parametro que inicializa la position del eje Y.
	 * @param visible Parametro booleano que hace visible u oculto  el panel.
	 */
	
	public PanelBasico(int x, int y, boolean visible) {
		if((x<0)||(y<0)) throw new IllegalArgumentException("Los valores de las posiciones no pueden ser negativos");

		this.position = new Position(x, y);
		
		this.visible = visible;
		
		this.tiempoGolpeo = 0;
	}
	
	
	/**
	 *	Constructor que ejecuta las mismas instrucciones que el constructor anterior, solo 
	 *	que simplifica el numero de parametros.
	 * @param x Parametro que inicializa el eje X.
	 * @param y Parametro que inicializa el eje Y.
	 */
	public PanelBasico(int x, int y)  {
		
		this(x, y, true); // visible = true
	}
	
	public Position getPosition() {
		
		// aliasing
		
		return new Position(position);
	}
	
	public void setPosition(Position pos) {
		
		// aliasing
		
		this.position = new Position(pos);
	}
	
	public boolean isVisible() {
		
		return visible;
	}
	
	// SÛlo permitido a las clases descendientes
	
	protected void setVisible(boolean visible) {
		
		this.visible = visible;
	}
	
	public boolean isOculto() {
		
		return !visible;
	}
	

	
	public void golpear() {
		
		if (isVisible()) {
			this.visible = false;		
			tiempoGolpeo = System.currentTimeMillis();
		}		
	}
	
	public void actualizarPanel1() {
		
		if (System.currentTimeMillis() - tiempoGolpeo > TIEMPO_OCULTO)
			this.visible = true;
	}

	

	
	public String getImagen() {
		return "imagenes/panel-basico.gif";
	}

	
	public int getPosicionX() {
		
		return position.getX();
	}

	
	public int getPosicionY() {
		
		return position.getY();
	}

	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + (int) (tiempoGolpeo ^ (tiempoGolpeo >>> 32));
		result = prime * result + (visible ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null && this != null) {
			return false;
		}
		if (!(obj instanceof PanelBasico)) {
			return false;
		}
		
		if (obj instanceof PanelFlash)
			return false;
		
		if (obj instanceof PanelResistente)
			return false;
		
		if(obj instanceof PanelAleatorio)
			return false;
		
		PanelBasico other = (PanelBasico) obj;
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		if (tiempoGolpeo != other.tiempoGolpeo) {
			return false;
		}
		if (visible != other.visible) {
			return false;
		}
		return true;
	}


}


