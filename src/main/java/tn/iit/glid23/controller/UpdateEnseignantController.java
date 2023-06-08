package tn.iit.glid23.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.glid23.cnx.EnseignantDAO;
import tn.iit.glid23.cnx.UtilisateurDB;
import tn.iit.glid23.model.Enseignant;
import tn.iit.glid23.model.Utilisateur;

/**
 * Servlet implementation class UpdateEnseignantController
 */
@WebServlet("/UpdateEnseignantController")
public class UpdateEnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEnseignantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enseignant u = new Enseignant(request.getParameter("nom"),
				request.getParameter("prenom"),
				request.getParameter("email"),
				request.getParameter("password"));
		ServletContext application = getServletContext();
		//List<Utilisateur> listUser = (List<Utilisateur>) application.getAttribute("tabUser");
		int pos = Integer.parseInt(request.getParameter("pos"));
		//listUser.set(pos,u);
		
		EnseignantDAO.updateEnseignant(pos,u);
		//application.setAttribute("tabUser", listUser);
        application.setAttribute("tabEseignants", EnseignantDAO.listEseignants());
		response.sendRedirect("liste-enseignants.jsp");
	}

}
