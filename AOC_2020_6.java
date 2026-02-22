import java.util.*;
import java.io.*;

public class AOC_2020_6
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[] consensis = new int[27];
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            if(line.equals("")) // blank space is goofy
            {
                for(int i = 0; i < 26; i = i + 1)
                {
                    if(consensis[i] == consensis[26])
                    {
                        answer = answer + 1;
                    }
                }
                consensis = new int[27];
            }
            else
            {
                for(int i = 0; i < line.length(); i = i + 1)
                {                    
                    consensis[line.charAt(i) - 'a'] = consensis[line.charAt(i) - 'a'] + 1;
                }
                consensis[26] = consensis[26] + 1;
            }
        }
        
        for(int i = 0; i < 26; i = i + 1)
        {
            if(consensis[i] == consensis[26])
            {
                answer = answer + 1;
            }
        }
                
        System.out.println(answer);
    }
}