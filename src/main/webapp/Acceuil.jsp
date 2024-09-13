<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Acceuil</title>
    <link rel="stylesheet" type="text/css" href="header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha384-Mf0A/58D8rZuhSjB1lOaOP5I6wuKt/p0xIA+5t2a/UW/pHmP0U8rAdrFJ5gI6BfG" crossorigin="anonymous">
</head>
<body>
<%@ include file="navbar.jsp" %>
    
    <main>
        <div class="content-container">
            <div class="left-content">
                <div class="logo">
                    <i class="fas fa-home fa-3x"></i>
                    <p>FreeHouse Agency</p>
                </div>
                <b><h1 class="animate__animated animate__fadeIn">Find Your Dream <br/>House by Us</h1></b>
            </div>
            <div class="right-content">
                <img src="https://cdn.pixabay.com/photo/2016/11/18/17/46/architecture-1836070_960_720.jpg" alt="Modern Apartment" class="img-fluid rounded shadow" />
            </div>
        </div>
        <div class="about-us">
            <div class="about-left">
                <img src="https://cdn.pixabay.com/photo/2015/10/12/15/18/landscape-984628_960_720.jpg" alt="About Us" class="img-fluid rounded shadow" />
            </div>
            <div class="about-right border rounded p-3">
                <div class="about-text">
                    <h2>About Us</h2>
                    <p>FreeHouse Agency is dedicated to helping you find your dream home. Our platform provides a wide range of services including:</p>
                    <ul>
                        <li>Advanced search capabilities to find the perfect property</li>
                        <li>Secure and streamlined rental application process</li>
                        <li>Professional assistance from experienced agents</li>
                        <li>And much more!</li>
                    </ul>
                    <p>Contact us today to get started on your journey to finding the perfect home!</p>
                </div>
            </div>
        </div>
    </main>
    
    <%@ include file="footer.jsp" %>

    <!-- Login Modal -->
    <div id="loginModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="handleCloseLogin()">&times;</span>
        <h2>Login</h2>
        <form id="loginForm" class="login-form" action="login" method="post" onsubmit="return validateLoginForm()">
            <div class="form-group">
                <label for="username">UserName</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Enter UserName" required>
            </div>
            <div class="form-group mt-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
            </div>
             <button type="submit" class="btn btn-primary mt-3">Login</button>
             
        </form>

        <div class="mt-3">
            <div class="forgot-password-link">
            <a href="#" onclick="handleShowForgotPassword()">Forgot Password?</a>
       	    </div>
            <p>
                Don't have an account? 
                <span class="register-link" style="color: #1e90ff; cursor: pointer;" onclick="handleShowRegister()">Register here</span>.
            </p>
        </div>
    </div>
</div>

    <!-- Register Modal -->
<div id="registerModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="handleCloseRegister()">&times;</span>
        <h2>Register</h2>
       <form id="registerForm" class="register-form" action="register" method="post">
             <div class="form-group">
                 <label for="registerEmail">Email address</label>
                 <input type="email" class="form-control" id="registerEmail" name="email" placeholder="Enter email">
             </div>
             <div class="form-group mt-3">
                 <label for="registerUsername">UserName</label>
                 <input type="text" class="form-control" id="registerUsername" name="username" placeholder="UserName">
             </div>
             <div class="form-group mt-3">
                  <label for="registerPassword">Password</label>
                  <input type="password" class="form-control" id="registerPassword" name="password" placeholder="Password">
             </div>
             <div class="form-group mt-3">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
             </div>
             <div class="form-group mt-3">
                  <label for="recoveryWord">Recovery Word</label>
                  <input type="text" class="form-control" id="recoveryWord" name="recoveryWord" placeholder="Recovery Word">
             </div>
             <button type="submit" class="btn btn-primary mt-3">Register</button>
        </form>
    </div>
</div>

<!-- Recovery Password Modal -->
<div id="recoveryModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="handleCloseRecovery()">&times;</span>
        <h2>Password Recovery</h2>
        <form id="recoveryForm" class="recovery-form" action="password-recovery" method="post">
            <div class="form-group">
                <label for="recoveryUsername">UserName</label>
                <input type="text" class="form-control" id="recoveryUsername" name="username" placeholder="Enter UserName" required>
            </div>
            <div class="form-group mt-3">
                <label for="recoveryWord">Recovery Word</label>
                <input type="text" class="form-control" id="recoveryWord" name="recoveryWord" placeholder="Recovery Word" required>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Submit</button>
        </form>
    </div>
</div>

 <!-- Reset Password Modal -->
       <div id="resetPasswordModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="handleCloseResetPassword()">&times;</span>
        <h2>Reset Password</h2>
        <form id="resetPasswordForm" class="reset-password-form" action="reset-password" method="post">
            <div class="form-group">
                <label for="newPassword">New Password</label>
                <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="Enter new password" required>
            </div>
            <div class="form-group mt-3">
                <label for="confirmNewPassword">Confirm New Password</label>
                <input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword" placeholder="Confirm new password" required>
            </div>
            <input type="hidden" name="username" value="<%= request.getAttribute("username") %>">
            <button type="submit" class="btn btn-primary mt-3">Reset Password</button>
        </form>
    </div>
</div>

<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            showAlert("<%= message %>");
            handleShowLogin();
        });
    </script>
<%
    }
%>

<script>
    function handleShowLogin() {
        document.getElementById('loginModal').style.display = 'block';
    }

    function handleCloseLogin() {
        document.getElementById('loginModal').style.display = 'none';
    }

    function handleShowRegister() {
        document.getElementById('loginModal').style.display = 'none';
        document.getElementById('registerModal').style.display = 'block';
    }

    function handleCloseRegister() {
        document.getElementById('registerModal').style.display = 'none';
    }

    function handleShowForgotPassword() {
        document.getElementById('loginModal').style.display = 'none';
        document.getElementById('recoveryModal').style.display = 'block';
    }

    function handleCloseRecovery() {
        document.getElementById('recoveryModal').style.display = 'none';
    }

    function handleShowResetPassword() {
        document.getElementById('resetPasswordModal').style.display = 'block';
    }

    function handleCloseResetPassword() {
        document.getElementById('resetPasswordModal').style.display = 'none';
    }

    window.onclick = function(event) {
        if (event.target == document.getElementById('loginModal')) {
            handleCloseLogin();
        }
        if (event.target == document.getElementById('registerModal')) {
            handleCloseRegister();
        }
        if (event.target == document.getElementById('recoveryModal')) {
            handleCloseRecovery();
        }
        if (event.target == document.getElementById('resetPasswordModal')) {
            handleCloseResetPassword();
        }
        if (event.target == document.getElementById('resetPasswordModal')) {
            handleCloseResetPassword();
        }
    }

    function showAlert(message) {
        var alertDiv = document.createElement('div');
        alertDiv.className = 'alert alert-danger';
        alertDiv.role = 'alert';
        alertDiv.innerText = message;
        document.querySelector('.modal-content').prepend(alertDiv);
    }

    // Ajout de la logique pour soumettre le formulaire de connexion et vérifier le chemin
    document.getElementById("loginForm").addEventListener("submit", function(event) {
        console.log("Form submitted");
    });

    // Ajout d'un événement pour vérifier que le modal s'affiche correctement
    document.getElementById('loginModal').addEventListener('show', function() {
        console.log("Login modal is shown");
    });

    // Ajout de logs pour les autres actions
    document.getElementById('loginModal').addEventListener('hide', function() {
        console.log("Login modal is hidden");
    });

    document.getElementById('registerModal').addEventListener('show', function() {
        console.log("Register modal is shown");
    });

    document.getElementById('registerModal').addEventListener('hide', function() {
        console.log("Register modal is hidden");
    });

    document.getElementById('recoveryModal').addEventListener('show', function() {
        console.log("Recovery modal is shown");
    });

    document.getElementById('recoveryModal').addEventListener('hide', function() {
        console.log("Recovery modal is hidden");
    });

    document.getElementById('resetPasswordModal').addEventListener('show', function() {
        console.log("Reset Password modal is shown");
    });

    document.getElementById('resetPasswordModal').addEventListener('hide', function() {
        console.log("Reset Password modal is hidden");
    });
    document.addEventListener('DOMContentLoaded', function() {
        // Récupérer l'élément du bouton Reset Password
        var resetPasswordButton = document.querySelector('.reset-password-form button[type="submit"]');
        // Ajouter un gestionnaire d'événements pour afficher le modal lorsque le bouton est cliqué
        resetPasswordButton.addEventListener('click', handleShowResetPassword);
    });
</script>

</body>
</html>
