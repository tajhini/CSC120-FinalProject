import java.util.Random;


    

public class Randomizer {
   
    Random rand = new Random();

    
    //prodeuces a ranndom integer for the location of the helper characters
    public String randomSelect(String [] randList){
    int max = randList.length;
    int randIndex = rand.nextInt(max);
    String listSelection = randList[randIndex];
    return listSelection;
    }

    


}

