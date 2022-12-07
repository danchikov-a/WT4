package servlets.hotel;

import models.Hotel;
import services.HotelService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelService hotelService = new HotelService();
        ArrayList<Hotel> hotels = null;

        try {
            hotels = (ArrayList<Hotel>) HotelService.findHotels();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        req.setAttribute("apartments", hotels);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/apartment/listApartment.jsp");
        HttpSession session = req.getSession();
        req.setAttribute("session", session.getAttribute("sessionName"));
        int idApartment = hotelService.getIdHotelFromUser((String) session.getAttribute("sessionName"));

        try {
            Hotel hotel = HotelService.findHotel(idApartment);
            if (hotel != null) {
                req.setAttribute("apartment", hotel);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        requestDispatcher.forward(req, resp);
    }
}
