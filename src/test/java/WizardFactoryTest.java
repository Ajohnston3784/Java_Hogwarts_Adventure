import java.io.ByteArrayInputStream;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import Wizard.Wizard;
import factories.WizardFactory;


public class WizardFactoryTest {
    // Test that the WizardFactory class can create a new Wizard object
    @Before
    public void setUp() {
        String simulatedInput = "Harry\nGryffindor\nOwl\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
    @Test
    public void testCreatePlayer() {
        Wizard player = WizardFactory.createPlayer();
        assertNotNull(player);
        assertEquals("Harry", player.getName());
        assertEquals("Gryffindor", player.getHouse());
        assertEquals("Owl", player.getAnimal());
}

    @Test
    public void testGryffindorPlayerStats() {
        Wizard player = WizardFactory.createPlayer();
        assertNotNull(player);
        assertEquals(7, (int) player.getStats().get("bravery"));
        assertEquals(6, (int) player.getStats().get("intelligence"));
        assertEquals(5, (int) player.getStats().get("cunning"));
        assertEquals(5, (int) player.getStats().get("strength"));
    }

    @Test
    public void testSettingStats() {
        Wizard player = WizardFactory.createPlayer();
        assertNotNull(player);
        player.setStat("bravery", 2);
        player.setStat("intelligence", 2);
        player.setStat("cunning", 2);
        player.setStat("strength", 2);
        assertEquals(9, (int) player.getStats().get("bravery"));
        assertEquals(8, (int) player.getStats().get("intelligence"));
        assertEquals(7, (int) player.getStats().get("cunning"));
        assertEquals(7, (int) player.getStats().get("strength"));
    }

    @Test
    public void testSlytherinPlayerStats() {
        String simulatedInput = "Draco\nSlytherin\nCat\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    
        Wizard player = WizardFactory.createPlayer();
        assertNotNull(player);
        assertEquals(5, (int) player.getStats().get("bravery"));
        assertEquals(5, (int) player.getStats().get("intelligence"));
        assertEquals(8, (int) player.getStats().get("cunning"));
        assertEquals(5, (int) player.getStats().get("strength"));
    }

    @Test
    public void testHufflepuffPlayerStats() {
        String simulatedInput = "Cedric\nHufflepuff\nToad\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    
        Wizard player = WizardFactory.createPlayer();
        assertNotNull(player);
        assertEquals(5, (int) player.getStats().get("bravery"));
        assertEquals(5, (int) player.getStats().get("intelligence"));
        assertEquals(5, (int) player.getStats().get("cunning"));
        assertEquals(8, (int) player.getStats().get("strength"));
    }

    @Test
    public void testRavenclawPlayerStats() {
        String simulatedInput = "Cho Chang\nRavenclaw\nRat\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    
        Wizard player = WizardFactory.createPlayer();
        assertNotNull(player);
        assertEquals(6, (int) player.getStats().get("bravery"));
        assertEquals(7, (int) player.getStats().get("intelligence"));
        assertEquals(5, (int) player.getStats().get("cunning"));
        assertEquals(5, (int) player.getStats().get("strength"));
    }
    
}
