package Controller;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import DAO.UsersDAO;
import Model.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String LOGIN_PAGE = "Acceuil.jsp";
    private static final String SUCCESS_PAGE = "login-success.jsp";
    private static final String INTERNAL_ERROR_MESSAGE = "Internal server error";

    private UsersDAO userDAO;

    public void init() {
        userDAO = new UsersDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Users user = userDAO.checkLogin(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(SUCCESS_PAGE);
            } else {
                request.setAttribute("message", "Invalid username or password");
                request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", INTERNAL_ERROR_MESSAGE);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(LOGIN_PAGE);
    }
}
