import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        GameState state = new GameState();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String choice = menu(scanner);
            switch (choice) {
                case "1": //Start Game
                    startGame(scanner, state);
                    break;
                case "2": //soon to be "Show Score"
                    break;
                case "3": //Quit Game
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public static String menu(Scanner scanner) {
        System.out.println("Start = 1");
        System.out.println("Show Score = 2");
        System.out.println("Quit = 3");
        return scanner.nextLine();
    }
    public static void startGame(Scanner scanner, GameState state) {
        boolean repeat = true;
        boolean yn;
        Random random = new Random();
        ArrayList<String> challenges= new ArrayList<>();
        challenges.add("Drink a glass of water");
        challenges.add("Do 10 Push-ups");
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
                        state.score++;
                        state.streak++;
                        System.out.println("Well done!");
                        System.out.println("Score = " + state.score);
                        System.out.println("Streak = " + state.streak);
                        if (state.streak > state.highestStreak) state.highestStreak = state.streak;
                        done = true;
                        break;
                    case "no":
                        state.streak = 0;
                        System.out.println("Oh no, your streak resets :(");
                        System.out.println("Score = " + state.score);
                        System.out.println("Streak = " + state.streak);
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
                        System.out.println("End score: " + state.score);
                        System.out.println("End streak: " + state.streak);
                        System.out.println("Highest streak: " + state.highestStreak);
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