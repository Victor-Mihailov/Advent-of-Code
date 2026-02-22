import java.util.*;
import java.io.*;

public class AOC_2022_12
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int iSize = 41;
        int jSize = 181;
        int[][] hight = new int[iSize][jSize];
        boolean[][] filled = new boolean[iSize][jSize];
        
        for(int i = 0; i < iSize; i = i + 1)
        {
            String scanedLine = scn.next();
            for(int j = 0; j < jSize; j = j + 1)
            {
                hight[i][j] = scanedLine.charAt(j);
                if(hight[i][j] == 'E')
                {
                    hight[i][j] = 'z';
                }
                else if(hight[i][j] == 'S')
                {
                    hight[i][j] = 'a';
                    filled[i][j] = true;
                    //System.out.println(i);
                    //System.out.println(j);
                }
                else if(hight[i][j] == 'a')
                {
                    filled[i][j] = true;
                }
            }
        }
        
        int step = 0;
        
        while(filled[20][158] == false)
        {
            printMap(filled);
            
            step = step + 1;
            //System.out.println(step);
            //System.out.println(filled[20][158]);
            boolean[][] toBeFilled = new boolean[iSize][jSize];
            for(int i = 0; i < iSize; i = i + 1)
            {
                for(int j = 0; j < jSize; j = j + 1)
                {
                    if(i != 0)
                    {
                        if(filled[i - 1][j] == true && hight[i][j] <= hight[i - 1][j] + 1)
                        {
                            toBeFilled[i][j] = true;
                            //System.out.println("u");
                            //System.out.println(step);
                        }
                    }
                    if(i != iSize - 1)
                    {
                        if(filled[i + 1][j] == true && hight[i][j] <= hight[i + 1][j] + 1)
                        {
                            toBeFilled[i][j] = true;
                            //System.out.println("d");
                            //System.out.println(step);
                        }
                    }
                    if(j != 0)
                    {
                        if(filled[i][j - 1] == true && hight[i][j] <= hight[i][j - 1] + 1)
                        {
                            toBeFilled[i][j] = true;
                            //System.out.println("l");
                            //System.out.println(step);
                        }
                    }
                    if(j != jSize - 1)
                    {
                        if(filled[i][j + 1] == true && hight[i][j] <= hight[i][j + 1] + 1)
                        {
                            toBeFilled[i][j] = true;
                            //System.out.println("r");
                            //System.out.println(step);
                        }
                    }
                }
            }
            
            filled = toBeFilled;
        }
        
        
        
        
        System.out.println(step);
    }
    
    public static void printMap(boolean[][] map)
    {
        for (int y = 0 ; y < map.length; y++)
        {
            System.out.println();
            for (int x = 0; x < map[y].length; x++)
            {
                if (map[y][x])
                {
                    System.out.print("#");
                }
                else
                {
                    System.out.print(".");
                }
            }
        }
        System.out.println();
    }
}