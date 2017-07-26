package topos.game;



import topos.structure.Direction;
import topos.structure.Scenery;
import topos.elements.*;
import topos.vista1.Alarma;
import topos.vista1.Pantalla;







/**
 *  
 * Este programa se encarga de construir un escenario, añadir varios topos e iniciar una partida.
 * @author Morad
 *
 */

public class Game {
	
		public static boolean fin = false;
	
	public static void main (String[] args) 
	{
		
		Scenery escenario =  new Scenery(8,8);
		
		Pantalla pantalla = escenario.getScreen();
		
		BlindMole topo1 = new BlindMole(1,2);
		SmartMole topo2 = new SmartMole(1,4);
		ClumsyMole topo3 = new ClumsyMole(1,6);
		ClumsyMole topo4 = new ClumsyMole(4,6);

		Rat rata = new Rat(4,4);
		Ammo municion = new Ammo(2,5,20);
		Clock reloj = new Clock(3,1, 10);
		Coin moneda = new Coin(5,1, 5);
		
		escenario.addElements(topo1,topo2,topo3, topo4,municion,rata,reloj,moneda);

		escenario.startGame(150, 160);

		while(!fin) {
		//escenario.update();
			
		escenario.refrescar();
		
		if(pantalla.hayTecla()) {
			
			String tecla = pantalla.leerTecla();

				switch (tecla)
				{
				case "i" : escenario.moveTarget(Direction.UP); 		break;
				case "j" : escenario.moveTarget(Direction.LEFT); 	break;
				case "k" : escenario.moveTarget(Direction.DOWN); 	break;
				case "l" : escenario.moveTarget(Direction.RIGHT); 	break;
				case "d" : escenario.shoot();  						break;		
							
				default : break;
				}
			
			}
		
		
		
		if(!escenario.getGameManagment().shotsAvailable() || escenario.getGameManagment().TimeEnd() || escenario.getGameManagment().getPendingPoints()<=0)
			{
			fin = true;
			pantalla.setBarraEstado("Fin de Juego");
			}
		
		
		if(escenario.getElements().isEmpty() || escenario.getGameManagment().getPendingPoints() == 0 )
		{
			pantalla.resetear();
			fin = true;
			pantalla.setBarraEstado("ENHORABUENA!!!	Tiempo restante: " + escenario.getGameManagment().getTimeLeft());
		}
		
		
				
		
		Alarma.dormir(100);
	}
		
		if(fin == true) System.out.println("Puntuacion:"+escenario.getGameManagment().getPoints());
}
 
}
	


