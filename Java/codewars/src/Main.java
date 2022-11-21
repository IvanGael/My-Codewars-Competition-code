import java.util.*;

public class Main {
    public static int squareDigits(int n) {
        String digits_str = String.valueOf(n);
        String str = "";
        for (int i = 0; i < digits_str.length(); i++){
            double digit_double = Math.pow((double) Integer.parseInt((String.valueOf(digits_str.charAt(i)))), 2);
            str += String.valueOf((int) digit_double);
        }
        return Integer.parseInt(str);
    }

    public static boolean getXO (String str) {
        int comptX = 0;
        int comptO= 0;
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == 'x' || str.charAt(i) == 'X'){
                comptX += 1;
            }
            else if(str.charAt(i) == 'o' || str.charAt(i) == 'O'){
                comptO += 1;
            }
        }
        return comptO == comptX;
    }

    public static String[] StringSplit(String s){
        String result[] = new String[]{""};
        List<String> list = new ArrayList<>();
        if(s.length() % 2 == 0){
            for(int i=0; i<s.length() - 1; i+=2){
                String s2 = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1));
                list.add(s2);
                result = list.toArray(result);
            }
        }
        else {
            s += '_';
            for(int i=0; i<s.length() - 1; i+=2){
                String s2 = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1));
                list.add(s2);
                result = list.toArray(result);
            }

        }
        return result;
    }

    public static String toCamelCase(String s){
        char value;
        StringBuilder sb = new StringBuilder();
        final char delim1 = '_';
        final char delim2 = '-';
        boolean capitalize = false;
        for (int i=0; i<s.length(); ++i) {
            value = s.charAt(i);
            if (value == delim1 || value == delim2) {
                capitalize = true;
            }
            else if (capitalize) {
                sb.append(Character.toUpperCase(value));
                capitalize = false;
            }
            else {
                sb.append(value);
            }
        }


        return sb.toString();
    }

    private static int makeNegative(final int x){
        String numberStr = String.valueOf(x);
        if(numberStr.contains("-") && numberStr.indexOf('-') == 0){
            numberStr = numberStr.replace("-","");
        }
        return -1 * Integer.parseInt(numberStr);
    }

    private static String replaceStr(String str){
        if(str.contains("[") && str.contains("]") && str.contains(",") && str.contains(" ")){
            str = str.replace("[","");
            str = str.replace("]","");
            str = str.replace(",","");
            str = str.replace(" ","");
        }
        return str;
    }

    public static String createPhoneNumber(int[] numbers) {
        int[] indicatif = new int[2];
        int[] otherNumbers1 = new int[2];
        int[] otherNumbers2 = new int[5];
        String phoneNumber = "";
        if(numbers.length == 10){
           indicatif = Arrays.copyOfRange(numbers, 0, 3);
           otherNumbers1 = Arrays.copyOfRange(numbers, 3, 6);
           otherNumbers2 = Arrays.copyOfRange(numbers, 6, 10);
           phoneNumber = "("+ replaceStr(Arrays.toString(indicatif)) + ")"+" "+ replaceStr(Arrays.toString(otherNumbers1))
                    +"-"+ replaceStr(Arrays.toString(otherNumbers2));
        }

        return phoneNumber;
    }


    public static boolean isValid(String braces) {
        while (braces.indexOf("{}") != -1 || braces.indexOf("()") != -1 || braces.indexOf("[]") != -1){
            braces = braces.replace("{}", "").replace("()", "").replace("[]", "");
        }
        return braces.length() == 0 ? true: false;
    }

    public static int find(int[] integers){
        int oddNumber = 0, evenNumber = 0;
        int oddCount=0, evenCount=0;
        if(integers.length >= 3){
            for (int i=0; i<integers.length; i++) {
                int value = integers[i];
                if(value % 2 == 0){
                    evenCount++;
                    evenNumber = value;
                }
                else {
                    oddCount++;
                    oddNumber = value;
                }
            }
        }
        if(evenCount < oddCount){
            return evenNumber;
        }
        return oddNumber;
    }


    public static String camelCase(String input) {
        if(input.length() == 0){
            return "";
        }
        String result = "";
        char[] chars = input.toCharArray();

        for(int i=0; i<input.length()-1; i++){
            result += chars[i];
            if(Character.isUpperCase(chars[i+1])){
                result += " ";
            }
        }
        result += chars[input.length()-1];
        return result;
    }


    public static void main(String[] args) {
       /* System.out.println(getXO("xxXooOasdsdsdsd"));
        System.out.println(squareDigits(1121));
        System.out.println(Arrays.toString(StringSplit("johndoe@gmail")));
        System.out.println(toCamelCase("good-luck"));
        System.out.println(makeNegative(0));
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println(isValid(""));
        System.out.println(find(new int[] {1,9,17,69,888}));*/
        System.out.println(camelCase("allonsDoncDormir"));
    }

}

