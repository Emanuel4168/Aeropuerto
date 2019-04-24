package aeropuerto;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

public class MainView extends JFrame{
	
	private Graphics g;
	private Image backbuffer = null;
	private Vector<Avion> planes;
	private JPanel glassPane;
	
	public MainView() {
		super("Aeropuerto");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		glassPane = (JPanel) getGlassPane();
        glassPane.setLayout(null);
        glassPane.setVisible(true);
        
		planes = new Vector<Avion>();
		JLabel lblPista = new JLabel();
		lblPista.setIcon(Rutinas.changeSize("pista.png", 800, 200));
		lblPista.setBounds(0,400,800,200);
		glassPane.add(lblPista);
		SwingUtilities.updateComponentTreeUI(glassPane);
		setVisible(true);
		initializePlanes();
		
//		Avion a = new Avion(20,20,20);
//		a.getPlaneImage().setBounds(a.getxPosition(), a.getyPosition(), 30, 30);
//		glassPane.add(a.getPlaneImage());
//		SwingUtilities.updateComponentTreeUI(glassPane);
		
	}

	
	private void initializePlanes() {
		for (int i = 0; i < 5 ; i++) {
			planes.add(new Avion(i,50,this.getWidth()));
			planes.get(i).setView(this);
		}
		
		planes.forEach(plane ->{
			plane.start();
		});

	}


	public void addPlane(Avion plane) {
		JLabel lblPlane = plane.getPlaneImage();
		lblPlane.setBounds(plane.getxPosition(), plane.getTurn()*50, 50, 50);
		glassPane.add(lblPlane);
		SwingUtilities.updateComponentTreeUI(glassPane);
	}
}
