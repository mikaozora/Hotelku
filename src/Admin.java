import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Admin {
    String adminId;
    String username;
    String password;
    String adminName;
    String adminPhoneNum;
    String adminAddress;

    List<Admin> adminList = new ArrayList<>();

    Admin(String username, String password, String adminName, String adminPhoneNum, String adminAddress) {
        this.adminId = "" + ((long) (Math.random() * (9999999999L - 1000000000L + 1)) + 1000000000L);
        this.setUsername(username);
        this.setPassword(password);
        this.setAdminName(adminName);
        this.setAdminPhoneNum(adminPhoneNum);
        this.setAdminAddress(adminAddress);
    }

    public void viewAll() {
        System.out.printf("=======================================================================================================%n");
        System.out.printf("|                                              ADMIN LISTS                                            |%n");
        System.out.printf("=======================================================================================================%n%n");
        System.out.printf("=======================================================================================================%n");
        System.out.printf("| %-2s | %-14s | %-20s | %-20s | %-14s | %-14s |%n", "NO", "ID", "NAME", "USERNAME", "PHONE", "ADDRESS");
        System.out.printf("=======================================================================================================%n");


        AtomicInteger i = new AtomicInteger(1);
        adminList.forEach(admin -> {
            System.out.printf("| %-2s | %-14s | %-20s | %-20s | %-14s | %-14s |%n", i, admin.getAdminId(), admin.getAdminName(), admin.getUsername(), admin.getAdminPhoneNum(), admin.getAdminAddress());
            i.getAndIncrement();
        });

        System.out.printf("=======================================================================================================%n");
    }

    void addAdmin(String username, String password, String adminName, String adminPhoneNum, String adminAddress) {
        adminList.add(new Admin(username, password, adminName, adminPhoneNum, adminAddress));
    }

    void updateAdmin(int index, String username, String password, String adminName, String adminPhoneNum, String adminAddress) {
        adminList.get(index).setUsername(username);
        adminList.get(index).setPassword(password);
        adminList.get(index).setAdminName(adminName);
        adminList.get(index).setAdminPhoneNum(adminPhoneNum);
        adminList.get(index).setAdminAddress(adminAddress);
    }

    void deleteAdmin(int index) {
        adminList.remove(index - 1);
    }

    void initAdmin() {
        adminList.add(new Admin("admin", "admin", "admin1", "12345", "sentul"));
    }

    int checkAdmin(String username, String password) {
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return adminList.indexOf(admin);
            }
        }
        return -1;
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

    public String getAdminPhoneNum() {
        return adminPhoneNum;
    }

    public void setAdminPhoneNum(String adminPhoneNum) {
        this.adminPhoneNum = adminPhoneNum;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public List<Admin> getListAdmin(){
        System.out.println(adminList);
        return adminList;
    }
    public boolean checkAdminUsername(String username){
        for(Admin admin : adminList){
            if(admin.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
