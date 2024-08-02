package factories;
import java.util.Scanner;

import Wizard.Wizard;

public class WizardFactory{
    public static Wizard createPlayer() {
        Scanner gamePrompt = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = gamePrompt.nextLine();
        System.out.println("\nHello " + name + "! What is your house? (Gryffindor, Slytherin, Ravenclaw, Hufflepuff)");
        String house = gamePrompt.nextLine();
        System.out.println("\nAs you well know, every wizard needs an animal companion. What is your animal companion? (Owl, Cat, Toad, Rat)");
        String animal = gamePrompt.nextLine();

        return new Wizard(name, animal, house, null, null);
    } 
}


// _    _   ____    _____ __          __       _____  _______  _____             _____ __      __ ______  _   _  _______  _    _  _____   ______ 
// | |  | | / __ \  / ____|\ \        / //\    |  __ \|__   __|/ ____|     /\    |  __ \\ \    / /|  ____|| \ | ||__   __|| |  | ||  __ \ |  ____|
// | |__| || |  | || |  __  \ \  /\  / //  \   | |__) |  | |  | (___      /  \   | |  | |\ \  / / | |__   |  \| |   | |   | |  | || |__) || |__   
// |  __  || |  | || | |_ |  \ \/  \/ // /\ \  |  _  /   | |   \___ \    / /\ \  | |  | | \ \/ /  |  __|  | . ` |   | |   | |  | ||  _  / |  __|  
// | |  | || |__| || |__| |   \  /\  // ____ \ | | \ \   | |   ____) |  / ____ \ | |__| |  \  /   | |____ | |\  |   | |   | |__| || | \ \ | |____ 
// |_|  |_| \____/  \_____|    \/  \//_/    \_\|_|  \_\  |_|  |_____/  /_/    \_\|_____/    \/    |______||_| \_|   |_|    \____/ |_|  \_\|______