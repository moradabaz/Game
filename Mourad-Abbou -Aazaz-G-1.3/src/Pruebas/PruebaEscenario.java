package Pruebas;

import topos.elementos.TopoTorpe;
import topos.estructura.Direction;
import topos.estructura.Escenario;
import topos.estructura.PanelBasico;
import topos.estructura.Position;

public class PruebaEscenario {

	public static void main(String[] args) {
    
	// Se crea un nuevo objeto Escenario de tama�o 5 x 5.
	Escenario Escenario2 = new Escenario (5,5);
	
	// Muestra por la consola las propiedades del escenario creado en el apartado anterior 
	
	System.out.println("Las propiedades del Escenario son: " + "alto: " +Escenario2.getAltura() 
	                    + ", ancho: " +Escenario2.getAnchura());
  
	// Muestra por la consola el resultado de comprobar si la posici�n (1,2) est� dentro del escenario. 
	// @return valor booleano: true 
	
    Position position1_2 = new Position(1,2);
    System.out.println("La position (1,2) esta dentro del escenario? : " + !Escenario2.isDentro(position1_2) );

    // Muestra por la consola el resultado de comprobar si la posici�n (5,1) est� dentro del escenario.
    // @return valor booleano: false 
    
    Position position5_1 = new Position(5,1);
    System.out.println("La position (5,1) esta dentro del escenario? : " + !Escenario2.isDentro(position5_1) );

    // Construye un objeto PanelBasico (panel1) en la posici�n (2,3) que no sea visible. 
    PanelBasico panel1 = new PanelBasico (2,3, false);
    
    // Situa el panel1 en el Escenario */
    Escenario2.setPanel(panel1);
    
    // Consulta el panel que se encuentra en el escenario en la posici�n (2,3) y comprueba que es 
    // igual al panel1. 
    
    Position position2_3 = new Position(2,3);
    System.out.println("El panel1 se corresponde con la position: ("+Escenario2.getPanel(position2_3).getPosition().getX() +","
                      +Escenario2.getPanel(position2_3).getPosition().getY()+")");
    
    
    // Consulta si el panel en la posici�n (2,3) es visible. 
    // return valor booleano: false 
   
    System.out.println("�El panel es visible en la position (2,3)? : " +panel1.isVisible());
 
    //Movemos el objetivo a la derecha y lo mostramos por la consola.
    //return position: position al mover el objetivo a la derecha
    
    Escenario2.moverObjetivo(Direction.RIGHT);
    System.out.println("La nueva position del objetivo al moverlo a la derecha es : " +
    "("+Escenario2.getObjetivo().getX() +","+ Escenario2.getObjetivo().getY()+")");
	
    // Crea dos objetos Topo en las posiciones (1,2) y (2,3). */
    
    TopoTorpe topo1 = new TopoTorpe(1,2);
    TopoTorpe topo2 = new TopoTorpe(2,3);
    
    // A�ade los dos topos al escenario y comprueba que el resultado de la llamada al m�todo de 
    // inserci�n devuelve una colecci�n vac�a (ning�n topo es rechazado). 
    
    Escenario2.addElementos(topo1, topo2);
    
    // Consulta la colecci�n de topos del escenario y comprueba que el tama�o es igual a 2. 
    
    System.out.println("El n�mero total de topos en el escenario es: "+Escenario2.getElemento().size());
    
    // Consulta el topo que se encuentra en la posici�n (1,2) y comprueba que es igual a topo1. 
    
    System.out.println("Position topo1: "+ "("+Escenario2.consultaElemento(position1_2).getPosition().getX() +","
    + Escenario2.consultaElemento(position1_2).getPosition().getY()+")");
    
    
  }
}
