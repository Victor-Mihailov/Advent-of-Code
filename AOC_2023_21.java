import java.util.*;
import java.io.*;

public class AOC_2023_21
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        final int size = 131;
        int answer = 0;
        boolean[][] rocks = new boolean[size][size];
        boolean[][] sick = new boolean[size][size];
        boolean[][] toBeSick = new boolean[size][size];
        
        for(int i = 0; i < size; i = i + 1)
        {
            String scand = scn.next();
            for(int j = 0; j < size; j = j + 1)
            {
                if(scand.charAt(j) == '#')
                {
                    rocks[i][j] = true;
                }
                if(scand.charAt(j) == 'S')
                {
                    sick[i][j] = true;
                }
            }
        }
                
        for(int step = 0; step < 64; step = step + 1)
        {
            for(int i = 0; i < size; i = i + 1)
            {
                for(int j = 0; j < size; j = j + 1)
                {
                    if(i != 0)
                    {
                        if(sick[i - 1][j] == true && rocks[i][j] == false)
                        {
                            toBeSick[i][j] = true;
                        }
                    }
                    if(i != size - 1)
                    {
                        if(sick[i + 1][j] == true && rocks[i][j] == false)
                        {
                            toBeSick[i][j] = true;
                        }
                    }
                    if(j != 0)
                    {
                        if(sick[i][j - 1] == true && rocks[i][j] == false)
                        {
                            toBeSick[i][j] = true;
                        }
                    }
                    if(j != size - 1)
                    {
                        if(sick[i][j + 1] == true && rocks[i][j] == false)
                        {
                            toBeSick[i][j] = true;
                        }
                    }
                }
            }
            
            sick = toBeSick;
            
            toBeSick = new boolean[size][size];
        }
        
        
        for(int i = 0; i < size; i = i + 1)
        {
           for(int j = 0; j < size; j = j + 1)
           {
               if(sick[i][j] == true)
               {
                   answer = answer + 1;
               }
           }
        }
        System.out.println(answer);
    }
}
