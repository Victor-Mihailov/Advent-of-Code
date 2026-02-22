import java.util.*;
import java.io.*;

public class AOC_2025_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            int index = -1;
            for(int nn = 0; nn < 12; nn = nn + 1)
            {
                int big = 0;
                for(int i = index + 1; i < line.length() - 11 + nn; i = i + 1)
                {
                    if(line.charAt(i) - '0' > big)
                    {
                        big = line.charAt(i) - '0';
                        System.out.println(big);
                        index = i;
                    }
                }
                answer = answer + big * (long)Math.pow(10, 11 - nn);
            }
        }
        
        System.out.println(answer);
    }
}