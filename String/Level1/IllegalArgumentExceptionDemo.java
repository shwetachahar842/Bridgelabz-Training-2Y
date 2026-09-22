import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    // Method to generate exception
    static void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }

    // Method to handle exception
    static void handleException(String text) {

        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException occurred.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        // This will generate the exception.
        // generateException(text);

        // Handling the exception
        handleException(text);

        sc.close();
    }
}