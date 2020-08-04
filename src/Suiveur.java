
public class Suiveur extends Vehicule{

	private double distanceIntervehiculaire;
	private Vehicule leader;
	private double vitesseLibre;
	private double tempsIVSecurite;
	private double maxAcceleration;
	private double descelerationDesiree;
	private double minDistance;
	

	// Constructeur
	public Suiveur(Vehicule leader){
		this.leader = leader;
		this.vitesseLibre = 36;
		this.tempsIVSecurite = 1.5;
		this.maxAcceleration = 1;
		this.descelerationDesiree = 5;
		this.minDistance = 2;
		this.longueur = 5;
		this.acceleration = 0;
		this.vitesse = 0;
		this.position = leader.getPosition()-leader.getLongueur()-this.minDistance;
		this.positionAngulaire = operations.modulo2Pi(this.position/100);
		this.setPosition();
		this.distanceIntervehiculaire = this.minDistance;
		this.mettreAJourLesVecteurs();
		
		// MŽthode de dŽplacement
		this.methodeDeplacement = new NePasBouger();
		System.out.println("CrŽation du suiveur rŽussie...");
	}

	// Getteurs
	public double getDistanceIntervehiculaire(){
		return this.distanceIntervehiculaire;
	}

	public double getVitesseLibre(){
		return this.vitesseLibre;
	}

	public double getTempsIVSecurite(){
		return this.tempsIVSecurite;
	}

	public double getMaxAcceleration(){
		return this.maxAcceleration;
	}

	public double getDescelerationDesiree(){
		return this.descelerationDesiree;
	}

	public double getMinDistance(){
		return this.minDistance;
	}

	public Vehicule getLeader(){
		return this.leader;
	}

	// Setteurs
	public void setDistanceIntervehiculaire(){
		double valeur = this.leader.getPosition()-this.position-leader.getLongueur();
		if (valeur >= 0){
			this.distanceIntervehiculaire = valeur;
		} 
		else {
			this.distanceIntervehiculaire = valeur + 2*Math.PI*100;
		}
	}
	
	public void setLeader(Vehicule leader){
		this.leader = leader;
	}

}
