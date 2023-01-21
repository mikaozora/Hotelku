import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Payment {
    String paymentId;
    String paymentMethod;
    int totalPayment;
    Date paymentDate = new Date();
    boolean paymentStat;

    static Booking date = new Booking(null,null,null,null,null);

    static Room room = new Room(0,null,0,false);

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String isPaymentStat() {

        if (paymentStat) return "Paid";
        return "Unpaid";
    }

    public void setPaymentStat(boolean paymentStat) {
        this.paymentStat = paymentStat;
    }

    Payment(String paymentMethod, int totalPayment, Date paymentDate, boolean paymentStat){
        this.setPaymentDate(paymentDate);
        this.paymentId = ""+(long)(Math.random() * 20000000000L);
        this.setPaymentStat(paymentStat);
        this.setTotalPayment(totalPayment);
        this.setPaymentMethod(paymentMethod);
    }

    List<Payment> paymentList = new ArrayList<>();

    void viewPayment(){
        paymentList.forEach(payment -> {
            System.out.println("Payment Date: " + payment.getPaymentDate() + ", Payment ID: " + payment.getPaymentId() + ", Payment Method: " + payment.getPaymentMethod() + ", Total Payment: " + payment.getTotalPayment() + "Payment Status: " + payment.isPaymentStat());
        });
    }

    void makePayment(String paymentMethod, int totalPayment, Date paymentDate, boolean paymentStat){
        paymentList.add(new Payment(paymentMethod, totalPayment, paymentDate, paymentStat));
    }

    public long countDate(){
        System.out.println(date.getStartDateByIndex());
        LocalDate date1 = LocalDate.parse(date.getStartDateByIndex(), DateTimeFormatter.ISO_DATE);
        LocalDate date2 = LocalDate.parse(date.getEndDateByIndex(), DateTimeFormatter.ISO_DATE);

        long count = ChronoUnit.DAYS.between(date1,date2);
        System.out.println(count);
        return count;
    }
}
