package tn.iit.glid23.cnx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import tn.iit.glid23.model.Autorisation;
import tn.iit.glid23.model.Enseignant;

public class AutorisationDAO {
	
	public static Autorisation findById(int id) {

		Connection conn= DBConnexion.getConnection();
		Autorisation u= null;
		try {
		
			PreparedStatement ps = conn.prepareStatement("SELECT a.* ,e.nom,e.prenom FROM autorisation a , enseignant e  where a.id_enseignant=?  and a.id_enseignant=e.id ");
					ps.setInt(1, id);
					
					ResultSet rs= ps.executeQuery();
					if (rs!=null)
					{
					while(rs.next())
					{
					u = new Autorisation();
					u.setId(rs.getInt("id"));
					u.setNom(rs.getString("nom"));
					u.setPrenom(rs.getString("prenom"));
					
					}
					}
					ps.close();
					} catch (SQLException e) {
					e.printStackTrace();
					}
					return u;
	}
	
	
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

		u.setNb_heures_demande(rs.getInt("nb_heures_demande"));
		

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
		
	
	public static List<Autorisation> AutorisationsByEnseignant(int id) {
		
		List<Autorisation> autorisation= new ArrayList<Autorisation>();

		Connection conn= DBConnexion.getConnection();
		try {
		
			
		PreparedStatement ps = conn.prepareStatement("SELECT a.* ,e.nom,e.prenom FROM autorisation a , enseignant e  where a.id_enseignant=?  and a.id_enseignant=e.id");
		ps.setInt(1, id);
		
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
			
			PreparedStatement ps = conn.prepareStatement(" insert into autorisation values (0,?,?,?,?,?)");
			
				ps.setString(1, e.getDate());
				ps.setInt(2, e.getNb_heures());
				ps.setInt(3, e.getNb_semaine());
				ps.setInt(4, e.getId_enseignant());
				ps.setInt(5,e.getNb_heures_demande());

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
		
		
		
		/*public static List<Autorisation> listAutorisations() {
			
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
			}*/
		
		

		public static boolean  getNbHeures(int id_enseignant, int nb_heures_demande) {

			

			boolean autorise = false;
		    int nbHeuresAutoriseesParSemaine = 4; 
		   
		    try {
		     
		    	Connection conn = DBConnexion.getConnection();
		    	
		      PreparedStatement psw =  conn.prepareStatement("SELECT SUM(nb_heures_demande) as nbsem FROM autorisation a, enseignant e WHERE a.id_enseignant = e.id AND e.id = ? AND nb_semaine = ?");
		      psw.setInt(1, id_enseignant);
		      psw.setInt(2, nb_heures_demande);

		      // Exécuter la requête
		      ResultSet rs = psw.executeQuery();

		      // Vérifier le résultat
		      if (rs.next()) {
		        int nbHeuresDejaDemandees = rs.getInt("nbsem");
		        System.out.println("nbsem"+nbHeuresDejaDemandees);
		        int nbHeuresTotalesDemandees = nbHeuresDejaDemandees + nb_heures_demande;
		        System.out.println("nbHeuresTotalesDemandees"+nbHeuresTotalesDemandees);
		        autorise = nbHeuresTotalesDemandees <= nbHeuresAutoriseesParSemaine;
		      }

		      // Fermer les ressources
		    } catch (SQLException e) {
		      // Gérer les erreurs SQL
		      e.printStackTrace();
		    }

		    return autorise;
				
		}
		
		
		
		
		/*public static int getNbHeures() {
			   // declare variables outside try block to ensure they are visible within finally block.
			   Connection conn = null; 
			   PreparedStatement psw = null;
			   ResultSet rs = null;
			   int nbsem = 0; 
			   
			   try {
			      conn = DBConnexion.getConnection();
			      LocalDate currentDate = LocalDate.now();
			      int currentWeek = currentDate.get(WeekFields.ISO.weekOfWeekBasedYear());
			      psw = conn.prepareStatement(
			         "SELECT SUM(nb_heures_demande) as nbsem FROM autorisation WHERE nb_semaine=?");
			      psw.setInt(1, currentWeek);
			      rs = psw.executeQuery();
			      if (rs != null && rs.next()) {
			         nbsem = rs.getInt("nbsem");
			      }
			 } catch(SQLException ex) {
			      ex.printStackTrace();
			   } finally {
			      // close resources in reverse order that they were opened
			      if (rs != null) {
			          try {
			              rs.close();
			          } catch (SQLException e) {
			              
			          }
			      }
			     if (psw != null) {
			          try {
			              psw.close();
			          } catch (SQLException e) {
			          }
			      }
			     if (conn != null) {
			         try {
			             conn.close();
			         } catch (SQLException e) {
			            
			         }
			     } 
			   }
			   return nbsem;
			}*/
		
		public static int getNbHeures2() {
		    int nbsem = 6;
		    
		    Connection conn = DBConnexion.getConnection();
		    
		    try {
		        LocalDate currentDate = LocalDate.now();
		        int currentWeek = currentDate.get(WeekFields.ISO.weekOfWeekBasedYear());
		        
		        PreparedStatement psw = conn.prepareStatement("SELECT SUM(nb_heures_demande) AS nbsem FROM autorisation WHERE nb_semaine = ?");
		        psw.setInt(1, currentWeek);
		        
		        ResultSet rs = psw.executeQuery();
		        
		        if (rs.next()) {
		            nbsem = rs.getInt("nbsem");
		        }
		    } catch (Exception e) {
		        // TODO: handle exception
		    } finally {
		        // Close the database connection and other resources here if needed
		    }
		    
		    return nbsem;
		}


	
		
		
		

}
