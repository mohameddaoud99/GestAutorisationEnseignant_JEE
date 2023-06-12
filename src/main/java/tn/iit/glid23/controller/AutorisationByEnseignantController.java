package tn.iit.glid23.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.glid23.cnx.AutorisationDAO;
import tn.iit.glid23.cnx.EnseignantDAO;
import tn.iit.glid23.cnx.UtilisateurDB;
import tn.iit.glid23.model.Enseignant;
import tn.iit.glid23.model.Utilisateur;

/**
 * Servlet implementation class AutorisationByEnseignantController
 */
@WebServlet("/AutorisationByEnseignantController")
public class AutorisationByEnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutorisationByEnseignantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext application = getServletContext();
	
		int pos = Integer.parseInt(request.getParameter("pos"));
		System.out.print("jhhhhhhhhhhhhhhhhhhhhhhhhhh"+pos);
		
        application.setAttribute("tabAutorisationsByEnseignant", AutorisationDAO.AutorisationsByEnseignant(13));
		response.sendRedirect("liste-AutorisationsByEnseignant.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
