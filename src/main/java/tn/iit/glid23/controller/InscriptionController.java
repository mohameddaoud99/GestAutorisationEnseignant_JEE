package tn.iit.glid23.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.glid23.cnx.UtilisateurDB;
import tn.iit.glid23.model.Utilisateur;

/**
 * Servlet implementation class InscriptionController
 */
@WebServlet("/InscriptionController")
public class InscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("courant");
		
		UtilisateurDB.addUser(u);
		ServletContext application = getServletContext();	
		/*
		List<Utilisateur> listUser = (List<Utilisateur>) application.getAttribute("tabUser");
		if(listUser == null) {
			listUser = new ArrayList<>();
		}
		listUser.add(u);*/
		
		application.setAttribute("tabUser", UtilisateurDB.listUser());
		System.out.println(application);
		response.sendRedirect("auth.jsp");
	
	}

}
