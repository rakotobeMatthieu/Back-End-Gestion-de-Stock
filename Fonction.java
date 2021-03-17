package fontion;

import java.lang.*;
import connexion.*;
import java.sql.*;
import java.util.*;
import java.lang.reflect.*;
public class Fonction{
    private String sqlTest;
    
	public String plusAncien(String pdt)throws Exception{
		String reponse = "";
		try{
			Connexion c = new Connexion();
			String sql = "SELECT id FROM MStock WHERE produit='"+pdt+"' AND quantite!='0' AND rownum=1 ORDER BY id ASC ";
			ResultSet rs = c.getStatement().executeQuery(sql);
			while(rs.next()){
				reponse = rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(reponse);
		return reponse;
	}

    public int findPU(String id)throws Exception{
		int reponse = 0;
		try{
			Connexion c = new Connexion();
			String sql = "SELECT PU FROM MStock WHERE id='"+id+"'";
			ResultSet rs = c.getStatement().executeQuery(sql);
			while(rs.next()){
				reponse = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return reponse;
	}

	public int findQuantite(String id)throws Exception{
		int reponse = 0;
		try{
			Connexion c = new Connexion();
			String sql = "SELECT quantite FROM MStock WHERE id='"+id+"'";
			ResultSet rs = c.getStatement().executeQuery(sql);
			while(rs.next()){
				reponse = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return reponse;
	}

	public void modifQuantite(int qte, String id)throws Exception{
		try{
			Connexion c = new Connexion();
			String sql = "UPDATE MStock SET quantite='"+qte+"' WHERE id='"+id+"'";
			System.out.println(sql);
			ResultSet rs = c.getStatement().executeQuery(sql);
			rs.close();
			c.getConnection().close(); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vector getAll(){
		Vector rep = new Vector();
		try{
			Connexion c=new Connexion();
			String sql = "SELECT produit,type,quantite,PU,montant FROM MvtStock";
			ResultSet rs=c.getStatement().executeQuery(sql);
			while(rs.next()){
				rep.add(rs.getString(1));
				rep.add(rs.getString(2));
				rep.add(rs.getString(3));
				rep.add(rs.getString(4));
				rep.add(rs.getString(5));
			}
			rs.close();
			c.getConnection().close(); 
		}
		catch(Exception e){ 
        	e.printStackTrace();
    	}
		return rep;
	}

    public  int getidM(String sql){
		int reponse=0;
		try{
			Connexion c=new Connexion();
			ResultSet rs=c.getStatement().executeQuery(sql);
			while(rs.next()){
				reponse=rs.getInt(1);
			}
			rs.close();
			c.getConnection().close(); 
		}
		catch(Exception e){ 
        	e.printStackTrace();
    	}
		return reponse;
	}

    public String formReqInsert(Object ob) throws Exception{
		String reponse="";
		try{
			Field[] attribut = ob.getClass().getDeclaredFields();
			Class[] a = null;
			reponse = "'"+ob.getClass().getMethod("get"+attribut[1].getName(),a).invoke(ob).toString()+"'";
			for (int i = 2; i < attribut.length; i++ ) {
				reponse = reponse+",'"+ob.getClass().getMethod("get"+attribut[i].getName(),a).invoke(ob).toString()+"'";
			}
		}
        catch (Exception e) {
			e.printStackTrace();
		}
		return reponse;
	}


    public int insert(Object ob, String nomtable,String nomSequence) throws Exception{
		int a=0;
		try{
			Connexion c = new Connexion();
			Field[] attribut = ob.getClass().getDeclaredFields();
			String sqlId = "select "+nomSequence+".nextval from dual";
	
			Class[] classe = {String.class};
			int ak = this.getidM(sqlId);
			ob.getClass().getMethod("setId",classe).invoke(ob, "'"+ak+"'");

			String sql = "INSERT INTO "+nomtable+" VALUES('"+ak+"',"+formReqInsert(ob)+")";
			this.sqlTest=sql;
			System.out.println(sql);

			ResultSet rs = c.getStatement().executeQuery(sql);
			a=1;
			System.out.println("Insertion effectue");
			rs.close();
			c.getConnection().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}