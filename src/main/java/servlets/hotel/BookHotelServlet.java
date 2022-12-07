package servlets.hotel;

import services.HotelService;
import services.UserService;
import services.DataHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class BookHotelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nameUser = request.getParameter("session");
        int parsedId = DataHelper.ParseToInt(id);

        try {
            if (UserService.checkRole(nameUser) == 0) {
                HotelService.resetDepartmentFromUser(nameUser);
                HotelService.bookHotel(parsedId);
                UserService.addApartmentToUser(nameUser, parsedId);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        response.sendRedirect("/listHotel");
    }
}
