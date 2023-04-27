import java.util.Scanner;
import java.util.ArrayList;

public class User {

    public String name;
    protected int health;
    protected String location;
    private String [] gameQues = {"Which band is abbreviated to 1D? "};
    
    private int slushCount;
    

    public User(String name) {
         this.name = name;
         this.health = 100; 
         this.slushCount = 2;
         
    }

    public String getQuestions(){
    Randomizer randQuestion = new Randomizer();
    String question = randQuestion.randomSelect(gameQues);
    return question;
    }

    public void getCharname(String nameChar){
        this.name = nameChar;
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
    System.out.println(Char1.getQuestions());
    String answer = scanner.nextLine();

    
        
    }
    
}
