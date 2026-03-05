import java.util.*;
import java.io.*;

public class AOC_2025_7
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        int length = scn.nextLine().length();
        int width = 142;
        long[][] map = new long[length][width];
        
        
        for(int y = 0; y < width; y = y + 1)
        {
            String line = scn.nextLine();
            //System.out.println();
            for(int x = 0; x < length; x = x + 1)
            {
                map[x][y] = (line.charAt(x) == '^') ? -1 : map[x][y];
                map[x][y] = (line.charAt(x) == 'S') ? 1 : map[x][y];
                //System.out.print(map[x][y]);
            }
        }
        
        for(int y = 0; y < width - 1; y = y + 1)
        {
            //System.out.println(answer);
            for(int x = 0; x < length; x = x + 1)
            {
                System.out.print(map[x][y]);
                if (map[x][y] >= 1)
                {
                    if(map[x][y + 1] == -1) // broken?
                    {
                        map[x - 1][y + 1] = map[x - 1][y + 1] + map[x][y];
                        map[x + 1][y + 1] = map[x + 1][y + 1] + map[x][y];
                    }
                    else if(map[x][y + 1] >= 0)
                    {
                        map[x][y + 1] = map[x][y + 1] + map[x][y];
                    }
                }
                
            }
        }
        
        for(int x = 0; x < length; x = x + 1)
        {
            answer = answer + map[x][width - 1];
        }
        
        // code below is for bug fixxing
        
        for(int y = 0; y < width; y = y + 1)
        {
            System.out.println();
            for(int x = 0; x < length; x = x + 1)
            {
                if(map[x][y] == -1)
                {
                    System.out.print("^");
                }
                else if(map[x][y] == 0)
                {
                    System.out.print(".");
                }
                else if(map[x][y] < 10)
                {
                    System.out.print(map[x][y]);
                }
                else
                {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
        System.out.println(answer);
    }
}