import java.util.Scanner;

public class SplitWordsIn2D {

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
        int index = 0;

        for (int i = 0; i <= length; i++) {

            if (i == length || str.charAt(i) == ' ') {

                String word = "";

                for (int j = start; j < i; j++) {
                    word = word + str.charAt(j);
                }

                words[index] = word;
                index++;

                start = i + 1;
            }
        }

        return words;
    }

    static String[][] wordLength(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {

            result[i][0] = words[i];

            int length = findLength(words[i]);

            result[i][1] = String.valueOf(length);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);

        String[][] result = wordLength(words);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");

        for (int i = 0; i < result.length; i++) {

            int length = Integer.parseInt(result[i][1]);

            System.out.println(result[i][0] + "\t" + length);
        }

        sc.close();
    }
}
