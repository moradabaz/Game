

package topos.game;

/**
 * 
 * The game management is the one in charge of the time and score of the game. Tts main function is to 
 * start the game, setting the inicial time and score. The game management also takes control of the number of shots.
 * The total points property is final and can't be modified onces it's initially set. The pending points represent you
 * have yet to get to achive the goal.
 * 
 * @author Moradisten
 *
 */
public class GameManagement {
	
	private final int totalPoints;
	private int points;					//	Puntos del Juego
	private int pendingShots;		//	Disparos del game
	private int seconds;			//	Tiempo maximo
	private long timeLimit;			// limite maximo del tiempo
	
	
	
	public GameManagement(int seconds, int pendingShots, int maxPoints) {
		
		if(( seconds < 0) || (pendingShots < 0) || (maxPoints < 0))
			throw new IllegalArgumentException("The value os the parameter cannot be negative");
		
		this.points = 0;
		this.seconds = seconds;
		this.pendingShots = pendingShots;
		this.totalPoints = maxPoints;
	}
	
	


	/** 
	 * 
	 * This operations starts the game. It sets the start of the time. 
	 * 
	 */
	public void start() {
		
		long startTime = System.currentTimeMillis();
		this.timeLimit = startTime + seconds * 1000;
		
		// La mezcla de paneles se produce a media partida
		
	}
	
	
	/**
	 * @return Returns a true value is the time has ended and a false values if it has not.
	 */
	public boolean TimeEnd() {
		
		return System.currentTimeMillis() > this.timeLimit;
	}
	
	/**
	 * 
	 * @return The time left. The difference between the current time and the start time.
	 */
	public int getTimeLeft() {
		
		long timeLeft = this.timeLimit - System.currentTimeMillis();
		if (timeLeft <= 0){
			return 0; 
		}
		else {
			return (int) (1 + (timeLeft / 1000));
		}
	}
	
	
	/**
	 * 
	 * This methods check if the game continues working.
	 * A game can continue working if the time hasn't finished yet and
	 * the number of shots is higher than zero.
	 * 
	 * @return If the game hasn't finished it returns a true value.
	 */
	public boolean gameIsOn() {
		
		return (System.currentTimeMillis() <= this.timeLimit && pendingShots > 0) ;
	}
	
	/**
	 * @return	It returns the pending shots.
	 */
	public int getPendingShots() {
		return pendingShots;
	}

	
	public int getTotalPoints() {
		return totalPoints;
	}
	
	

	public int getPoints() {
		return points;
	}
	

	
	public void addPoints(int points) {		
		this.points += points;
	}
	

	public void deletePuntos(int points){
		this.points -= points;
		if (this.points <= 0) {
			this.points = 0;
		}
	}
	

	
	public void decreaseShot() {		
		this.pendingShots--;
	}
	
	
	public void addShots(int shots) {
		
		this.pendingShots += shots;
	}
	
	
	
	public boolean shotsAvailable() {
		
		return pendingShots > 0;
	}


	public void addSeconds(int seconds) {
		this.timeLimit += (seconds * 1000);
	}
	
	
	

	public int getPendingPoints() {
		return totalPoints - points;
	}
}