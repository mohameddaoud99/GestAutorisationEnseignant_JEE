

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@page import="java.util.List"%>


<%@page import="tn.iit.glid23.model.Utilisateur"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des utilisateurs</title>
</head>
<body>
    <h1>Liste des utilisateurs</h1>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Âge</th>
        </tr>
        
        <% 
        List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("utilisateurs");
        
        for (Utilisateur utilisateur : utilisateurs) { 
        %>
        <tr>
            <td><%= utilisateur.getId() %></td>
            <td><%= utilisateur.getNom() %></td>
            <td><%= utilisateur.getPrenom() %></td>
           
        </tr>
        <% } %>
    </table>
</body>
</html>
