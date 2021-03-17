package fenetre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import fontion.*;

public class Historique extends JPanel{
    Fenetre fenetre;
    
    public Historique(Fenetre f){
        try{
            fenetre = f;
            this.setBounds(10,10,700,650);
			this.setBackground(Color.GRAY);

            DefaultTableModel model;
            JTable tableau;

            Fonction fonc = new Fonction();
            Vector vect = fonc.getAll();
            int taille = vect.size();
            Vector rep = new Vector();
            int i = 0;
            System.out.println(vect);
            while(i<taille){
                System.out.println(vect.elementAt(i));
                Temp temp = new Temp(vect.elementAt(i).toString(),vect.elementAt(i+1).toString(),vect.elementAt(i+2).toString(),vect.elementAt(i+3).toString(),vect.elementAt(i+4).toString());
                rep.add(temp);
                i+=5;
            }
            Object[] o = rep.toArray();
            // Temp[] h = (Temp[]) o;
            String [] entetes = {"Produit","Type","Quantite","PU","Montant"};
            model = new DefaultTableModel(entetes, 0);
            for(int j=0;j<o.length;j++){
                System.out.println(o[j].getClass().getSimpleName());
                model.addRow(o.getClass().getSimpleName());
            }
            tableau = new JTable(model);
            this.add(new JScrollPane(tableau), BorderLayout.CENTER);

        }
        catch (Exception e) {
		    e.printStackTrace();
	    }
    }
}