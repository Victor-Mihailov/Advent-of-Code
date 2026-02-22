import java.util.*;
import java.io.*;

public class AOC_2017_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;

        while (scn.hasNextLine())
        {
            ArrayList<Integer> lity = new ArrayList<Integer>();
            
            for(int c = 0; c < 16; c++)
            {
                lity.add( new Integer(scn.nextInt()) );
            }
            
            for(int i = 0; i < lity.size(); i++)
            {
                for(int j = 0; j < lity.size(); ++j)
                {
                    if(lity.get(i) % lity.get(j) == 0 && i != j)
                    {
                        answer = answer + lity.get(i) / lity.get(j);
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}
