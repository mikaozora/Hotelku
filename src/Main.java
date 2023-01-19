import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Admin admin = new Admin(null, null, null, 0, null);
    static Employee employee = new Employee(null, null, null, null);
    static Receptionist receptionist = new Receptionist(null, null, null, null, null, 0);
    static Guest guest = new Guest(null, null, null, 0, 0, null);
    static Room room = new Room(0, null, 0, false);
    static Booking book = new Booking(null,null,null,null, null);

    static int indexLogin = -1;

    static void addAdmin(){
        int phoneNum;
        String username, password, address, name;
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
    }
    static void updateAdmin(){
        int phoneNum;
        String username, password, address, name;
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
        admin.updateAdmin(indexLogin, username, password, name, phoneNum, address);
    }
    static void deleteAdmin(){
        int index;
        admin.viewAll();
        System.out.print("Choose data you want to delete: ");
        index = input.nextInt();
        input.nextLine();
        if (index - 1 == indexLogin) {
            admin.deleteAdmin(index);
            System.out.println("Successfully delete admin");
            indexLogin = -1;
            formLogin();

        } else {
            admin.deleteAdmin(index);
            System.out.println("Successfully delete admin");
        }
    }
    static void adminMenu(){
        int choose;

        do {
            System.out.println("1. View admin");
            System.out.println("2. Add admin");
            System.out.println("3. Change data");
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
                    addAdmin();
                    break;
                case 3:
                    updateAdmin();
                    break;
                case 4:
                    deleteAdmin();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }

    static void addEmployee(){
        String name, phoneNum, address, role;
        System.out.println("====Add Employee======");
        //Input Name
        System.out.print("Name: ");
        name = input.nextLine();
        //Input Role
        System.out.println("Role: ");
        role = input.nextLine();
        //Input Phone Number
        System.out.print("Phone number: ");
        phoneNum = input.nextLine();
        //Input Address
        System.out.print("Address: ");
        address = input.nextLine();

        employee.addEmployee(name, address, phoneNum, role);

        System.out.println("Employee's data has successfully added");
    }
    static void updateEmployee(){
        String name, phoneNum, address, role;
        int index;
        employee.viewAll();
        System.out.println("Choose data you want to change");
        index = input.nextInt();
        input.nextLine();
        System.out.println("====Change Data Employee======");
        //Update Name
        System.out.print("Name: ");
        name = input.nextLine();
        //Update Role
        System.out.println("Role: ");
        role = input.nextLine();
        //Update Phone Number
        System.out.print("Phone number: ");
        phoneNum = input.nextLine();
        //Update Address
        System.out.print("Address: ");
        address = input.nextLine();

        employee.updateEmployee(index, name, address, phoneNum, role);
        System.out.println("Employee Has Been Updated!");
    }
    static void deleteEmployee(){
        int index;
        employee.viewAll();
        System.out.println("====Delete Data Employee======");
        //Input data employee to delete
        System.out.print("Choose data you want to delete: ");
        index = input.nextInt();
        input.nextLine();
        employee.deleteEmployee(index);
        System.out.println("Successfully delete employee");
    }
    static void employeeMenu() {
        String name, phoneNum, address, role;
        int choose, index;
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
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while(choose != 5);
    }

    static void addReceptionist(){
        int age;
        String phoneNum, username, password, address, name;
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
    }
    static void updateReceptionist(){
        int age, index;
        String phoneNum, username, password, address, name;
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
        receptionist.updateReceptionist(index, username, password, name, phoneNum, address, age);
    }
    static void deleteReceptionist(){
        int index;
        receptionist.viewAll();
        System.out.print("Choose data you want to delete: ");
        index = input.nextInt();
        input.nextLine();
        receptionist.deleteReceptionist(index);
        System.out.println("Successfully delete admin");
    }
    static void receptionistMenu() {
        int choose;

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
                    addReceptionist();
                    break;
                case 3:
                    updateReceptionist();
                    break;
                case 4:
                    deleteReceptionist();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }

    static void addRoom(){
        String roomCategory;
        int roomNumber, roomPrice;
        boolean roomStatus;
        System.out.println("====Add Room======");
        System.out.print("Room Number: ");
        roomNumber = input.nextInt();
        input.nextLine();
        System.out.print("Room Category: ");
        roomCategory = input.nextLine();
        System.out.print("Room Price: ");
        roomPrice = input.nextInt();
        input.nextLine();
        System.out.print("Room Status: ");
        roomStatus = input.nextBoolean();
        room.addRoom(roomNumber, roomCategory, roomPrice, roomStatus);
        System.out.println("Room has successfully added!");
    }
    static void updateRoom(){
        String roomCategory;
        int roomNumber, roomPrice, index;
        boolean roomStatus;
        room.viewRoom();
        System.out.print("Choose data you want to change: ");
        index = input.nextInt();
        input.nextLine();
        System.out.println("====Change Room's data======");
        System.out.print("Room Number: ");
        roomNumber = input.nextInt();
        input.nextLine();
        System.out.print("Room Category: ");
        roomCategory = input.nextLine();
        System.out.print("Room Price: ");
        roomPrice = input.nextInt();
        input.nextLine();
        System.out.print("Room Status: ");
        roomStatus = input.nextBoolean();
        room.updateRoom(index, roomNumber, roomCategory, roomPrice, roomStatus);
    }
    static void deleteRoom(){
        int index;
        room.viewRoom();
        System.out.print("Choose data you want to delete: ");
        index = input.nextInt();
        input.nextLine();
        room.deleteRoom(index);
        System.out.println("Successfully delete room");
    }
    static void roomMenu(){
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
            switch (choose){
                case 1:
                    Room.viewRoom();
                    break;
                case 2:
                    addRoom();
                    break;
                case 3:
                    updateRoom();
                    break;
                case 4:
                    deleteRoom();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }


    static void bookingMenu() {
        room.viewAvailableRoom();

        String name, address, phone, gender;
        int roomNumber, Age;

        String type,start,end,desc;

        System.out.println("====Add Guest======");
        System.out.print("Guest Name : ");
        name = input.nextLine();
        System.out.print("Guest Address : ");
        address = input.nextLine();
        System.out.print("Guest Phone : ");
        phone = input.nextLine();
        System.out.print("Guest Room Number : ");
        roomNumber = input.nextInt();
        System.out.print("Guest Age : ");
        Age = input.nextInt();
        input.nextLine();
        System.out.print("Guest Gender : ");
        gender = input.nextLine();
        guest.addGuest(name, address, phone, roomNumber, Age, gender);
        System.out.println(guest.indexGuest());
        System.out.println("====Add Booking======");
        System.out.print("Boking Type : ");
        type = input.nextLine();
        System.out.print("Start Date (dd/mm/yy) : ");
        start = input.nextLine();
        System.out.print("End Date (dd/mm/yy) : ");
        end = input.nextLine();
        System.out.print("Booking Description : ");
        desc = input.nextLine();
        book.checkIn(type,start,end,desc,guest.indexGuest());




    }

    static void homeAdmin() {

        int choose;
        if (indexLogin != -1) {
            do {
                System.out.println("======Hotelku=======");
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
        } else {
            formLogin();
        }


    }

    static void homeRec() {

        int choose;
        do {
            System.out.println("======Hotelku Receptionist=======");
            System.out.println("1. Add Booking");
            System.out.println("2. Check Room");
            System.out.println("3. Check Booking");
            System.out.println("4. Check Guest");
            System.out.println("5. Logout");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    bookingMenu();
                    break;
                case 2:
                    room.viewRoom();
                    break;
                case 3:
                    book.viewBook();
                    break;
                case 4:
                    guest.viewAll();
                    break;
            }
        } while (choose != 5);
        formLogin();

    }

    static int checkLogin(String username, String password) {
        if (admin.checkAdmin(username, password) != -1) {
            indexLogin = admin.checkAdmin(username, password);
            return 1;
        } else if (receptionist.checkRec(username, password)) {
            return 2;
        } else {
            return 0;
        }
    }

    static void formLogin(){
        System.out.println("=========Login=========");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        int res = checkLogin(username, password);
        if(res == 1){
            homeAdmin();
        }else if(res == 2){
            homeRec();
        } else {
            System.out.println("wrong username or password");
        }

    }

    public static void main(String[] args) {
        room.roomInit();
        admin.initAdmin();
        employee.init();
        receptionist.init();
        guest.init();
        formLogin();



    }
}