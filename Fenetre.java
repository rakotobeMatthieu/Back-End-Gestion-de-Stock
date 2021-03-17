package fenetre;
import javax.swing.*;

public class Fenetre extends JFrame{
	
	private Accueil accueil;
	
	public Accueil getAccueil(){
		return accueil;
	}
	
	public Fenetre(){
		this.accueil = new Accueil(this);
		this.setContentPane(accueil);
		this.setSize(700,750);
		this.setTitle("Gestion Stock");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}