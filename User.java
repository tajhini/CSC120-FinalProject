import java.util.Scanner;
import java.util.ArrayList;

public class User extends characters{

    public String name;
    protected int health;
    protected String location;
    private String [] gameQues = {"Which band is abbreviated to 1D?", "Which Jonas brother has diabetes?", "Which band is abbriviated to 5SOS?", "Who sung Baby?", "Who wore a meat dress?"};
    private String [] gameAns = {"One Direction", "Nick Jonas","Five Seconds of Summer","Justin Bieber", "Lady Gaga"};
    Randomizer randQuestion = new Randomizer();
    private ArrayList<Integer> numbers = new ArrayList<Integer>();
    
    
    
    public String answer;
    private int slushCount;

   
    

    public User(String name) {
         this.name = name;
         this.health = 100; 
         this.slushCount = 2;
         
    }

    public String getQuestions(){
    int index = randQuestion.randomSelect(gameQues);
    numbers.add(0, index);
    String question = gameQues[index];
    return question;
    }

    public String getVillian(){
        int index1 = randQuestion.randomSelect(villianChars);
        characters villian = villianChars.get(index1);
        return "You will be competeing against: " + villian.toString();
        }

    public void getCharacter(){
        for (int i =0; i<helpCharacters.size(); i++){
            System.out.println(helpCharacters.get(i));
        } 

    }

    public void getAnswer(String answer){
        if(answer.equalsIgnoreCase(gameAns[numbers.get(0)])){
            this.health += 10;
        } else{
            this.health -=10;
        }
    }
    public void getCharname(String nameChar){
        this.name = nameChar;
    }
    
    public void game(User u){
        Scanner scanner1 = new Scanner(System.in);
        for (int i =0; i<5; i++){
            
            System.out.println(u.getQuestions());
            String answer = scanner1.nextLine();
            u.getAnswer(answer);
            System.out.println("Health: " + u.health);
        } 
    }
   
    public void isHelprequested(String help){
        if (help.equalsIgnoreCase("yes")){
            System.out.println("The following characters are scattered throughout the school.");

            System.out.println("You have 30 seconds to find them.");
        }
    }
    
    public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);
    System.out.println("ENTER PLAYER NAME:");
    String nameChar = scanner.nextLine();
    User Char1 = new User(nameChar);
    System.out.println("PLAYER STATS");
    System.out.println("------------");
    System.out.println("Name: " + Char1.name);
    System.out.println("Slushie Count: " + Char1.slushCount);
    System.out.println("Health: " + Char1.health);
    System.out.println("------------");

     characters Santana = new characters ("Santana", 12, false);
     characters Kurt = new characters ("Kurt", 10, false);
    // System.out.println(Santana.location);
    characters Will = new characters("Will", 100, true);
    characters Rachel = new characters("Rachel", 100, true);
        

    Char1.addVilian(Rachel);
    Char1.addVilian(Will);
    Char1.addChar(Santana);
    Char1.addChar(Kurt);

    System.out.println(Char1.getVillian());
    System.out.println("Would you like to continue or request help?");
    String isHelprequested = scanner.nextLine();
    Char1.isHelprequested(isHelprequested);
    Char1.getCharacter();
    
    Char1.game(Char1);
    

    
    

    
        
    }
    
}
