package servlets.hotel;

import models.Hotel;
import services.HotelService;
import services.DataHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditHotelServlet extends HttpServlet {
    private String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        response.setContentType("text/html");
        Hotel hotel = new Hotel();

        int parsedId = DataHelper.ParseToInt(id);

        try {
            hotel = HotelService.findHotel(parsedId);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        request.setAttribute("hotel", hotel);
        request.setAttribute("getHotelName", hotel.getApartmentName());
        request.setAttribute("getRoomCount", hotel.getRoomCount());
        request.setAttribute("getRoomPrice", hotel.getRoomPrice());
        request.setAttribute("getIsBooked", hotel.getIsBooked());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/apartment/editHotel.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomName = request.getParameter("roomName");
        String roomCount = request.getParameter("roomCount");
        String roomPrice = request.getParameter("roomPrice");
        String isBooked = request.getParameter("isBooked");
        int _id = DataHelper.ParseToInt(id);
        int isBook = DataHelper.ParseToInt(isBooked);
        HotelService.editHotel(roomName, roomCount, roomPrice, isBook, _id);

        doGet(request, response);
    }
}
