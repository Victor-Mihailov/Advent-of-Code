import java.util.*;
import java.io.*;

public class AOC_2016_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 13;
        String code = " ";
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            
            for(int i = 0; i < line.length(); i = i + 1)
            {
                if(line.charAt(i) == 'U'&& answer != 11 && answer != 7 && answer != 3 && answer != 9 && answer != 15)
                {
                    answer = answer - 5;
                }
                else if(line.charAt(i) == 'L' && answer != 11 && answer != 3 && answer != 7 && answer != 17 && answer != 23)
                {
                    answer = answer - 1;
                }
                else if(line.charAt(i) == 'D' && answer != 17 && answer != 11 && answer != 23 && answer != 19 && answer != 15)
                {
                    answer = answer + 5;
                }
                else if(line.charAt(i) == 'R' && answer != 3 && answer != 15 && answer != 9 && answer != 19 && answer != 23)
                {
                    answer = answer + 1;
                }
                
                code = answer + " ";
            }
        
            System.out.println(answer);
        }
    }
}