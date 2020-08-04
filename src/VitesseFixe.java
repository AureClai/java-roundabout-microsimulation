
public class VitesseFixe implements MethodeDeDeplacement{
	
	private double vitesse;
	private Vehicule vehiculeAssocie;
	
	// Constructeur
	public VitesseFixe(Vehicule veh, double vitesse){
		this.vehiculeAssocie = veh;
		this.vitesse = vitesse;
	}
	
	// Méthode de déplacement par vitesse fixe
	public void seDeplacer(double dt){
		vehiculeAssocie.setVitesse(vitesse);
		vehiculeAssocie.setAcceleration(0d);
		double nouvellePosition = vehiculeAssocie.getPosition()+vehiculeAssocie.getVitesse()*dt+0.5*vehiculeAssocie.getAcceleration()*Math.pow(dt,2);
		vehiculeAssocie.setPosition(nouvellePosition);
	}
	
}
