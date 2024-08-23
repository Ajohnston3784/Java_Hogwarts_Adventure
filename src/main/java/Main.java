import java.util.Map;
import java.util.Scanner;

import Wizard.Wizard;
import classes.Divination_Class;
import classes.Potions_Class;
import factories.WizardFactory;

public class Main {
    public static void main(String[] args) {
        // Set exit to false to start the character creation loop
        Boolean exit = false;
            while (!exit) {
                System.out.println("Welcome to the Wizarding World of Harry Potter! You are starting your 4th year of school at Hogwarts the magical school of witches and wizards. Before we get started please tell me a little bit about yourself \n\n");
                Wizard player = WizardFactory.createPlayer();
                
                System.out.println("\n\nHello " + player.getName() + "!");
                System.out.println("\nYou are a " + player.getHouse() + " wizard with a " + player.getAnimal() + " as your animal companion.");
                Map<String, Integer> stats = player.getStats();
                System.out.printf("Your current stats are: \n strength: %d \n intellect: %d \n cunning: %d \n bravery %d", stats.get("strength"), stats.get("intelligence"), stats.get("cunning"), stats.get("bravery"));
                
                Scanner characterCreationPrompt = new Scanner(System.in);
                System.out.println("\n\nIs this correct? (yes/no)\n");
                String acceptPlayer = characterCreationPrompt.nextLine();

                if (acceptPlayer.equals("yes")) {
                    System.out.println("\n\nGreat! Let's get started on your adventure!");
                    String hogwarts = 
" _    _   ____    _____ __          __       _____  _______  _____             _____ __      __ ______  _   _  _______  _    _  _____   ______ \n" +
"| |  | | / __ \\  / ____|\\ \\        / //\\    |  __ \\|__   __|/ ____|     /\\    |  __ \\\\ \\    / /|  ____|| \\ | ||__   __|| |  | ||  __ \\ |  ____|\n" +
"| |__| || |  | || |  __  \\ \\  /\\  / //  \\   | |__) |  | |  | (___      /  \\   | |  | |\\ \\  / / | |__   |  \\| |   | |   | |  | || |__) || |__   \n" +
"|  __  || |  | || | |_ |  \\ \\/  \\/ // /\\ \\  |  _  /   | |   \\___ \\    / /\\ \\  | |  | | \\ \\/ /  |  __|  | . ` |   | |   | |  | ||  _  / |  __|  \n" +
"| |  | || |__| || |__| |   \\  /\\  // ____ \\ | | \\ \\   | |   ____) |  / ____ \\ | |__| |  \\  /   | |____ | |\\  |   | |   | |__| || | \\ \\ | |____ \n" +
"|_|  |_| \\____/  \\_____|    \\/  \\//_/    \\_\\|_|  \\_\\  |_|  |_____/  /_/    \\_\\|_____/    \\/    |______||_| \\_|   |_|    \\____/ |_|  \\_\\|______\n";
                    System.out.println(hogwarts);

                    exit = true;
                } else {
                    System.out.println("Okay. Please rebuild your character.");
                }
            }
            // reset exit to false to start the game loop
            exit = false;
            Scanner gamePlayScanner = new Scanner(System.in);
            while (!exit) {
                System.out.println("Today is your first day of classes here at Hogwarts. Which class would you like to attend first, Divination or Potions?");
                String classSelection = gamePlayScanner.nextLine();
                if (classSelection.equals("Divination")) {
                    Divination_Class divinationClass = new Divination_Class();
                } else if (classSelection.equals("Potions")) {
                    Potions_Class potionsClass = new Potions_Class();
                } else if (classSelection.toLowerCase().equals("exit")) {
                    exit = true;
                }
            }
        }
}
