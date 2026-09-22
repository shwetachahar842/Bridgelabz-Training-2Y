public class NullPointerExceptionDemo {


    // Method to handle exception
    static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurred.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred.");
        }
    }

    public static void main(String[] args) {

        // This will generate the exception and stop the program.
        // generateException();

        // Handling the exception
        handleException();
    }
}