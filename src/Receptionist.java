import java.util.ArrayList;
import java.util.List;

public class Receptionist {
    private String recId;
    private String recName;
    private String recUsername;
    private String recPassword;
    private String recAddress;
    private String recPhone;
    private int recAge;

    Receptionist(String recId, String recName, String recUsername, String recPassword, String recAddress, String recPhone, int recAge) {
        this.recId = "" + (long) (Math.random() * 2000000000L);
        this.setRecName(recName);
        this.setRecUsername(recUsername);
        this.setRecPassword(recPassword);
        this.setRecPassword(recPassword);
        this.setRecAddress(recAddress);
        this.setRecPhone(recPhone);
        this.setRecAge(recAge);
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getRecUsername() {
        return recUsername;
    }

    public void setRecUsername(String recUsername) {
        this.recUsername = recUsername;
    }

    public String getRecPassword() {
        return recPassword;
    }

    public void setRecPassword(String recPassword) {
        this.recPassword = recPassword;
    }

    public String getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(String recAddress) {
        this.recAddress = recAddress;
    }

    public String getRecPhone() {
        return recPhone;
    }

    public void setRecPhone(String recPhone) {
        this.recPhone = recPhone;
    }

    public int getRecAge() {
        return recAge;
    }

    public void setRecAge(int recAge) {
        this.recAge = recAge;
    }

    List<Receptionist> rcpArr = new ArrayList<>();

    public void addReceptionist(String recId, String recName, String recUsername, String recPassword, String recAddress, String recPhone, int recAge){
        rcpArr.add(new Receptionist(recId,recName,recUsername,recPassword,recAddress,recPhone,recAge));
    }

    public void updateReceptionist(int index, String recName, String recUsername, String recPassword, String recAddress, String recPhone, int recAge){
        rcpArr.get(index-1).setRecName(recName);
        rcpArr.get(index-1).setRecUsername(recUsername);
        rcpArr.get(index-1).setRecPassword(recPassword);
        rcpArr.get(index-1).setRecAddress(recAddress);
        rcpArr.get(index-1).setRecPhone(recPhone);
        rcpArr.get(index-1).setRecAge(recAge);
    }

    public void deleteReceptionist(int index){
        rcpArr.remove(index-1);
    }

    public void viewAll(String recId, String recName, String recUsername, String recPassword, String recAddress, String recPhone, int recAge) {
        rcpArr.forEach(cetak -> {
            System.out.println("Receptionist Id" + recId +"Receptionist Name" +recName +"Receptionist Username" + recUsername + "Receptionist Password" + recPassword
                    + "Receptionist Address" + recAddress + "Receptionist Phone" + recPhone + "Receptionist Age" + recAge);
        });
    }

}
