
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
    ArrayList<characters> villianChars = new ArrayList<characters>();
    ArrayList<characters> helpCharacters = new ArrayList<characters>();
  
    Randomizer randLocal = new Randomizer();
    
    

    public characters (String name, int strength, boolean isVillian) {
         this.name = name;
         this.strength = strength; 
         
         int index = randLocal.randomSelect(schoolRooms);
         this.location = schoolRooms[index];
         this.isVillian = isVillian;

    }

    public characters () {

   }

   /** Accessors */
    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public String toString() {
        return this.name ;
    }

    
    public void addVilian(characters c){
        villianChars.add(c); 
    }

    public void addChar(characters c){
        helpCharacters.add(c); 
    }

    public static void main(String[] args) {
        

        
        
        
        
    
       
        
        
        
       

    
        
}
}

