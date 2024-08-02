import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import classes.Potions_Class;

public class PotionsClassTest {
    @Test
    public void testCorrrectPotionsClass() {
        String simulatedInput = "yes\nwingardium\nleviosa\nalohomora\nexpelliarmus\nlumos\nnox\naccio\nexpecto\npatronum\nstupefy\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            Potions_Class potions = new Potions_Class();
            assertNotNull(potions);
            assertEquals("Professor Snape", potions.getTeacher());
            assertEquals("intelligence", potions.getStatUsed());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testNoFirstPrompt() {
        String simulatedInput = "no\nyes\nwingardium\nleviosa\nalohomora\nexpelliarmus\nlumos\nnox\naccio\nexpecto\npatronum\nstupefy\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            Potions_Class potions = new Potions_Class();
            assertNotNull(potions);
            assertEquals("Professor Snape", potions.getTeacher());
            assertEquals("intelligence", potions.getStatUsed());
        } finally {
            System.setIn(originalIn);
        }
    }
    
    @Test
    public void skipClass() {
        String simulatedInput = "no\nno";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            Potions_Class potions = new Potions_Class();
            assertNotNull(potions);
            assertEquals("Professor Snape", potions.getTeacher());
            assertEquals("intelligence", potions.getStatUsed());

            String output = outContent.toString();
            String[] lines = output.split(System.getProperty("line.separator"));
            assertEquals("You have chosen to skip class for today, which resulted in no stat bonus. Goodbye!", lines[lines.length - 1]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testCorrectClassOutput() {
        String simulatedInput = "yes\nwingardium\nleviosa\nalohomora\nexpelliarmus\nlumos\nnox\naccio\nexpecto\npatronum\nstupefy\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            Potions_Class potions = new Potions_Class();
            assertNotNull(potions);
            assertEquals("Professor Snape", potions.getTeacher());
            assertEquals("intelligence", potions.getStatUsed());

            String output = outContent.toString();
            String[] lines = output.split(System.getProperty("line.separator"));
            assertEquals("Congratulations! You have successfully brewed the potion. You will gain a bonus of +1 to your intelligence stat for the day.", lines[lines.length - 1]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testIncorrrectPotionsInput() {

        String simulatedInput = "Yes\nwingrdium";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            Potions_Class potions = new Potions_Class();
            assertNotNull(potions);
 
            String output = outContent.toString();
            String[] lines = output.split(System.getProperty("line.separator"));
            assertEquals("You have failed the potion. You will not gain any benefits for the day.", lines[lines.length - 1]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
