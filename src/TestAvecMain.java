import java.util.ArrayList;
public class TestAvecMain {
	
	public static void main(String[] args){
		
		Suiveur leader = new Suiveur(new Leader());
		// On modifie sa méthode de déplacement
		leader.setMethodeDeDeplacement(new VitesseFixe(leader, 36d));
		
		// On fait la liste des suiveurs
		ArrayList<Suiveur> listeVeh = new ArrayList();
		// Init
		listeVeh.add(new Suiveur(leader));
		
		for (int i=0 ; i<15 ; i++){
			listeVeh.add(new Suiveur(listeVeh.get(listeVeh.size()-1)));
			// On définit la méthode de déplacement
			System.out.println(listeVeh.get(i).getPosition());
		}
		
		leader.setLeader(listeVeh.get(listeVeh.size()-1));
		leader.setMethodeDeDeplacement(new InteligentDriverModel(leader));
		
		for (Suiveur suivCourant : listeVeh){
			suivCourant.setMethodeDeDeplacement(new InteligentDriverModel(suivCourant));
		}
		
		// définition du panneau
		PanneauPrincipal pan = new PanneauPrincipal();
		// Modification de la liste de véhicules dans le panneau
		pan.setListeVehicules(listeVeh);
		pan.setLeader(leader);
		
		FenetrePrincipale fen = new FenetrePrincipale(pan);
		
		// Initialisation
		double dt = 0.05d;
		double temps = 0d;
		Horloge horloge = new Horloge();
		pan.setHorloge(horloge);
		
		
		// Mise à jour du système
		while (true){
			pan.repaint();
			try{
				Thread.sleep(1);
			} catch (InterruptedException e){
				System.out.println("Message :" + e);
			}
			leader.avancer(dt);
			for (Vehicule vehCourant : listeVeh){
				vehCourant.avancer(dt);
			}
			horloge.avancerTemps(dt);
			System.out.println("Temps = " + temps);
			System.out.println("Position Leader = " + leader.getPosition() + " m");
			System.out.println("Position Suiveur = " + listeVeh.get(0).getPosition() + " m");
			System.out.println("Vitesse Suiveur = " + listeVeh.get(0).getVitesse()*3.6 + " km/h" );
			System.out.println("Acceleration Suiveur = " + listeVeh.get(0).getAcceleration() + " m.s^-2");
			System.out.println("Distance Intervehiculaire = " + listeVeh.get(0).getDistanceIntervehiculaire() + " m");
		}
	}

}
