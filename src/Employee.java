import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private String empName;
    private String empId;
    private String empAddress;
    private String empPhone;
    private String empRole;

    public Employee(String empName, String empAddress, String empPhone, String empRole) {
        this.setempName(empName);
        this.empId = "" + (long) (Math.random() * 2000000000L);
        this.setempAddress(empAddress);
        this.setempPhone(empPhone);
        this.setempRole(empRole);
    }

    public String getempName() {
        return empName;
    }

    public void setempName(String empName) {
        this.empName = empName;
    }

    public String getempId() {
        return empId;
    }

    public void setempId() {
        this.empId = empId;
    }

    public String getempAddress() {
        return empAddress;
    }

    public void setempAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getempPhone() {
        return empPhone;
    }

    public void setempPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getempRole() {
        return empRole;
    }

    public void setempRole(String empRole) {
        this.empRole = empRole;
    }

    List<Employee> empArr = new ArrayList<>();

    public void viewAll() {
        AtomicInteger i = new AtomicInteger(1);
        empArr.forEach(cetak -> {

            System.out.print(i + ". ");
            System.out.println("Id: " + cetak.getempId());
            System.out.println("Name: " + cetak.getempName());
            System.out.println("Addres: " + cetak.getempAddress());
            System.out.println("Phone Number: " + cetak.getempPhone());
            System.out.println("Role: " + cetak.getempRole());
            i.getAndIncrement();
        });
    }

    public void addEmployee(String empName, String empAddress, String empPhone, String empRole) {
        empArr.add(new Employee(empName, empAddress, empPhone, empRole));
    }

    public void updateEmployee(int index, String empName, String empAddress, String empPhone, String empRole) {
        empArr.get(index - 1).setempName(empName);
        empArr.get(index - 1).setempAddress(empAddress);
        empArr.get(index - 1).setempPhone(empPhone);
        empArr.get(index - 1).setempRole(empRole);
    }

    public void deleteEmployee(int index) {
        empArr.remove(index - 1);
    }

    public void init(){
        addEmployee("julll","jakarta","008944","OB");
    }


}
