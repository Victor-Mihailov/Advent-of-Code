import java.util.*;
import java.io.*;

public class AOC_2021_11
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        System.out.println("hi");
        int answer = 0;
        int[][] map = new int[10][10];
        
        // an int[][] array of (y, x) offsets :: {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, etc. for all 8 directions}
        int[][] offsets = new int[8][2];
        offsets[0] = new int[]{-1, 0};
        offsets[1] = new int[]{-1, 1};
        offsets[2] = new int[]{0, 1};
        offsets[3] = new int[]{1, 1};
        offsets[4] = new int[]{1, 0};
        offsets[5] = new int[]{1, -1};
        offsets[6] = new int[]{0, -1};
        offsets[7] = new int[]{-1, -1};
        
        for(int y = 0; y < 10; y = y + 1)
        {
            String line = scn.nextLine();
            //System.out.println();
            for(int x = 0; x < 10; x = x + 1)
            {
                map[y][x] = line.charAt(x) - '0';
                //System.out.print(map[y][x]);
            }
        }
        
        for(int t = 0; t < 800; t = t + 1)
        {
            for(int y = 0; y < 10; y = y + 1)
            {
                //System.out.println();
                for(int x = 0; x < 10; x = x + 1)
                {
                    map[y][x] = map[y][x] + 1;
                    //System.out.print(map[y][x]);
                }
            }
            
            boolean[][] went = new boolean[10][10];
            boolean repeat = true;
            while(repeat)
            {
                repeat = false;
                
                for(int y = 0; y < 10; y = y + 1)
                {
                    for(int x = 0; x < 10; x = x + 1)
                    {
                        // for loop for each offset here!!!
                        for(int offsetIndex = 0; offsetIndex < offsets.length; offsetIndex = offsetIndex + 1)
                        {
                            int naborY = y + offsets[offsetIndex][0];
                            int naborX = x + offsets[offsetIndex][1];
                            
                            if(inBounds(naborY, naborX) == false || went[naborY][naborX])
                            {
                                continue;
                            }
                            if(map[y][x] > 9)
                            {
                                map[naborY][naborX] = map[naborY][naborX] + 1;
                            }
                            
                        }
                        
                        if(map[y][x] > 9)
                        {
                            went[y][x] = true;
                            map[y][x] = 0;
                            answer = answer + 1;
                            repeat = true;
                        }
                    }
                }
            }
            boolean allWent = true;
            for(int y = 0; y < 10; y = y + 1)
            {
                for(int x = 0; x < 10; x = x + 1)
                {
                    if(went[y][x] == false)
                    {
                        allWent = false;
                    }
                }
            }
            if(allWent)
            {
                System.out.println(t);
            }
            //System.out.println();
            //System.out.print(map[y][x]);
        }
        
        //System.out.println(answer);
    }
    
    // create an inBounds function (int x, int y) returns a boolean
    public static boolean inBounds (int y, int x)
    {
        if(x < 0 || y < 0 || x > 9 || y > 9)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}