public class Helper {

    public static boolean checkDigit(String str){
        char [] chars = str.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneNumber(String str){
        char [] chars = str.toCharArray();
        if(str.length() == 12){
            for(char c : chars){
                if(Character.isAlphabetic(c)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean checkChoose(int choose, int max){
        if(choose < 1 || choose > max){
            return false;
        }
        return true;
    }

    public static boolean checkString(int n){
        String str = Integer.toString(n);
        char [] chars = str.toCharArray();
        for(char c : chars){
            if(Character.isAlphabetic(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkRoomNumber(int num){
        if(num >= 100 && num <= 999){
            return true;
        }
        return false;
    }

    public static boolean checkCategory(String str){
        String []arr = {"Single", "Double", "Queen", "King"};
        for (int i = 0; i < arr.length; i++) {
            if(str.contains(arr[i])){
                return true;
            }
        }
        return false;
    }
    public static boolean checkGender(String str){
        String []arr = {"Male", "Female"};
        for (int i = 0; i < arr.length; i++) {
            if(str.contains(arr[i])){
                return true;
            }
        }
        return false;
    }

    public static boolean checkDate(String str){
        if(str.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")){
            return true;
        }
        return false;
    }
}
