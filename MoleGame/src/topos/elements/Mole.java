package topos.elements;

import java.util.Random;

import topos.structure.Direction;

public abstract class Mole extends ActiveElement implements Pointable {

	private static final int POINTS = 4;
	
	protected Random random;
	
	public Mole(int x, int y) {
		super(x, y);
		random = new Random();
	}

	
	/**
	 * @see ActiveElement#act()
	 */
	public  void act() {
		
		if (this.getScenery() != null  && canMove()) {
			long now = System.currentTimeMillis();
			long timePassed = now - lastMove;
			if(timePassed >= WAIT_TIME) {
				Direction direction = calculateDirection();
				boolean displaced = moveElement(direction);
				if (displaced) {
					lastMove = System.currentTimeMillis();
				}
			}
		}
	}
	
	public abstract boolean canMove();
	
	public abstract Direction calculateDirection();
	
	@Override
	public int getPoints(){
		return POINTS;
		
	}
}
