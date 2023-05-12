import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Enumeration;


    /** This class represents a player
    * This class contains methods to ask a user questions, check if the answer is correct, assign the player a villian, 
    * tell the player which characters are available for providing help, providing a user with help if needed
    * @author Tajhini Brown
    * @version 1
    */

public class User extends Characters{

    public String direction;
    private ArrayList<String> backpack = new ArrayList<String>();
    int yPos;
    int xPos;
    public String name; //the name of the user
    private int health; //the health of the user
    private String location;
    private String [] songs = {"Ice-Ice Baby","Don't rain on my Parade", "Baby", "No Air" };
    private Integer [] songPoints = {50, 50, 40, 20 };
    private String [] gameQues = {"Which band is abbreviated to 1D?", "Which Jonas brother has diabetes?", "Which band is abbriviated to 5SOS?", "Who sung Baby?", "Who wore a meat dress?"};
    private String [] gameAns = {"One Direction", "Nick Jonas","Five Seconds of Summer","Justin Bieber", "Lady Gaga"};
    Randomizer randQuestion = new Randomizer();
    private ArrayList<Integer> numbers = new ArrayList<Integer>();
    public String answer;
    private int slushCount; //the amount of slushies the player has

    /**
   * Creates the "User" class
   * @param name The name of the player
   */
    public User(String name) {
         super();
         this.name = name;
         this.health = 50; 
         this.slushCount = 2;  
         this.xPos = 0;
         this.yPos = 0; 
         this.backpack = backpack; 
    }


    /**
   * Gets a random question  ask the player
   * @return The question
   */
    public String getQuestions(){
    int index = randQuestion.randomSelect(gameQues);
    numbers.add(0, index);
    String question = gameQues[index];
    return question;
    }

    /**
   * Gets a random villian for the player to compete against
   * @return The name of the villian the user will be competing against
   */
    public Characters getVillian(){
        int index1 = randQuestion.randomSelect(villianChars);
        Characters villian = villianChars.get(index1);
        return villian; 
    }

    /**
   * Output the name of the characters that the player can ask for help
   */
    public void getCharacter(){
        for (int i =0; i<helpCharacters.size(); i++){
            System.out.println(helpCharacters.get(i));
        } 
    }

    public String getSong(){
        int index = randQuestion.randomSelect(songs);
        String songChoice = songs[index] ;
        return songChoice;
    }

    /**
   * Gets the answer the player entered and checks if its correct and adds and subtracts points based on this.
   * @param answer The answer the player entered
   * @return The current health of the player
   */
    public void getAnswer(String answer){
        if(answer.equalsIgnoreCase(gameAns[numbers.get(0)])){
            Characters villian = getVillian();
            int villStrength = villian.getStrength(villian);
            this.health += 10;
            villStrength -=10;
        if (answer.equalsIgnoreCase("SLUSH")){
            if (this.slushCount != 0){
            villStrength -= 20;
            this.slushCount -= 1;
            System.out.print("Slushcount" + this.slushCount);
            System.out.print("Health" + this.health);
            System.out.print(villStrength);
            } else {
                throw new RuntimeException("You have no Sluchies remaining.");
            } 
        }
        } else{
            this.health -=10;
        }
    }

    /**
   * Gets the name of the player from the terminal
   * @param namePlayer The entered name of the player
   */
    public void getPlayername(String namePlayer){
        this.name = namePlayer;
    }
    
    /** Uses a for loop to start the game by calling methods to ask the player questions and accept their answer
   * Gets the name of the player from the terminal
   * @param u The player object
   */
    public void game(User u){
        Scanner scanner1 = new Scanner(System.in);
        for (int i =0; i<5; i++){
            System.out.println(u.getQuestions());
            String answer = scanner1.nextLine();
            u.getAnswer(answer);
            System.out.println("Health: " + u.health);}
        Characters villian = getVillian();
        if(villian.getHealth() < u.getHealth()){
            System.out.println("You have won.");
        } else{ System.out.println("You have lost");}
       
 } 
   
    /** Accepts information from the player as to whether they need help to defeat the villian
   * Gets the name of the player from the terminal
   * @param help the player's input
   * @param u The player object
   */
    public void isHelprequested(String help, User u){

        Scanner in = new Scanner(System.in);
        if (help.equalsIgnoreCase("yes")){
            System.out.println("The following characters are scattered throughout the school:");
            u.getCharacter();
            while ((emmasOffice.size() != 2 ) || (choirRoom.size() != 2 ) || (principalOffice.size() != 2 ) || (suesOffice.size() != 2 )){
                System.out.println("Enter a direction you would like to go: east, west, north or south");
                String direction = in.nextLine();
                if (direction.equals("undo")){
                    undo();
                } 
                walk(direction);
                if ((this.xPos == 0 ) && (this.yPos == 5) ){
                    emmasOffice.add(u);
                    System.out.print("You are in Emma's office");
                }
                if ((this.xPos == 0 ) && (this.yPos == 10) ){
                    suesOffice.add(u);
                    System.out.print("You are in Sue's office");
                }
                if ((this.xPos == 5 ) && (this.yPos == 5) ){
                    principalOffice.add(u);
                    System.out.print("You are in the Principal's office");
                }
                if ((this.xPos == 0 ) && (this.yPos == -5) ){
                    System.out.println("You have found the key to the choir room. Enter P to pick it up or a cardinal direction to move on.");
                    answer = in.nextLine();
                    if(answer.equals("P")){
                        System.out.println("You have picked up the key.");
                        this.backpack.add("key");
                    } else {
                        continue;
                    } continue;
                }
                if ((this.xPos == 0 ) && (this.yPos == -10) ){
                    System.out.print("You are at the choir room");
                    if(this.backpack.contains("key"))
                    choirRoom.add(u);
                    System.out.print("You have located the key and can enter.");
                }
                
              }
            } else{
                game(u);
            }
        }
 /**
   * Returns the boolean that indicates that the character is walking 
   * and the direction the character is going and changes their x and y position by 5.
   * @param direction
   * @return isWalking
   */
  public boolean walk(String direction){
    boolean isWalking = direction.equalsIgnoreCase("east");
    if (isWalking){
        System.out.println("You are going: " + direction.toUpperCase());
        this.xPos = this.xPos + 5;
        return isWalking;
    }

    isWalking = direction.equalsIgnoreCase("west");
    if (isWalking){
        System.out.println("You are going: " + direction.toUpperCase());
        this.xPos = this.xPos - 5;
        return isWalking;
    }

    isWalking = direction.equalsIgnoreCase("north");
    if (isWalking){
        System.out.println("You are going: " + direction.toUpperCase());
        this.yPos = this.yPos + 5;
        return isWalking;
    } 

    isWalking = direction.equalsIgnoreCase("south");
    if (isWalking){
        System.out.println("You are going: " + direction.toUpperCase());
        this.yPos = this.yPos - 5;
        System.out.println("Xpos" + this.xPos);
        System.out.println("Ypos" + this.yPos);
        return isWalking;
    }
    else {
        throw new RuntimeException("This is not a direction. Enter a direction.");
    }

}

    public void undo(){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to undo?");
        String undoMethod = input.nextLine();
        if (undoMethod.equalsIgnoreCase("walk")){
            System.out.println("What direction did you go?");
            String undoDirt = input.nextLine();
            if (undoDirt.equalsIgnoreCase("East")){
                this.xPos = this.xPos - 5;
            }
            if (undoDirt.equalsIgnoreCase("West")){
                this.xPos = this.xPos + 5;
            }
            if (undoDirt.equalsIgnoreCase("South")){
                this.yPos = this.yPos + 5;
            }
            if (undoDirt.equalsIgnoreCase("North")){
                this.yPos = this.yPos - 5;
            }
            System.out.println("Walk undone");
    }
}
    
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("ENTER PLAYER NAME:");
    String namePlayer = scanner.nextLine();
    User Char1 = new User(namePlayer);
    System.out.println("PLAYER STATS");
    System.out.println("------------");
    System.out.println("Name: " + Char1.name);
    System.out.println("Slushie Count: " + Char1.slushCount);
    System.out.println("Health: " + Char1.health);
    System.out.println("------------");

     
    Characters Santana = new Characters ("Santana", 20, false);
    Characters Kurt = new Characters ("Kurt", 10, false);
   // System.out.println(Santana.location);
   Characters Will = new Characters("Will", true);
   Characters Rachel = new Characters("Rachel", true);
   

    Char1.addVilian(Rachel);
    Char1.addVilian(Will);
    Char1.addChar(Santana);
    Char1.addChar(Kurt);

    System.out.println("You will be facing: " + Char1.getVillian().toString());
    System.out.println("The song chosen is: " + Char1.getSong());
    System.out.println("Would you like to continue or request help? Enter YES for help.");
    String isHelprequested = scanner.nextLine();
    Char1.isHelprequested(isHelprequested, Char1);

    
      
    }
    
}
