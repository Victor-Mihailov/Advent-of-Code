import java.util.*;
import java.io.*;

public class AOC_2024_6
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int size = 130;
        
        boolean[][] filled = new boolean[size][size];
        boolean[][] rocks = new boolean[size][size];
        int answer = 0;
        
        int x = -1;
        int y = -1;
        int dir = 0;
        
        for(int i = 0; i < size; i = i + 1)
        {
            String scaned = scn.nextLine();
            for(int j = 0; j < size; j = j + 1)
            {
                if(scaned.charAt(j) == '#')
                {
                    rocks[i][j] = true;
                }
                else if(scaned.charAt(j) == '^')
                {
                    y = i;
                    x = j;
                }
            }
        }
        
        int ogx = x;
        int ogy = y;
        int ogdir = dir;
        for(int i = 0; i < size; i = i + 1)
        {
            for(int j = 0; j < size; j = j + 1)
            {
                if(rocks[i][j] || ogy == i && ogx == j)
                {
                    continue;
                }
                rocks[i][j] = true;
                int c = 0;
                x = ogx;
                y = ogy;
                dir = ogdir;
                while(x >= 0 && x < size && y >= 0 && y < size && c != 100000)
                {
                    filled[y][x] = true;
                    int oldX = x;
                    int oldY = y;
                    c = c + 1;
                    if(dir % 4 == 0)
                    {
                        y = y - 1;
                    }
                    else if(dir % 4 == 1)
                    {
                        x = x + 1;
                    }
                    else if(dir % 4 == 2)
                    {
                        y = y + 1;
                    }
                    else if(dir % 4 == 3)
                    {
                        x = x - 1;
                    }
                    
                    if(x >= 0 && x < size && y >= 0 && y < size && rocks[y][x])
                    {
                        x = oldX;
                        y = oldY;
                        dir = dir  + 1;
                    }
                }
                rocks[i][j] = false;
                if(c == 100000)
                {
                    answer = answer + 1;
                }
            }
        }
            
        /*
        for(int i = 0; i < size; i = i + 1)
        {
            for(int j = 0; j < size; j = j + 1)
            {
                if(filled[i][j])
                {
                    answer = answer + 1;
                }
            }
        }
        */
        System.out.println(answer);
    }
}
