import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Admin admin = new Admin(null, null, null, 0, null);
    static Employee employee = new Employee(null, null, null, null);
    static Receptionist receptionist = new Receptionist(null, null, null, null, null, 0);
    static Guest guest = new Guest(null, null, null, 0, 0, null);

    static void adminMenu() {
        int choose, phoneNum, index;
        String username, password, address, name;

        do {
            System.out.println("1. View admin");
            System.out.println("2. Add admin");
            System.out.println("3. Update admin");
            System.out.println("4. Delete admin");
            System.out.println("5. Exit");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    admin.viewAll();
                    break;
                case 2:
                    System.out.println("====Add Admin======");
                    System.out.print("Username: ");
                    username = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                    System.out.print("Name: ");
                    name = input.nextLine();
                    System.out.print("Phone number: ");
                    phoneNum = input.nextInt();
                    input.nextLine();
                    System.out.print("Address: ");
                    address = input.nextLine();
                    admin.addAdmin(username, password, name, phoneNum, address);
                    break;
                case 3:
                    admin.viewAll();
                    System.out.print("Choose data you want to change: ");
                    index = input.nextInt();
                    input.nextLine();
                    System.out.println("====Change Data Admin======");
                    System.out.print("Username: ");
                    username = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                    System.out.print("Name: ");
                    name = input.nextLine();
                    System.out.print("Phone number: ");
                    phoneNum = input.nextInt();
                    input.nextLine();
                    System.out.print("Address: ");
                    address = input.nextLine();
                    admin.updateAdmin(index, username, password, name, phoneNum, address);
                    break;
                case 4:
                    admin.viewAll();
                    System.out.print("Choose data you want to delete: ");
                    index = input.nextInt();
                    input.nextLine();
                    admin.deleteAdmin(index);
                    System.out.println("Successfully delete admin");
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }

    static void receptionistMenu() {
        int choose, index,age;
        String phoneNum, username, password, address, name;

        do {
            System.out.println("1. View Receptionist");
            System.out.println("2. Add Receptionist");
            System.out.println("3. Update Receptionist");
            System.out.println("4. Delete Receptionist");
            System.out.println("5. Exit");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    receptionist.viewAll();
                    break;
                case 2:
                    System.out.println("====Add Receptionist======");
                    System.out.print("Username: ");
                    username = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                    System.out.print("Name: ");
                    name = input.nextLine();
                    System.out.print("Phone number: ");
                    phoneNum = input.nextLine();
                    input.nextLine();
                    System.out.print("Address: ");
                    address = input.nextLine();
                    System.out.print("Age: ");
                    age = input.nextInt();
                    receptionist.addReceptionist(username, password, name, phoneNum, address, age);
                    break;
                case 3:
                    receptionist.viewAll();
                    System.out.print("Choose data you want to change: ");
                    index = input.nextInt();
                    input.nextLine();
                    System.out.println("====Change Data Receptionist======");
                    System.out.print("Username: ");
                    username = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                    System.out.print("Name: ");
                    name = input.nextLine();
                    System.out.print("Phone number: ");
                    phoneNum = input.nextLine();
                    System.out.print("Address: ");
                    address = input.nextLine();
                    System.out.print("Age: ");
                    age = input.nextInt();
                    receptionist.updateReceptionist(index, username, password, name, phoneNum, address,age);
                    break;
                case 4:
                    receptionist.viewAll();
                    System.out.print("Choose data you want to delete: ");
                    index = input.nextInt();
                    input.nextLine();
                    receptionist.deleteReceptionist(index);
                    System.out.println("Successfully delete admin");
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }

    static void employeeMenu() {
        int choose;
        do {
            System.out.println("1. View employee");
            System.out.println("2. Add employee");
            System.out.println("3. Update employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Exit");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    employee.viewAll();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }

    static void roomMenu() {
        int choose;
        do {
            System.out.println("1. View room");
            System.out.println("2. Add room");
            System.out.println("3. Update room");
            System.out.println("4. Delete room");
            System.out.println("5. Exit");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }

    static void bookingMenu(){

    }

    static void homeAdmin() {

        int choose;
        do {
            System.out.println("======Hotelku Admin=======");
            System.out.println("1. Receptionist");
            System.out.println("2. Employee");
            System.out.println("3. Rooms");
            System.out.println("4. Admin");
            System.out.println("5. Logout");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    receptionistMenu();
                    break;
                case 2:
                    employeeMenu();
                    break;
                case 3:
                    roomMenu();
                    break;
                case 4:
                    adminMenu();
                    break;
                default:
                    break;
            }
        } while (choose != 5);
        formLogin();

    }


    static void homeRec() {

        int choose;
        do {
            System.out.println("======Hotelku Receptionist=======");
            System.out.println("1. Add Booking");
            System.out.println("2. Check Room");
            System.out.println("3. Logout");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    bookingMenu();
                    break;
                case 2:
                    break;
            }
        } while (choose != 3);
        formLogin();

    }

    static int checkLogin() {
        return 1;
    }

    static void formLogin() {
        System.out.println("=========Login=========");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        boolean res = true;

        if (res) {
            homeAdmin();
        } else {
            homeRec();
        }

    }

    public static void main(String[] args) {
        admin.initAdmin();
        employee.init();
        receptionist.init();
        guest.init();
        formLogin();

    }
}