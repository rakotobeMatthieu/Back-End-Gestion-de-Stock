package stock;
import fontion.*;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MouvementStock{
    String idStock;
    String produit;
    String type;
    int quantite;
    int PU;
    int montant;

    public MouvementStock(String produit,String type,int quantite,int PU,int montant){
        this.produit = produit;
        this.type = type;
        this.quantite = quantite;
        this.PU = PU;
        this.montant = montant;
    }


    public void insertStock(MouvementStock m) throws Exception{
        Fonction f = new Fonction();
        String ancien = f.plusAncien(m.getproduit());
        String idNouvAncien = "";
        
        Date d = new Date();
        int dt = d.getDate();
        int month = d.getMonth();
        int years = d.getYear();
        int hours = d.getHours();
        int minutes = d.getMinutes();
        int secondes = d.getSeconds();
        String dS = d.toString();
        Timestamp t = new Timestamp(years,month,dt,hours,minutes,secondes,0);
        
        if(m.gettype().compareTo("Entree")==0){
            int qte = f.findQuantite(ancien) - m.getquantite();
            m.setmontant(m.getquantite()*m.getPU());
            f.insert(m,"MStock","idStock");
           
            // MvtStock mvt = new MvtStock(m.getproduit(),m.gettype(),m.getquantite(),m.getPU(),m.getmontant(),t);
            MvtStock mvt = new MvtStock(m.getproduit(),m.gettype(),m.getquantite(),m.getPU(),m.getmontant());
            f.insert(mvt,"MvtStock","idMvtStock");
        }
        if(m.gettype().compareTo("Sortie")==0){
            System.out.println("ancien = "+ancien);
            m.setPU(f.findPU(ancien));
            if(f.findQuantite(ancien)<m.getquantite()){
                int moyennePond = 0, moyenne = 0, somme = 0;
                while(somme<m.getquantite()){
                    if(somme+f.findQuantite(ancien)>m.getquantite()){
                        System.out.println("Tapitra");
                        int ecart = m.getquantite()-somme;
                        System.out.println("Ecart = "+ecart);
                        moyenne += (f.findQuantite(ancien)-ecart)*f.findPU(ancien);
                        f.modifQuantite(ecart,ancien);
                        break;
                    }
                    moyenne += f.findQuantite(ancien)*f.findPU(ancien);
                    somme +=f.findQuantite(ancien);
                    f.modifQuantite(0,ancien);
                    ancien = f.plusAncien(m.getproduit());
                }
                moyennePond = moyenne/m.getquantite();
                m.setPU(moyennePond);
            }
            m.setmontant(m.getquantite()*m.getPU());
            f.insert(m,"MStock","idStock");
            // MvtStock mvt = new MvtStock(m.getproduit(),m.gettype(),m.getquantite(),m.getPU(),m.getmontant(),t);
            MvtStock mvt = new MvtStock(m.getproduit(),m.gettype(),m.getquantite(),m.getPU(),m.getmontant());
            f.insert(mvt,"MvtStock","idMvtStock");
        }
            // int somme = 0;
            // while(somme<m.getquantite()){
            //     m.setPU(f.findPU(ancien));
            //     if(f.findQuantite(ancien)<m.getquantite()){
            //         int temp = m.getquantite();
            //         // ancien
            //         m.setquantite(f.findQuantite(ancien));
            //         m.setmontant(m.getquantite()*m.getPU());
            //         f.insert(m,"MStock","idStock");
            //         f.modifQuantite(0,ancien);
            //         somme += m.getquantite();

            //         // nouveau ancien
            //         int restant = 0;
            //         while(m.getquantite()<temp){
            //             restant++;
            //             m.setquantite(m.getquantite()+1);
            //         }
            //         if(restant>f.findQuantite(ancien)){
                    
            //         }
            //         else{
            //             m.setquantite(restant);
            //             idNouvAncien = f.plusAncien(m.getproduit());
            //             m.setPU(f.findPU(idNouvAncien));
            //             m.setmontant(restant*m.getPU());
            //             f.insert(m,"MStock","idStock");
            //         }
            //     }
            //     // ancien = idNouvAncien;
            //     somme += m.getquantite();
        // 
    }

    public String getproduit(){
        return produit;
    }
    public void setproduit(String n){
        produit = n;
    }
    public String gettype(){
        return type;
    }
    public void settype(String n){
        type = n;
    }
    public int getquantite(){
        return quantite;
    }
    public void setquantite(int n){
        quantite = n;
    }
    public int getPU(){
        return PU;
    }
    public void setPU(int n){
        PU = n;
    }
    public int getmontant(){
        return montant;
    }
    public void setmontant(int n){
        montant = n;
    }
    public void setId(String id){
		this.idStock = id;
	}
}