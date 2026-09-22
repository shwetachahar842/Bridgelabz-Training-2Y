import java.util.Scanner;

public class TrimLeading {

    static int findLength(String str) {

        int count = 0;

        while (true) {
            try {
                str.charAt(count);
                count++;
            } catch (RuntimeException e) {
                break;
            }
        }

        return count;
    }

    static int[] findTrimIndexes(String str) {

        int start = 0;
        int end = findLength(str) - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    static String createSubstring(String str, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + str.charAt(i);
        }

        return result;
    }

    static boolean compareStrings(String a, String b) {

        if (findLength(a) != findLength(b)) {
            return false;
        }

        for (int i = 0; i < findLength(a); i++) {

            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);

        String userTrimmed;

        if (indexes[0] > indexes[1]) {
            userTrimmed = "";
        } else {
            userTrimmed = createSubstring(
                    text, indexes[0], indexes[1]);
        }

        String builtInTrimmed = text.trim();

        System.out.println("User-defined trim: [" + userTrimmed + "]");
        System.out.println("Built-in trim:      [" + builtInTrimmed + "]");

        System.out.println("Both are same: "
                + compareStrings(userTrimmed, builtInTrimmed));

        sc.close();
    }
}