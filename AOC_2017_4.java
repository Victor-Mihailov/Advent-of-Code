import java.util.*;
import java.io.*;

public class AOC_2017_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            ArrayList<String> w = new ArrayList<String>();
            String line = scn.nextLine();
            
            Scanner lineScan = new Scanner(line);
            while(lineScan.hasNext())
            {
                w.add(lineScan.next());
            }
            
            for(int i = 0; i < w.size(); i = i + 1)
            {
                for(int j = 0; j < w.size(); j = j + 1)
                {
                    if(shady(w.get(i)) == shady(w.get(j)) && i != j)
                    {
                        answer = answer - 1;
                        i = w.size();
                        j = w.size();
                    }
                }
            }
            answer = answer + 1;
        }
        
        System.out.println(answer);
    }
    
    public static int shady(String word)
    {
        int value = 1;
        for(int i = 0; i < word.length(); i = i + 1)
        {
            value = value * word.charAt(i);
        }
        return value;
    }
}