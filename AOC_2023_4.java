import java.util.*;
import java.io.*;

public class AOC_2023_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int inputLength = 196;
        int[] cards = new int[inputLength]; // starts with 0 should start with 1 for each crad;
        int[] affect = new int[inputLength];
        int cardNum = 0;
        while (scn.hasNextLine())
        {
            cardNum = cardNum + 1; // Might go out of bounds;
            
            ArrayList<Integer> winning = new ArrayList<Integer>();
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            
            String line = scn.nextLine();
            line = line.substring(10);
            
            line = line.replace("|", "@");
            String[] data = line.split(" @ ");
            
            String goodNums = data[0];
            String myNums = data[1];
            
            String[] goodNumsArray = goodNums.split(" ");
            String[] myNumsArray = myNums.split(" ");
            
            for(int i = 0; i < goodNumsArray.length; i = i + 1)
            {
                if(goodNumsArray[i].equals("") == false)
                {
                    winning.add(Integer.parseInt(goodNumsArray[i]));
                }
            }
            for(int j = 0; j < myNumsArray.length; j = j + 1)
            {
                if(myNumsArray[j].equals("") == false)
                {
                    numbers.add(Integer.parseInt(myNumsArray[j]));
                }
            }
            //System.out.println(winning.size());
            int overlap = 0;
            for(int i = 0; i < winning.size(); i = i + 1)
            {
                for(int j = 0; j < numbers.size(); j = j + 1)
                {
                    if(numbers.get(j) == winning.get(i))
                    {
                        overlap = overlap + 1;
                    }
                }
            }
            System.out.println(overlap);
            
            affect[cardNum - 1] = overlap;
            cards[cardNum - 1] = 1;
            
            //System.out.println(answer);
        }
        
        for(int i = 0; i < inputLength; i = i + 1)
        {
            for(int j = 1; j <= affect[i]; j = j + 1) // < shoud be <= ?;
            {
                cards[j + i] = cards[j + i] + cards[i]; // j + i might break everything;
                
            }
            answer = answer + cards[i];
        }
        
        System.out.println(answer);
    }
}
