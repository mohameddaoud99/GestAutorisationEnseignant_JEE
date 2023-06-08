package tn.iit.glid23.cnx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.glid23.model.Enseignant;
import tn.iit.glid23.model.Utilisateur;



public class UtilisateurDB {


	public static void addUser(Utilisateur u) {

	Connection conn= DBConnexion.getConnection();
	try {
	
	PreparedStatement ps = conn.prepareStatement(" insert into admin values (0,?,?,?,?)");
	
	ps.setString(1, u.getNom());
	ps.setString(2, u.getPrenom());
	ps.setString(3, u.getEmail());
	ps.setString(4, u.getMdp());

	ps.executeUpdate();
	} catch (SQLException e) {

	e.printStackTrace();
	}
	}

	public static List<Utilisateur> listUser() {
	
	List<Utilisateur> users= new ArrayList<Utilisateur>();

	Connection conn= DBConnexion.getConnection();
	try {
	
	PreparedStatement ps = conn.prepareStatement(" select * from admin");

	ResultSet rs= ps.executeQuery();
	if (rs!=null)
	{
	
	while(rs.next())
	{
	
	Utilisateur u = new Utilisateur();
	u.setId(rs.getInt("id"));
	u.setNom(rs.getString("nom"));
	u.setPrenom(rs.getString("prenom"));
	u.setEmail(rs.getString("email"));
	u.setMdp(rs.getString("mdp"));
	
	users.add(u);
	}
	}
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}

	return users;
	}
	

	public static Utilisateur getUserByLoginAndpwd(String l, String p) {

	Connection conn= DBConnexion.getConnection();
	Utilisateur u= null;
	try {
	
		PreparedStatement ps = conn.prepareStatement(" select * from admin where email =? and mdp = ?");
				ps.setString(1, l);
				ps.setString(2, p);
				System.out.println(ps);
				ResultSet rs= ps.executeQuery();
				System.out.print(rs);
				if (rs!=null)
				{
				while(rs.next())
				{
				u = new Utilisateur();
				u.setId(rs.getInt("id"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setEmail(rs.getString("email"));
				u.setMdp(rs.getString("mdp"));
				}
				}
				ps.close();
				} catch (SQLException e) {
				e.printStackTrace();
				}
				return u;
				}
				
	/*	public static void updateUser(int pos, Utilisateur u) {
				
				Connection conn= DBConnexion.getConnection();
				try {
				
				PreparedStatement ps = conn.prepareStatement(" update utilisateur 	set nom= ?, prenom=?, login=?, pwd=? where id=? ");
				ps.setString(1, u.getNom());
				ps.setString(2, u.getPrenom());
				ps.setString(3, u.getLogin());
				ps.setString(4, u.getPwd());
				ps.setInt(5, pos);
				System.out.print(pos);
				System.out.print(ps);
				ps.executeUpdate();
				
				System.out.print(ps);
				} catch (SQLException e) {
				
				e.printStackTrace();
				}
				}
			
				public static void deleteUser(int id) {
			
				Connection conn= DBConnexion.getConnection();
				try {
				
				PreparedStatement ps = conn.prepareStatement(" delete from utilisateur where id=? ");
				ps.setInt(1, id);
				System.out.print(id);
				ps.executeUpdate();
				} catch (SQLException e) {
				
				e.printStackTrace();
				}
				}
				
				public static Utilisateur findById(int id) {

					Connection conn= DBConnexion.getConnection();
					Utilisateur u= null;
					try {
					
						PreparedStatement ps = conn.prepareStatement(" select * from utilisateur where id =? ");
								ps.setInt(1, id);
								
								ResultSet rs= ps.executeQuery();
								if (rs!=null)
								{
								while(rs.next())
								{
								u = new Utilisateur();
								u.setId(rs.getInt("id"));
								u.setNom(rs.getString("nom"));
								u.setPrenom(rs.getString("prenom"));
								u.setLogin(rs.getString("login"));
								u.setPwd(rs.getString("pwd"));
								}
								}
								ps.close();
								} catch (SQLException e) {
								e.printStackTrace();
								}
								return u;
				}
				
		*/		
				
				
}
