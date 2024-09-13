<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha384-Mf0A/58D8rZuhSjB1lOaOP5I6wuKt/p0xIA+5t2a/UW/pHmP0U8rAdrFJ5gI6BfG" crossorigin="anonymous">
</head>
<body>
<header>
    <div class="top-bar"></div>
    <div class="nav-bar d-flex justify-content-between align-items-center">
        <div class="logo d-flex align-items-center">
            <i class="fas fa-home freehouse-icon"></i>
            <p class="ms-2 mb-0">FreeHouse</p>
        </div>
        <nav class="d-flex gap-4">
                <a href="Acceuil.jsp">Home</a>
    			<a href="Empty.jsp">Shop</a>
    			<a href="Empty.jsp">Contact</a>
        </nav>
        <div class="nav-icons d-flex align-items-center">
            <div class="ms-3">
                <% if (session.getAttribute("user") == null) { %>
                    <!-- Affiche le bouton Sign in uniquement si l'utilisateur n'est pas authentifié -->
                    <button class="btn btn-primary me-2" onclick="handleShowLogin()">
                        Sign in
                    </button>
                <% } else { %>
                    <!-- Affiche le bouton Logout uniquement si l'utilisateur est authentifié -->
                    <a href="<%= request.getContextPath() %>/logout" class="btn btn-danger me-2">Logout</a>

                <% } %>
            </div>
        </div>
    </div>
</header>

</body>
</html>
