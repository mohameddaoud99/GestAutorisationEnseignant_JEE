package tn.iit.glid23.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.glid23.cnx.EnseignantDAO;
import tn.iit.glid23.cnx.UtilisateurDB;
import tn.iit.glid23.model.Utilisateur;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("email");
		String pwd = request.getParameter("mdp");

		RequestDispatcher rdAuth = getServletContext().getRequestDispatcher("/auth.jsp");
		RequestDispatcher rdIndex = getServletContext().getRequestDispatcher("/index.jsp");

		ServletContext application = getServletContext();
		//List<Utilisateur> listUser = (List<Utilisateur>) application.getAttribute("tabUser");
		HttpSession session = request.getSession();

		

		Utilisateur user = UtilisateurDB.getUserByLoginAndpwd(login, pwd);

		if (user != null) {
			
			application.setAttribute("tabEseignants", EnseignantDAO.listEseignants());
			System.out.println(application);
			session.setAttribute("currentUser", user);
			rdIndex.forward(request, response);
		} else {
			request.setAttribute("erreur", "Veuillez reessayer !!");
			rdAuth.forward(request, response);
		}
	
		
		/*if (listUser == null) {
			request.setAttribute("erreur", "Aucun utilisateur n'est inscrit");
			rdAuth.forward(request, response);
		} else {
			boolean trouve = false;
			for (Utilisateur utilisateur : listUser) {
				if (utilisateur.getLogin().equals(login) && utilisateur.getPwd().equals(mp)) {
					session.setAttribute("currentUser", utilisateur);
					trouve = true;
					break;
				}
			}
			if(trouve) {
				rdIndex.forward(request, response);
			}
			else {
				request.setAttribute("erreur", "Veuillez reessayer !!");
				rdAuth.forward(request, response);
			}*/
		

//		if("admin".equals(login)&&"123".equals(mp)) {
//			HttpSession session = request.getSession();
//			session.setAttribute("currentUser", new Utilisateur("Jemal", "Ahmed", "admin", "123"));
//			rdIndex.forward(request, response);
//			//response.sendRedirect("IndexView");
//		}
//		else {
//			request.setAttribute("erreur", "Veuillez vérifier vos paramètres !!");
//			rdAuth.forward(request, response);
//		}
	}

}
