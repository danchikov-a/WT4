package servlets.user;

import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/user/registerUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        boolean canLogin = false;
        int role = 0;

        try {
            canLogin = UserService.loginUser(userName, userPassword);
            role = UserService.checkRole(userName);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        if (canLogin) {
            req.setAttribute("userPassword", userPassword);
            HttpSession session = req.getSession();
            session.setAttribute("sessionName", userName);

            session.setAttribute("session_role", role == 0 ? "User" : "Administrator");

            resp.sendRedirect("/listApartment");
        } else {
            resp.sendRedirect("../..");
        }
    }
}
