
package topos.structure;

import java.util.LinkedList;

/**

 * 
 * A resistant panel has a capability of bearing shots before it's struck down.
 * It has a property of hardness which sets the number of shot it can bear.
 * If it is shot three times in a row in less than a second, then it will be struck down and will be invisible.
 * 
 * @author Moradisten
 *
 */

/**
 * @author Morad
 *
 */
public class ResistantPanel extends BasicPanel {

	public static final int TIME = 1000;
	public static final int HARDNESS_GRADE_DEFAULT = 3;
	private  int hardnessGrade; 			//panel hardness

	private LinkedList<Long> timeStamps;	// The number of elements containt can't be higher than the number that sets the hardness

	
	public ResistantPanel(int x, int y, int hardnessGrade) {
		super(x, y);
		this.hardnessGrade = hardnessGrade;
		timeStamps = new LinkedList<Long>();
	}
	
	public ResistantPanel(int x, int y) {
		super(x, y);
		this.hardnessGrade = HARDNESS_GRADE_DEFAULT;
		timeStamps = new LinkedList<Long>();
	}
	

	public ResistantPanel(int x, int y, boolean visible, int hardnessGrade) {
		super(x, y, visible);
		this.hardnessGrade = hardnessGrade;
		timeStamps = new LinkedList<Long>();
	}
	
	

	/**
	 * When the panel is struck, the list will store the time stamp at that time.
	 * When the list size equals the hardess grade then it will check if the diference
	 * between the last and the first time stamp is lesser than 1000 milis (1 sec).
	 * If the diference is lesser, then it will turn invisible because of the strike.
	 * If not, we'll remove the first element of the list.
	 * 
	 * @see topos.structure.PanelBasico#strike()
	 */

	public void strike() { 
		timeStamps.add(System.currentTimeMillis());
		if (timeStamps.size() == hardnessGrade) {
			if (timeStamps.getLast() - timeStamps.getFirst() < TIME) {
				super.strike();
				timeStamps.clear();
			} else {
				timeStamps.removeFirst();
			}
		}	
	}

	
	
	/**
	 * 
	 * @see topos.structure.PanelBasico#getImagen()
	 */
	public String getImagen() {

		return "imagenes/panel-resistente.gif";
	}

	
	@Override
	public ResistantPanel clone() throws CloneNotSupportedException {
		ResistantPanel copy = (ResistantPanel) super.clone();
		copy.timeStamps = new LinkedList<Long>();
		return copy;
	}
}
