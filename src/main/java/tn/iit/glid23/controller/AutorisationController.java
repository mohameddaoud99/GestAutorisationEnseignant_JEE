package tn.iit.glid23.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import tn.iit.glid23.cnx.AutorisationDAO;
import tn.iit.glid23.cnx.DBConnexion;
import tn.iit.glid23.model.Autorisation;

/**
 * Servlet implementation class AutorisationController
 */
@WebServlet("/AutorisationController")
public class AutorisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutorisationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		
	        
	        // Transmettre les utilisateurs à la page JSP
	        request.setAttribute("utilisateurs", AutorisationDAO.listAutorisation());
	        request.getRequestDispatcher("liste-autorisations.jsp").forward(request, response);
	        
	        
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
