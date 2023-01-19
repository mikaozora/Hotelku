import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private String roomCategory;
    private int roomPrice;
    private boolean status;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String isStatus() {
        if (this.status) return "Available";
        return "Unavailable";
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private static List<Room> listRoom = new ArrayList<>();

    Room(int roomNumber, String roomCategory, int roomPrice, boolean status){
        this.setRoomNumber(roomNumber);
        this.setRoomCategory(roomCategory);
        this.setRoomPrice(roomPrice);
        this.setStatus(status);
    }

    public static void viewRoom(){
        listRoom.forEach(rooms -> {
            System.out.println("Room Number: " + rooms.getRoomNumber() + ", Room Category: " + rooms.getRoomCategory() + ", Room Price: " + rooms.getRoomPrice() + ", Room Status: " + rooms.isStatus());
        });
    }

    public static void viewAvailableRoom(){
        listRoom.forEach(rooms -> {
            if (rooms.isStatus().equals("Available")) {
                System.out.println("Room Number: " + rooms.getRoomNumber() + ", Room Category: " + rooms.getRoomCategory() + ", Room Price: " + rooms.getRoomPrice() + ", Room Status: " + rooms.isStatus());
            }
        });
    }

    public void addRoom(int roomNumber, String roomCategory, int roomPrice, boolean status){

        listRoom.add(new Room(roomNumber, roomCategory, roomPrice, status));
    }

    public void updateRoom(int num, int roomNumber, String roomCategory, int roomPrice, boolean status){
        listRoom.get(num-1).roomNumber = roomNumber;
        listRoom.get(num-1).roomCategory = roomCategory;
        listRoom.get(num-1).roomPrice = roomPrice;
        listRoom.get(num-1).status = status;
    }

    public void deleteRoom(int num){
        listRoom.remove(num-1);
    }

    public void roomInit(){
        addRoom(100, "Single", 700000,false);
        addRoom(101, "Double", 1000000,true);
        addRoom(102, "Queen", 2000000,true);
        addRoom(103, "King", 4000000,false);
        addRoom(104, "Double", 1000000,false);
        addRoom(105, "Double", 1000000,false);
        addRoom(106, "Queen", 2000000,true);
        addRoom(107, "Single", 700000,false);
        addRoom(108, "Queen", 2000000,false);
        addRoom(109, "King", 4000000,false);
    }

}
