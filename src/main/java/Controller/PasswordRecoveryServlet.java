package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.UsersDAO;
import Model.Users;

@WebServlet("/password-recovery")
public class PasswordRecoveryServlet extends HttpServlet {
    
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
        String recoveryWord = request.getParameter("recoveryWord");

        Users user = userDAO.selectUserByUsername(username);

        if (user != null && user.getRecoveryWord().equals(recoveryWord)) {
            request.setAttribute("username", username);
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Invalid username or recovery word");
            request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
        }
    }
}
