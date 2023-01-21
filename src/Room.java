import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    List<Room> listRoom = new ArrayList<>();

    List<Room> listRoomAvailable = new ArrayList<>();

    Room(int roomNumber, String roomCategory, int roomPrice, boolean status){
        this.setRoomNumber(roomNumber);
        this.setRoomCategory(roomCategory);
        this.setRoomPrice(roomPrice);
        this.setStatus(status);
    }

    public void viewRoom(){

        System.out.printf("==============================================================%n");
        System.out.printf("|                         ROOM LISTS                         |%n");
        System.out.printf("==============================================================%n%n");
        System.out.printf("==============================================================%n");
        System.out.printf("| %-2s | %-8s | %-12s | %-12s | %-12s |%n","NO","ROOM","CATEGORY","PRICE","STATUS");
        System.out.printf("==============================================================%n");


        AtomicInteger i = new AtomicInteger(1);
        listRoom.forEach(rooms -> {
            System.out.printf("| %-2s | %-8s | %-12s | %-12s | %-12s |%n",i,rooms.getRoomNumber(),rooms.getRoomCategory(),rooms.getRoomPrice(),rooms.isStatus());
            i.getAndIncrement();
        });

        System.out.printf("==============================================================%n");

    }

    public void viewAvailableRoom(){

        System.out.printf("==============================================================%n");
        System.out.printf("|                     AVAILABLE ROOM LISTS                   |%n");
        System.out.printf("==============================================================%n%n");
        System.out.printf("==============================================================%n");
        System.out.printf("| %-2s | %-8s | %-12s | %-12s | %-12s |%n","NO","ROOM","CATEGORY","PRICE","STATUS");
        System.out.printf("==============================================================%n");


        AtomicInteger i = new AtomicInteger(1);
        listRoom.forEach(rooms -> {
            if (rooms.isStatus().equals("Available")) {
                System.out.printf("| %-2s | %-8s | %-12s | %-12s | %-12s |%n", i, rooms.getRoomNumber(), rooms.getRoomCategory(), rooms.getRoomPrice(), rooms.isStatus());
                i.getAndIncrement();
            }
        });

        System.out.printf("==============================================================%n");

    }

    void viewUnavailableRoom(){
        System.out.printf("==============================================================%n");
        System.out.printf("|                     UNAVAILABLE ROOM LISTS                   |%n");
        System.out.printf("==============================================================%n%n");
        System.out.printf("==============================================================%n");
        System.out.printf("| %-2s | %-8s | %-12s | %-12s | %-12s |%n","NO","ROOM","CATEGORY","PRICE","STATUS");
        System.out.printf("==============================================================%n");


        AtomicInteger i = new AtomicInteger(1);
        listRoom.forEach(rooms -> {
            if (rooms.isStatus().equals("Unavailable")) {
                System.out.printf("| %-2s | %-8s | %-12s | %-12s | %-12s |%n", i, rooms.getRoomNumber(), rooms.getRoomCategory(), rooms.getRoomPrice(), rooms.isStatus());
                i.getAndIncrement();
            }
        });

        System.out.printf("==============================================================%n");
    }

    public void addRoom(int roomNumber, String roomCategory, int roomPrice, boolean status){

        listRoom.add(new Room(roomNumber, roomCategory, roomPrice, status));
        if(status){
            listRoomAvailable.add(new Room(roomNumber, roomCategory, roomPrice, status));
        }
    }

    public int getRoomNumberByIndex(int index){
        return listRoomAvailable.get(index-1).getRoomNumber();
    }

    public void updateRoom(int num, int roomNumber, String roomCategory, int roomPrice, boolean status){
        listRoom.get(num-1).roomNumber = roomNumber;
        listRoom.get(num-1).roomCategory = roomCategory;
        listRoom.get(num-1).roomPrice = roomPrice;
        listRoom.get(num-1).status = status;

        listRoomAvailable.forEach(x -> {
            if (x.getRoomNumber() == listRoom.get(num-1).roomNumber){
                x.setRoomNumber(roomNumber);
                x.setRoomCategory(roomCategory);
                x.setRoomPrice(roomPrice);
                x.setStatus(status);

                if (!x.status){
                    listRoomAvailable.remove(x);
                }
            }
        });
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

    public int getPriceByIndex(int index){
        return listRoomAvailable.get(index-1).getRoomPrice();
    }

}
