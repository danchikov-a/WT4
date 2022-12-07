package DAO;

import models.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelDao {
    List<Hotel> show() throws SQLException;
    Hotel index(int id) throws SQLException;
    void update(String roomName, String roomCount, String roomPrice, int isBooked, int idApartment);
    void book(int id);
    int getHotelIdFromUser(String userName);
    void resetApartmentFromUser(String userName);
}
