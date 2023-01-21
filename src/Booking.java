import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Booking {
    String bookId;
    String bookType;
    String startDate;
    String endDate;
    String bookDesc;
    String guestId;

    static Guest idGuest = new Guest(null,null,null,0,0,null);

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String  getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {

        this.guestId = guestId;
    }

    Booking(String bookType, String startDate, String endDate, String bookDesc, String guestId){
        this.bookId = ""+(long)(Math.random() * 20000000000L);
        this.setBookDesc(bookDesc);
        this.setGuestId(guestId);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setBookType(bookType);
    }

    List<Booking> bookList = new ArrayList<>();
    List<Booking> bookHistory = new ArrayList<>();



    void checkIn(String bookType, String startDate, String endDate, String bookDesc, String guestId){
        bookList.add(new Booking(bookType, startDate, endDate, bookDesc, guestId));
        bookHistory.add(new Booking(bookType, startDate, endDate, bookDesc, guestId));
    }

    public void viewBook(){

        System.out.printf("==================================================================================================================%n");
        System.out.printf("|                                                  BOOKING LISTS                                                 |%n");
        System.out.printf("==================================================================================================================%n%n");
        System.out.printf("==================================================================================================================%n");
        System.out.printf("| %-2s | %-15s | %-14s | %-14s | %-12s | %-19s | %-15s  |%n","NO","ID","TYPE","START DATE","END DATE","DESCRIPTION","ID GUEST");
        System.out.printf("==================================================================================================================%n");


        AtomicInteger i = new AtomicInteger(1);
        bookList.forEach(cetak -> {
            System.out.printf("| %-2s | %-15s | %-14s | %-14s | %-12s | %-19s | %-15s  |%n",i,cetak.getBookId(),cetak.getBookType(),cetak.getStartDate(),cetak.getEndDate(),cetak.getBookDesc(),cetak.getGuestId());
            i.getAndIncrement();
        });

        System.out.printf("==================================================================================================================%n");

    }

    void checkOut(int num){
        bookList.remove(num-1);
        System.out.println("Booking has been removed");
    }

    void bookHistory(){
        AtomicInteger i = new AtomicInteger(1);
        bookHistory.forEach(x -> {
            System.out.print(i + ". ");
            System.out.println("Booking Start Date : " + x.getStartDate());
            System.out.println("   Booking End Date : " + x.getEndDate());
            System.out.println("   Booking Id : " + x.getBookId());
            System.out.println("   Booking Type : " + x.getBookType());
            System.out.println("   Booking Description : " + x.getBookDesc());
            System.out.println("   Guest Id : " + x.getGuestId());
            System.out.println();

            Main.guest.guestHistory.forEach(y -> {

                if (y.getGuestId().equals(x.getGuestId())){
                    System.out.println("   Id: " + y.getGuestId());
                    System.out.println("   Name: " + y.getGuestName());
                    System.out.println("   Address: " + y.getGuestAddress());
                    System.out.println("   Phone Number: " + y.getGuestPhone());
                    System.out.println("   Room Number: " + y.getGuestRoom());
                    System.out.println("   Age: " + y.getGuestAge());
                    System.out.println("   Gender: " + y.getGuestGender());
                    System.out.println();
                }
            });
            i.getAndIncrement();
        });
    }

    void updateBook(int num, String bookType, String startDate, String endDate, String bookDesc, String guestId){
        bookList.get(num-1).bookType = bookType;
        bookList.get(num-1).bookDesc = bookDesc;
        bookList.get(num-1).guestId = guestId;
        bookList.get(num-1).startDate = startDate;
        bookList.get(num-1).endDate = endDate;

        bookHistory.get(num-1).bookType = bookType;
        bookHistory.get(num-1).bookDesc = bookDesc;
        bookHistory.get(num-1).guestId = guestId;
        bookHistory.get(num-1).startDate = startDate;
        bookHistory.get(num-1).endDate = endDate;
    }

    public int sizeList(){
        return bookList.size();
    }
    public String testSize(){
        System.out.println(bookList.size());
        int index = bookList.size()-1;
        return bookList.get(index).getStartDate();
    }

    public String getStartDateByIndex(){
        int index = bookList.size()-1;
        return bookList.get(index).getStartDate();
    }
    public String getEndDateByIndex(){
        int index = bookList.size()-1;
        return bookList.get(index).getEndDate();
    }
}
