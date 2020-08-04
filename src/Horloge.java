
public class Horloge {

	private double temps;
	
	public Horloge(){
		this.temps = 0d;
	}
	
	public void avancerTemps(double dt){
		this.temps += dt;
	}
	
	// Get
	public double getTemps(){
		return this.temps;
	}
	
}
