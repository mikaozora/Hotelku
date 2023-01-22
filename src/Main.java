import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Admin admin = new Admin(null, null, null, null, null);
    static Employee employee = new Employee(null, null, null, null);
    static Receptionist receptionist = new Receptionist(null, null, null, null, null, 0);
    static Guest guest = new Guest(null, null, null, 0, 0, null);
    static Room room = new Room(0, null, 0, false);
    static Booking book = new Booking(null, null, null, null, null);
    static Payment payment = new Payment(null, 0, null, false);

    static int indexLogin = -1;

    static void addAdmin() {
        String phoneNum = null;
        String username = null, password = null, address = null, name = null;
        boolean checkAdmin = false, checkRec = false;
        System.out.println("====Add Admin======");
        do {
            try {
                System.out.print("Username: ");
                username = input.nextLine();
                checkAdmin = admin.checkAdminUsername(username);
                checkRec = receptionist.checkUsernameRec(username);
                if (checkAdmin || checkRec) {
                    System.out.println("Username Already Exist!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (checkAdmin || checkRec);
        do {
            try {
                System.out.print("Password: ");
                password = input.nextLine();
                if (password.length() < 8) {
                    System.out.println("Password length must be more than or equal 8");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (password.length() < 8);
        do {
            try {
                System.out.print("Name: ");
                name = input.nextLine();
                if (Helper.checkDigit(name)) {
                    System.out.println("Name can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(name));
        do {
            try {
                System.out.print("Phone number: ");
                phoneNum = input.nextLine();
                if (!Helper.checkPhoneNumber(phoneNum)) {
                    System.out.println("Phone Number must be a 12 digit number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkPhoneNumber(phoneNum));
        do {
            try {
                System.out.print("Address: ");
                address = input.nextLine();
                if (address.length() < 5 || address.length() > 256) {
                    System.out.println("Address length between 5 to 256");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (address.length() < 5 || address.length() > 256);

        admin.addAdmin(username, password, name, phoneNum, address);
    }

    static void updateAdmin() {
        String phoneNum = null;
        String username = null, password = null, address = null, name = null;
        boolean checkAdmin = false, checkRec = false;
        System.out.println("====Change Data Admin======");
        do {
            try {
                System.out.print("Username: ");
                username = input.nextLine();
                checkAdmin = admin.checkAdminUsername(username);
                checkRec = receptionist.checkUsernameRec(username);
                if (checkAdmin || checkRec) {
                    System.out.println("Username Already Exist!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (checkAdmin || checkRec);
        do {
            try {
                System.out.print("Password: ");
                password = input.nextLine();
                if (password.length() < 8) {
                    System.out.println("Password length must be more than or equal 8");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (password.length() < 8);
        do {
            try {
                System.out.print("Name: ");
                name = input.nextLine();
                if (Helper.checkDigit(name)) {
                    System.out.println("Name can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(name));
        do {
            try {
                System.out.print("Phone number: ");
                phoneNum = input.nextLine();
                if (!Helper.checkPhoneNumber(phoneNum)) {
                    System.out.println("Phone Number must be a 12 digit number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkPhoneNumber(phoneNum));
        do {
            try {
                System.out.print("Address: ");
                address = input.nextLine();
                if (address.length() < 5 || address.length() > 256) {
                    System.out.println("Address length between 5 to 256");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (address.length() <= 5 || address.length() >= 256);
        admin.updateAdmin(indexLogin, username, password, name, phoneNum, address);
    }

    static void deleteAdmin() {
        int index = 0;
        String badInput = null;
        admin.viewAll();
        do {
            try {
                System.out.print("Choose data you want to delete: ");
                index = input.nextInt();
                input.nextLine();
                if (!Helper.checkChoose(index, admin.adminList.size())) {
                    System.out.printf("Please input number between %d to %d\n", 1, admin.adminList.size());
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }

        } while (!Helper.checkChoose(index, admin.adminList.size()) || badInput != null);

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

    static void adminMenu() {
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

    static void addEmployee() {
        String name = null, phoneNum = null, address = null, role = null;
        System.out.println("====Add Employee======");
        //Input Name
        do {
            try {
                System.out.print("Name: ");
                name = input.nextLine();
                if (Helper.checkDigit(name)) {
                    System.out.println("Name can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(name));

        //Input Role
        do {
            try {
                System.out.print("Role: ");
                role = input.nextLine();
                if (Helper.checkDigit(role)) {
                    System.out.println("Role can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(role));

        //Input Phone Number
        do {
            try {
                System.out.print("Phone number: ");
                phoneNum = input.nextLine();
                if (!Helper.checkPhoneNumber(phoneNum)) {
                    System.out.println("Phone Number must be a 12 digit number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkPhoneNumber(phoneNum));

        //Input Address
        do {
            try {
                System.out.print("Address: ");
                address = input.nextLine();
                if (address.length() < 5 || address.length() > 256) {
                    System.out.println("Address length between 5 to 256");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (address.length() < 5 || address.length() > 256);

        employee.addEmployee(name, address, phoneNum, role);

        System.out.println("Employee's data has successfully added");
    }

    static void updateEmployee() {
        if (employee.empArr.size() < 1){
            System.out.println("There are no Employees currently");
            System.out.print("Press Enter to Continue.....");
            input.nextLine();
            System.out.println();
            return;
        }
        String name = null, phoneNum = null, address = null, role = null, badInput = null;
        int index = 0;
        employee.viewAll();
        do {
            try {
                System.out.print("Choose data you want to change: ");
                index = input.nextInt();
                input.nextLine();
                if (!Helper.checkChoose(index, employee.empArr.size())) {
                    System.out.printf("Please input number between %d to %d\n", 1, employee.empArr.size());
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }

        } while (!Helper.checkChoose(index, employee.empArr.size()) || badInput != null);
        System.out.println("====Change Data Employee======");
        //Update Name
        do {
            try {
                System.out.print("Name: ");
                name = input.nextLine();
                if (Helper.checkDigit(name)) {
                    System.out.println("Name can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(name));

        //update Role
        do {
            try {
                System.out.print("Role: ");
                role = input.nextLine();
                if (Helper.checkDigit(role)) {
                    System.out.println("Role can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(role));

        //Update Phone Number
        do {
            try {
                System.out.print("Phone number: ");
                phoneNum = input.nextLine();
                if (!Helper.checkPhoneNumber(phoneNum)) {
                    System.out.println("Phone Number must be a 12 digit number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkPhoneNumber(phoneNum));

        //Update Address
        do {
            try {
                System.out.print("Address: ");
                address = input.nextLine();
                if (address.length() < 5 || address.length() > 256) {
                    System.out.println("Address length between 5 to 256");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (address.length() < 5 || address.length() > 256);

        employee.updateEmployee(index, name, address, phoneNum, role);
        System.out.println("Employee Has Been Updated!");
    }

    static void deleteEmployee() {
        if (employee.empArr.size() < 1){
            System.out.println("There are no Employees currently");
            System.out.print("Press Enter to Continue.....");
            input.nextLine();
            System.out.println();
            return;
        }
        int index = 0;
        String badInput = null;
        employee.viewAll();
        do {
            try {
                System.out.print("Choose data you want to delete: ");
                index = input.nextInt();
                input.nextLine();
                if (!Helper.checkChoose(index, employee.empArr.size())) {
                    System.out.printf("Please input number between %d to %d\n", 1, employee.empArr.size());
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }

        } while (!Helper.checkChoose(index, employee.empArr.size()) || badInput != null);
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
                    if (employee.empArr.size() < 1){
                        System.out.println("There are no Employees currently");
                        System.out.print("Press Enter to Continue.....");
                        input.nextLine();
                        System.out.println();
                        continue;
                    }
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
        } while (choose != 5);
    }

    static void addReceptionist() {
        int age = 0;
        String phoneNum = null, username = null, password = null, address = null, name = null, badInput = null;
        boolean checkAdmin = false, checkRec = false;
        System.out.println("====Add Receptionist======");
        do {
            try {
                System.out.print("Username: ");
                username = input.nextLine();
                checkAdmin = admin.checkAdminUsername(username);
                checkRec = receptionist.checkUsernameRec(username);
                if (checkAdmin || checkRec) {
                    System.out.println("Username Already Exist!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (checkAdmin || checkRec);
        do {
            try {
                System.out.print("Password: ");
                password = input.nextLine();
                if (password.length() < 8) {
                    System.out.println("Password length must be more than or equal 8");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (password.length() < 8);
        do {
            try {
                System.out.print("Name: ");
                name = input.nextLine();
                if (Helper.checkDigit(name)) {
                    System.out.println("Name can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(name));
        do {
            try {
                System.out.print("Phone number: ");
                phoneNum = input.nextLine();
                if (!Helper.checkPhoneNumber(phoneNum)) {
                    System.out.println("Phone Number must be a 12 digit number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkPhoneNumber(phoneNum));
        do {
            try {
                System.out.print("Address: ");
                address = input.nextLine();
                if (address.length() < 5 || address.length() > 256) {
                    System.out.println("Address length between 5 to 256");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (address.length() < 5 || address.length() > 256);
        do {
            try {
                System.out.print("Age: ");
                age = input.nextInt();
                input.nextLine();
                if (age <= 0) {
                    System.out.println("Age must be greater than 0");
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.nextLine();
                System.out.println("Please input a number");
            }
        } while (badInput != null || age <= 0);

        receptionist.addReceptionist( name,username, password, address,phoneNum, age);
    }

    static void updateReceptionist() {
        int age = 0, index = 0;
        String phoneNum = null, username = null, password = null, address = null, name = null, badInput = null;
        boolean checkAdmin = false, checkRec = false;

        if (receptionist.rcpArr.size() < 1){
            System.out.println("There's no Receptionist currently");
            System.out.print("Press Enter to Continue.....");
            input.nextLine();
            System.out.println();
            return;
        }
        receptionist.viewAll();
        do {
            try {
                System.out.print("Choose data you want to change: ");
                index = input.nextInt();
                input.nextLine();
                if (!Helper.checkChoose(index, receptionist.rcpArr.size())) {
                    System.out.printf("Please input number between %d to %d\n", 1, receptionist.rcpArr.size());
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }
        } while (!Helper.checkChoose(index, receptionist.rcpArr.size()) || badInput != null);
        System.out.println("====Change Data Receptionist======");
        do {
            try {
                System.out.print("Username: ");
                username = input.nextLine();
                checkAdmin = admin.checkAdminUsername(username);
                checkRec = receptionist.checkUsernameRec(username);
                if (checkAdmin || checkRec) {
                    System.out.println("Username Already Exist!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (checkAdmin || checkRec);
        do {
            try {
                System.out.print("Password: ");
                password = input.nextLine();
                if (password.length() < 8) {
                    System.out.println("Password length must be more than or equal 8");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (password.length() < 8);
        do {
            try {
                System.out.print("Name: ");
                name = input.nextLine();
                if (Helper.checkDigit(name)) {
                    System.out.println("Name can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(name));
        do {
            try {
                System.out.print("Phone number: ");
                phoneNum = input.nextLine();
                if (!Helper.checkPhoneNumber(phoneNum)) {
                    System.out.println("Phone Number must be a 12 digit number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkPhoneNumber(phoneNum));
        do {
            try {
                System.out.print("Address: ");
                address = input.nextLine();
                if (address.length() < 5 || address.length() > 256) {
                    System.out.println("Address length between 5 to 256");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (address.length() < 5 || address.length() > 256);
        do {
            try {
                System.out.print("Age: ");
                age = input.nextInt();
                input.nextLine();
                if (age <= 0) {
                    System.out.println("Age must be greater than 0");
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.nextLine();
                System.out.println("Please input a number");
            }
        } while (badInput != null || age <= 0);
        receptionist.updateReceptionist(index, username, password, name, phoneNum, address, age);
    }

    static void deleteReceptionist() {

        if (receptionist.rcpArr.size() < 1){
            System.out.println("There's no Receptionist currently");
            System.out.print("Press Enter to Continue.....");
            input.nextLine();
            System.out.println();
            return;
        }
        int index = 0;
        String badInput = null;
        receptionist.viewAll();
        do {
            try {
                System.out.print("Choose data you want to delete: ");
                index = input.nextInt();
                input.nextLine();
                if (!Helper.checkChoose(index, receptionist.rcpArr.size())) {
                    System.out.printf("Please input number between %d to %d\n", 1, receptionist.rcpArr.size());
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }
        } while (!Helper.checkChoose(index, receptionist.rcpArr.size()) || badInput != null);
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
                    if (receptionist.rcpArr.size() < 1){
                        System.out.println("There are no Receptionists currently");
                        System.out.print("Press Enter to Continue.....");
                        input.nextLine();
                        System.out.println();
                        continue;
                    }
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

    static void addRoom() {
        String roomCategory = null, badInput = null;
        int roomNumber = 0, roomPrice = 0;
        boolean roomStatus = false;
        System.out.println("====Add Room======");
        do {
            try {
                System.out.print("Room Number: ");
                roomNumber = input.nextInt();
                input.nextLine();
                badInput = null;
                if (!Helper.checkRoomNumber(roomNumber)) {
                    System.out.println("Room number must 3 digit number");
                }
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Pleas input a number");
            }
        } while (!Helper.checkRoomNumber(roomNumber) || badInput != null);
        do {
            try {
                System.out.print("Room Category: ");
                roomCategory = input.nextLine();
                if (!Helper.checkCategory(roomCategory)) {
                    System.out.println("Please input a valid room category [Single, Double, Queen, King]");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkCategory(roomCategory));
        do {
            try {
                System.out.print("Room Price: ");
                roomPrice = input.nextInt();
                input.nextLine();
                badInput = null;
                if (roomPrice <= 0) {
                    System.out.println("Room price must be greater than 0");
                }
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Pleas input a number");
            }
        } while (roomPrice <= 0 || badInput != null);
        room.addRoom(roomNumber, roomCategory, roomPrice, true);
        System.out.println("Room has successfully added!");
    }

    static void updateRoom() {
        if (room.listRoom.size() < 1){
            System.out.println("There are no Rooms currently");
            System.out.print("Press Enter to Continue.....");
            input.nextLine();
            System.out.println();
            return;
        }
        String roomCategory = null, badInput = null;
        int roomNumber = 0, roomPrice = 0, index = 0;
        room.viewRoom();
        do {
            try {
                System.out.print("Choose data you want to change: ");
                index = input.nextInt();
                input.nextLine();
                if (!Helper.checkChoose(index, room.listRoom.size())) {
                    System.out.printf("Please input number between %d to %d\n", 1, room.listRoom.size());
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }
        } while (!Helper.checkChoose(index, room.listRoom.size()) || badInput != null);

        System.out.println("====Change Room's data======");
        do {
            try {
                System.out.print("Room Number: ");
                roomNumber = input.nextInt();
                input.nextLine();
                badInput = null;
                if (!Helper.checkRoomNumber(roomNumber)) {
                    System.out.println("Room number must 3 digit number");
                }
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Pleas input a number");
            }
        } while (!Helper.checkRoomNumber(roomNumber) || badInput != null);
        do {
            try {
                System.out.print("Room Category: ");
                roomCategory = input.nextLine();
                if (!Helper.checkCategory(roomCategory)) {
                    System.out.println("Please input a valid room category [Single, Double, Queen, King]");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkCategory(roomCategory));
        do {
            try {
                System.out.print("Room Price: ");
                roomPrice = input.nextInt();
                input.nextLine();
                badInput = null;
                if (roomPrice <= 0) {
                    System.out.println("Room price must be greater than 0");
                }
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Pleas input a number");
            }
        } while (roomPrice <= 0 || badInput != null);
        room.updateRoom(index, roomNumber, roomCategory, roomPrice, room.listRoom.get(index - 1).getStatus());
    }

    static void deleteRoom() {
        if (room.listRoom.size() < 1){
            System.out.println("There are no Rooms currently");
            System.out.print("Press Enter to Continue.....");
            input.nextLine();
            System.out.println();
            return;
        }
        int index = 0;
        String badInput = null;
        room.viewRoom();
        do {
            try {
                System.out.print("Choose data you want to change: ");
                index = input.nextInt();
                input.nextLine();
                if (!Helper.checkChoose(index, room.listRoom.size())) {
                    System.out.printf("Please input number between %d to %d\n", 1, room.listRoom.size());
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }
        } while (!Helper.checkChoose(index, room.listRoom.size()) || badInput != null);
        room.deleteRoom(index);
        System.out.println("Successfully delete room");
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
                    if (room.listRoom.size() < 1){
                        System.out.println("There are no Rooms currently");
                        System.out.print("Press Enter to Continue.....");
                        input.nextLine();
                        System.out.println();
                        continue;
                    }
                    room.viewRoom();
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
        if (room.listRoomAvailable.size() < 1){
            System.out.println("There are no available rooms currently");
            System.out.print("Press Enter to Continue.....");
            input.nextLine();
            System.out.println();
            return;
        }
        room.viewAvailableRoom();

        String name = null, address = null, phone = null, gender = null;
        String payMethod = null, badInput = null;
        int roomIndex = 0, age = 0;

        String type = null, start = null, end = null, desc = null;

        System.out.println("====Add Guest======");
        do {
            try {
                System.out.print("Guest Name: ");
                name = input.nextLine();
                if (Helper.checkDigit(name)) {
                    System.out.println("Name can't contains number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (Helper.checkDigit(name));
        do {
            try {
                System.out.print("Guest Address: ");
                address = input.nextLine();
                if (address.length() < 5 || address.length() > 256) {
                    System.out.println("Address length between 5 to 256");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (address.length() < 5 || address.length() > 256);
        do {
            try {
                System.out.print("Guest Phone number: ");
                phone = input.nextLine();
                if (!Helper.checkPhoneNumber(phone)) {
                    System.out.println("Phone Number must be a 12 digit number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkPhoneNumber(phone));
        int roomNumber = 0;
        do {
            try {
                System.out.print("Choose Room number : ");
                roomIndex = input.nextInt();
                if (!Helper.checkChoose(roomIndex, room.listRoomAvailable.size())) {
                    System.out.printf("Please input number between %d to %d\n", 1, room.listRoomAvailable.size());
                } else {
                    roomNumber = room.getRoomNumberByIndex(roomIndex);
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }
        } while (!Helper.checkChoose(roomIndex, room.listRoomAvailable.size()) || badInput != null);

        do {
            try {
                System.out.print("Guest Age: ");
                age = input.nextInt();
                input.nextLine();
                if (age <= 0) {
                    System.out.println("Age must be greater than 0");
                } else if (age < 18) {
                    System.out.println("Minimum guest age is 18 years old");
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.nextLine();
                System.out.println("Please input a number");
            }
        } while (badInput != null || age < 18);
        do {
            try {
                System.out.print("Guest Gender: ");
                gender = input.nextLine();
                if (!Helper.checkGender(gender)) {
                    System.out.println("Please input a valid gender [Male, Female]");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkGender(gender));
        guest.addGuest(name, address, phone, roomNumber, age, gender);
        System.out.println();
        System.out.println("====Add Booking======");
        do {
            try {
                System.out.print("Booking Type : ");
                type = input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (type.length() > 100);
        do {
            try {
                System.out.print("Start Date (yyyy-mm-dd) : ");
                start = input.nextLine();
                if (!Helper.checkDate(start)) {
                    System.out.println("Please input a valid date");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkDate(start));
        do {
            try {
                System.out.print("End Date (yyyy-mm-dd) : ");
                end = input.nextLine();
                if (!Helper.checkDate(end)) {
                    System.out.println("Please input a valid date");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!Helper.checkDate(end));
        do {
            try {
                System.out.print("Booking Description : ");
                desc = input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (desc.length() < 10);
        book.checkIn(type, start, end, desc, guest.indexGuest());

        final int[] getIndex = new int[1];
        final int temp = roomNumber;
        room.listRoom.forEach(x -> {
            if (x.getRoomNumber() == temp) {
                x.setStatus(false);

                room.listRoomAvailable.forEach(y -> {
                    if (y.getRoomNumber() == x.getRoomNumber()) {
                        getIndex[0] = room.listRoomAvailable.indexOf(y);
                    }
                });
            }
        });

        room.listRoomAvailable.remove(getIndex[0]);

        System.out.println("====Add Payment======");
        do {
            try {
                System.out.print("Payment Method: ");
                payMethod = input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (payMethod.length() < 2);

        LocalDate date1 = LocalDate.parse(book.getStartDateByIndex(), DateTimeFormatter.ISO_DATE);
        LocalDate date2 = LocalDate.parse(book.getEndDateByIndex(), DateTimeFormatter.ISO_DATE);
        long count = ChronoUnit.DAYS.between(date1, date2);
        int total = (int) count * room.getPriceByIndex(roomIndex);
        payment.makePayment(payMethod, total, book.getStartDateByIndex(), true);
        payment.notaPayment();
    }

    static void removeBooking() {
        String badInput = null;
        int guestOut = 0;
        if (book.sizeList() < 1){
            System.out.println("There's no booking currently");
            System.out.print("Press Enter to Continue.....");
            input.nextLine();
            System.out.println();
            return;
        }
        guest.viewAll();
        System.out.println("===========================================");
        System.out.println("Choose number of room you wish to check out");
        do {
            try {
                System.out.print(">> ");
                guestOut = input.nextInt();
                input.nextLine();
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = input.next();
                System.out.println("Please input a number");
            }
        } while (badInput != null);
        final int temp = guestOut;
        room.listRoom.forEach(z -> {
            if (z.getRoomNumber() == guest.guestsArr.get(temp - 1).getGuestRoom()) {
                z.setStatus(true);
                room.listRoomAvailable.add(z);
            }
        });
        guest.deleteGuest(guestOut);
        book.checkOut(guestOut);
    }

    static void homeAdmin() {

        int choose = 0;
        String badInput = null;
        if (indexLogin != -1) {
            do {
                System.out.println("======Hotelku=======");
                System.out.println("1. Receptionist");
                System.out.println("2. Employee");
                System.out.println("3. Rooms");
                System.out.println("4. Admin");
                System.out.println("5. Logout");
                do {
                    try {
                        System.out.print(">> ");
                        choose = input.nextInt();
                        input.nextLine();
                        badInput = null;
                    } catch (InputMismatchException e) {
                        badInput = input.next();
                        System.out.println("Please input a number");
                    }
                } while (badInput != null);

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
                    case 5:
                        formLogin();
                        break;
                    default:
                        System.out.println("Please input a number between 1 - 5");
                        break;
                }
            } while (choose != 5);
        } else {
            formLogin();
        }


    }

    static void homeRec() {

        int choose = 0;
        String badInput = null;
        do {
            System.out.println("======Hotelku Receptionist=======");
            System.out.println("1. Add Booking");
            System.out.println("2. Remove Booking");
            System.out.println("3. Check Room");
            System.out.println("4. Check Booking");
            System.out.println("5. Check Guest");
            System.out.println("6. Payment History");
            System.out.println("7. Logout");
            do {
                try {
                    System.out.print(">> ");
                    choose = input.nextInt();
                    input.nextLine();
                    badInput = null;
                } catch (InputMismatchException e) {
                    badInput = input.next();
                    System.out.println("Please input a number");
                }
            } while (badInput != null);
            switch (choose) {
                case 1:
                    bookingMenu();
                    break;
                case 2:
                    removeBooking();
                    break;
                case 3:
                    if (room.listRoom.size() < 1){
                        System.out.println("There are no Rooms currently");
                        System.out.print("Press Enter to Continue.....");
                        input.nextLine();
                        System.out.println();
                        continue;
                    }
                    room.viewRoom();
                    break;
                case 4:
                    int chooseBook = 0;
                    System.out.println("========Check Booking========");
                    System.out.println("1. Check Current Booking");
                    System.out.println("2. Check Booking History");
                    System.out.println("3. Update Booking");
                    System.out.println("4. Back");
                    do {
                        try {
                            System.out.print(">> ");
                            chooseBook = input.nextInt();
                            input.nextLine();
                            badInput = null;
                        } catch (InputMismatchException e) {
                            badInput = input.next();
                            System.out.println("Please input a number");
                        }
                    } while (badInput != null);

                    if (chooseBook == 1) {
                        if (book.bookList.size() < 1) {
                            System.out.println();
                            System.out.println("There's no booking currently");
                            System.out.print("Press Enter to continue.....");
                            input.nextLine();
                            System.out.println();
                            continue;
                        }
                        book.viewBook();
                    } else if (chooseBook == 2) {
                        if (book.bookHistory.size() < 1) {
                            System.out.println();
                            System.out.println("There's no booking history");
                            System.out.print("Press Enter to continue.....");
                            input.nextLine();
                            System.out.println();
                            continue;
                        }
                        book.bookHistory();
                    } else if (chooseBook == 3) {

                        if (book.sizeList() < 1){
                            System.out.println("There's no booking currently");
                            System.out.print("Press Enter to Continue.....");
                            input.nextLine();
                            System.out.println();
                            continue;
                        }
                        book.viewBook();
                        String type = null, start = null, end = null, desc = null;
                        int chooseBookUpdate = 0;
                        do {
                            try {
                                System.out.print("Choose data you want to change: ");
                                chooseBookUpdate = input.nextInt();
                                input.nextLine();
                                if (!Helper.checkChoose(chooseBookUpdate, book.bookList.size())) {
                                    System.out.printf("Please input number between %d to %d\n", 1, book.bookList.size());
                                }
                                badInput = null;
                            } catch (InputMismatchException e) {
                                badInput = input.next();
                                System.out.println("Please input a number");
                            }

                        } while (!Helper.checkChoose(chooseBookUpdate, book.bookList.size()) || badInput != null);
                        System.out.println("====Update Booking======");
                        do {
                            try {
                                System.out.print("Booking Type : ");
                                type = input.nextLine();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } while (type.length() > 100);
                        do {
                            try {
                                System.out.print("Start Date (yyyy-mm-dd) : ");
                                start = input.nextLine();
                                if (!Helper.checkDate(start)) {
                                    System.out.println("Please input a valid date");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } while (!Helper.checkDate(start));
                        do {
                            try {
                                System.out.print("End Date (yyyy-mm-dd) : ");
                                end = input.nextLine();
                                if (!Helper.checkDate(end)) {
                                    System.out.println("Please input a valid date");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } while (!Helper.checkDate(end));
                        do {
                            try {
                                System.out.print("Booking Description : ");
                                desc = input.nextLine();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } while (desc.length() < 10);
                        book.updateBook(chooseBookUpdate, type, start, end, desc);
                        System.out.println();
                    } else if (chooseBook == 4) {
                        continue;
                    }
                    break;
                case 5:
                    if (guest.guestsArr.size() < 1){
                        System.out.println("There are no Guests currently");
                        System.out.print("Press Enter to Continue.....");
                        input.nextLine();
                        System.out.println();
                        continue;
                    }
                    int updt = 0;
                    guest.viewAll();
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println("1. Update Guest");
                    System.out.println("2. Back");
                    do {
                        try {
                            System.out.print(">> ");
                            updt = input.nextInt();
                            input.nextLine();
                            badInput = null;
                        } catch (InputMismatchException e) {
                            badInput = input.next();
                            System.out.println("Please input a number");
                        }
                    } while (badInput != null);

                    if (updt == 1) {
                        String name = null, address = null, phone = null, gender = null;
                        int roomNumber = 0, age = 0, inp = 0, roomIndex = 0;
                        System.out.println("====Update Guest======");
                        do {
                            try {
                                System.out.print("Choose data you want to change: ");
                                inp = input.nextInt();
                                input.nextLine();
                                if (!Helper.checkChoose(inp, guest.guestsArr.size())) {
                                    System.out.printf("Please input number between %d to %d\n", 1, guest.guestsArr.size());
                                }
                                badInput = null;
                            } catch (InputMismatchException e) {
                                badInput = input.next();
                                System.out.println("Please input a number");
                            }
                        } while (!Helper.checkChoose(inp, guest.guestsArr.size()) || badInput != null);
                        do {
                            try {
                                System.out.print("Guest Name: ");
                                name = input.nextLine();
                                if (Helper.checkDigit(name)) {
                                    System.out.println("Name can't contains number");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } while (Helper.checkDigit(name));
                        do {
                            try {
                                System.out.print("Guest Address: ");
                                address = input.nextLine();
                                if (address.length() < 5 || address.length() > 256) {
                                    System.out.println("Address length between 5 to 256");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } while (address.length() < 5 || address.length() > 256);
                        do {
                            try {
                                System.out.print("Guest Phone number: ");
                                phone = input.nextLine();
                                if (!Helper.checkPhoneNumber(phone)) {
                                    System.out.println("Phone Number must be a 12 digit number");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } while (!Helper.checkPhoneNumber(phone));
                        room.viewAvailableRoom();
                        do {
                            if (room.viewAvailableRoom() == -1) break;
                            try {
                                System.out.print("Choose Room number : ");
                                roomIndex = input.nextInt();
                                if (!Helper.checkChoose(roomIndex, room.listRoomAvailable.size())) {
                                    System.out.printf("Please input number between %d to %d\n", 1, room.listRoomAvailable.size());
                                } else {
                                    roomNumber = room.getRoomNumberByIndex(roomIndex);
                                }
                                badInput = null;
                            } catch (InputMismatchException e) {
                                badInput = input.next();
                                System.out.println("Please input a number");
                            }
                        } while (!Helper.checkChoose(roomIndex, room.listRoomAvailable.size()) || badInput != null);
                        do {
                            try {
                                System.out.print("Guest Age: ");
                                age = input.nextInt();
                                input.nextLine();
                                if (age <= 0) {
                                    System.out.println("Age must be greater than 0");
                                } else if (age < 18) {
                                    System.out.println("Minimum guest age is 18 years old");
                                }
                                badInput = null;
                            } catch (InputMismatchException e) {
                                badInput = input.nextLine();
                                System.out.println("Please input a number");
                            }
                        } while (badInput != null || age < 18);
                        do {
                            try {
                                System.out.print("Guest Gender: ");
                                gender = input.nextLine();
                                if (!Helper.checkGender(gender)) {
                                    System.out.println("Please input a valid gender [Male, Female]");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } while (!Helper.checkGender(gender));
                        guest.updateGuest(inp, name, address, phone, roomNumber, age, gender);
                        System.out.println();

                    } else {
                        continue;
                    }
                    break;

                case 6:
                    if (payment.paymentList.size() < 1){
                        System.out.println("There are no Payments History currently");
                        System.out.print("Press Enter to Continue.....");
                        input.nextLine();
                        System.out.println();
                        continue;
                    }
                    payment.viewPayment();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please input a number between 1 - 7");
                    break;
            }
        } while (choose != 7);
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

        setTimeout(() -> System.out.println(), 900);
        setTimeout(() -> System.out.println(), 900);

        setTimeout(() -> System.out.println(" ██╗  ██╗ ██████╗ ████████╗███████╗██╗     ██╗  ██╗██╗   ██╗"), 1000);
        setTimeout(() -> System.out.println(" ██║  ██║██╔═══██╗╚══██╔══╝██╔════╝██║     ██║ ██╔╝██║   ██║"), 1300);
        setTimeout(() -> System.out.println(" ███████║██║   ██║   ██║   █████╗  ██║     █████╔╝ ██║   ██║"), 1500);
        setTimeout(() -> System.out.println(" ██╔══██║██║   ██║   ██║   ██╔══╝  ██║     ██╔═██╗ ██║   ██║"), 1700);
        setTimeout(() -> System.out.println(" ██║  ██║╚██████╔╝   ██║   ███████╗███████╗██║  ██╗╚██████╔╝"), 1900);
        setTimeout(() -> System.out.println(" ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚══════╝╚══════╝╚═╝  ╚═╝ ╚═════╝"), 2100);

    }

    static void formLogin() {
        font();

        setTimeout(() -> {
            for (int i = 0; i < 1; ++i) System.out.println();
        }, 2800);

        setTimeout(() -> System.out.println("========================= Login ============================"), 3100);
        setTimeout(() -> System.out.print("Username: "), 3200);
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        int res = checkLogin(username, password);
        if (res == 1) {
            homeAdmin();
        } else if (res == 2) {
            homeRec();
        } else {
            System.out.println("Wrong username or password");
        }

    }

    public static void main(String[] args) {
        room.roomInit();
        admin.initAdmin();
        employee.init();
        receptionist.init();
        formLogin();

    }
}