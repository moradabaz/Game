package Pruebas;



import topos.estructura.Direction;
import topos.estructura.PanelBasico;
import topos.estructura.Position;


public class PruebaPanelBasico {

	
	public static void main(String[] args){
		
		
		
		 PanelBasico panel1 = new PanelBasico(0,0, true);
		 
		 PanelBasico panel2 = new PanelBasico(0,1, false);
		 
		 System.out.println("position del panel l: ( "+ panel1.getPosition().getX()+" , " +panel1.getPosition().getY()+ ") , y la visibilidad del panel 1:" +panel1.isVisible());
		 
		 // No se puede poner .getPos() simplemente porque al sel un objeto compuesto por dos parametros primitivos el ordenador no lo entiende bien
		 // y te devuelve la direccion del objeto por pantalla asi que hay que poner despues del .getPos() el .getX() y el .getY() para si nos devuelva
		 // el atributo x e y del objeto position.
		
		 System.out.println("position del panel 2: ("+ panel2.getPosition().getX()+ "," +panel2.getPosition().getY() +") , y la visibilidad del panel 2:" +panel2.isVisible());
		
		 
	     Position position1 = new Position(2,2);
	     
	
	     
	     panel1.setPosition(position1);
	     
	     position1.move(Direction.UP);
	     
	     panel2.setPosition(position1);
	     
	     
	     System.out.println("position del panel l: ( "+ panel1.getPosition().getX()+" , " +panel1.getPosition().getY()+ ") , y la visibilidad del panel 1:" +panel1.isVisible());
			
	     System.out.println("position del panel 2: ("+ panel2.getPosition().getX()+ "," +panel2.getPosition().getY() +") , y la visibilidad del panel 2:" +panel2.isVisible());
	     
	     
	     
	     position1 = new Position(panel1.getPosition().getX(),panel1.getPosition().getY() );
	     
	     position1.move(Direction.RIGHT);
	     
	     
	     System.out.println("position del panel l: ( "+ panel1.getPosition().getX()+" , " +panel1.getPosition().getY()+ ") , y la visibilidad del panel 1:" +panel1.isVisible());
	     panel1.golpear();
	     panel2.golpear();
	     
	     System.out.println("position del panel l: ( "+ panel1.getPosition().getX()+" , " +panel1.getPosition().getY()+ ") , y la visibilidad del panel 1:" +panel1.isVisible());
			
	     System.out.println("position del panel 2: ("+ panel2.getPosition().getX()+ "," +panel2.getPosition().getY() +") , y la visibilidad del panel 2:" +panel2.isVisible());
	     
	     
	}
}
