package main;

import connexion.*;
import stock.*;
import fontion.*;
import fenetre.*;
public class Main{
    public static void main(String[] args) throws Exception{
        // MouvementStock m = new MouvementStock("Pdt1","Entree",500,1000,0);
        // MouvementStock m2 = new MouvementStock("Pdt1","Entree",100,2000,0);
        // MouvementStock m3 = new MouvementStock("Pdt1","Entree",200,2500,0);
        // MouvementStock m4 = new MouvementStock("Pdt1","Entree",100,1500,0);
        // MouvementStock m5 = new MouvementStock("Pdt1","Sortie",850,0,0);
        // m.insertStock(m);
        // m.insertStock(m2);
        // m.insertStock(m3);
        // m.insertStock(m4);
        // m.insertStock(m5);
        // Fonction f = new Fonction();
        // f.plusAncien("Pdt1");

        Fenetre fn = new Fenetre();
		Accueil f = new Accueil(fn);
    }
}