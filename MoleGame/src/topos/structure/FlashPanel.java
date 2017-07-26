package topos.structure;


/**
 *
 * 
 * The flash panel restores its visibility very quickly.
 * After been struck, a short time passes and when it's update by the scenery, it turns its 
 * visibility back
 * 
 * @author Moradisten
 *
 */

public class FlashPanel extends BasicPanel {

	private int counter;		// We have a counter to control when the visibility is going to be restored.
	
	public FlashPanel(int x, int y) {
		super(x, y);
		counter = 0;
	}

		
	public FlashPanel(int x, int y, boolean visible) {
		super(x, y, visible);
		counter = 0;
	}

	/**
	 * When a panel wants to update the visibility, it increases the counter.
	 * if the counter equals 2, and the panels is hidden, it turns visible again.
	 * 
	 *	@see PanelBasico#updateVisibility()
	 */
	@Override
	public void updateVisibility() {
		counter++;
		if(counter >= 2)
		{	if(!isVisible()){
				setVisibility(true);
			}
		  counter = 0;
		}
	}
	
	/**
	 * 
	 * @see topos.structure.PanelBasico#getImagen()
	 */
	public String getImagen() {
		
		return "imagenes/panel-flash.gif";
	}
}