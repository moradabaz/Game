package topos.elements;

import topos.game.GameManagement;


public class Ammo extends PasiveElement {


	public static final int AMMO = 20;
	
	
	public Ammo(int x, int y) {
		super(x, y);
	}


	public Ammo(int x, int y, int cantidad) {
		super(x, y, cantidad);
	}


	public void updateGamePoints(GameManagement gestionJuego) {
		gestionJuego.addShots(AMMO);
	}

	public String getImage() {
		return "imagenes/municion.png";
	}


}
