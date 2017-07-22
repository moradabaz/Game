package Pruebas;

import topos.elementos.Element;
import topos.elementos.TopoTorpe;
import topos.estructura.Direction;
import topos.estructura.Position;


public class PruebaTopo {

	 public static void  main(String[] args) {
		
	
	
	Element elem1 = new TopoTorpe(0,9);
	
	 Position position1 = elem1.getPosition();
			 
			 
	 System.out.println("la position del topo1 es:"+ position1.getX()+","+ position1.getY());
	 
	 Position position2 = elem1.getPosition().getAdyacent(Direction.UP);
	 
	 System.out.println("la position del topo2 es:"+ position2.getX()+","+ position2.getY());
	 }
}
