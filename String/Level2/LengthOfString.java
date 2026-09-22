import java.util.Scanner;

public class LengthOfString {

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        int userLength = findLength(str);
        int builtInLength = str.length();

        System.out.println("Length without length(): " + userLength);
        System.out.println("Length using length(): " + builtInLength);

        sc.close();
    }
}