
public class Leader extends Vehicule{
	
	
	public Leader(){
		this.acceleration = 0f;
		this.vitesse = 0f;
		this.positionAngulaire = 0f;
		this.longueur = 5;
		this.setPosition();
		this.mettreAJourLesVecteurs();
		this.methodeDeplacement = new NePasBouger();
		System.out.println("Création du Leader réussie...");
	}
	
	
	

}
