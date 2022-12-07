package DAO.impl;

import DAO.UserDao;
import services.ConnectionData;
import services.DataHelper;

import java.sql.*;

public class UserDAOImpl implements UserDao {
    public void registerUser(String userName, String userPassword) throws SQLException {
        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "INSERT INTO WebTech.user (id,userName,userPassword,userRole) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, 0);
            pst.setString(2, userName);
            pst.setString(3, userPassword);
            pst.setInt(4, 0);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean loginUser(String userName, String userPassword) throws SQLException {
        String password = "";

        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "SELECT userPassword FROM WebTech.user WHERE userName = " + "\"" + userName + "\"";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);

            while (result.next()) {
                password = result.getString("userPassword");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return DataHelper.ParseToInt(password) == DataHelper.ParseToInt(userPassword);
    }

    public int checkRole(String userName) throws SQLException {
        int role = 0;

        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "SELECT userRole FROM WebTech.user WHERE userName = " + "\"" + userName + "\"";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);

            while (result.next()) {
                role = result.getInt("userRole");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return role;
    }

    public void addApartmentToUser(String userName, int idApartment) {
        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE WebTech.user SET idApartment = ? WHERE userName = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idApartment);
            pst.setString(2, userName);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setRole(String userName, int newRole) {
        try {
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE WebTech.user SET userRole = ? WHERE userName = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, newRole);
            pst.setString(2, userName);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
