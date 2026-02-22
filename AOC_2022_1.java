import java.util.*;
import java.io.*;

public class AOC_2022_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int smallWait = 0;
        int medumeWait = 0;
        int bigWait = 0;
        int newWait = 0;
        
        while (scn.hasNextLine())
        {
            String calories = scn.nextLine();       
            
            if (calories.equals(""))
            {
                if(bigWait < newWait)
                {
                    smallWait = medumeWait;
                    medumeWait = bigWait;
                    bigWait = newWait; 
                }
                else if (medumeWait < newWait)
                {
                    smallWait = medumeWait;
                    medumeWait = newWait;
                }
                else if (smallWait < newWait)
                {
                    smallWait = newWait;
                }
                newWait = 0;
            }
            else
            {
                newWait = newWait + Integer.parseInt(calories);
            }
        }
        
        System.out.println(bigWait + medumeWait + smallWait);
    }
}
