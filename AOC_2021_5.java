import java.util.*;
import java.io.*;

public class AOC_2021_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[][] map = new int[1000][1000];
        
        while (scn.hasNextLine())
        {
            String scand = scn.nextLine();
            scand = scand.replace(",", " ");
            scand = scand.replace(" -> ", " ");
            
            String[] nums = scand.split(" ");
            int x1 = Integer.parseInt(nums[0]);
            int y1 = Integer.parseInt(nums[1]);
            int x2 = Integer.parseInt(nums[2]);
            int y2 = Integer.parseInt(nums[3]);
            
            if(x1 == x2)
            {
                if(y1 > y2)
                {
                    for(; y1 >= y2; y1 = y1 - 1)
                    {
                        map[x1][y1] = map[x1][y1] + 1;
                    }
                }
                else if(y1 < y2)
                {
                    for(; y1 <= y2; y1 = y1 + 1)
                    {
                        map[x1][y1] = map[x1][y1] + 1;
                    }
                }
            }
            else if(y1 == y2)
            {
                if(x1 > x2)
                {
                    for(; x1 >= x2; x1 = x1 - 1)
                    {
                        map[x1][y1] = map[x1][y1] + 1;
                    }
                }
                else if(x1 < x2)
                {
                    for(; x1 <= x2; x1 = x1 + 1)
                    {
                        map[x1][y1] = map[x1][y1] + 1;
                    }
                }
            }
            else
            {
                if(x1 > x2)
                {
                    if(y1 > y2)
                    {
                        for(; x1 >= x2 && y1 >= y2; x1 = x1 - 1 , y1 = y1 - 1)
                        {
                            map[x1][y1] = map[x1][y1] + 1;
                        }
                    }
                    else if(y1 < y2)
                    {
                        for(; x1 >= x2 && y1 <= y2; x1 = x1 - 1 , y1 = y1 + 1)
                        {
                            map[x1][y1] = map[x1][y1] + 1;
                        }
                    }
                }
                else if(x1 < x2)
                {
                    if(y1 > y2)
                    {
                        for(; x1 <= x2 && y1 >= y2; x1 = x1 + 1 , y1 = y1 - 1)
                        {
                            map[x1][y1] = map[x1][y1] + 1;
                        }
                    }
                    else if(y1 < y2)
                    {
                        for(; x1 <= x2 && y1 <= y2; x1 = x1 + 1 , y1 = y1 + 1)
                        {
                            map[x1][y1] = map[x1][y1] + 1;
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < 1000; i = i + 1)
        {
            for(int j = 0; j < 1000; j = j + 1)
            {
                if(map[i][j] >= 2)
                {
                    answer = answer + 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}
