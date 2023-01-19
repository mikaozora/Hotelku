import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Payment {
    String paymentId;
    String paymentMethod;
    int totalPayment;
    Date paymentDate = new Date();
    boolean paymentStat;

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
        paymentList.forEach(rooms -> {
            System.out.println("Payment Date: " + getPaymentDate() + ", Payment ID: " + getPaymentId() + ", Payment Method: " + getPaymentMethod() + ", Total Payment: " + getTotalPayment() + "Payment Status: " + isPaymentStat());
        });
    }

    void makePayment(String paymentMethod, int totalPayment, Date paymentDate, boolean paymentStat){
        paymentList.add(new Payment(paymentMethod, totalPayment, paymentDate, paymentStat));
    }
}
