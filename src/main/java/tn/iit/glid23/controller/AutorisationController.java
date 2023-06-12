package tn.iit.glid23.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.iit.glid23.cnx.AutorisationDAO;
import tn.iit.glid23.cnx.EnseignantDAO;
import tn.iit.glid23.model.Autorisation;
import tn.iit.glid23.model.Enseignant;

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
		RequestDispatcher rdAutorisation = getServletContext().getRequestDispatcher("/autorisation.jsp");
		rdAutorisation.forward(request, response);
		
		
		LocalDate currentDate = LocalDate.now();
		ServletContext application1 = getServletContext();
		application1.setAttribute("CurrentDate",currentDate );
		
		// Obtenir le numéro de la semaine actuelle
        int currentWeek = currentDate.get(WeekFields.ISO.weekOfWeekBasedYear());
        ServletContext application2 = getServletContext();
		application2.setAttribute("CurrentWeek",currentWeek );


        // Obtenir le nombre total de semaines dans l'année
        int totalWeeks = currentDate.lengthOfYear() / 7;
        

        // Calculer le nombre de semaines restantes dans l'année
        int remainingWeeks = totalWeeks - currentWeek;
        ServletContext application4 = getServletContext();
		application4.setAttribute("RemainingWeeks",remainingWeeks );
		
		// calaculer le nombre d'heures autorisées restante
		int nbHeureRes = remainingWeeks*4;
        ServletContext application3 = getServletContext();
		application3.setAttribute("NbHeureRes",nbHeureRes );

        System.out.println(currentDate +" ----   "+currentWeek);
        System.out.println("Nombre de semaines restantes : " + remainingWeeks);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String id_enseignant  = request.getParameter("teacherId ");
		//String id_enseignant  = "1";
		int id_enseignant = Integer.parseInt(request.getParameter("teacherId"));

		System.out.print("ddddddddddddd"+id_enseignant);
		
		String date = request.getParameter("date");
		String nb_semaine = request.getParameter("nb_semaine");
		String nb_heures = request.getParameter("nb_heures");
		String nb_heures_demande = request.getParameter("nb_heures_demande");

		System.out.println(id_enseignant);
<<<<<<< HEAD
		Autorisation newAutorisation = new Autorisation(date,Integer.parseInt(nb_semaine),Integer.parseInt(nb_heures),
				Integer.parseInt(id_enseignant),Integer.parseInt(nb_heures_demande));
=======
		Autorisation newAutorisation = new Autorisation(date,Integer.parseInt(nb_semaine),Integer.parseInt(nb_heures),id_enseignant);
>>>>>>> a6eb47ec1ae9a1d0f3e0c895c3b694225878c659
		AutorisationDAO.insertAutorisation(newAutorisation);
		ServletContext application = getServletContext();
        application.setAttribute("tabAutorisations", AutorisationDAO.listAutorisations());
		response.sendRedirect("liste-autorisations.jsp");
		
		
	}
	
	
	private void listAutorisation(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Autorisation> ListeAutorisations = AutorisationDAO.listAutorisations();
		request.setAttribute("listAut", ListeAutorisations);
		RequestDispatcher dispatcher = request.getRequestDispatcher("liste-autorisations.jsp");
		dispatcher.forward(request, response);
	}

	private void insertAutorisation(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {
		String date = request.getParameter("date");
		int nb_heures = Integer.parseInt(request.getParameter("nb_heures"));
		int nb_semaine = Integer.parseInt(request.getParameter("nb_semaine"));
		int id_enseignant  = Integer.parseInt(request.getParameter("id_enseignant "));
		int nb_heures_demande = Integer.parseInt(request.getParameter("nb_heures_demande"));
		Autorisation newAutorisation = new Autorisation(date,nb_heures,nb_semaine,id_enseignant,nb_heures_demande);
		AutorisationDAO.insertAutorisation(newAutorisation);
		response.sendRedirect("list");
	}
	
	
	

}
