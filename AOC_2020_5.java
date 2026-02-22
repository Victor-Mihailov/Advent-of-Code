import java.util.*;
import java.io.*;

public class AOC_2020_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        boolean[] seats = new boolean[1024]; // Some seats do not egsist;
        while (scn.hasNextLine())
        {
            int temp = 0;
            String line = scn.nextLine();
            int min = 0;
            int max = 127;
            for(int i = 0; i < 10; i = i + 1)
            {
                if(i < 7)
                {
                    if(line.charAt(i) == 'B')
                    {
                        if(min == 0)
                        {
                            min = (max + 1) / 2;
                        }
                        else
                        {
                            min = min + ((max - min + 1) / 2);
                        }
                    }
                    else if(line.charAt(i) == 'F')
                    {
                        max = max - ((max - min + 1) / 2);
                    }
                    
                    if(i == 6)
                    {
                        temp = min * 8;
                        min = 0;
                        max = 7;
                    }
                    /*
                    if(i == 6 && min != max)
                    {
                        System.out.print(min);
                        System.out.print(",");
                        System.out.print(max);
                        System.out.println("");
                    }
                    */
                }
                else if(i >= 7)
                {
                    if(line.charAt(i) == 'R')
                    {
                        if(min == 0)
                        {
                            min = (max + 1) / 2;
                        }
                        else
                        {
                            min = min + ((max - min + 1) / 2);
                        }
                    }
                    else if(line.charAt(i) == 'L')
                    {
                        max = max - ((max - min + 1) / 2);
                    }
                }
            }
            temp = temp + max;
            seats[temp] = true;
            //System.out.println(temp);
        }
        
        for(int i = 0; i < 1024; i = i + 1)
        {
            if(seats[i] == false)
            {
                System.out.println(i);
            }
        }
        
        System.out.println(answer);
    }
}