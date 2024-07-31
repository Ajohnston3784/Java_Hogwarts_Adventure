import classes.Wizard;
import factories.WizardFactory;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Boolean exit = false;
            while (!exit) {
                System.out.println("Welcome to the Wizarding World of Harry Potter! You are starting your 4th year of school at Hogwarts the magical school of witches and wizards. Before we get started please tell me a little bit about yourself \n\n");
                Wizard player = WizardFactory.createPlayer();
                
                System.out.println("Hello " + player.getName() + "!");
                System.out.println("You are a " + player.getHouse() + " wizard with a " + player.getAnimal() + " as your animal companion.");
                Map<String, Integer> stats = player.getStats();
                System.out.printf("Your current stats are: \n strength: %d \n intellect: %d \n cunning: %d \n bravery %d", stats.get("strength"), stats.get("intelligence"), stats.get("cunning"), stats.get("bravery"));
                
                Scanner characterCreationPrompt = new Scanner(System.in);
                System.out.println("\n\nIs this correct? (yes/no)\n");
                String acceptPlayer = characterCreationPrompt.nextLine();

                if (acceptPlayer.equals("yes")) {
                    System.out.println("Great! Let's get started on your adventure!");
                    exit = true;
                } else {
                    System.out.println("Okay. Please rebuild your character.");
                }
                
                characterCreationPrompt.close();
            }

        }
}
