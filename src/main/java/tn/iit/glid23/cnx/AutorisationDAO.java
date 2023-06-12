package tn.iit.glid23.cnx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.glid23.model.Autorisation;

public class AutorisationDAO {
	
	
	public static List<Autorisation> listAutorisations() {
		
		List<Autorisation> autorisation= new ArrayList<Autorisation>();

		Connection conn= DBConnexion.getConnection();
		try {
		
			// SELECT a.*, e.nom,e.prenom FROM autorisation a , enseignant e  where a.id_enseignant=e.id;
		PreparedStatement ps = conn.prepareStatement(" SELECT a.*, e.nom,e.prenom FROM autorisation a , enseignant e  where a.id_enseignant=e.id");

		ResultSet rs= ps.executeQuery();
		if (rs!=null)
		{
		
		while(rs.next())
		{
		
		Autorisation u = new Autorisation();
		u.setId(rs.getInt("id"));
		u.setDate(rs.getString("date"));
		u.setId_enseignant(rs.getInt("id_enseignant"));
		u.setNb_heures(rs.getInt("nb_heures"));
		u.setNb_semaine(rs.getInt("nb_semaine"));
		u.setNom(rs.getString("nom"));
		u.setPrenom(rs.getString("prenom"));
		autorisation.add(u);
		}
		}
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return autorisation;
		}
		
		
		
		public static void insertAutorisation(Autorisation e) {

			Connection conn= DBConnexion.getConnection();
			try {
			
			PreparedStatement ps = conn.prepareStatement(" insert into autorisation values (0,?,?,?,?)");
			
			ps.setString(1, e.getDate());
			ps.setInt(2, e.getNb_heures());
			ps.setInt(3, e.getNb_semaine());
			ps.setInt(4, e.getId_enseignant());

			ps.executeUpdate();
			} catch (SQLException exp) {

			exp.printStackTrace();
			}
			}
		

}
