import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Guest {
    private String guestName;
    private String guestAddress;
    private String guestId;
    private String guestPhone;
    private int guestRoom;
    private int guestAge;
    private String guestGender;

    Guest(String guestName, String guestAddress, String guestPhone, int guestRoom, int guestAge, String guestGender) {
        this.setGuestName(guestName);
        this.setGuestAddress(guestAddress);
        this.guestId = "" + ((long)(Math.random() * (9999999999L - 1000000000L + 1)) + 1000000000L);
        this.setGuestPhone(guestPhone);
        this.setGuestRoom(guestRoom);
        this.setGuestAge(guestAge);
        this.setGuestGender(guestGender);
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public int getGuestRoom() {
        return guestRoom;
    }

    public void setGuestRoom(int guestRoom) {
        this.guestRoom = guestRoom;
    }

    public int getGuestAge() {
        return guestAge;
    }

    public void setGuestAge(int guestAge) {
        this.guestAge = guestAge;
    }

    public String getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(String guestGender) {
        this.guestGender = guestGender;
    }

    List<Guest> guestsArr = new ArrayList<>();

    public void viewAll() {
        AtomicInteger i = new AtomicInteger(1);
        guestsArr.forEach(cetak -> {

            System.out.print(i + ". ");
            System.out.println("Id: " + cetak.getGuestId());
            System.out.println("Name: " + cetak.getGuestName());
            System.out.println("Addres: " + cetak.getGuestAddress());
            System.out.println("Phone Number: " + cetak.getGuestPhone());
            System.out.println("Room Number: " + cetak.getGuestRoom());
            System.out.println("Age: " + cetak.getGuestAge());
            System.out.println("Gender: " + cetak.getGuestGender());
            i.getAndIncrement();
        });
    }

    public void addGuest(String guestName, String guestAddress, String guestPhone, int guestRoom, int guestAge, String guestGender) {
        guestsArr.add(new Guest(guestName, guestAddress, guestPhone, guestRoom, guestAge, guestGender));
    }

    public void updateGuest(int index, String guestName, String guestAddress, String guestId, String guestPhone, int guestRoom, int guestAge, String guestGender) {

        guestsArr.get(index - 1).setGuestId(guestId);
        guestsArr.get(index - 1).setGuestName(guestName);
        guestsArr.get(index - 1).setGuestAddress(guestAddress);
        guestsArr.get(index - 1).setGuestPhone(guestPhone);
        guestsArr.get(index - 1).setGuestRoom(guestRoom);
        guestsArr.get(index - 1).setGuestAge(guestAge);
        guestsArr.get(index - 1).setGuestGender(guestGender);
    }

    public void deleteGuest(int index) {
        guestsArr.remove(index - 1);
    }

    public void init() {
        addGuest("abdhy","lampung", "4098408",22,23,"Laki");
    }


}
