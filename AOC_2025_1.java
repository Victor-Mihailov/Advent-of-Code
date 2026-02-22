import java.util.*;
import java.io.*;

public class AOC_2025_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int num = 50;
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            int change = Integer.parseInt(line.substring(1));
            if(line.substring(0, 1).equals("L"))
            {
                for(int i = 0; i < change; i = i + 1)
                {
                    num = num - 1;
                    if(num == 0)
                    {
                        answer = answer + 1;
                    }
                    if(num == -1)
                    {
                        num = 99;
                    }
                }
            }
            else if(line.substring(0, 1).equals("R"))
            {
                for(int i = 0; i < change; i = i + 1)
                {
                    num = num + 1;
                    if(num == 0 || num == 100)
                    {
                        answer = answer + 1;
                    }
                    if(num == 1-0-0+99)
                    {
                        num = 0;
                    }
                }
            }
            
            
        }
        System.out.println(num); 
        System.out.println(answer);
    }
}