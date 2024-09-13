package Controller;

import DAO.UsersDAO;
import Model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsersDAO usersDAO;

    public void init() {
        usersDAO = new UsersDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            registerUser(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String recoveryWord = request.getParameter("recoveryWord");

        // Vérification si les mots de passe correspondent
        if (!password.equals(confirmPassword)) {
            request.setAttribute("message", "Passwords do not match");
            request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
            return;
        }

        // Vérification de la longueur du mot de passe
        if (password.length() < 4) {
            request.setAttribute("message", "Password must be at least 4 characters long");
            request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
            return;
        }

        // Vérification si l'utilisateur existe déjà
        if (usersDAO.selectUserByUsername(username) != null) {
            request.setAttribute("message", "Username already exists");
            request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
            return;
        }

        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRecoveryWord(recoveryWord);

        usersDAO.insertUser(newUser);

        request.setAttribute("message", "Registration successful");
        request.getRequestDispatcher("registration-success.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Acceuil.jsp");
    }
}
