import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Admin {
    String adminId;
    String username;
    String password;
    String adminName;
    int adminPhoneNum;
    String adminAddress;

    List<Admin> adminList = new ArrayList<>();

    Admin(String username, String password, String adminName, int adminPhoneNum, String adminAddress){
        this.adminId = "" + ((long)(Math.random() * (9999999999L - 1000000000L + 1)) + 1000000000L);
        this.setUsername(username);
        this.setPassword(password);
        this.setAdminName(adminName);
        this.setAdminPhoneNum(adminPhoneNum);
        this.setAdminAddress(adminAddress);
    }

    public void viewAll(){
        AtomicInteger i = new AtomicInteger(1);
        adminList.forEach(admin -> {

            System.out.print(i + ". ");
            System.out.println("Id: " + admin.getAdminId());
            System.out.println("Name: " + admin.getAdminName());
            System.out.println("Username: " + admin.getUsername());
            System.out.println("Phone Number: " + admin.getAdminPhoneNum());
            System.out.println("Address: " + admin.getAdminAddress());
            i.getAndIncrement();
        });
    }

    void addAdmin(String username, String password, String adminName, int adminPhoneNum, String adminAddress){
        adminList.add(new Admin(username, password, adminName, adminPhoneNum, adminAddress));
    }

    void updateAdmin(int index, String username, String password, String adminName, int adminPhoneNum, String adminAddress){
        adminList.get(index-1).setUsername(username);
        adminList.get(index-1).setPassword(password);
        adminList.get(index-1).setAdminName(adminName);
        adminList.get(index-1).setAdminPhoneNum(adminPhoneNum);
        adminList.get(index-1).setAdminAddress(adminAddress);
    }
    void deleteAdmin(int index){
        adminList.remove(index-1);
    }

    void initAdmin(){
        adminList.add(new Admin("admin", "admin", "admin1", 12345, "sentul"));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getAdminPhoneNum() {
        return adminPhoneNum;
    }

    public void setAdminPhoneNum(int adminPhoneNum) {
        this.adminPhoneNum = adminPhoneNum;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }
}
