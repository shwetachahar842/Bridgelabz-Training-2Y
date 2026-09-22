import java.util.Scanner;

public class LowercaseConversion {

    static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            result = result + ch;
        }

        return result;
    }

    static boolean compareStrings(String text1, String text2) {

        if (text1.length() != text2.length()) {
            return false;
        }

        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter complete text: ");
        String text = sc.nextLine();

        String userDefinedResult = convertToLowerCase(text);

        String builtInResult = text.toLowerCase();

        System.out.println("Using charAt(): " + userDefinedResult);
        System.out.println("Using toLowerCase(): " + builtInResult);

        boolean result =
                compareStrings(userDefinedResult, builtInResult);

        System.out.println("Both results are same: " + result);

        sc.close();
    }
}