package topos.structure;

import java.awt.Color;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import topos.elements.ActiveElement;
import topos.elements.Element;
import topos.elements.Pointable;
import topos.game.GameManagement;
import topos.vista1.Pantalla;


/**
 * The Scenery is the one in charge of the organization of the space and the management
 * of elements inside it. The screen is divided by grids. The area of each grid is 1 x 1 
 * The bottom left grid takes the position (0, 0) of the scenery.
 * All the other grids have the same size.
 * The player will move throughout the screen with a target scope and shoot the panels
 * to see if there's anything behind the panel. 
 * The player must all the moles before the time ends.
 * 
 * @author Moradisten
 *
 */

public class Scenery {

	
	private static final int SCREEN_WIDTH = 8;
	private static final int SCREEEN_HEIGHT = 8;
	private static final int SCREEEN_GRID_SIZE = 60;
	private static final java.awt.Color SCREEN_BACKGROUND_COLOR = Color.BLUE;

	private final int width;							// Scenery width								
	private final int height;							// Scenery height	
	private Position target;							// Target scope position	
	private BasicPanel[][] panels;						// Array of panels in the scenery
	private Map<Position, Element> elements;			// Map of elements and positions
	private GameManagement gameManagement;				// game management
	private Pantalla pantalla;							// screen controller						
		
	
	

	public Scenery(int width, int heights) {
		
		if (width <= 0)
			throw new IllegalArgumentException("the width must be greater than 0");
		if (heights <= 0)
			throw new IllegalArgumentException("the height must be greater than 0");
		
		this.height = heights;
		this.width = width;
		pantalla =new Pantalla(SCREEN_WIDTH, SCREEEN_HEIGHT, SCREEEN_GRID_SIZE, SCREEN_BACKGROUND_COLOR);
		
		
		Random random = new Random();
		
		this.panels = new BasicPanel[width][heights];
		
		for (int i = 0; i < heights; i++)
			for (int j = 0; j < width; j++){
					this.panels[i][j] = new BasicPanel(i,j);
					int type = random.nextInt(4);
					switch(type){
					case 0: this.panels[i][j]= new BasicPanel(i,j);
						break;
					case 1:	this.panels[i][j]= new RandomPanel(i,j); 
						break;
					case 2: this.panels[i][j]= new FlashPanel(i,j); 
						break;
					case 3: this.panels[i][j]= new ResistantPanel(i,j,3);
						break;
					default: this.panels[i][j]= new BasicPanel(i,j); 
						break;
			}
			
		}
		
		this.elements = new HashMap<Position,Element>();
		this.target = new Position(0, 0);
			
	}
	

	public int getHeights() {
		return height;
	}
	

	public int getWidth() {
		return width;
	}
	
	
	public void setPanel(BasicPanel panel) throws CloneNotSupportedException {
		this.panels[panel.getPosition().getX()][panel.getPosition().getY()] =  panel.clone();
	}
	
	
	
	public boolean isInsideSurface(Position pos) {
		return ((pos.getX() >= 0 && pos.getX() <= width-1) && (pos.getY() >= 0 && pos.getY() <= height-1));
	}
	
	
	/**
	 * @param position
	 * @return 	Returns the panel that's in the current position which is taken as argument.
	 */
	public BasicPanel getPanel(Position position) {
		if(!isInsideSurface(position))
			throw new IllegalArgumentException("The position given by the argument must inside the Scenery surface");
			
		return panels[position.getX()][position.getY()];
	}
	
	
	/**
	 * @return	This method returns the visibility of a panel by its position
	 */
	public boolean isVisible(Position pos) {
		return (!getPanel(pos).isVisible()); 
	}
	
	
	
	public Position getTarget() {
		return this.target;
	}
		
	
	
	
	/**

	 * This method make the target move.
	 * It the action has been executed sucessfuly it will return a true value.
	 */
	public boolean moveTarget(Direction direction) {
		
			Position adjacent = this.target.getAdjacent(direction);
		
			if (isInsideSurface(adjacent)) {
				this.target.move(direction);
				return true;
			}
			
			return false;
	}
	
	

		public GameManagement getGameManagment() {
			return gameManagement;
		}
		
	/**
	 * Esta operacioÌ�n puede recibir cualquier numero de elementos (argumento variable).
	 * No se aceptara la insercioÌ�n de un element si existe otro que ya ocupa la misma position del escenario.
	 * Esta operacioÌ�n retornara una lista con los elementos que no han sido aceptados.
	 * Notese que no se ofrece ninguna operacioÌ�n para que otros objetos soliciten quitar elementos.
	 * Los elementos iran siendo eliminados por el propio escenario conforme sean disparados por el jugador.
	 * 
	 * This method receives a variable number of element arguments, a tries to put them all
	 * in their respective positions. If an element wants to be set in an occupied position by another element,
	 * then it'll be put in a list. If the position is not occupied the element will put in its respective position
	 * 
	 * @return The method returns a linked list with the elements that couldn't be put in the
	 * scenery.
	 *
	 */
	 public LinkedList<Element> addElements(Element... element){
		LinkedList<Element> list = new LinkedList<Element>();
		
		for (Element elem : element) {
			if (!thereAreElements(elem.getPosition())) {
				elements.put(elem.getPosition(), elem);
				elem.setScenery(this);
			} else {
				list.add(elem);

			}
		}

		return list;
	}
	
	 /**
	  *
	  * @return The method returns a true value is there's any element 
	  * occupying a position passed as an argument.
	  *
	  */
	public boolean thereAreElements(Position pos){
		return (this.consultElement(pos) != null);
	}
	
	/**
	 * @return This method returns the element taking the position passed as an argument
	 * If there's no element, it'll return a null value.
	 * 
	 */
	public Element consultElement(Position pos){	
		for (Element elem : getElements()) {
			Position elemPosition = elem.getPosition();
			if(elemPosition.equals(pos))	
			return elem;					
		}
		return null;
	}
	
	/**

	 * This methods iterates all the pointable elements and returns
	 * the maximum points the player can reach.
	 * 
	 */
	private int getMaxPoints() {
		int counter = 0;
		Iterator<Element> it = elements.values().iterator();
		while(it.hasNext()) {
			Element elem = it.next();
			if(elem instanceof Pointable)
				counter += ((Pointable) elem).getPoints();
		}

		return counter;
	}
	
	
	
	/**
	 * This methods inicializes the time and number of shots and starts the game.
	 * 
	 */
	public void startGame(int seconds, int shots){
		gameManagement = new GameManagement(seconds, shots, getMaxPoints());
		getGameManagment().start();
	}
	
	
	

	
	/**

	 * 
	 * This method represents the action of shooting. The shot will be efective if the game is on.
	 * If it's on, the method will consult the panel where the target position is currently. If it's visible,
	 * the target will strike the panel and bring it down.
	 * If the panel is not visible and there's an element, it target will eliminate it.
	 * After shooting the element, the game will be updated, the elements will be removed from the scenery and
	 * the element scenery will be null.
	 * 
	 */
	public void shoot() {
		if (this.gameManagement.gameIsOn()) {
		
			BasicPanel targetPanel = getPanel(target);
			
			if (isVisible(target)) {			
				if(thereAreElements(target)){
					Element elem = consultElement(target);	
					elem.updateGamePoints(gameManagement);
					elements.remove(elem.getPosition(), elem);
					elem.setScenery(null);
					elem = null;
				}

			} else {
				targetPanel.strike();
			}
			
		}
		this.gameManagement.decreaseShot();
	}

	
	
	public LinkedList<BasicPanel> getPanels() {
		
		LinkedList<BasicPanel> resultado = new LinkedList<BasicPanel>();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				resultado.add(this.panels[i][j]);
		    }
		}
		return resultado;
	}
	
	
	/**
	 * @return This method returns all the elements in the scenery.
	 */
	public Collection<Element> getElements() {
		return Collections.unmodifiableCollection(elements.values());
	}
	
	
	/**
	 * This method requests all the components of the scenery to update their current status.
	 */
	public void update() {
		
		LinkedList<Element> moved = new LinkedList<Element>();
		Iterator<Element> it = elements.values().iterator();
		
		while(it.hasNext()) {
			Element element = it.next();
			if (element instanceof ActiveElement) {
				Position prevPosition = element.getPosition();
				((ActiveElement) element).act();
				if (!prevPosition.equals(element.getPosition())) {
					moved.add(element);
					it.remove();
				}
			}
		}
		
		for(Element element : moved) {
			elements.put(element.getPosition(), element);
		}
		
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				this.panels[i][j].updateVisibility();
		
		
	}
			  
	
	
	
	
	
	/**
	 * 
	 *  This method is in charge of the update of the images of all the components of the game. The steps to follow are:
	 *  - Reset the game screen
	 *  - Go all over the elemens: If They are inside a hidden panel, their image shall be drawn
	 *  - Go over all the panels: If a panel is visible, its image shall be drawn the in its position.
	 *
	 *  - The target scope image shall be drawn
	 *  - status bar in the bottom side(time, shots and points) shall be set and drawn.
	 *  
	 */
	public void refrescar() {	
		
		this.update();
		
		pantalla.resetear();

		for(Element elem: elements.values()) {
			pantalla.addImagen(elem.getPosition().getX(), elem.getPosition().getY(), elem.getImage());
		}
		
		for(int i =0; i < this.getHeights(); i++) {
			for(int j = 0; j < this.getWidth(); j++) {
				if(panels[i][j].isVisible())	this.pantalla.addImagen(panels[i][j].getPosition().getX(), panels[i][j].getPosition().getY(), panels[i][j].getImagen());
			}
		}
		
		pantalla.setBarraEstado("Time Left: " + this.getGameManagment().getTimeLeft() + " - shots available: " + this.getGameManagment().getPendingShots()
					+ " - Score: " + this.getGameManagment().getPoints() + "- Max Points: "+this.getGameManagment().getTotalPoints());
		
		pantalla.addImagen(this.getTarget().getX(), this.getTarget().getY(), "imagenes/objetivo.png");
			
		pantalla.dibujar();
	}
	
	
		
		
	
		/**
		 * 
		 * @return Devuelve la pantalla del escenario.
		 */
		public Pantalla getScreen() {
			return this.pantalla;
		}
	
		
}