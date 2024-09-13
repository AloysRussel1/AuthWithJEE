<%@ page import="Model.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Successful</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="navbar.jsp" %>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header text-center">
                        <h2>Login Successful</h2>
                    </div>
                    <div class="card-body text-center">
                        <% 
                            Users user = (Users) session.getAttribute("user");
                            if (user != null) { 
                        %>
                            <p>Welcome, <strong><%= user.getUsername() %></strong>!</p>
                            <a href="Acceuil.jsp" class="btn btn-primary mt-3">Go to Home</a>
                        <% 
                            } else { 
                        %>
                            <p>Error: User information is not available.</p>
                            <a href="Acceuil.jsp" class="btn btn-primary mt-3">Go to Home</a>
                        <% 
                            } 
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <%@ include file="footer.jsp" %>
</body>
</html>