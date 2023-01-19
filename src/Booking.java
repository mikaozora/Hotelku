import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking {
    String bookId;
    String bookType;
    Date startDate;
    Date endDate;
    String bookDesc;
    String guestId;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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

    Booking(String bookType, Date startDate, Date endDate, String bookDesc, String guestId){
        this.bookId = ""+(long)(Math.random() * 20000000000L);
        this.setBookDesc(bookDesc);
        this.setGuestId(guestId);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setBookType(bookType);
    }

    List<Booking> bookList = new ArrayList<>();

    void checkIn(String bookType, Date startDate, Date endDate, String bookDesc, String guestId){
        bookList.add(new Booking(bookType, startDate, endDate, bookDesc, guestId));
    }

    void viewBook(){
        bookList.forEach(rooms -> {
            System.out.println("" + getStartDate() + " - " + getEndDate() + ", Booking ID: " + getBookId() + ", Booking Type: " + getBookType() + ", Guest's ID: " + getGuestId() + ", Booking Description: " + getBookDesc());
        });
    }

    void checkOut(int num){
        bookList.remove(num-1);
        System.out.println("Booking has been removed");
    }

    void updateBook(int num, String bookType, Date startDate, Date endDate, String bookDesc, String guestId){
        bookList.get(num-1).bookType = bookType;
        bookList.get(num-1).bookDesc = bookDesc;
        bookList.get(num-1).guestId = guestId;
        bookList.get(num-1).startDate = startDate;
        bookList.get(num-1).endDate = endDate;
    }
}
