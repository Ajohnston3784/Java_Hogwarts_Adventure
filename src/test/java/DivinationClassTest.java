import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import classes.Divination_Class;

public class DivinationClassTest {
    @Test
    public void testCorrectPotionsClass() {
        String simulatedInput = "yes\nOwl\nParseltongue\nThe Whomping Willow\nCedric Diggory\nSirius Black\nSnape\n The elder wand\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            Divination_Class potions = new Divination_Class();
            assertNotNull(potions);
            assertEquals("Professor Trelawney", potions.getTeacher());
            assertEquals("Cunning", potions.getStatUsed());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testCorrectClassOutput() {
        String simulatedInput = "yes\nOwl\nparseltongue\nthe whomping willow\nCedric Diggory\nSirius Black\nSnape\nThe elder wand\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            Divination_Class potions = new Divination_Class();
            assertNotNull(potions);

            String output = outContent.toString();
            String[] lines = output.split(System.getProperty("line.separator"));
            assertEquals("Congratulations! You have passed your written exam! You will gain a bonus of +1 to your cunning stat for the day.", lines[lines.length - 1].trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testIncorrectClassOutput() {
        String simulatedInput = "yes\nbird\nslithering\na tree\nHufflepuff\na dog\npotions teacher\nan old wand\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            Divination_Class potions = new Divination_Class();
            assertNotNull(potions);

            String output = outContent.toString();
            String[] lines = output.split(System.getProperty("line.separator"));
            assertEquals("You have failed the written exam. You will not gain any benefits for the day.", lines[lines.length - 1].trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
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
            Divination_Class potions = new Divination_Class();
            assertNotNull(potions);

            String output = outContent.toString();
            String[] lines = output.split(System.getProperty("line.separator"));
            assertEquals("You have chosen to skip class for today, which resulted in no stat bonus. Goodbye!", lines[lines.length - 1].trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
