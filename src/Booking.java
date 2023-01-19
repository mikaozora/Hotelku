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

    void checkIn(String bookType, String startDate, String endDate, String bookDesc, String guestId){
        bookList.add(new Booking(bookType, startDate, endDate, bookDesc, guestId));
    }

    public void viewBook(){
        AtomicInteger i = new AtomicInteger(1);
        bookList.forEach(cetak -> {

            System.out.print(i + ". ");
            System.out.println("Booking Id : " + cetak.getBookId());
            System.out.println("Booking Type : " + cetak.getBookType());
            System.out.println("Booking Start Date : " + cetak.getStartDate());
            System.out.println("Booking End Date : " + cetak.getEndDate());
            System.out.println("Booking Description : " + cetak.getBookDesc());
            System.out.println("Guest Id : " + cetak.getGuestId());
            i.getAndIncrement();
        });
    }

    void checkOut(int num){
        bookList.remove(num-1);
        System.out.println("Booking has been removed");
    }

    void updateBook(int num, String bookType, String startDate, String endDate, String bookDesc, String guestId){
        bookList.get(num-1).bookType = bookType;
        bookList.get(num-1).bookDesc = bookDesc;
        bookList.get(num-1).guestId = guestId;
        bookList.get(num-1).startDate = startDate;
        bookList.get(num-1).endDate = endDate;
    }
}
