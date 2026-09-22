import java.util.Scanner;

public class String2Characters {

    static char[] getCharacters(String text) {
        char[] characters = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }

        return characters;
    }

    static boolean compareArrays(char[] array1, char[] array2) {

        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userDefinedArray = getCharacters(text);

        char[] builtInArray = text.toCharArray();

        boolean result =
                compareArrays(userDefinedArray, builtInArray);

        System.out.println("Both character arrays are same: " + result);

        sc.close();
    }
}