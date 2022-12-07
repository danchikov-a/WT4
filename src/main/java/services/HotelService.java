package services;

import DAO.impl.HotelDAOImpl;
import models.Hotel;

import java.sql.SQLException;
import java.util.List;

public class HotelService {
    private static final HotelDAOImpl HOTEL_DAO_IMPL = new HotelDAOImpl();

    public static Hotel findHotel(int id) throws SQLException {
        return HOTEL_DAO_IMPL.index(id);
    }

    public static List<Hotel> findHotels() throws SQLException {
        return HOTEL_DAO_IMPL.show();
    }

    public static void editHotel(String roomName, String roomCount, String roomPrice, int isBooked, int idApartment) {
        HOTEL_DAO_IMPL.update(roomName, roomCount, roomPrice, isBooked, idApartment);
    }

    public static void resetDepartmentFromUser(String userName) {
        HOTEL_DAO_IMPL.resetApartmentFromUser(userName);
    }

    public int getIdHotelFromUser(String userName) {
        return HOTEL_DAO_IMPL.getHotelIdFromUser(userName);
    }

    public static void bookHotel(int id) {
        HOTEL_DAO_IMPL.book(id);
    }
}
