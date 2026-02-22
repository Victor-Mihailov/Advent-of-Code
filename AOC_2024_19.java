import java.util.*;
import java.io.*;

public class AOC_2024_19
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        
        String[] towels = scn.nextLine().split(", ");
        scn.nextLine();
        
        while (scn.hasNextLine())
        {
            String pattern = scn.nextLine();
            long[] valid = new long[pattern.length() + 1];
            valid[0] = 1;
            for(int i = 0; i < pattern.length(); i = i + 1)
            {
                if(valid[i] >= 1)
                {
                    for(int j = 0; j < towels.length; j = j + 1)
                    {
                        if(towels[j].length() + i <= pattern.length() && pattern.substring(i, towels[j].length() + i).equals(towels[j]))
                        {
                            valid[i + towels[j].length()] = valid[i + towels[j].length()] + valid[i];
                        }
                    }
                }
            }
            answer = answer + valid[pattern.length()];
        }
        
        System.out.println(answer);
    }
}