package ecouteur;

import fontion.*;
import fenetre.*;
import stock.*;
import javax.swing.*; 
import java.awt.event.*;
// import java.text.SimpleDateFormat;
// import java.sql.Timestamp;

public class Ecouteur implements ActionListener{
	private Fenetre f;
	
    public Ecouteur(Fenetre f){
		this.f = f;
	}

    // public Ecouteur(Fenetre f,String[] liste1, String[] liste2){
    //     this.f = f;
    //     this.listeJoueur1 = liste1;
    //     this.listeJoueur2 = liste2;
    // }

    public Ecouteur(){}

	public void actionPerformed(ActionEvent a){
        try{
            if(a.getSource()==f.getAccueil().getBouton()){
                String prod = f.getAccueil().getProduit().getText(); 
                String type = f.getAccueil().getType().getText(); 
                String qte = f.getAccueil().getQuantite().getText();
                String PU = f.getAccueil().getPU().getText();

                // System.out.println(qte);
                // Fonction function = new Fonction();
                int quant = Integer.parseInt(qte);
                int prix = Integer.parseInt(PU);
                MouvementStock m = new MouvementStock(prod,type,quant,prix,0);
                m.insertStock(m);
                f.getAccueil().getEtat().setText("Mouvement insere");

                // Bouton bouton = new Bouton(this.f,lj1,lj2,o,listeIdJoueurE1,listeIdJoueurE2);
                // f.setContentPane(bouton);
                // f.setSize(bouton.getSize());

            }
            if(a.getSource()==f.getAccueil().getHistorique()){
                Historique historique = new Historique(this.f);
                f.setContentPane(historique);
                // f.setSize(bouton.getSize());
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}