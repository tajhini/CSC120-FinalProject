import java.util.Random;
import java.util.ArrayList;


/** This class represents a character
* This class contains methods to add a character to the villian list, place a character in a random location
*/

public class Character {

    protected String name;
    protected int strength;
    protected String location;
    public boolean isVillian;
    private String [] schoolRooms = {"Emma's Office", "Principal's Office", "Choir Room"};
    public ArrayList<Object> villianChars = new ArrayList<Object>();

    public Character(String name, int strength, boolean isVillian) {
         this.name = name;
         this.strength = strength; 
         Randomizer randLocal = new Randomizer();
         this.location = randLocal.randomSelect(schoolRooms);
         this.isVillian = isVillian;

    }

   /** Accessors */
    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public String toString() {
        return " This is " + this.name ;
    }


    /**
   * Adds a character to the villian list if they are a villian
   */
    private void villianList(){
        if (this.isVillian){
        villianChars.set(-1, this);
    }
}

    public static void main(String[] args) {
        Character Santana = new Character ("Santana", 12, false);
        System.out.println(Santana.location);
        Character Will = new Character("Will", 100, true);
        Character Rachel = new Character("Rachel", 100, true);
        Will.villianList();
        Rachel.villianList();


        
    
        
}
}
