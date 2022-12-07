package models;

public class Hotel {
    private int id;
    private String apartmentName;
    private int roomCount;
    private int roomPrice;
    private int isBooked;

    public Hotel(){

    }

    public Hotel(int id, String apartmentName, int roomCount, int roomPrice, int isBooked) {
        this.id = id;
        this.apartmentName = apartmentName;
        this.roomCount = roomCount;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
    }

    public int getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(int isBooked) {
        this.isBooked = isBooked;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
