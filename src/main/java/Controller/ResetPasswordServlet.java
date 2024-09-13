package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.UsersDAO;
import Model.Users;

@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsersDAO userDAO;

    @Override
    public void init() {
        userDAO = new UsersDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        
        // Vérification si les mots de passe correspondent
        if (!newPassword.equals(confirmNewPassword)) {
            request.setAttribute("message", "Passwords do not match");
            request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
            return;
        }

        // Vérification de la longueur du mot de passe
        if (newPassword.length() < 4) {
            request.setAttribute("message", "Password must be at least 4 characters long");
            request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
            return;
        }

        if (newPassword.equals(confirmNewPassword)) {
            userDAO.updatePassword(username, newPassword);
            request.setAttribute("message", "Password reset successful. Please login with your new password.");
            request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Passwords do not match");
            request.setAttribute("username", username);  // Retain username for convenience
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
        }
    }
}
