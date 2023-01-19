import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String empName;
    private String empId;
    private String empAddress;
    private String empPhone;
    private String empRole;

    public Employee(String empName, String empId, String empAddress, String empPhone, String empRole) {
        this.setempName(empName);
        this.empId ="" + (long) (Math.random() * 2000000000L);
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

    public void viewAll(){
        empArr.forEach(cetak->{
            System.out.println("Employee Id" + cetak.getempId()+"Employee Name"+cetak.getempName()+"Employee Address"+cetak.getempAddress()+"Employee Phone"+cetak.getempPhone()+"Employee Role"+cetak.getempRole());
        });
        System.out.println();
    }

    public void addEmployee(String empName, String empId, String empAddress, String empPhone, String empRole) {
        empArr.add(new Employee(empName, empAddress, empId, empPhone, empRole));
    }

    public void updateEmployee(int index,String empName,String empAddress, String empPhone, String empRole) {
        empArr.get(index-1).setempName(empName);
        empArr.get(index-1).setempAddress(empAddress);
        empArr.get(index-1).setempPhone(empPhone);
        empArr.get(index-1).setempRole(empRole);
    }

    public void deleteEmployee(int index){
        empArr.remove(index-1);
    }




}
