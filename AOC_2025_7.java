import java.util.*;
import java.io.*;

public class AOC_2025_7
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int length = scn.nextLine().length();
        int width = 142;
        int[][] map = new int[length][width];
        
        
        for(int y = 0; y < width; y = y + 1)
        {
            String line = scn.nextLine();
            //System.out.println();
            for(int x = 0; x < length; x = x + 1)
            {
                map[x][y] = (line.charAt(x) == '^') ? 1 : map[x][y];
                map[x][y] = (line.charAt(x) == 'S') ? 2 : map[x][y];
                //System.out.print(map[x][y]);
            }
        }
        
        for(int y = 0; y < width; y = y + 1)
        {
            System.out.println();
            for(int x = 0; x < 0; x = x + 1)
            {
                System.out.print(map[x][y]);
                if (map[x][y] != 2)continue;
                
                if(map[x][y - 1] == 1)
                {
                    map[x - 1][y - 1] = 2;
                    map[x + 1][y - 1] = 2;
                    answer = answer + 1;
                }
                else
                {
                    map[x][y - 1] = 2;
                }
            }
        }
        
        System.out.println(answer);
    }
}