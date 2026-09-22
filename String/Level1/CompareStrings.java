import java.util.Scanner;

public class CompareStrings {

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

        System.out.print("Enter first string: ");
        String text1 = sc.next();

        System.out.print("Enter second string: ");
        String text2 = sc.next();

        boolean userDefinedResult = compareStrings(text1, text2);
        boolean builtInResult = text1.equals(text2);

        System.out.println("Using charAt(): " + userDefinedResult);
        System.out.println("Using equals(): " + builtInResult);

        if (userDefinedResult == builtInResult) {
            System.out.println("Both results are same.");
        } else {
            System.out.println("Both results are different.");
        }

        sc.close();
    }
}