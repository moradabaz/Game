package topos.juego;



import topos.elementos.*;
import topos.estructura.Direction;
import topos.estructura.Escenario;

import topos.elementos.BlindMole;
import topos.vista1.Alarma;
import topos.vista1.Pantalla;







/**
 *  
 * Este programa se encarga de construir un escenario, añadir varios topos e iniciar una partida.
 * @author Morad
 *
 */

public class Partida {
	
		public static boolean fin = false;
	
	public static void main (String[] args) 
	{
		
		Escenario escenario =  new Escenario(8,8);
		
		Pantalla pantalla = escenario.getPantalla();
		
		BlindMole topo1 = new BlindMole(1,2);
		TopoListo topo2 = new TopoListo(1,4);
		TopoTorpe topo3 = new TopoTorpe(1,6);
		Rata rata = new Rata(4,4);
		Municion municion = new Municion(2,5);
		Reloj reloj = new Reloj(3,1);
		Monedas moneda = new Monedas(5,1);
		
		escenario.addElementos(topo1,topo2,topo3,municion,rata,reloj,moneda);

		escenario.iniciarPartida(150, 160);

		while(!fin)
		{
		escenario.actualizar();
			
		escenario.refrescar();
		
		if(pantalla.hayTecla())
		{
			String tecla = pantalla.leerTecla();
			
			
				switch (tecla)
				{
				case "i" : escenario.moverObjetivo(Direction.UP); 	break;
				case "j" : escenario.moverObjetivo(Direction.LEFT); 	break;
				case "k" : escenario.moverObjetivo(Direction.DOWN); 	break;
				case "l" : escenario.moverObjetivo(Direction.RIGHT); 	break;
				case "d" : escenario.disparar();  break;		
							
				default : break;
				}
			
			}
		
		
		
		if(!escenario.getGestionJuego().haydisparos() || escenario.getGestionJuego().tiempoFinalizado() || escenario.getGestionJuego().getPuntosPendientes()<=0)
			{
			fin = true;
			pantalla.setBarraEstado("Fin de Juego");
			}
		
		
		if(escenario.getElemento().isEmpty() || escenario.getGestionJuego().getPuntosPendientes() == 0 )
		{
			pantalla.resetear();
			fin = true;
			pantalla.setBarraEstado("¡¡¡ENHORABUENA!!!	Tiempo restante: " + escenario.getGestionJuego().getSegundosRestantes());
		}
		
		
				
		
		Alarma.dormir(200);
	}
		
		if(fin == true) System.out.println("Puntuacion:"+escenario.getGestionJuego().getPuntos());
}
 
}
	


