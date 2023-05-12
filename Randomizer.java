import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/** This class represents a randomiser
    * This class contains methods to ask a user questions, to randomly produce an integer depending on the size and length of a class.
    * @author Tajhini Brown
    * @version 1
    */ 
public class Randomizer{
   
    Random rand = new Random();
    
    /**
   * Randomly selects an integer using the array length as an upperbound
   * @param randList An entered array 
   * @return a random integer that will be used as an index
   */
    public int randomSelect(String [] randList){
        List randArray = Arrays.asList(randList);
        int max = randArray.size();
        int randIndex = rand.nextInt(max);
        return randIndex;
    }

    /**
   * Randomly selects an integer using the list size as an upperbound
   * @param randList An entered list
   * @return a random integer that will be used as an index
   */
    public int randomSelect(List<String> randList){
        Collections.shuffle(randList, rand);
        int max = randList.size();
        int randIndex = rand.nextInt(max);
        return randIndex;
    }

    /**
   * Randomly selects an integer using the arraylist size as an upperbound
   * @param randList An entered arraylist
   * @return a random integer that will be used as an index
   */
    public int randomSelect( ArrayList<Characters> randList){
        Collections.shuffle(randList, rand);
        int max = randList.size();
        int randIndex = rand.nextInt(max);
        return randIndex;
    }

}



