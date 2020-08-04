
public class InteligentDriverModel implements MethodeDeDeplacement{

	private Suiveur vehiculeAssocie;


	public InteligentDriverModel(Suiveur veh){
		this.vehiculeAssocie = veh;
	}

	public void seDeplacer(double dt){
		// Nouvelle position
		vehiculeAssocie.setPosition(vehiculeAssocie.getPosition() + vehiculeAssocie.getVitesse()*dt + 0.5*vehiculeAssocie.getAcceleration()*Math.pow(dt, 2)/100);
		// Nouvelle vitesse
		vehiculeAssocie.setVitesse(vehiculeAssocie.getVitesse() +vehiculeAssocie.getAcceleration()*dt);
		// Nouvel espacment IV
		vehiculeAssocie.setDistanceIntervehiculaire();
		// Nouvelle accélération
		double sEtoile = vehiculeAssocie.getMinDistance() + vehiculeAssocie.getVitesse()*vehiculeAssocie.getTempsIVSecurite() + (vehiculeAssocie.getVitesse()*(vehiculeAssocie.getVitesse()-vehiculeAssocie.getLeader().getVitesse()))/(2*Math.sqrt(vehiculeAssocie.getMaxAcceleration()*vehiculeAssocie.getDescelerationDesiree()));
		vehiculeAssocie.acceleration = Math.max(-vehiculeAssocie.getDescelerationDesiree(),vehiculeAssocie.getMaxAcceleration()*(1-Math.pow(vehiculeAssocie.getVitesse()/vehiculeAssocie.getVitesseLibre(), 4)-Math.pow(sEtoile/vehiculeAssocie.getDistanceIntervehiculaire(),2)));
	}

}
