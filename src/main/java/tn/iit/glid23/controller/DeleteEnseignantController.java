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

/**
 * Servlet implementation class DeleteEnseignantController
 */
@WebServlet("/DeleteEnseignantController")
public class DeleteEnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEnseignantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pos = Integer.parseInt(request.getParameter("id"));
		ServletContext application = getServletContext();
		
		EnseignantDAO.deleteEnseignant(pos);
		/*List<Utilisateur> listUser = (List<Utilisateur>) application.getAttribute("tabUser");
		listUser.remove(pos);
		*/
		application.setAttribute("tabEseignants", EnseignantDAO.listEseignants());
		response.sendRedirect("liste-enseignants.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
