package DAO.impl;

import DAO.HotelDao;
import models.Hotel;
import services.ConnectionData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDao {
    public List<Hotel> show() throws SQLException {
        List<Hotel> listHotel = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM HotelBooking.Hotel";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery(sql);

            while (resultSet.next()) {
                Hotel hotel = new Hotel(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5)
                );

                listHotel.add(hotel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return listHotel;
    }

    public Hotel index(int id) throws SQLException {
        Hotel hotel = null;

        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM WebTech.apartment WHERE id = " + id;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                hotel = new Hotel(
                    result.getInt("id"),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getInt(5)
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return hotel;
    }


    public void update(String roomName, String roomCount, String roomPrice, int isBooked, int idApartment) {
        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE HotelBooking.Hotel SET apartmentName = ?, roomCount = ?, price = ?, isBooked = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, roomName);
            pst.setString(2, roomCount);
            pst.setString(3, roomPrice);
            pst.setInt(4, isBooked);
            pst.setInt(5, idApartment);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void book(int id) {
        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE WebTech.apartment SET isBooked = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, 1);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getHotelIdFromUser(String userName) {
        int id = 0;

        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "SELECT idApartment FROM WebTech.user WHERE userName = " + "\"" + userName + "\"";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                id = result.getInt("idApartment");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public void resetApartmentFromUser(String userName) {
        int id = getHotelIdFromUser(userName);

        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE WebTech.apartment SET isBooked = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
