import java.util.*;
import java.io.*;

public class AOC_2017_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        String line = scn.nextLine();
        
        for(int i = 0; i < line.length()/2; i++)
        {
            if(line.charAt(i) == line.charAt(line.length()/2 + i))
            {
                answer = answer + line.charAt(i) - 48;
            }
        }
        
        for(int j = line.length()/2; j < line.length(); j++)
        {
            if(line.charAt(j) == line.charAt(j - line.length()/2))
            {
                answer = answer + line.charAt(j) - 48;
            }
        }
        
        System.out.println(answer);
    }
}
