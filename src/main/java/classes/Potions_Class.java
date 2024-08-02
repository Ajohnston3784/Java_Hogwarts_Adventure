package classes;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Potions_Class extends Hogwarts_Class {
    String name = "Potions";
    String teacher = "Professor Snape";
    String statUsed = "intelligence";
    boolean timeUp = false;
    int timeLimit = 0;

    public Potions_Class() {
        System.out.println("\n\nYou have chosen to attend Potions class. Your teacher is Professor Snape. This class will use your intelligence stat.\n");
        brewPotion();
    }

    private void brewPotion() {
        System.out.println("\nYou have been given a potion to brew. You must follow the instructions carefully to brew the potion correctly.\n");
        System.out.println("\nIn order to brew the potions correctly you must correctly type the following words within the allotted time frame. If you do not type the words correctly within the time frame you will fail the potion and not gain any benefits for the day.\n\n");
        Scanner potionPrompt = new Scanner(System.in);

        System.out.println("Are you ready to begin (yes/no) \n\n");
        String ready = potionPrompt.nextLine();
        if (!ready.toLowerCase().equals("yes")) {
            System.out.println("You have chosen to skip class for today, which would result in no stat bonus. If you'd rather continue type yes \n\n");
            ready = potionPrompt.nextLine();
        }

        if (ready.toLowerCase().equals("yes")) {
            System.out.println("Great let's get started! \n\n");
            String[] potionWords = {"wingardium", "leviosa", "alohomora", "expelliarmus", "lumos", "nox", "accio", "expecto", "patronum", "stupefy"};
        

            for (String word : potionWords) {

                if (word.length() < 5) {
                    this.timeLimit = 3;
                } else if (word.length() < 8) {
                    this.timeLimit = 5;
                } else {
                    this.timeLimit = 7;
                }

                System.out.println(word);

                ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
                ScheduledFuture<?> future = executor.schedule(() -> {
                    this.timeUp = true;
                    System.out.println(this.timeLimit);
                }, this.timeLimit, TimeUnit.SECONDS);

                String userWord = potionPrompt.nextLine();

                future.cancel(true);
                executor.shutdown();
                if (this.timeUp) {
                    System.out.println("\nYou have failed to type the word in the allotted time. You will not gain any benefits for the day.\n");
                    break;
                } else if (!userWord.equals(word)) {
                    System.out.println("\nYou have failed the potion. You will not gain any benefits for the day.\n");
                    break;
                } else {
                    System.out.println("\nCorrect! You have successfully typed the ingredient\n");
                    this.timeUp = false;
                }

                if (word.equals(potionWords[potionWords.length - 1])) {
                    System.out.println("Congratulations! You have successfully brewed the potion. You will gain a bonus of +1 to your intelligence stat for the day.\n\n");
                    // System.out.printf("Your intelligence is now %s", Wizard.Wizard.setStat("intelligence", 1));

                }
            }
        } else {
            System.out.println("You have chosen to skip class for today, which resulted in no stat bonus. Goodbye!");
        }
    }

    public String getTeacher() {
        return this.teacher;
    }

    public String getStatUsed() {
        return this.statUsed;
    }


}
