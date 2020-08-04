
public class Operations {
	
	public double modulo2Pi(double nombre){
		int quotient = partieEntiere(nombre/(2*Math.PI));
		return nombre-Math.PI*2*quotient;
	}
	
	public int partieEntiere(double nombre){
		if (nombre >= 0){
			return (int) nombre;
		}
		else{
			return (int)(nombre-1);
		}
	}

}
