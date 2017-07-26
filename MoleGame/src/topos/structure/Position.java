package topos.structure;

/**
 *
 * This class representes the position of the characters of the game.
 * It contains two atributes:
 * 	- x
 * 	- y
 *
 * @author Moradisten
 *
 */
public class Position implements Cloneable{

	private int x;
	private int y;

	/**
	 * Constructor of the class Position
	 * @param x Parameter x
	 * @param y	Parameter y
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor of the class Position.
	 * This Constructor needs an object of Position to inicialize
	 * the attributes.
	 * @param position
	 */
	public Position(Position position) {
		this(position.x, position.y);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	/**
	 * This method moves the position to the given direction.
	 * @param dir Direction where the position is going to move to.
	 */
	public void move(Direction dir) {
		
		switch (dir) {
		
		case UP: y = y + 1; break;
		case RIGHT: x = x + 1; break;
		case DOWN: y = y - 1; break;
		case LEFT: x = x - 1; break;
		
		}
	}

	/**
	 *
	 * @param dir
	 * @return Given a Direction, this methods returns the adyacent position.
	 */
	public Position getAdjacent(Direction dir) {
		Position resultado = new Position(this.x, this.y);
		resultado.move(dir);
		return resultado;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if ((obj == null && (this != null))) {
			return false;
		}
		if((obj)==null)
			return false;
		
		if (!(obj instanceof Position)) {
			return false;
		}
		Position other = new Position((Position) obj);
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		if(hashCode() != other.hashCode())
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Position clone() throws CloneNotSupportedException{
		Position pos = copy();
		pos.x = this.x;
		pos.y = this.y;
		return pos;
	}
	
	
	private Position copy() {
		Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Can't be cloned");
        }
        return (Position) obj;
	}

}
