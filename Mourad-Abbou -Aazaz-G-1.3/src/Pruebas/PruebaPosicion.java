package Pruebas;

import topos.estructura.Direction;
import topos.estructura.Position;
;

public class PruebaPosicion {
	
	public static void main(String[] args)
	{
	
		Position position1 = new Position(1,3);
		//Hacemos esto para poder reservar espacio 
		 //en memoria para nuestro objeto position1.
    
 
    
    
    Position position2 = new Position(12,3);
	
	
	
    Position position3 = new Position(position1);
	
	
	Position position4 = new Position(2,3);
	
	position4 = position2;
	
    position2 = new Position(3,4);
    
    position4 = new Position(6,6);
    
    Position position5 = new Position(2,1);
    
   
    
    position5.move(Direction.UP);

    System.out.println("La position x de la position 5  es: "+ position5.getX()+" y la position y es: "+ position5.getY());
    
    position5.move(Direction.DOWN);
    
    System.out.println("La position x de la position 5  es: "+ position5.getX()+" y la position y es: "+ position5.getY());
    
    position5.move(Direction.RIGHT);
    
    System.out.println("La position x de la position 5  es: "+ position5.getX()+" y la position y es: "+ position5.getY());
    
    position5.move(Direction.LEFT);
    
    System.out.println("La position x de la position 5  es: "+ position5.getX()+" y la position y es: "+ position5.getY());
    
    
    Position position6 = new Position(1,0);
    
    
    
     

    
    System.out.println("La position x de la position 6  es: "+ position6.getAdyacent(Direction.UP).getX()+" y la position y es: "+ position6.getAdyacent(Direction.UP).getY());
    
   
    System.out.println("La position x de la position 6  es: "+ position6.getAdyacent(Direction.DOWN).getX()+" y la position y es: "+ position6.getAdyacent(Direction.DOWN).getY());
    
    
    System.out.println("La position x de la position 6  es: "+ position6.getAdyacent(Direction.RIGHT).getX()+" y la position y es: "+ position6.getAdyacent(Direction.RIGHT).getY());
    
  
    System.out.println("La position x de la position 6  es: "+ position6.getAdyacent(Direction.LEFT).getX()+" y la position y es: "+ position6.getAdyacent(Direction.LEFT).getY());
	
	
	
			
			System.out.println("La position x de la position 1  es: "+ position1.getX()+" y la position y es: "+ position1.getY());
	
			System.out.println("La position x de la position 2  es: "+ position2.getX()+" y la position y es: "+ position2.getY());
			
			System.out.println("La position x de la position 3  es: "+ position3.getX()+" y la position y es: "+ position3.getY());
			
			System.out.println("La position x de la position 4  es: "+ position4.getX()+" y la position y es: "+ position4.getY());

			
	}	
	}
