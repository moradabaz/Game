package topos.estructura;

import java.awt.Color;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import topos.elementos.Element;
import topos.elementos.ActiveElement;
import topos.elementos.Puntuable;
import topos.juego.GestionJuego;
import topos.vista1.Pantalla;


/**
 * El escenario del juego organiza el espacio en secciones definiendo una cuadricula.
 * Cada seccion se identifica por la position de la cuadricula que ocupa.
 * La seccion situada en la esquina inferior izquierda ocupa la position (0, 0) del escenario.
 * Todas las secciones tienen el mismo tamano.
 * 
 * @author Morad Abbou Azaz y Juan Arnau Sanchez
 *
 */

public class Escenario {


	private final int ancho;												//	El ancho del escenario
	private final int alto;													// 	El alto del Escenario
	private Position objetivo;												//  El objetivo del escenario que va a disparar los paneles
	private PanelBasico[][] paneles;										//	El array de paneles que hay en el escenario
	private Map<Position, Element> elementos;								//  La mapa de elementos que hay en el escenario
	private GestionJuego gestionJuego;										//  La gestion del juego(Tiempo, puntuacion)
	private Pantalla pantalla;			//  Inicializamos la pantalla
	
	
	
	/**
	 * Esta Operacion construye el escenario del juego. Para ello inicializa el ancho y el alto del juego.
	 * Despues va creando en cada position un panel de distinto tipo de manera randomDirection.
	 * Construye un mapa Hash formado por la position de los elementos como clave, y los elementos;
	 * Inicializa el objetivo del escenario a Cero.
	 * @param ancho Inicializa el ancho del Escenario
	 * @param alto	Inicializa el alto del Escenario
	 */
	public Escenario(int ancho, int alto) {
		if (ancho <= 0)
			throw new IllegalArgumentException("ancho debe ser un valor mayor que 0");
		if (alto <= 0)
			throw new IllegalArgumentException("alto debe ser un valor mayor que 0");
		
		this.alto = alto;
		this.ancho = ancho;
		pantalla =new Pantalla(8,8,60, Color.GREEN);
		
		
		Random random = new Random();
		
		
		
		
		this.paneles = new PanelBasico[ancho][alto];
		
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++){
					this.paneles[i][j] = new PanelBasico(i,j);
			int a = random.nextInt(4);
			switch(a){
			case 0: this.paneles[i][j]= new PanelBasico(i,j);
				break;
			case 1:	this.paneles[i][j]= new PanelAleatorio(i,j); break;
			case 2: this.paneles[i][j]= new PanelFlash(i,j); break;
			case 3: this.paneles[i][j]= new PanelResistente(i,j,3); break;
			default: this.paneles[i][j]= new PanelAleatorio(i,j); break;
			}
			
			}
				 // visible
		
		this.elementos = new HashMap<Position,Element>();
		
		this.objetivo = new Position(0, 0);
			
	}
	
	/**
	 * @return	Devuelve el alto del escenario.
	 */
	public int getAltura() {
		return alto;
	}
	
	/**
	 * @return Devuelve el alto del escenario.
	 */
	public int getAnchura() {
		return ancho;
	}
	
	/**
	 * Toma el tipo de panel que se le pasa como parametro en el array de paneles.
	 * @param panel	Panel que toma la position del array de paneles.
	 */
	
	public void setPanel(PanelBasico panel) {
		
		
		this.paneles.clone()[panel.getPosition().getX()][panel.getPosition().getY()] = panel;
	}
	
	/**
	 * @param pos Position en la que tiene que devolver el tipo de panel.
	 * @return 	Devuelve el panel que hay en la position que toma el metodo como parametro.
	 */
	public PanelBasico getPanel(Position pos) {
		if((pos.getX() < 0) || (pos.getX() > (ancho-1)) || (pos.getY() < 0) || (pos.getY() > (alto-1)))
			throw new IllegalArgumentException("La position del parametro debe estar dentro del Escenario");
		
		
		return this.paneles.clone()[pos.getX()][pos.getY()];
	}
	
	
	/**
	 * @param pos Position que toma el escenario para ver si el panel que esta en dicha position es visible o no.
	 * @return	Devuelve la visibilidad de un panel en una position que toma como parametro.
	 */
	public boolean isVisible(Position pos) {
		
		return (!getPanel(pos).isVisible()); 
		
	}
	
	
	
	/**
	 * Esta operacion se encarga de devolver un valor true si la position que toma como parametro esta dentro
	 * del escenario.
	 * @param pos Position en la que se compreuba si esta dentro del escenario.
	 * @return	Devuelve un valor verdadero si la position esta dentro del escenario, y un valor false
	 * en caso contrario.
	 */
	public boolean isDentro(Position pos) {
		
		return ((pos.getX() >= 0 && pos.getX() <= ancho-1) && (pos.getY() >= 0 && pos.getY() <= alto-1));
	}
	
	
	/**
	 * 
	 * @return Devuelve la position del Objetivo.
	 */
	public Position getObjetivo() {
			return this.objetivo;
		}
		
	
	
	
	/**
	 * Esta operacion devuelve un booleano si la position del objetivo ha podido
	 * desplazarse a la direction que se le pasa al metodo como parametro.
	 * @param direction Direction a la que se desplaza el objetivo.
	 * @return Devuelve un booleano si el objetivo se ha movido a la direction dada.
	 */
	public boolean moverObjetivo(Direction direction) {
		
			Position posvecina = this.objetivo.getAdyacent(direction);
		
			if (isDentro(posvecina)) {
			
				this.objetivo.move(direction);
				return true;
			}
			else return false;
			
	}
	/**
	 * @return Devuelve la gestion del juego del escenario.
	 */
	
		public GestionJuego getGestionJuego() {
		return gestionJuego;
		}
		
	/**
	 * Esta operación puede recibir cualquier numero de elementos (argumento variable).
	 * No se aceptara la inserción de un element si existe otro que ya ocupa la misma position del escenario.
	 * Esta operación retornara una lista con los elementos que no han sido aceptados.
	 * Notese que no se ofrece ninguna operación para que otros objetos soliciten quitar elementos.
	 * Los elementos iran siendo eliminados por el propio escenario conforme sean disparados por el jugador.
	 * 
	 * @param element Lista de elementos que se van anadiendo
	 * @return Devuelve la lista de elementos que han sido anadidos en las posiciones desocupadas.
	 *
	 */
	 public LinkedList<Element> addElementos(Element... element){
		LinkedList<Element> lista = new LinkedList<Element>();
		
		for (Element elem : element) {
			if (!this.hayElementos(elem.getPosition())) {
				this.elementos.put(elem.getPosition(), elem);
				elem.setEscenario(this);
			} else {
				lista.add(elem);

			}
		}

		return lista;
	}
	
	 /**
	  * Esta operacion consulta si hay algun elemento en una position del escenario retornando un valor booleano.
	  * La implentacion de este metodo puede apoyarse en la anterior,
	  * de modo que hay un elemento en una position si la referencia que se obtiene es distinta del valor nulo.
	  * @param pos Position que toma como parametro para consultar si hay un elemento
	  * @return Valor booleano en funcion de si el elemento esta o no.
	 * 
	  */
	public boolean hayElementos(Position pos){
		if (this.consultaElemento(pos) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Una operacion para consultar el elemento situado en una position del escenario.
	 * Ten en cuenta que los elementos tienen asociada su position.
	 * Si se encuentra un elemento en la position que se consulta, se retornara su referencia.
	 * En caso contrario se retornara el valor nulo.
	 * @param pos Position en la cual se hace la consulta.
	 * @return Devuelve la referencia del elemento si se encuentra en esa position
	 * y devuelve un valor nulo si no existe elemento.
	 * 
	 */
	public Element consultaElemento(Position pos){
		
		
		
		
		
		for (Element elem : getElemento()) {
			Position posicionelemento = elem.getPosition();
			//if (posicionelemento.getX() == pos.getX() && posicionelemento.getY() == pos.getY()) 
			if(posicionelemento.equals(pos))	
			return elem;
								
		}
		
		return null;
	}
	
	// GETPUNTOSTOTALES
	/**
	 * Este metodo se encarga de recorrer con un iterador todos
	 * los elementos del escenario que sean puntuables para obtener
	 * la puntuacion maxima que se pueda alcanzar.
	 * 
	 * @return Retorna la puntuacion maxima equivalente
	 * a la suma de todos los elementos puntuables del escenario.
	 */
	private int getPuntuables()
	{
		int n = 0;
		Iterator<Element> it;
		
		it = getElemento().iterator();
		
		while(it.hasNext()){
			Element elem = it.next();
			if(elem instanceof Puntuable)
				n += ((Puntuable) elem).getPuntuacion();
			}
			
		/*for(Element elem : elementos.values()){
			if(elem instanceof Puntuable)
					n+= ((Puntuable) elem).getPuntuacion();
		}*/
		
		return n;
	}
	
	
	
	// Funcionalidad
	/**
	 * Inicializa el tiempo y los disparos de la gestion del juego del escenario.
	 * @param segundos	Los segundos con los que comienza el juego.
	 * @param disparosRestantes	Los disparos con los que comienza el juego.
	 */
	public void iniciarPartida(int segundos, int disparosRestantes ){
		
		this.getPuntuables();
		
		this.gestionJuego = new GestionJuego(segundos, disparosRestantes, this.getPuntuables());
		
		this.getGestionJuego().arrancar();
	}
	
	
	

	
	/**
	 * Esta accion representa la acción de disparo del arma del jugador. El disparo se hara efectivo si la partida esta en juego.
	 * Si es asi, se consulta el panel de la position del objetivo. Si esta visible, aplica el metodo golpear sobre el panel.
	 * En caso contrario, si en esa position hay un elemento lo elimina del escenario.
	 * Para ello se solicita al elementos que actualice la partida y 
	 * se elimina la relacion bidireccional entre el elementos y el escenario, esto es, saca al elemento del escenario y
	 * se le indica al elementos que ya no tiene escenario (su escenario es nulo).
	 * 
	 */
	public void disparar() {
		
	
		
		if (this.gestionJuego.enJuego()) {
		
			PanelBasico objetivo = getPanel(this.objetivo);
			
			if (isVisible(this.objetivo)) {
				Element elem = this.consultaElemento(this.objetivo);
				if(hayElementos(this.objetivo)){
					elem.updateGamePoints(gestionJuego);
					elem.setEscenario(null);
					if(elem instanceof Puntuable)
					{	
						this.gestionJuego.decPuntosPendientes(gestionJuego.getPuntos());
						
					}
				 
				 this.elementos.remove(elem.getPosition(), elem);
				 this.elementos.remove(elem.getImage());
				}
			
			
			}else {
				objetivo.golpear();
			}
			
		}
		this.gestionJuego.consumeDisparo();
	}
	
	/**
	 * 
	 * @return Devuelve una Lista enlazada con todos los paneles del escenario.
	 */
	
	public LinkedList<PanelBasico> getPaneles() {
		
		LinkedList<PanelBasico> resultado = new LinkedList<PanelBasico>();
		
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++)
				resultado.add(this.paneles[i][j]);
		
		return resultado;
	}
	
	
	/**
	 * 
	 * @return Devuelve una coleccion con todos los elemenentos del escenario.
	 */
	
	public Collection<Element> getElemento() {
		
		Collection<Element> lista = new LinkedList<Element>();
		for(Element elem: elementos.values()){
			lista.add(elem);
			elem.setEscenario(this);
		}
		Collection<Element> Copia = Collections.unmodifiableCollection(lista);

		return Copia;
	}
	
	
	/**
	 * Este metodo solicita a los componentes del escenario que actualicen su estado. 
	 * Para ello aplicara el metodo actualizar sobre todos los paneles y el metodo act sobre todos los elementos.
	 * 
	 */
	public void actualizar() {
		
		
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++)
				this.paneles[i][j].actualizarPanel1();
		
		
		

			for(Element elem : this.getElemento()){
			if(elem instanceof ActiveElement){
				
				
					Position posAntigua = elem.getPosition();
					
					((ActiveElement) elem).act();
					Position posNueva = elem.getPosition();
			
					if(posAntigua.equals(posNueva)){
						elementos.remove(posAntigua);
						elementos.put(elem.getPosition(), elem);
							
							}
					}
			elem.setEscenario(this);		
		}	

	}
			  
	
	
	
	
	
	/**
	 *  Esta operacion esta a cargo de actualizar las imagenes de la pantalla. Los pasos que debe realizar son los siguientes:
	 *	• Resetear la pantalla.
	 *	• Recorrer todos los paneles: si estan visibles, anadir su imagen a la seccion de la pantalla correspondiente con su position.
	 *	• Recorrer los elementos: si estan detras de un panel oculto (la seccion del escenario es visible), anadir su imagen a la seccion de la pantalla correspondiente con position.
	 *	• Anadir la imagen del objetivo (arma del jugador) en la position que corresponda.
	 *	• Establecer la informacion de la barra de estado: tiempo restante, disparos y puntos.
	 *	• Actualizar graficamente los cambios solicitando a la pantalla que vuelva a dibujar.
	 * 
	 *
	 */
	public void refrescar()
	{	
		pantalla.resetear();

		for(Element elem: elementos.values())
			pantalla.addImagen(elem.getPosition().getX(), elem.getPosition().getY(), elem.getImage());
		
		
		
		for(int i =0; i < this.getAltura(); i++)
			for(int j = 0; j < this.getAnchura(); j++)
				if(paneles[i][j].isVisible())	this.pantalla.addImagen(paneles[i][j].getPosition().getX(), paneles[i][j].getPosition().getY(), paneles[i][j].getImagen());
	
		
		
		
		
		
			pantalla.setBarraEstado("Tiempo restante: " + this.getGestionJuego().getSegundosRestantes() + " - Disparos Restantes: " + this.getGestionJuego().getDisparosRestantes()
					+ " - Puntuacion: " + this.getGestionJuego().getPuntosPendientes() + "-P: "+this.getGestionJuego().getPuntoTotales() );
		
			pantalla.addImagen(this.getObjetivo().getX(), this.getObjetivo().getY(), "imagenes/objetivo.png");
			
			
			pantalla.dibujar();
		}
	
	
		
		
	
		/**
		 * 
		 * @return Devuelve la pantalla del escenario.
		 */
		public Pantalla getPantalla()
		{
			return this.pantalla;
		}
	
		
}