import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame{
	
	public FenetrePrincipale(PanneauPrincipal pan){
		this.setTitle("Simulation");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Definition du panneau ˆ afficher
		this.setContentPane(pan);
		
		
		// Visible
		this.setVisible(true);
		
		
	}

}
