import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = menu(scanner);
        switch (choice) {
            case "1":
                startGame(scanner);
                break;
            case "2":
                break;
            case "3":
                break;
        }
    }

    public static String menu(Scanner scanner) {
        System.out.println("Start = 1");
        System.out.println("Show Score = 2");
        System.out.println("Quit = 3");
        return scanner.nextLine();
    }
    public static void startGame(Scanner scanner) {
        boolean repeat = true;
        boolean yn = false;
        int score = 0;
        int streak = 0;
        int highestStreak = 0;
        Random random = new Random();
        ArrayList<String> challenges= new ArrayList<String>();
        challenges.add("Drink a glass of water");
        challenges.add("Do 10 Pushups");
        challenges.add("Read 5 pages");
        challenges.add("Meditate for 5 minutes");
        challenges.add("Make your bed");
        while (repeat) {
            String challenge = challenges.get(random.nextInt(challenges.size()));
            String result;
            boolean done = false;
            while (!done) {
                System.out.println(challenge);
                System.out.println("done? (yes/no)");
                result = scanner.nextLine();
                switch (result) {
                    case "yes":
                        score++;
                        streak++;
                        System.out.println("Well done!");
                        System.out.println("Score = " + score);
                        System.out.println("Streak = " + streak);
                        if (streak > highestStreak) highestStreak = streak;
                        done = true;
                        break;
                    case "no":
                        streak = 0;
                        System.out.println("Oh no, your streak resets :(");
                        System.out.println("Score = " + score);
                        System.out.println("Streak = " + streak);
                        break;
                    default:
                        System.out.println("Please write yes/no");
                }
            }
            yn = false;
            System.out.println("Want another one? (yes/no)");
            result = scanner.nextLine();
            while (!yn) {
                switch (result) {
                    case "yes":
                        yn = true;
                        break;
                    case "no":
                        System.out.println("End score: " + score);
                        System.out.println("End streak: " + streak);
                        System.out.println("Highest streak: " + highestStreak);
                        repeat = false;
                        yn = true;
                        break;
                    default:
                        System.out.println("Write yes/no");
                        result = scanner.nextLine();
                }
            }
        }
    }
}