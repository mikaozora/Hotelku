import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static void menuAdmin() {

        int choose;
        do {
            System.out.println("======Hotelku=======");
            System.out.println("1. Receptionist");
            System.out.println("2. Employee");
            System.out.println("3. Rooms");
            System.out.println("4. Logout");
            System.out.print(">> ");
            choose = input.nextInt();
            input.nextLine();

        } while (choose != 4);
        formLogin();

    }

    static void menuRec(){

    }

    static int checkLogin(){
        return 1;
    }

    static void formLogin(){
        System.out.println("=========Login=========");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        boolean res = true;

        if(res){
            menuAdmin();
        }else{
            menuRec();
        }

    }
    public static void main(String[] args) {
        formLogin();
    }
}