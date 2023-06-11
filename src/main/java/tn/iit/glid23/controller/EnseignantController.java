package tn.iit.glid23.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.glid23.cnx.EnseignantDAO;
import tn.iit.glid23.cnx.UtilisateurDB;
import tn.iit.glid23.model.Enseignant;

/**
 * Servlet implementation class EnseignantController
 */
@WebServlet("/EnseignantController")
public class EnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnseignantDAO EnseignantDAO;
   
    
    public void init() {
    	EnseignantDAO = new EnseignantDAO();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/aaa":
	                	AddEnseignantPage(request, response);
	                    break;
	                case "/insert":
	                	insertEnseignant(request, response);
	                    break;
	               
	                default:
	                	listEnseignant(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Enseignant newEnseignant = new Enseignant(nom,prenom, email, password);
        EnseignantDAO.insertEnseignant(newEnseignant);
		ServletContext application = getServletContext();
        application.setAttribute("tabEseignants", EnseignantDAO.listEseignants());
		response.sendRedirect("liste-enseignants.jsp");
	}
	
	
	
	
	
	private void listEnseignant (HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Enseignant > ListeEnseignants = EnseignantDAO.listEseignants();
		        request.setAttribute("listEns", ListeEnseignants);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("liste-enseignants.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void AddEnseignantPage(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("enseignant-form.jsp");
		        dispatcher.forward(request, response);
		    }

		   

		    private void insertEnseignant(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String nom = request.getParameter("name");
		        String prenom = request.getParameter("prenom");
		        String email = request.getParameter("email");
		        String password = request.getParameter("password");
		        Enseignant newEnseignant = new Enseignant(nom,prenom, email, password);
		        EnseignantDAO.insertEnseignant(newEnseignant);
		        response.sendRedirect("list");
		    }

		   
	
	
	

}
