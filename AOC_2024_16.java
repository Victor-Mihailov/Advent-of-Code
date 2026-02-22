import java.util.*;
import java.io.*;

public class AOC_2024_16
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int size = 15; // real size is 141;
        boolean[][] rocks = new boolean[size][size];
        boolean[][] filled = new boolean[size][size];
        int[][] dir = new int[size][size];
        int[][] money = new int[size][size];
        for(int i = 0; i < size; i = i + 1)
        {
            String line = scn.nextLine();
            for(int j = 0; j < size; j = j + 1)
            {
                if(line.charAt(j) == '#')
                {
                    rocks[i][j] = true;
                }
                else if(line.charAt(j) == 'S')
                {
                    filled[i][j] = true;
                    dir[i][j] = 1;
                }
            }
        }
        
        boolean[][] toBeFilled = new boolean[size][size];
        while(filled[1][13] == false) // Note: The end possion was atambed manuly, may be wrong; End is 1,139
        {
            answer = answer + 1;
            for(int i = 1; i < size - 1; i = i + 1)
            {
                for(int j = 1; j < size - 1; j = j + 1)
                {
                    if(filled[i][j] && money[i][j] == 1000)
                    {
                        if(rocks[i - 1][j] == false && filled[i - 1][j] == false)
                        {
                            toBeFilled[i - 1][j] = true;
                            dir[i - 1][j] = 0;
                        }
                        if(rocks[i][j + 1] == false && filled[i][j + 1] == false)
                        {
                            toBeFilled[i][j + 1] = true;
                            dir[i][j + 1] = 1;
                        }
                        if(rocks[i + 1][j] == false && filled[i + 1][j] == false)
                        {
                            toBeFilled[i + 1][j] = true;
                            dir[i + 1][j] = 2;
                        }
                        if(rocks[i][j - 1] == false && filled[i][j - 1] == false)
                        {
                            toBeFilled[i][j - 1] = true;
                            dir[i][j - 1] = 3;
                        }
                        
                        money[i][j] = 0;
                    }
                    else if(filled[i][j])
                    {
                        money[i][j] = money[i][j] + 1;
                        if(dir[i][j] == 0 && rocks[i - 1][j] == false && filled[i - 1][j] == false || dir[i][j] == -2 && rocks[i][j - 1] == false && filled[i][j - 1] == false) // Need to stop opisit dirs from making -2/cheak code dir;
                        {
                            
                            toBeFilled[i - 1][j] = true;
                            if(dir[i][j - 1] > -1)
                            {
                                dir[i][j - 1] = -2;
                            }
                            else
                            {
                                dir[i][j - 1] = 0;
                            }
                        }
                        if(dir[i][j] != dir[i - 1][j] && dir[i][j] != (dir[i - 1][j] + 2) % 4 && rocks[i - 1][j] == false && filled[i - 1][j])
                        {
                            dir[i - 1][j] = -2;
                        }
                        
                        if(dir[i][j] == 1 && rocks[i][j + 1] == false && filled[i][j + 1] == false || dir[i][j] == -2 && rocks[i][j - 1] == false && filled[i][j - 1] == false)
                        {
                            
                            toBeFilled[i][j + 1] = true;
                            if(dir[i][j - 1] > -1)
                            {
                                dir[i][j - 1] = -2;
                            }
                            else
                            {
                                dir[i][j - 1] = 1;
                            }
                        }
                        if(dir[i][j] != dir[i][j - 1] && dir[i][j] != (dir[i][j - 1] + 2) % 4 && rocks[i][j - 1] == false && filled[i][j + 1])
                        {
                            dir[i][j - 1] = -2;
                        }
                        
                        if(dir[i][j] == 2 && rocks[i + 1][j] == false && filled[i + 1][j] == false || dir[i][j] == -2 && rocks[i][j - 1] == false && filled[i][j - 1] == false)
                        {
                            
                            toBeFilled[i + 1][j] = true;
                            if(dir[i][j - 1] > -1)
                            {
                                dir[i][j - 1] = -2;
                            }
                            else
                            {
                                dir[i][j - 1] = 2;
                            }
                        }
                        if(dir[i][j] != dir[i + 1][j] && dir[i][j] != (dir[i + 1][j] + 2) % 4 && rocks[i + 1][j] == false && filled[i + 1][j])
                        {
                            dir[i + 1][j] = -2;
                        }
                        
                        if(dir[i][j] == 3 && rocks[i][j - 1] == false && filled[i][j - 1] == false || dir[i][j] == -2 && rocks[i][j - 1] == false && filled[i][j - 1] == false)
                        {
                            
                            toBeFilled[i][j - 1] = true;
                            if(dir[i][j - 1] > -1)
                            {
                                dir[i][j - 1] = -2;
                            }
                            else
                            {
                                dir[i][j - 1] = 3;
                            }
                        }
                        if(dir[i][j] != dir[i][j - 1] && dir[i][j] != (dir[i][j - 1] + 2) % 4 && filled[i][j - 1] && rocks[i][j - 1] == false)
                        {
                            dir[i][j - 1] = -2;
                        }
                        
                    }
                }
            }
            
            for(int i = 0; i < size; i = i + 1)
            {
                for(int j = 0; j < size; j = j + 1)
                {
                    if(toBeFilled[i][j])
                    {
                        filled[i][j] = true;
                    }
                }
            }
            
        }
        
        System.out.println(answer);
    }
}