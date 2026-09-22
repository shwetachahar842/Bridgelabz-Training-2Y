import java.util.Scanner;

public class TextIntoWords {

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

    static String[] splitWords(String str) {

        int length = findLength(str);
        int wordCount = 1;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];

        int start = 0;
        int wordIndex = 0;

        for (int i = 0; i <= length; i++) {

            if (i == length || str.charAt(i) == ' ') {

                String word = "";

                for (int j = start; j < i; j++) {
                    word = word + str.charAt(j);
                }

                words[wordIndex] = word;
                wordIndex++;

                start = i + 1;
            }
        }

        return words;
    }

    static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] userWords = splitWords(text);

        
        String[] builtInWords = text.split(" ");

        System.out.println("\nWords using user-defined method:");

        for (String word : userWords) {
            System.out.println(word);
        }

        System.out.println("\nWords using split():");

        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nBoth results are same: "
                + compareArrays(userWords, builtInWords));

        sc.close();
    }
}