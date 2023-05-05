import java.util.Random;
import java.util.List;

public class Randomizer{
   
    Random rand = new Random();

    
    //prodeuces a ranndom integer for the location of the helper characters
    public String randomSelect(String [] randList){
    int max = randList.length;
    int randIndex = rand.nextInt(max);
    String listSelection = randList[randIndex];
    return listSelection;
    }

    public String randomSelect(List<String> randList){
        int max = randList.size();
        int randIndex = rand.nextInt(max);
        String listSelection = randList.get(randIndex);
        return listSelection;
        }


    


}

