package tn.iit.glid23.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tn.iit.glid23.cnx.DBConnexion;
import tn.iit.glid23.cnx.UtilisateurDB;
import tn.iit.glid23.model.Utilisateur;

@WebServlet("/UtilisateursServlet")
public class UtilisateursServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
        // Transmettre les utilisateurs à la page JSP
        request.setAttribute("utilisateurs", UtilisateurDB.listUser());
        request.getRequestDispatcher("liste_utilisateurs.jsp").forward(request, response);
    }
}
