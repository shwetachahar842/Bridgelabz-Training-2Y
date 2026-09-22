import java.util.Scanner;

public class CheckCharacterType {

    static String checkCharacter(char ch) {

        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {

                return "Vowel";

            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    static String[][] findCharacterType(String str) {

        String[][] result = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {

            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = checkCharacter(str.charAt(i));
        }

        return result;
    }

    static void display(String[][] data) {

        System.out.println("\nCharacter\tType");
        System.out.println("-------------------------");

        for (int i = 0; i < data.length; i++) {

            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String[][] result = findCharacterType(str);

        display(result);

        sc.close();
    }
}