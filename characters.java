import java.util.Random;
import java.util.ArrayList;

    /** This class represents a character
    * This class contains methods to add a character to the villian list, place a character in a random location
    * @author Tajhini Brown
    * @version 1
    */

public class Characters{

    private String name;
    private int health;
    private int strength;
    private String location; // the location on the map where a character is in
    public boolean isVillian;
    private String [] schoolRooms = {"Emma's Office", "Principal's Office", "Choir Room", "Sue's Office"};
    ArrayList<Characters> emmasOffice = new ArrayList<Characters>();
    ArrayList<Characters> principalOffice = new ArrayList<Characters>();
    ArrayList<Characters> choirRoom = new ArrayList<Characters>();
    ArrayList<Characters> suesOffice = new ArrayList<Characters>();
    ArrayList<Characters> villianChars = new ArrayList<Characters>();
    ArrayList<Characters> helpCharacters = new ArrayList<Characters>();
    Randomizer randLocal = new Randomizer(); 
    
   /**
   * Creates the "Characters" class
   * @param name The name of the character
   * @param strength The amount of help or damage points a character provides
   * @param isVillian Indicates whether a character is a villian or not.
   */

   /** Constructor */
    public Characters (String name, int strength, boolean isVillian) {
         this.name = name;
         this.strength = strength; 
         int index = randLocal.randomSelect(schoolRooms);
         this.location = schoolRooms[index];
         this.isVillian = isVillian;
    }

    public Characters (String name, boolean isVillian) {
        this.name = name;
        if (isVillian == true){this.health = 50;}
        int index = randLocal.randomSelect(schoolRooms);
        this.location = schoolRooms[index];
        this.isVillian = isVillian;
   }

    public Characters() {
   }

   /** Accessors */
    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getHealth() {
        return this.health;
    }

    public int getStrength(Characters c) {
        return c.strength;
    }

    public String getLocation(Characters c) {
        return c.location;
    }

    public String toString() {
        return this.name ;
    }

    /** Adds a character to the viliian arraylist */
    public void addVilian(Characters c){
        villianChars.add(c); 
    }

    /** Adds a character to the list of characters who can be called on for help */
    public void addChar(Characters c){
        helpCharacters.add(c); 
    } 

    /** Adds a character to a location array based on thier randonmyly assigned location */
    public void charLocation(){
        for (Characters i : helpCharacters){
            if (i.location.equals(" Emma's Office")){
                emmasOffice.add(i);
            }
            if (i.location.equals("Principal's Office")){
                principalOffice.add(i);
            }
            if (i.location.equals("Choir Room")){
                choirRoom.add(i);
            }
            if (i.location.equals("Sue's Office")){
                suesOffice.add(i);
            }
        } 
    }
}