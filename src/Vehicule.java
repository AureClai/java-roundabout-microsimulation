
abstract class Vehicule {
	
	protected double acceleration;
	protected double vitesse;
	protected double position;
	protected double positionAngulaire;
	protected double longueur;
	protected int[] vecteurDesX;
	protected int[] vecteurDesY;
	protected MethodeDeDeplacement methodeDeplacement;
	
	// Pour les opérations mathématiques avancées
	protected Operations operations = new Operations();
	
	
	// Getteurs des variables
	public double getPosition(){
		return this.position;
	}
	public double getVitesse(){
		return this.vitesse;
	}
	public double getAcceleration(){
		return this.acceleration;
	}
	public double getPositionAngulaire(){
		return this.positionAngulaire;
	}
	public double getLongueur(){
		return this.longueur;
	}
	public int[] getVecteurDesX(){
		return this.vecteurDesX;
	}
	public int[] getVecteurDesY(){
		return this.vecteurDesY;
	}
	public MethodeDeDeplacement getMethodeDeDeplacement(){
		return this.methodeDeplacement;
	}
	
	// Cette section est vide
	public void setAcceleration(double acc){
		this.acceleration = acc;
	}
	public void setVitesse(double vit){
		this.vitesse = vit;
	}
		// Avec argument
	public void setPosition(double pos){
		this.position = pos;
		this.setPositionAngulaire();
		this.mettreAJourLesVecteurs();
	}
		// Sans argument
	public void setPosition(){
		this.position = this.positionAngulaire*100;
		this.mettreAJourLesVecteurs();
	}
		// Avec argument
	public void setPositionAngulaire(double angle){
		this.positionAngulaire = operations.modulo2Pi(angle);
		this.setPosition();
		this.mettreAJourLesVecteurs();
	}
		// Sans argument
	public void setPositionAngulaire(){
		this.positionAngulaire = operations.modulo2Pi(this.position/100);
		this.setPosition();
		this.mettreAJourLesVecteurs();
	}
	// 
	public void setMethodeDeDeplacement(MethodeDeDeplacement methDep){
		this.methodeDeplacement = methDep;
	}
	
	
	// Effectuer la rotation
	protected void mettreAJourLesVecteurs(){
		int[] xBase = {646, 654, 654, 646};
		int[] yBase = {335, 335, 350, 350};
		int[] centre = {350,350};
		int[] nouveauXVect = new int[4];
		int[] nouveauYVect = new int[4];
		for (int i=0 ; i<4 ; i++){
			// On fait la rotation
			int[] vecteur = {-(centre[0]-xBase[i]),-(centre[1]-yBase[i])};
			int[] nouveauVecteur = {(int)(vecteur[0]*Math.cos(this.positionAngulaire)-vecteur[1]*Math.sin(this.positionAngulaire)),(int)(vecteur[1]*Math.cos(this.positionAngulaire)+vecteur[0]*Math.sin(this.positionAngulaire))};
			// On met à jour les Vecteurs
			nouveauXVect[i] = nouveauVecteur[0]+centre[0];
			nouveauYVect[i] = nouveauVecteur[1]+centre[1];
		}
		this.vecteurDesX = nouveauXVect;
		this.vecteurDesY = nouveauYVect;
	}
	
	// Méthode d'évolution du véhicule
	public void avancer(double dt){
		this.methodeDeplacement.seDeplacer(dt);
	}
	
}
