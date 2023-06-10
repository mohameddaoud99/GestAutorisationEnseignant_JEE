package tn.iit.glid23.cnx;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.glid23.model.Autorisation;



public class AutorisationDAO {
	
	
	

	public static List<Autorisation> listAutorisation() {
		
	List<Autorisation> ens= new ArrayList<Autorisation>();

	Connection conn= DBConnexion.getConnection();
	try {
	
	PreparedStatement ps = conn.prepareStatement(" select * from autorisation");

	ResultSet rs= ps.executeQuery();
	if (rs!=null)
	{
	
	while(rs.next())
	{
	
		Autorisation u = new Autorisation();
	u.setId(rs.getInt("id"));
	u.setDate(rs.getDate("date"));
	u.setNb_heures(rs.getInt("nb_heures"));
	u.setNb_semaine(rs.getInt("nb_semaine"));
	u.setId_enseignant(rs.getInt("id_enseignant"));

	
	ens.add(u);
	System.out.print(ens);
	}
	}
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return ens;
	}
	
	
	
	public static void insertAutorisation(Autorisation e) {

		Connection conn= DBConnexion.getConnection();
		try {
		
		PreparedStatement ps = conn.prepareStatement(" insert into autorisation values (0,?,?,?,?)");
		
		ps.setDate(1, e.getDate());
		ps.setInt(2, e.getNb_heures());
		ps.setInt(3, e.getNb_semaine());
		ps.setInt(4, e.getId_enseignant());

		ps.executeUpdate();
		} catch (SQLException exp) {

		exp.printStackTrace();
		}
		}
	
	
	public static void deleteAutorisation(int id) {
		
		Connection conn= DBConnexion.getConnection();
		try {
		
		PreparedStatement ps = conn.prepareStatement(" delete from autorisation where id=? ");
		ps.setInt(1, id);
		System.out.print(id);
		ps.executeUpdate();
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
		}
	
	
	public static void updateAutorisation(int pos, Autorisation u) {
		
		Connection conn= DBConnexion.getConnection();
		try {
		
		PreparedStatement ps = conn.prepareStatement(" update autorisation 	set date= ?, nb_heures=?, nb_semaine=?, id_enseignant=? where id=? ");
		ps.setDate(1, u.getDate());
		ps.setInt(2, u.getNb_heures());
		ps.setInt(3, u.getNb_semaine());
		ps.setInt(4, u.getId_enseignant());
		
		
		ps.setInt(5, pos);
		System.out.print(pos);
		System.out.print(ps);
		ps.executeUpdate();
		
		System.out.print(ps);
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
		}
	
	public static Autorisation findById(int id) {

		Connection conn= DBConnexion.getConnection();
		Autorisation u= null;
		try {
		
			PreparedStatement ps = conn.prepareStatement(" select * from autorisation where id =? ");
					ps.setInt(1, id);
					
					ResultSet rs= ps.executeQuery();
					if (rs!=null)
					{
					while(rs.next())
					{
					u = new Autorisation();
					u.setId(rs.getInt("id"));			
					u.setDate(Date.valueOf("date"));
					u.setNb_heures(rs.getInt("nb_heures"));
					u.setNb_semaine(rs.getInt("nb_semaine"));
					u.setId_enseignant(rs.getInt("id_enseignant"));
					
					
					}
					}
					ps.close();
					} catch (SQLException e) {
					e.printStackTrace();
					}
					return u;
	}
	

}
