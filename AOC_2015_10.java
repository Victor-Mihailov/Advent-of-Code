import java.util.*;
import java.io.*;

public class AOC_2015_10
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
         /// value == 0 || 
        String line = scn.nextLine();
        for(int i = 0; i < 50; i = i + 1)
        {
            //System.out.println(i);
            String newLine = "";
            int value = 0;
            int times = 0;
            for(int j = 0; j < line.length(); j = j + 1)
            {
                
                boolean flag = value == line.charAt(j) - '0' || value == 0;
                newLine = flag ? newLine : newLine + times + value;
                times = flag ? times + 1 : 1;
                /*
                if(flag)
                {
                    //value = line.charAt(j) - '0';
                    times = times + 1;
                }
                else
                {
                    newLine = newLine + times + value;
                    //System.out.println(newLine);
                    //value = line.charAt(j) - '0';
                    times = 1;
                }
                */
                value = line.charAt(j) - '0';
            }
            newLine = newLine + times + value;
            
            line = newLine;
            
            //System.out.println(line);
            System.out.println(line.length());
            System.out.println(i);
        }
        
        System.out.println(line.length());
    }
}