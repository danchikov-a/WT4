package models;

public class User {
    private int id;
    private String userName;
    private String userPassword;
    private int userRole;

    private Hotel hotel;

    public User(int id, String userName, String userPassword, int userRole) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public User(int id, String userName, String userPassword, int userRole, int FK_Apartment) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.FK_Apartment = FK_Apartment;
    }

    public User(int id, String userName, String userPassword, int userRole, Hotel hotel, int FK_Apartment) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.hotel = hotel;
        this.FK_Apartment = FK_Apartment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public Hotel getApartment() {
        return hotel;
    }

    public void setApartment(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getFK_Apartment() {
        return FK_Apartment;
    }

    public void setFK_Apartment(int FK_Apartment) {
        this.FK_Apartment = FK_Apartment;
    }

    private int FK_Apartment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
