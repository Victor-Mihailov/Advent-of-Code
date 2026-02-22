import java.util.*;
import java.io.*;

public class AOC_2024_20
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int size = 141;
        boolean[][] rocks = new boolean[size][size];
        int[][] time = new int[size][size];
        
        int x = 0;
        int y = 0;
        int ogx = 0;
        int ogy = 0;
        for(int i = 0; i < size; i = i + 1)
        {
            String line = scn.nextLine();
            for(int j = 0; j < size; j = j + 1)
            {
                if(line.charAt(j) == '#')
                {
                    rocks[i][j] = true;
                    time[i][j] = -1;
                }
                else if(line.charAt(j) == 'S')
                {
                    y = i;
                    x = j;
                    ogy = y;
                    ogx = x;
                    time[i][j] = 0;
                }
                else
                {
                    time[i][j] = -1;
                }
            }
        }
        // May need to change x y stuff;
        boolean flag = false;
        int c = 0;
        while(flag == false)
        {
            c = c + 1;
            if(time[y - 1][x] == -1 && rocks[y - 1][x] == false) // up
            {
                time[y - 1][x] = c;
                y = y - 1;
            }
            else if(time[y + 1][x] == -1 && rocks[y + 1][x] == false) // down
            {
                time[y + 1][x] = c;
                y = y + 1;
            }
            else if(time[y][x - 1] == -1 && rocks[y][x - 1] == false) // left
            {
                time[y][x - 1] = c;
                x = x - 1;
            }
            else if(time[y][x + 1] == -1 && rocks[y][x + 1] == false) // right
            {
                time[y][x + 1] = c;
                x = x + 1;
            }
            else
            {
                flag = true;
            }
        }
        
        flag = false;
        int tel = 2;
        int dir = -1;
        y = ogy;
        x = ogx;
        while(flag == false)
        {
            System.out.println(x + ", " + y + ": " + time[y][x]);
            
            for(int i = -20; i <= 20; i = i + 1)
            {
                for(int j = -20; j <= 20; j = j + 1)
                {
                    if(Math.abs(i) + Math.abs(j) <= 20)
                    {
                        if(y + i >= 0 && y + i < size && x + j >= 0 && x + j < size && time[i + y][j + x] - time[y][x] >= 100 + Math.abs(i) + Math.abs(j) && rocks[i + y][j + x] == false)
                        {
                            answer = answer + 1;
                        }
                    }
                }
            }
            
            
            
            /*
            if(y - tel >= 0 && time[y - tel][x] - time[y][x] >= 100 + tel && rocks[y - tel][x] == false)
            {
                answer = answer + 1;
            }
            if(y + tel < size && time[y + tel][x] - time[y][x] >= 100 + tel && rocks[y + tel][x] == false)
            {
                answer = answer + 1;
            }
            if(x - tel >= 0 && time[y][x - tel] - time[y][x] >= 100 + tel && rocks[y][x - tel] == false)
            {
                answer = answer + 1;
            }
            if(x + tel < size && time[y][x + tel] - time[y][x] >= 100 + tel && rocks[y][x + tel] == false)
            {
                answer = answer + 1;
            }
            */
            if(rocks[y - 1][x] == false && dir != 2) // up
            {
                dir = 0;
                y = y - 1;
            }
            else if(rocks[y + 1][x] == false && dir != 0) // down
            {
                dir = 2;
                y = y + 1;
            }
            else if(rocks[y][x - 1] == false && dir != 1) // left
            {
                dir = 3;
                x = x - 1;
            }
            else if(rocks[y][x + 1] == false && dir != 3) // right
            {
                dir = 1;
                x = x + 1;
            }
            else
            {
                flag = true;
            }
        }
        
        System.out.println(answer);
    }
}