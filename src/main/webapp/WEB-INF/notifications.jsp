<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Notifications</title>
    <%@ include file="header.jsp"%>
</head>
<body>
    <%@ include file="menu.jsp"%>
    <h1>Liste des notifications de l'utilisateur connecté:</h1>

    <table>
        <thead>
        <tr>
            <th>Type de notif</th>
            <th>Contenu</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="notification" items="${ notificationsUtilisateur }">
            <tr>
                <td>${ notification.type_notif }</td>
                <td>${ notification.contenu }</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Liste des notifications de tous les utilisateurs:</h1>
    <table>
        <thead>
        <tr>
            <th>Type de notif</th>
            <th>Contenu</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="notification" items="${ notifications }">
            <tr>
                <td>${ notification.type_notif }</td>
                <td>${ notification.contenu }</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
