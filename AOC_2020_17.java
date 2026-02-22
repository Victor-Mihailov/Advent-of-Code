import java.util.*;
import java.io.*;

public class AOC_2020_17
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        boolean[][][][] grid = new boolean[22][22][15][15];
        for(int i = 0; i < 8; i = i + 1)
        {
            String line = scn.nextLine();
            for(int j = 0; j < 8; j = j + 1)
            {
                if(line.charAt(j) == '#')
                {
                    grid[j + 7][i + 7][0 + 7][7] = true; // + 7 is sus;
                }
            }
        }
        
        for(int cycle = 0; cycle < 6; cycle = cycle + 1)
        {
            boolean[][][][] temp = new boolean[22][22][15][15];
            for(int x = 1; x < 21; x = x + 1)
            {
                for(int y = 1; y < 21; y = y + 1)
                {
                    for(int z = 1; z <= 13; z = z + 1)
                    {
                        for(int w = 1; w <= 13; w = w + 1)
                        {
                            int nabers = 0;
                            for(int xd = -1; xd < 2; xd = xd + 1)
                            {
                                for(int yd = -1; yd < 2; yd = yd + 1)
                                {
                                    for(int zd = -1; zd < 2; zd = zd + 1)
                                    {
                                        for(int wd = -1; wd < 2; wd = wd + 1)
                                        {
                                            if(xd != 0 || yd != 0 || zd != 0 || wd != 0)
                                            {
                                                if(grid[x + xd][y + yd][z + zd][w + wd])
                                                {
                                                    nabers = nabers + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(nabers == 3 || (nabers == 2 && grid[x][y][z][w]))
                            {
                                temp[x][y][z][w] = true;
                            }
                        }
                    }
                }
            }
            grid = temp;
        }
        
        for(int x = 0; x <= 21; x = x + 1)
        {
            for(int y = 0; y <= 21; y = y + 1)
            {
                for(int z = 0; z <= 13; z = z + 1)
                {
                    for(int w = 0; w <= 13; w = w + 1)
                    {
                        if(grid[x][y][z][w])
                        {
                            answer = answer + 1;
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}