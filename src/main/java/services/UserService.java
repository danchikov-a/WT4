package services;

import DAO.impl.UserDAOImpl;

import java.sql.SQLException;

public class UserService {
    private static final UserDAOImpl USER_DAO_IMPL = new UserDAOImpl();

    public static void registerUser(String userName, String userPassword) throws SQLException {
        USER_DAO_IMPL.registerUser(userName, userPassword);
    }

    public static boolean loginUser(String userName, String userPassword) throws SQLException {
        return USER_DAO_IMPL.loginUser(userName, userPassword);
    }

    public static int checkRole(String userName) throws SQLException {
        return USER_DAO_IMPL.checkRole(userName);
    }

    public static void addApartmentToUser(String userName, int idApartment) {
        USER_DAO_IMPL.addApartmentToUser(userName, idApartment);
    }
}
