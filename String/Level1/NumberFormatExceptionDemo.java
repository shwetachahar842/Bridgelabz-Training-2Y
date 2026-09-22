import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Method to generate exception
    static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number = " + number);
    }

    // Method to handle exception
    static void handleException(String text) {

        try {
            int number = Integer.parseInt(text);
            System.out.println("Number = " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number as text: ");
        String text = sc.next();

        // This will generate the exception.
        // generateException(text);

        // Handling the exception
        handleException(text);

        sc.close();
    }
}