package Pruebas;

import topos.juego.GestionJuego;


public class PruebaGestionJuego {
	
	public static void main(String[] args) {
	
//	Crea un objeto GestionJuego con una duraci�n de 60 segundos y 3 disparos. Arranca la partida.
	GestionJuego partida = new GestionJuego(60,3, 0);
	
//	- Muestra en la consola si la partida est� en juego. La respuesta debe ser true.
    System.out.println("La partida est� en juego: "+partida.enJuego());
    
//	- Muestra en la consola los puntos. La respuesta debe ser 0.
    System.out.println("Puntos: "+partida.getPuntos());
    
//	- Simula que se dispara 4 veces, con lo que se pierden 4 disparos.
    partida.addDisparos(4);
    System.out.println("Disparos disponibles: "+partida.getDisparosRestantes());

    
//	- Muestra en la consola los disparos restantes. La respuesta debe ser 0.
    System.out.println("Tras disparar 4 veces, los disparos restantes son: "+partida.getDisparosRestantes());
    
//	- Gana 5 puntos.
    partida.addPuntos(5);
    
//	- Pausa la ejecuci�n durante 4 segundos (ver NOTA).
    partida.addSegundos(60);
    long fin = System.currentTimeMillis() + 4000; // 4000 ms = 4seg
    while (System.currentTimeMillis() < fin);
    
//	- Muestra en la consola los segundos restantes. La
//	respuesta debe ser 56.
    System.out.println("Los segundos son: "+partida.getSegundosRestantes());
    System.out.println("Al pausar durante 4 s, los segundos restantes son: "+partida.getSegundosRestantes());
    
//	- Muestra en la consola si el tiempo ha finalizado. La respuesta debe ser false.
    System.out.println("�El tiempo ha finalizado? : "+partida.enJuego());
    
//	- Muestra en la consola si la partida est� en juego. La respuesta debe ser false (no quedan disparos).
    System.out.println("�Partida en juego? (no quedan disparos) : "+partida.enJuego());
    
//	- Muestra en la consola los puntos conseguidos. La respuesta debe ser 5. 
    System.out.println("Ahora los puntos son: " + partida.getPuntos());

  }
}
