package Wizard;

import java.util.HashMap;
import java.util.Map;

public class Wizard {
    private String name;
    private String animal;
    private String house;
    private Map<String, Integer> stats;
    // Uncomment when adding combat into the game
    // private String[] spells;


    public Wizard(String name, String animal, String house, HashMap<String, Integer> stats, String[] spells) {
        this.name = name;
        this.animal = animal;
        this.house = house;
        this.stats = stats != null ? stats : new HashMap<>();
        // this.spells = spells;

        setBaseStats();
        setHouse(this.house);
        setAnimal(this.animal);
    }   

    private void setBaseStats() {
        stats.put("bravery", 5);
        stats.put("intelligence", 5);
        stats.put("strength", 5);
        stats.put("cunning", 5);
        
        /*
         * Uncomment the below stats when adding combat into the game
         */
        // stats.put("health", 100);
        // stats.put("mana", 100);
        // stats.put("defense", 10);
        // stats.put("speed", 10);
    }

    private void setHouse(String house) {
        this.house = house;
        switch (house) {
            case "Gryffindor" -> {
                stats.put("bravery", stats.get("bravery") + 2); 
                // System.out.println("\nAh, so you are a brave Gryffindor! Many bold and adventuring wizards have come from that house. Just make sure not to stray too far from the path of righteousness.");
            }
            case "Slytherin" -> {
                stats.put("cunning", stats.get("cunning") + 2);
                // System.out.println("\nAh, so you are a cunning Slytherin! Many powerful wizards have come from that house. Also many dark wizards have come from that house. Make sure to walk a straight path and use your cunning for good... that is if you so choose.");
            }
            case "Ravenclaw" -> {
                stats.put("intelligence", stats.get("intelligence") + 2);
                // System.out.println("\nAh, so you are an intelligent Ravenclaw! Many wise wizards have come from that house.");
            }
            case "Hufflepuff" -> { 
                stats.put("strength", stats.get("strength") + 2);
                // System.out.println("\nAh, so you are a strong Hufflepuff! Many loyal wizards have come from that house.");
            }
            default -> { 
            }
        }
    }

    private void setAnimal(String animal) {
        this.animal = animal;
        switch (animal) {
            case "Owl" -> stats.put("intelligence", stats.get("intelligence") + 1);
            case "Cat" -> stats.put("cunning", stats.get("cunning") + 1);
            case "Toad" -> stats.put("strength", stats.get("strength") + 1);
            case "Rat" -> stats.put("bravery", stats.get("bravery") + 1);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getHouse() {
        return this.house;
    }

    public String getAnimal() {
        return this.animal;
    }

    public int setStat(String stat, int amount) {
        this.stats.put(stat, this.stats.get(stat) + amount);
        return this.stats.get(stat);
    }

    public HashMap<String, Integer> getStats() {
        return (HashMap<String, Integer>) this.stats;
    }

}