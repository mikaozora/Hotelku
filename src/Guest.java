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



    static List<Guest> guestHistory = new ArrayList<>();

    public void viewAll() {

        System.out.printf("==================================================================================================================%n");
        System.out.printf("|                                                   GUEST LISTS                                                  |%n");
        System.out.printf("==================================================================================================================%n%n");
        System.out.printf("==================================================================================================================%n");
        System.out.printf("| %-2s | %-14s | %-20s | %-20s | %-14s | %-4S | %-4s | %-11s |%n","NO","ID","NAME","ADDRESS","PHONE","ROOM","AGE","GENDER");
        System.out.printf("==================================================================================================================%n");


        AtomicInteger i = new AtomicInteger(1);
        guestsArr.forEach(cetak -> {
            System.out.printf("| %-2s | %-14s | %-20s | %-20s | %-14s | %-4S | %-4s | %-11s |%n",i,cetak.getGuestId(),cetak.getGuestName(),cetak.getGuestAddress(),cetak.getGuestPhone(),cetak.getGuestRoom(),cetak.getGuestAge(),cetak.getGuestGender());
            i.getAndIncrement();
        });
        System.out.printf("==================================================================================================================%n");

    }

    public void addGuest(String guestName, String guestAddress, String guestPhone, int guestRoom, int guestAge, String guestGender) {
        Guest temp = new Guest(guestName, guestAddress, guestPhone, guestRoom, guestAge, guestGender);
        guestsArr.add(temp);
        guestHistory.add(temp);
    }



    public void updateGuest(int index, String guestName, String guestAddress, String guestPhone, int guestRoom, int guestAge, String guestGender) {

        guestsArr.get(index - 1).setGuestName(guestName);
        guestsArr.get(index - 1).setGuestAddress(guestAddress);
        guestsArr.get(index - 1).setGuestPhone(guestPhone);
        guestsArr.get(index - 1).setGuestRoom(guestRoom);
        guestsArr.get(index - 1).setGuestAge(guestAge);
        guestsArr.get(index - 1).setGuestGender(guestGender);

        guestHistory.forEach(x -> {
            if (x.getGuestId().equals(guestsArr.get(index-1).getGuestId())){
                x.setGuestName(guestName);
                x.setGuestAddress(guestAddress);
                x.setGuestPhone(guestPhone);
                x.setGuestRoom(guestRoom);
                x.setGuestAge(guestAge);
                x.setGuestGender(guestGender);
            }
        });

    }

    public String indexGuest(){
//        System.out.println(guestId);
//        for(Guest guest : guestsArr){
//            if(guest.getGuestId().equals(guestId)){
//                return guestsArr.indexOf(guest);
//            }
//        }
//        return -1;
        int index = guestsArr.size()-1;
        return guestsArr.get(index).getGuestId();
    }

    public void deleteGuest(int index) {
        guestsArr.remove(index - 1);
    }


    public void init() {
        addGuest("abdhy","lampung", "4098408",22,23,"Laki");
    }


}
