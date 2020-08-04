import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class PanneauPrincipal extends JPanel{
	
	private ArrayList<Suiveur> listeVehicule;
	private Vehicule leader;
	private Horloge horloge;
	
	// On modifie la liste de vehicules
	public void setListeVehicules(ArrayList<Suiveur> listeVeh){
		this.listeVehicule = listeVeh;
	}
	// Setteur du leader
	public void setLeader(Vehicule leader){
		this.leader = leader;
	}
	// Setteur de l'horloge
	public void setHorloge(Horloge horloge){
		this.horloge = horloge;
	}
	
	// Getteurs ????
	
	public void paintComponent(Graphics g){
		// définir la couleur en blanc
		g.setColor(Color.WHITE);
		// dessiner un rectangle
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// définir la couleur en gris
		g.setColor(Color.LIGHT_GRAY);
		// On trace la route
		g.fillOval(42,42,615,615);
		// définir la couleur en blanc
		g.setColor(Color.WHITE);
		g.fillOval(57, 57, 585, 585);
		
		/* grille
		g.setColor(Color.BLACK);
		for (int i=0 ; i<700 ; i+=50){
			g.drawLine(i, 0, i, 700);
		}
		for (int i=0 ; i<700 ; i+=50){
			g.drawLine(0, i, 700, i);
		}*/
		
		// On dessine le leader
			// Couleur Rouge
		g.setColor(Color.RED);
			// On trace le leader
		g.fillPolygon(leader.getVecteurDesX(), leader.getVecteurDesY(), 4);
		
		// On définit la couleur à bleu
		g.setColor(Color.BLUE);
		// On trace la liste des voitures
		for (Vehicule vehCourant:listeVehicule){
			g.fillPolygon(vehCourant.getVecteurDesX(), vehCourant.getVecteurDesY(), 4);
		}
		
		g.drawString("Simulation :", 700, 100);
		g.drawString("T = " + (double)((int)(this.horloge.getTemps()*100))/100 + " s", 750, 150);
		g.drawString("Vitesse Leader =" + (int)(leader.getVitesse()*3.6) + " km/h", 750, 200);
		
	}

}
