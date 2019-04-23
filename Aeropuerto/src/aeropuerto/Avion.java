package aeropuerto;

public class Avion extends Thread{

	private int turn;
	private int leftLimit;
	private int rightLimit;
	private int unsuccessLandings;
	private int xPosition;
	private int yPosition;
	
	public Avion(int turn, int leftLimit, int rightLimit, int unsuccessLandings) {
		this.turn = turn;
		this.leftLimit = leftLimit;
		this.rightLimit = rightLimit;
		this.unsuccessLandings = unsuccessLandings;
	}
	

}
