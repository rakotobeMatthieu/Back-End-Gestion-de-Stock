package fenetre;
import ecouteur.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Accueil extends JPanel {
	
	private Fenetre fn;
	private JTextField produit;
	private JTextField type;
	private JTextField quantite;
	private JTextField PU;
	private JButton bouton;
	private JButton historique;
	private JButton equivalence; 
	private Ecouteur ecouteur;
	JLabel etat;

	public JLabel getEtat(){
		return etat;
	}

	public Ecouteur getEcouteur(){
		return ecouteur;
	}

	public JTextField getProduit(){
		return produit;
	}
	
	public JTextField getType(){
		return type;
	}


	public JTextField getQuantite(){
		return quantite;
	}

	public JTextField getPU(){
		return PU;
	}

	public JButton getBouton(){
		return bouton;
	}

    public JButton getHistorique(){
		return historique;
	}

    public JButton getEquivalence(){
		return equivalence;
	}


	public Accueil(Fenetre f){
		try{
			this.fn = f;
			this.setBounds(10,10,400,400);
			this.setBackground(Color.GRAY);

			etat = new JLabel("essai");
			etat.setBounds(250,10,300,50);
			add(etat);

			JLabel l1 = new JLabel("Produit");
			l1.setBounds(50,50,300,50);
			this.add(l1);
			produit = new JTextField();
			produit.setBounds(50,100,300,50);
			this.add(produit);

			JLabel l2 = new JLabel("Type");
			l2.setBounds(50,150,300,50);
			this.add(l2);
			type= new JTextField();
			type.setBounds(50,200,300,50);
			this.add(type);

			JLabel l3 = new JLabel("Quantite");
			l3.setBounds(50,250,300,50);
			this.add(l3);
			quantite= new JTextField();
			quantite.setBounds(50,300,300,50);
			this.add(quantite);

			JLabel l4 = new JLabel("Prix unitaire");
			l4.setBounds(50,350,300,50);
			this.add(l4);
			PU= new JTextField();
			PU.setBounds(50,400,300,50);
			this.add(PU);

			bouton = new JButton("Creer");
			bouton.setBounds(100,500,200,50);
			
			this.ecouteur = new Ecouteur(fn);
			bouton.addActionListener(ecouteur);
			this.add(bouton);

			historique = new JButton("Historique");
			historique.setBounds(450,200,200,50);
			// this.historique = historique1;
			
			// Ecouteur e = new Ecouteur(fn);
			// this.ecouteur=e;
			// historique.addActionListener(e);
			historique.addActionListener(ecouteur);
			this.add(historique);

			equivalence = new JButton("Equivalence");
			equivalence.setBounds(450,300,200,50);
			// this.equivalence = equivalence1;
			
			// Ecouteur e = new Ecouteur(fn);
			// this.ecouteur=e;
			// equivalence.addActionListener(e);
			this.add(equivalence);

		}catch (Exception e) {
			e.printStackTrace();
		}

		// fn.add(this);
	}
	public Accueil(){}
}