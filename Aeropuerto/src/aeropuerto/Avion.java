package aeropuerto;

import java.awt.Image;

import javax.swing.*;

public class Avion extends Thread{

	private int turn;
	private int leftLimit;
	private int rightLimit;
	private int unsuccessLandings;
	private int xPosition;
	private int yPosition;
	private JLabel planeImage; 
	private MainView view;
	private int size;
	
	public Avion(int turn, int leftLimit, int rightLimit) {
		this.turn = turn;
		this.leftLimit = leftLimit;
		this.rightLimit = rightLimit;
		this.unsuccessLandings = 0;
		xPosition = 0;
		yPosition = 0;
		size = 50;
		if(planeImage == null) {
			planeImage = new JLabel();
			planeImage.setIcon(Rutinas.changeSize("plane.png", size, size));
		}
	}
	
	@Override
	public void run() {
		boolean right = true;
		while(true) {
			if(right){
				xPosition+=5;
				if(xPosition > rightLimit){
					right = false;
					xPosition = rightLimit;
					planeImage.setIcon(Rutinas.changeSize("plane_reverse.png", size, size));
				}
				view.addPlane(this);
			}
			else {
				xPosition-=5;
				if(xPosition<= leftLimit){
					right = true;
					xPosition =0;
					planeImage.setIcon(Rutinas.changeSize("plane.png", size, size));
				}
				view.addPlane(this);
			}
//			if(xPosition < rightLimit - 30) {
//				xPosition += 5;
//				if(xPosition <= 30)
//					planeImage = Rutinas.changeSize("plane.png", 30, 30);
//			}
//			else {
//				xPosition -= 5;
//				if(xPosition > leftLimit -30)
//					planeImage = Rutinas.changeSize("plane.png", 30, 30);
//			}

			try {
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

	public int getLeftLimit() {
		return leftLimit;
	}

	public void setLeftLimit(int leftLimit) {
		this.leftLimit = leftLimit;
	}

	public int getRightLimit() {
		return rightLimit;
	}

	public void setRightLimit(int rightLimit) {
		this.rightLimit = rightLimit;
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
	

}