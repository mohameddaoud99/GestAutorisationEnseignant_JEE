package tn.iit.glid23.cnx;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnexion
{
private static Connection connection =null;
static
{
	try {
	
		Class.forName("com.mysql.jdbc.Driver");
	
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestensjee","root","");
	
	} catch (Exception e) {

		System.out.println("Problème de connexion à la BD..");
		e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		//return l'objet de connexion
		return connection;
	}
}