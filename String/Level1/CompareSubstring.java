import java.util.Scanner;

public class CompareSubstring {

    static String createSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
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

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String userDefinedSubstring =
                createSubstring(text, start, end);

        String builtInSubstring =
                text.substring(start, end);

        System.out.println("Substring using charAt(): "
                + userDefinedSubstring);

        System.out.println("Substring using substring(): "
                + builtInSubstring);

        boolean result =
                compareStrings(userDefinedSubstring, builtInSubstring);

        System.out.println("Both substrings are same: " + result);

        sc.close();
    }
}