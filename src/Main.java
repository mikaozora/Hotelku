import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Admin admin = new Admin(null, null, null, 0, null);
    static Employee employee = new Employee(null, null, null, null);
    static Receptionist receptionist = new Receptionist(null, null, null, null, null, 0);
    static Guest guest = new Guest(null, null, null, 0, 0, null);
    static Room room = new Room(0, null, 0, false);
    static Booking book = new Booking(null,null,null,null, null);
    static Payment payment = new Payment(null, 0, null, false);

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
        String payMethod;
        int roomIndex, Age;

        String type,start,end,desc;

        System.out.println("====Add Guest======");
        System.out.print("Guest Name : ");
        name = input.nextLine();
        System.out.print("Guest Address : ");
        address = input.nextLine();
        System.out.print("Guest Phone : ");
        phone = input.nextLine();
        System.out.print("Choose Room number : ");
        roomIndex = input.nextInt();
        int roomNumber = room.getRoomNumberByIndex(roomIndex);
        System.out.println(roomNumber);
        System.out.print("Guest Age : ");
        Age = input.nextInt();
        input.nextLine();
        System.out.print("Guest Gender : ");
        gender = input.nextLine();
        guest.addGuest(name, address, phone, roomNumber, Age, gender);
        System.out.println();
        System.out.println("====Add Booking======");
        System.out.print("Booking Type : ");
        type = input.nextLine();
        System.out.print("Start Date (yyyy-mm-dd) : ");
        start = input.nextLine();
        System.out.print("End Date (yyyy-mm-dd) : ");
        end = input.nextLine();
        System.out.print("Booking Description : ");
        desc = input.nextLine();
        book.checkIn(type,start,end,desc,guest.indexGuest());

        room.listRoom.forEach(x -> {
            if (x.getRoomNumber() == roomNumber){
                x.setStatus(false);

                room.listRoomAvailable.forEach(y -> {
                    if (y.getRoomNumber() == x.getRoomNumber()){
                        room.listRoomAvailable.remove(y);
                    }
                });
            }
        });

        System.out.println("====Add Payment======");
        System.out.print("Payment Method: ");
        payMethod = input.nextLine();

        LocalDate date1 = LocalDate.parse(book.getStartDateByIndex(), DateTimeFormatter.ISO_DATE);
        LocalDate date2 = LocalDate.parse(book.getEndDateByIndex(), DateTimeFormatter.ISO_DATE);

        long count = ChronoUnit.DAYS.between(date1,date2);
        System.out.println(count);
        int total = (int) count * room.getPriceByIndex(roomIndex);
        System.out.println(total);
        payment.makePayment(payMethod, total, null, true);
        payment.viewPayment();
    }
    static void removeBooking(){
        guest.viewAll();
        System.out.println("==============================================");
        System.out.println("Choose Guest you want to check out");
        System.out.print(">> ");
        int guestOut = input.nextInt();
        room.listRoom.forEach(z -> {
            if (z.getRoomNumber() == guest.guestsArr.get(guestOut-1).getGuestRoom()){
                z.setStatus(true);
                room.listRoomAvailable.add(z);
            }
        });
        guest.deleteGuest(guestOut);
        book.checkOut(guestOut);
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
            System.out.println("2. Remove Booking");
            System.out.println("3. Check Room");
            System.out.println("4. Check Booking");
            System.out.println("5. Check Guest");
            System.out.println("6. Logout");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    bookingMenu();
                    break;
                case 2:
                    removeBooking();
                    break;
                case 3:
                    room.viewRoom();
                    break;
                case 4:
                    int chooseBook;
                    System.out.println("========Check Booking========");
                    System.out.println("1. Check Current Booking");
                    System.out.println("2. Check Booking History");
                    System.out.println("3. Update Booking");
                    System.out.println("4. Back");
                    System.out.print(">> ");
                    chooseBook = input.nextInt();
                    input.nextLine();

                    if (chooseBook == 1) {
                        if (book.bookList.size() < 1){
                            System.out.println();
                            System.out.println("There's no booking currently");
                            System.out.println("Press Enter to continue.....");
                            input.nextLine();
                            System.out.println();
                            continue;
                        }
                        book.viewBook();
                    }
                    else if(chooseBook == 2){
                        if (book.bookHistory.size() < 1){
                            System.out.println();
                            System.out.println("There's no booking history");
                            System.out.println("Press Enter to continue.....");
                            input.nextLine();
                            System.out.println();
                            continue;
                        }
                        book.bookHistory();
                    }
                    else if (chooseBook == 3){
                        String type, start, end, desc;
                        int chooseBookUpdate;
                        System.out.println("Choose Data you want to update");
                        System.out.print(">>");
                        chooseBookUpdate = input.nextInt();
                        input.nextLine();
                        System.out.println("====Update Booking======");
                        System.out.print("Booking Type : ");
                        type = input.nextLine();
                        System.out.print("Start Date (yyyy-mm-dd) : ");
                        start = input.nextLine();
                        System.out.print("End Date (yyyy-mm-dd) : ");
                        end = input.nextLine();
                        System.out.print("Booking Description : ");
                        desc = input.nextLine();
                        book.updateBook(chooseBookUpdate,type,start,end,desc);
                        System.out.println();
                    }else if (chooseBook == 4){
                        continue;
                    }
                    break;
                case 5:
                    int updt;
                    guest.viewAll();
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println("1. Update Guest");
                    System.out.println("2. Back");
                    System.out.println(">> ");
                    updt = input.nextInt();

                    if (updt == 1){
                        String name, address, phone, gender;
                        int roomNumber, Age, inp;
                        System.out.println("====Update Guest======");
                        System.out.print("Choose data you want to update: ");
                        inp = input.nextInt();
                        input.nextLine();
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
                        guest.updateGuest(inp, name, address, phone, roomNumber, Age, gender);
                        System.out.println();

                    }else {
                        continue;
                    }
                    break;
            }
        } while (choose != 6);
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

    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    static void font(){

        setTimeout(() -> System.out.println(" ██╗  ██╗ ██████╗ ████████╗███████╗██╗     ██╗  ██╗██╗   ██╗"), 1000);
        setTimeout(() -> System.out.println(" ██║  ██║██╔═══██╗╚══██╔══╝██╔════╝██║     ██║ ██╔╝██║   ██║"), 1300);
        setTimeout(() -> System.out.println(" ███████║██║   ██║   ██║   █████╗  ██║     █████╔╝ ██║   ██║"), 1500);
        setTimeout(() -> System.out.println(" ██╔══██║██║   ██║   ██║   ██╔══╝  ██║     ██╔═██╗ ██║   ██║"), 1700);
        setTimeout(() -> System.out.println(" ██║  ██║╚██████╔╝   ██║   ███████╗███████╗██║  ██╗╚██████╔╝"), 1900);
        setTimeout(() -> System.out.println(" ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚══════╝╚══════╝╚═╝  ╚═╝ ╚═════╝"), 2100);

    }

    static void formLogin(){
        font();

//        setTimeout(() -> {
//            for (int i = 0; i < 50; ++i) System.out.println();
//        }, 2800);

        setTimeout(() -> {
            System.out.println();
        }, 2500);


        setTimeout(() -> System.out.println("===================================== Login ==============================================="), 3000);
        setTimeout(() -> System.out.print("Username: "), 3100);
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