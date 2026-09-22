import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Method to generate exception
    static void generateException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    // Method to handle exception
    static void handleException(String text) {

        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException occurred.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        // This will generate the exception and stop the program.
        // generateException(text);

        // Handling the exception
        handleException(text);

        sc.close();
    }
}