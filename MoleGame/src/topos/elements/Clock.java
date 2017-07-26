package topos.elements;

import topos.game.GameManagement;

public class Clock extends PasiveElement {
	/*
	 * The clock adds time to the game once it's found and
	 * shot
	 */

	public static final int SECONDS = 30;
	
	public Clock(int x, int y) {
		super(x, y);
	}

	public Clock(int x, int y, int cantidad) {
		super(x, y, cantidad);
	}

	public void updateGamePoints(GameManagement gestionJuego) {
		gestionJuego.addSeconds(SECONDS);
	}

	public String getImage() {
		return "imagenes/reloj.png";
	}


}
