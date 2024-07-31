package factories;
import classes.Wizard;
import java.util.Scanner;

public class WizardFactory{
    public static Wizard createPlayer() {
        Scanner gamePrompt = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = gamePrompt.nextLine();
        System.out.println("\n\n Hello " + name + "! What is your house? (Gryffindor, Slytherin, Ravenclaw, Hufflepuff) \n");
        String house = gamePrompt.nextLine();
        System.out.println("\n\n As you well know, every wizard needs an animal companion. What is your animal companion? (Owl, Cat, Toad, Rat) \n");
        String animal = gamePrompt.nextLine();

        return new Wizard(name, animal, house, null, null);
    } 
}
