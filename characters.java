
import java.util.Random;
import java.util.ArrayList;


/** This class represents a character
* This class contains methods to add a character to the villian list, place a character in a random location
*/

public class characters{

    protected String name;
    protected int strength;
    protected String location;
    public boolean isVillian;
    private String [] schoolRooms = {"Emma's Office", "Principal's Office", "Choir Room"};
    public ArrayList<Object> villianChars = new ArrayList<Object>();

    public characters (String name, int strength, boolean isVillian) {
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




    public static void main(String[] args) {
        characters Santana = new characters ("Santana", 12, false);
        System.out.println(Santana.location);
        characters Will = new characters("Will", 100, true);
        characters Rachel = new characters("Rachel", 100, true);
       

    
        
}
}

