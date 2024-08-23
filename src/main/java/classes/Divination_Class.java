package classes;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Divination_Class extends Hogwarts_Class {
    String name = "Divination";
    String teacher = "Professor Trelawney";
    String statUsed = "Cunning";
    boolean timeUp = false;
    int correctAnswers = 0;

    public Divination_Class() {
        System.out.println("\n\nYou have chosen to attend Diviniation class. Your teacher is Professor Trelawney. This class will use your cunning stat.\n");
        brewPotion();
    }

    private void brewPotion() {
        System.out.println("\nToday you are given a written exam to complete. You must answer the questions correctly to pass.\n");
        Scanner divinationPrompt = new Scanner(System.in);

        System.out.println("Are you ready to begin (yes/no) \n\n");
        String ready = divinationPrompt.nextLine();
        if (!ready.toLowerCase().equals("yes")) {
            System.out.println("You have chosen to skip class for today, which would result in no stat bonus. If you'd rather continue type yes \n\n");
            ready = divinationPrompt.nextLine();
        }

        if (ready.toLowerCase().equals("yes")) {
            System.out.println("Great let's get started! \n\n");
            String[] examQuestions = {"What kind of animal brought Harry his first letter from Hogwarts?",
                                        "What is the ability to talk to snakes called?",
                                        "What broke Ron's car after he flew it to Hogwarts?",
                                        "Which Tri-wizard tournament contestant died?",
                                        "Who died at the Ministry of Magic offices?",
                                        "Who killed Dumbledore?",
                                        "Which deathly hollows is represented by a stick figure?"};
            String[] examAnswers ={"owl", "parseltongue", "the whomping willow", "cedric diggory", "sirius black", "snape", "the elder wand"};

            for (int i = 0; i < examQuestions.length; i++) {

                System.out.printf("Question number %s: %s ", i + 1, examQuestions[i]);

                ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
                ScheduledFuture<?> future = executor.schedule(() -> {
                    this.timeUp = true;
                }, 10, TimeUnit.SECONDS);

                String userWord = divinationPrompt.nextLine();

                future.cancel(true);
                executor.shutdown();
                if (this.timeUp) {
                    System.out.println("\nYou have failed to answer the question in the allotted time. Be better prepared for the next one.\n");
                } else if (!userWord.toLowerCase().equals(examAnswers[i].toLowerCase())) {
                    System.out.println("\nWrong answer. Better luck with the next question!\n");
                } else {
                    System.out.println("\nThat is correct! Get ready for the next question.\n");
                    this.timeUp = false;
                    correctAnswers++;
                }

                if (i == examQuestions.length - 1 && correctAnswers >= examQuestions.length - 3) {
                    System.out.println("Congratulations! You have passed your written exam! You will gain a bonus of +1 to your cunning stat for the day.\n\n");
                } else if (i == examQuestions.length - 1 && correctAnswers < examQuestions.length - 3) {
                    System.out.println("You have failed the written exam. You will not gain any benefits for the day.\n\n");
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
