package topos.estructura;

import java.util.Random;

// Este tipo de panel acepta los golpes con una probabilidad de 50%


/**
 * 
 * Un panel aleatorio se caracteriza por su capacidad para ignorar golpes.
 * Este comportamiento lo realiza de forma aleatoria con una probabilidad del 50%. 
 * Asi pues, cuando recibe un golpe, unas veces ignorara el golpe y otras se comportara como un panel basico. 
 * Se entiende por ignorar un golpe no hacer nada, esto es, si esta visible, seguira visible.
 * 
 * @author Morad
 *
 */
public class PanelAleatorio extends PanelBasico {
    
    public PanelAleatorio(int x, int y) {
        super(x, y);
        
    }
    
    public PanelAleatorio(int x, int y, boolean visible) {
        super(x, y, visible);
      
    }
    
    @Override
    public void golpear() {
        
        Random random = new Random();
        
        // Con una probabilidad de 50% acepta el golpe
        
        if (random.nextBoolean())
            super.golpear();
    }
    
    @Override
    public String getImagen() {
        
        return "imagenes/panel-aleatorio.png";
    }
    
}