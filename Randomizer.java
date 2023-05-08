import java.util.Random;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Randomizer{
   
    Random rand = new Random();

    
    //prodeuces a ranndom integer for the location of the helper characters
    public int randomSelect(String [] randList){
    int max = randList.length;
    int randIndex = rand.nextInt(max);
    return randIndex;
    }

    public int randomSelect(List<String> randList){
        int max = randList.size();
        int randIndex = rand.nextInt(max);
        return randIndex;
        }
   
    public int randomSelect(Set<String> randList){
            int max = randList.size();
            int randIndex = rand.nextInt(max);
            return randIndex;
            }

            public int randomSelect( ArrayList<characters> randList){
                int max = randList.size()-1;
                int randIndex = rand.nextInt(max);
                return randIndex;
                }


}

