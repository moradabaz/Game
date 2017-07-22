


package topos.elementos;

import topos.estructura.Direction;
import topos.juego.GestionJuego;

/**
 * Las ratas son un tipo de elementos activos que perjudican al jugador cuando
 * son disparadas, decrementando en una unidad la puntuacion del juego.
 * 
 * @author Morad
 *
 */
public class Rata extends ActiveElement {
	/**
	 * Este constructor inicializa la position del elemento con los dos
	 * parametros que recibe como argumento.
	 * 
	 * @param x
	 *            El valor del eje de abcisa que forma la position X de la clase
	 *            position del elemento.
	 * @param y
	 *            El valor del eje de ordenada que forma la position Y de la
	 *            clase position del elemento.
	 */
	public Rata(int x, int y) {
		super(x, y);
	}

	/**
	 * 
	 */
	public void act() {
		if (super.escenario != null && canMove()) {
			Direction dir = calculateDirection();
			if (System.currentTimeMillis() - lastMove > WAIT_TIME) {
				if (moveElement(dir))
					lastMove = System.currentTimeMillis();
			}

		}
	}

	/**
	 * @return La rata siempre puede moverse. Por eso devuelve un valor true.
	 */
	public boolean canMove() {

		return true;
	}

	/**
	 * Este metodo decrementa en una unidad la puntuacion al disparar al
	 * elemento rata.
	 */
	public void updateGamePoints(GestionJuego gestionjuego) {
		gestionjuego.decPuntosPendientes(1);

	}

	/**
	 * Este metodo se encarga de calcular y retornar una direccio. Primero
	 * comprueba si las posiciones a las que se mueven las direcciones estan
	 * visibles y estan dentro del escenario. Entonces se coge la primera que
	 * cumple esta condicion. Si no existen direcciones que cumplan esta
	 * condicion se retornara una direccion randomDirection.
	 */
	public Direction calculateDirection() {

		if (this.escenario.isDentro(this.position.getAdyacent(Direction.UP))
				&& this.escenario.isVisible(this.position.getAdyacent(Direction.UP))) {
			return Direction.UP;
		} else if (this.escenario.isDentro(this.position.getAdyacent(Direction.LEFT))
				&& this.escenario.isVisible(this.position.getAdyacent(Direction.LEFT))) {
			return Direction.LEFT;
		} else if (this.escenario.isDentro(this.position.getAdyacent(Direction.DOWN))
				&& this.escenario.isVisible(this.position.getAdyacent(Direction.DOWN))) {
			return Direction.DOWN;
		} else if (this.escenario.isDentro(this.position.getAdyacent(Direction.RIGHT))
				&& this.escenario.isVisible(this.position.getAdyacent(Direction.RIGHT))) {
			return Direction.RIGHT;
		}

		return Direction.randomDirection();
	}

	public String getImage() {

		return "imagenes/rata.png";
	}

	/*
	 * public void act() {
	 * 
	 * 
	 * 
	 * if(System.currentTimeMillis() - lastMove > TIEMPOESPERA)
	 * if(calcularDesplazamiento(calculateDirection())) lastMove =
	 * System.currentTimeMillis(); }
	 * 
	 * @Override public boolean canMove() { if
	 * (!this.escenario.isVisible(this.position.getAdyacent(calculateDirection())))
	 * return false; return true; }
	 * 
	 * 
	 * public Direction calculateDirection() { if
	 * (this.escenario.isDentro(this.position.getAdyacent(Direction.UP)) &&
	 * this.escenario.isVisible(this.position .getAdyacent(Direction.UP))){
	 * return Direction.UP; }else if
	 * (this.escenario.isDentro(this.position.getAdyacent(Direction.LEFT))&&
	 * this.escenario.isVisible(this.position .getAdyacent(Direction.LEFT))){
	 * return Direction.LEFT; }else if
	 * (this.escenario.isDentro(this.position.getAdyacent(Direction.DOWN))&&
	 * this.escenario.isVisible(this.position .getAdyacent(Direction.DOWN))){
	 * return Direction.DOWN; }else if
	 * (this.escenario.isDentro(this.position.getAdyacent(Direction.RIGHT)) &&
	 * this.escenario.isVisible(this.position .getAdyacent(Direction.RIGHT))){
	 * return Direction.RIGHT;}
	 * 
	 * return Direction.randomDirection(); }
	 * 
	 * 
	 * public void updateGamePoints(GestionJuego gestionjuego){
	 * gestionjuego.deletePuntos(1); }
	 * 
	 * public String getImage(){ return "imagenes/rata.png"; }
	 * 
	 * 
	 * 
	 * public boolean DesplazamientoEfectuado(Direction direccion) throws
	 * CloneNotSupportedException { Position pos = position;
	 * 
	 * 
	 * if(escenario.isDentro(position.getAdyacent(direccion)) &&
	 * !escenario.hayElementos(position.getAdyacent(direccion))){
	 * this.move(direccion);
	 * 
	 * if(!pos.equals(position)) return true; } return false; }
	 * 
	 * 
	 * public int getPuntuacion() { return 0; }
	 * 
	 * 
	 * 
	 * 
	 * @Override public void act() { // TODO Auto-generated method stub
	 * 
	 * }
	 */
}
