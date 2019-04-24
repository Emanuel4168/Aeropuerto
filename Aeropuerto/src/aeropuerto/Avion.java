package aeropuerto;

import java.awt.Image;

import javax.swing.*;

public class Avion extends Thread{

	private int turn;
	private int landingLimit;
	private int rightLimit;
	private int unsuccessLandings;
	private int xPosition;
	private int yPosition;
	private JLabel planeImage; 
	private MainView view;
	private int size;
	private static int currentTurn = 0;
	
	public Avion(int turn, int landingLimit, int size,int rightLimit) {
		this.turn = turn;
		this.landingLimit = landingLimit;
		this.unsuccessLandings = 0;
		this.rightLimit = rightLimit;
		xPosition = 0;
		yPosition = turn*size;
		this.size = size;
		if(planeImage == null) {
			planeImage = new JLabel();
			planeImage.setIcon(Rutinas.changeSize("plane.png", size, size));
		}
	}
	
	@Override
	public void run() {
		boolean right = true;
		boolean isGoingUp = false;
		System.out.println(turn);
		while(true) {
			try {
				
				if(right) {
					planeImage.setIcon(Rutinas.changeSize("plane.png", size, size));
					if(yPosition < landingLimit && !isGoingUp) {
						yPosition += 5;
						xPosition += 5;
						view.addPlane(this);
						sleep(100);
						continue;
					}
					isGoingUp = true;
					if(currentTurn == turn) {
						return;
					}
					yPosition -= 5;
					xPosition += 5;
					view.addPlane(this);
					sleep(100);
					if(xPosition > rightLimit - size) {
						right = false;
						isGoingUp = false;
					}
					continue;
				}
				
				planeImage.setIcon(Rutinas.changeSize("plane_reverse.png", size, size));
//				if(turn == 1)
//					System.out.println(yPosition < landingLimit);
				if(yPosition < landingLimit && !isGoingUp) {
					yPosition += 5;
					xPosition -= 5;
					view.addPlane(this);
					sleep(100);
					continue;
				}
				isGoingUp = true;
				if(currentTurn == turn) {
					return;
				}
				yPosition -= 5;
				xPosition -= 5;
				view.addPlane(this);
				if(xPosition <  size) {
					right = true;
					isGoingUp = false;
				}

				sleep(100);
			}catch(Exception e) {}
		}
			
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getLandingLimit() {
		return landingLimit;
	}

	public void setLandingLimit(int leftLimit) {
		this.landingLimit = landingLimit;
	}

	public int getUnsuccessLandings() {
		return unsuccessLandings;
	}

	public void setUnsuccessLandings(int unsuccessLandings) {
		this.unsuccessLandings = unsuccessLandings;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public JLabel getPlaneImage() {
		return planeImage;
	}

	public void setPlaneImage(JLabel planeImage) {
		this.planeImage = planeImage;
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
	public static void nextTurn() {
		currentTurn ++; 
	}
	

}