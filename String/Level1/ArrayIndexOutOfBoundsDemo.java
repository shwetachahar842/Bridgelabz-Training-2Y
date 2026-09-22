import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate exception
    static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    // Method to handle exception
    static void handleException(String[] names) {

        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[3];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        // This will generate the exception.
        // generateException(names);

        // Handling the exception
        handleException(names);

        sc.close();
    }
}