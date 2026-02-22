import java.util.*;
import java.io.*;

public class AOC_2022_24
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        
        int iSize = 27;
        int jSize = 122;
        boolean[][] rock = new boolean[iSize][jSize];
        boolean[][] right = new boolean[iSize][jSize];
        boolean[][] left = new boolean[iSize][jSize];
        boolean[][] up = new boolean[iSize][jSize];
        boolean[][] down = new boolean[iSize][jSize];
        // add the stuff for each rock
        for(int i = 0; i < 27; i = i + 1)
        {
            String scand = scn.next();
            for(int j = 0; j < 122; j = j + 1)
            {
                if(scand.charAt(j) == '#')
                {
                    rock[i][j] = true;
                }
                else if(scand.charAt(j) == '<')
                {
                    left[i][j] = true;
                }
                else if(scand.charAt(j) == '>')
                {
                    right[i][j] = true;
                }
                else if(scand.charAt(j) == '^')
                {
                    up[i][j] = true;
                }
                else if(scand.charAt(j) == 'v')
                {
                    down[i][j] = true;
                }
            }
        }
        
        boolean[][] filled = new boolean[iSize][jSize];
        filled[0][1] = true;
        
        int steps = 0;
        while(filled[26][120] == false)
        {
            steps = steps + 1;
            for(int i = 0; i < iSize; i = i + 1)
            {
                for(int j = 0; j < jSize; j = j + 1)
                {
                    if(i != 0 && rock[i][j] != true && filled[i - 1][j] == true)//down
                    {
                        
                    }
                    if(i != iSize - 1 && rock[i][j] != true && filled[i + 1][j] == true)//up
                    {
                        
                    }
                    if(j != 0 && rock[i][j] != true && filled[i][j - 1] == true)//right
                    {
                        
                    }
                    if(j != jSize - 1 && rock[i][j] != true && filled[i][j + 1] == true)//left
                    {
                        
                    }
                    // not moving here
                    
                    if(j != 0 && right[i][j - 1] == true)
                    {
                        
                    }
                    if(j != jSize - 1 && left[i][j + 1] == true)
                    {
                        
                    }
                }
            }
        
            // get rid of the bad stuff
            System.out.println(steps);
        }
    }
}