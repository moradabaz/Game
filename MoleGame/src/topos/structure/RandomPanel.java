package topos.structure;

import java.util.Random;

// Este tipo de panel acepta los golpes con una probabilidad de 50%


/**
 * 

 * The main characteristic of a random panel is the probability of been struck is 50%. In other words,
 * There's a 50% probability of turning invisible after it's shot.
 * 
 * @author Morad
 *
 */
public class RandomPanel extends BasicPanel {
    
    public RandomPanel(int x, int y) {
        super(x, y);   
    }
    
    public RandomPanel(int x, int y, boolean visible) {
        super(x, y, visible);
    }
    
    @Override
    public void strike() {
        Random random = new Random();        
        if (random.nextBoolean())
            super.strike();
    }
    
    @Override
    public String getImagen() {
        return "imagenes/panel-aleatorio.png";
    }
    
    
}