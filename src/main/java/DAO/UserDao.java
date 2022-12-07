package DAO;

import java.sql.SQLException;

public interface UserDao {
    void registerUser(String userName, String userPassword) throws SQLException;
    boolean loginUser(String userName, String userPassword) throws SQLException;
    int checkRole(String userName) throws SQLException;
    void addApartmentToUser(String userName, int idApartment);
    void setRole(String userName, int newRole);
}
