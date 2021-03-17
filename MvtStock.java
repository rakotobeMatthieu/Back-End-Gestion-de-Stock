package stock;
import java.sql.Timestamp;

public class MvtStock{
    String id;
    String produit;
    String type;
    int quantite;
    int PU;
    int montant;
    // Timestamp time;

    // public MvtStock(String produit,String type,int quantite,int PU,int montant,Timestamp time){
    public MvtStock(String produit,String type,int quantite,int PU,int montant){
        this.produit = produit;
        this.type = type;
        this.quantite = quantite;
        this.PU = PU;
        this.montant = montant;
        // this.time=time;
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
		this.id = id;
	}
    // public Timestamp gettime(){
    //     return time;
    // }
}