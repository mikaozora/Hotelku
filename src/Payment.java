import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Payment {
    String paymentId;
    String paymentMethod;
    int totalPayment;
    String paymentDate;
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

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean getPaymentStat() {
        return paymentStat;
    }

    public void setPaymentStat(Date paymentDate) {
        this.paymentStat = paymentStat;
    }

    public String isPaymentStat() {

        if (paymentStat) return "Paid";
        return "Unpaid";
    }

    public void setPaymentStat(boolean paymentStat) {
        this.paymentStat = paymentStat;
    }

    Payment(String paymentMethod, int totalPayment, String paymentDate, boolean paymentStat){
        this.setPaymentDate(paymentDate);
        this.paymentId = ""+(long)(Math.random() * 20000000000L);
        this.setPaymentStat(paymentStat);
        this.setTotalPayment(totalPayment);
        this.setPaymentMethod(paymentMethod);
    }

    List<Payment> paymentList = new ArrayList<>();

    void notaPayment(){
        int index = paymentList.size() - 1;
        System.out.println("=======================================");
        System.out.println("=============== HOTELKU ===============");
        System.out.println("=========== PAYMENT RESULT ===========");
        System.out.println("=======================================");
        System.out.printf("|    ID     :    %-21s|%n",paymentList.get(index).getPaymentId());
        System.out.printf("|    DATE   :    %-21s|%n",paymentList.get(index).getPaymentDate());
        System.out.printf("|    METHOD :    %-21s|%n",paymentList.get(index).getPaymentMethod());
        System.out.printf("|    TOTAL  :    %-21s|%n",paymentList.get(index).getTotalPayment());
        System.out.println("=======================================");
        System.out.println("=========== PAYMENT SUCCESS ==========");
        System.out.println("=======================================");
    }

    void viewPayment(){
        System.out.printf("=======================================================================================================%n");
        System.out.printf("|                                            PAYMENT LISTS                                            |%n");
        System.out.printf("=======================================================================================================%n%n");
        System.out.printf("=======================================================================================================%n");
        System.out.printf("| %-2s | %-14s | %-14s | %-20s | %-20s | %-14s |%n","NO","ID","DATE","METHOD","TOTAL","STATUS");
        System.out.printf("=======================================================================================================%n");


        AtomicInteger i = new AtomicInteger(1);
        paymentList.forEach(cetak -> {
            System.out.printf("| %-2s | %-14s | %-14s | %-20s | %-20s | %-14s |%n",i,cetak.getPaymentId(),cetak.getPaymentDate(),cetak.getPaymentMethod(),cetak.getTotalPayment(),cetak.getPaymentStat());
            i.getAndIncrement();
        });

        System.out.printf("=======================================================================================================%n");
    }

    void makePayment(String paymentMethod, int totalPayment, String paymentDate, boolean paymentStat){
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
