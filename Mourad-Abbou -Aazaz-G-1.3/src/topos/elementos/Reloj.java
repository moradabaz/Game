package topos.elementos;

import topos.juego.GestionJuego;

public class Reloj extends PasiveElement implements Puntuable {
	/*
	 * Por �ltimo, un reloj es un tipo de elemento pasivo que contribuye en
	 * �actualizar partida� sumando segundos al tiempo de la partida. La
	 * quantity de segundos es igual a la propiedad quantity de los elementos
	 * pasivos.
	 */

	public Reloj(int x, int y) {
		super(x, y);
	}

	public Reloj(int x, int y, int cantidad) {
		super(x, y, cantidad);
	}

	public void updateGamePoints(GestionJuego gestionJuego) {
		gestionJuego.addSegundos(quantity);
	}

	public String getImage() {
		return "imagenes/reloj.png";
	}

	@Override
	public int getPuntuacion() {
		// TODO Auto-generated method stub
		return quantity;
	}

}
