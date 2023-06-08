package tn.iit.glid23.cnx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.glid23.model.Enseignant;
import tn.iit.glid23.model.Utilisateur;



public class EnseignantDAO {
	
	
	

	public static List<Enseignant> listEseignants() {
		
	List<Enseignant> ens= new ArrayList<Enseignant>();

	Connection conn= DBConnexion.getConnection();
	try {
	
	PreparedStatement ps = conn.prepareStatement(" select * from enseignant");

	ResultSet rs= ps.executeQuery();
	if (rs!=null)
	{
	
	while(rs.next())
	{
	
	Enseignant u = new Enseignant();
	u.setId(rs.getInt("id"));
	u.setNom(rs.getString("nom"));
	u.setPrenom(rs.getString("prenom"));
	u.setEmail(rs.getString("email"));
	u.setPassword(rs.getString("password"));
	
	ens.add(u);
	}
	}
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return ens;
	}
	
	
	
	public static void insertEnseignant(Enseignant e) {

		Connection conn= DBConnexion.getConnection();
		try {
		
		PreparedStatement ps = conn.prepareStatement(" insert into enseignant values (0,?,?,?,?)");
		
		ps.setString(1, e.getNom());
		ps.setString(2, e.getPrenom());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getPassword());

		ps.executeUpdate();
		} catch (SQLException exp) {

		exp.printStackTrace();
		}
		}
	
	
	public static void deleteEnseignant(int id) {
		
		Connection conn= DBConnexion.getConnection();
		try {
		
		PreparedStatement ps = conn.prepareStatement(" delete from enseignant where id=? ");
		ps.setInt(1, id);
		System.out.print(id);
		ps.executeUpdate();
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
		}
	
	
	public static void updateEnseignant(int pos, Enseignant u) {
		
		Connection conn= DBConnexion.getConnection();
		try {
		
		PreparedStatement ps = conn.prepareStatement(" update enseignant 	set nom= ?, prenom=?, email=?, password=? where id=? ");
		ps.setString(1, u.getNom());
		ps.setString(2, u.getPrenom());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getPassword());
		ps.setInt(5, pos);
		System.out.print(pos);
		System.out.print(ps);
		ps.executeUpdate();
		
		System.out.print(ps);
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
		}
	
	public static Enseignant findById(int id) {

		Connection conn= DBConnexion.getConnection();
		Enseignant u= null;
		try {
		
			PreparedStatement ps = conn.prepareStatement(" select * from enseignant where id =? ");
					ps.setInt(1, id);
					
					ResultSet rs= ps.executeQuery();
					if (rs!=null)
					{
					while(rs.next())
					{
					u = new Enseignant();
					u.setId(rs.getInt("id"));
					u.setNom(rs.getString("nom"));
					u.setPrenom(rs.getString("prenom"));
					u.setEmail(rs.getString("email"));
					u.setPassword(rs.getString("password"));
					}
					}
					ps.close();
					} catch (SQLException e) {
					e.printStackTrace();
					}
					return u;
	}
	

}
