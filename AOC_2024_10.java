import java.util.*;
import java.io.*;

public class AOC_2024_10
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int size = 45;
        int[][] hight = new int[size][size];
        ArrayList<Integer>[][] color = new ArrayList[size][size];
        int ID = 0;
        
        for(int i = 0; i < size; i = i + 1)
        {
            String line = scn.next();
            for(int j = 0; j < size; j = j + 1)
            {
                color[i][j] = new ArrayList<Integer>();
                hight[i][j] = Integer.parseInt(line.charAt(j) + "");
                if(hight[i][j] == 0)
                {
                    color[i][j].add(ID);
                    ID = ID + 1;
                }
            }
        }
        
        for(int round = 0; round < 9; round = round + 1)
        {
            for(int i = 0; i < size; i = i + 1)
            {
                for(int j = 0; j < size; j = j + 1)
                {
                    hight[i][j] = hight[i][j] - 1;
                }
            }
            
            for(int y = 0; y < size; y = y + 1)
            {
                for(int x = 0; x < size; x = x + 1)
                {
                    if(hight[y][x] == -1)
                    {
                        if(y != 0 && hight[y - 1][x] == 0)
                        {
                            for(Integer num : color[y][x])
                            {
                                color[y - 1][x].add(num);
                            }
                        }
                        if(y != size - 1 && hight[y + 1][x] == 0)
                        {
                            for(Integer num : color[y][x])
                            {
                                color[y + 1][x].add(num);
                            }
                        }
                        if(x != 0 && hight[y][x - 1] == 0)
                        {
                            for(Integer num : color[y][x])
                            {
                                color[y][x - 1].add(num);
                            }
                        }
                        if(x != size - 1 && hight[y][x + 1] == 0)
                        {
                            for(Integer num : color[y][x])
                            {
                                color[y][x + 1].add(num);
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < size; i = i + 1)
        {
            for(int j = 0; j < size; j = j + 1)
            {
                if(hight[i][j] == 0)
                {
                    answer = answer + color[i][j].size();
                }
            }
        }
        
        System.out.println(answer);
    }
}