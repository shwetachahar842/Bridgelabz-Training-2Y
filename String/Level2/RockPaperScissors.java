import java.util.Scanner;

public class RockPaperScissors {

    static int computerChoice() {

        return 1 + (int)(Math.random() * 3);
    }

    static String choiceName(int choice) {

        if (choice == 1) {
            return "Rock";
        } else if (choice == 2) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    static String findWinner(int user, int computer) {

        if (user == computer) {
            return "Draw";
        }

        if ((user == 1 && computer == 3) ||
            (user == 2 && computer == 1) ||
            (user == 3 && computer == 2)) {

            return "User";
        }

        return "Computer";
    }

    static String[][] calculatePercentage(int userWins,
                                           int computerWins,
                                           int games) {

        String[][] result = new String[2][2];

        double userPercentage =
                (userWins * 100.0) / games;

        double computerPercentage =
                (computerWins * 100.0) / games;

        result[0][0] = "User";
        result[0][1] = String.valueOf(userPercentage);

        result[1][0] = "Computer";
        result[1][1] = String.valueOf(computerPercentage);

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        int userWins = 0;
        int computerWins = 0;

        System.out.println("\n1 = Rock");
        System.out.println("2 = Paper");
        System.out.println("3 = Scissors");

        System.out.println("\nGame\tUser\tComputer\tWinner");

        for (int i = 1; i <= games; i++) {

            System.out.print("\nEnter your choice for game "
                    + i + ": ");

            int user = sc.nextInt();

            int computer = computerChoice();

            String winner = findWinner(user, computer);

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }

            System.out.println(i + "\t"
                    + choiceName(user) + "\t"
                    + choiceName(computer) + "\t\t"
                    + winner);
        }

        int draws = games - userWins - computerWins;

        String[][] percentage =
                calculatePercentage(
                        userWins, computerWins, games);

        System.out.println("\n----- Statistics -----");

        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Draws: " + draws);

        System.out.println("\nPlayer\t\tWinning Percentage");

        System.out.println(percentage[0][0] + "\t\t"
                + percentage[0][1] + "%");

        System.out.println(percentage[1][0] + "\t"
                + percentage[1][1] + "%");

        sc.close();
    }
}