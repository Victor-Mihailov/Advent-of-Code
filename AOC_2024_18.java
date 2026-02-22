import java.util.*;
import java.io.*;

public class AOC_2024_18
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int size = 71;
        boolean[][] rock = new boolean[size][size];
        boolean flag = false;
        while(scn.hasNextLine() && flag == false)
        {
            answer = answer + 1;
            String line = scn.nextLine();
            String[] cords = line.split(",");
            rock[Integer.parseInt(cords[0])][Integer.parseInt(cords[1])] = true;
            
            boolean[][] filled = new boolean[size][size];
            boolean[][] toBeFilled = new boolean[size][size];
            int step = 0;
            filled[0][0] = true;
            while(filled[size - 1][size - 1] == false && step < 10000)
            {
                step = step + 1;
                for(int i = 0; i < size; i = i + 1)
                {
                    for(int j = 0; j < size; j = j + 1)
                    {
                        if(i != 0 && filled[i][j] && rock[i - 1][j] == false)
                        {
                            toBeFilled[i - 1][j] = true;
                        }
                        if(j != 0 && filled[i][j] && rock[i][j - 1] == false)
                        {
                            toBeFilled[i][j - 1] = true;
                        }
                        if(i != size - 1 && filled[i][j] && rock[i + 1][j] == false)
                        {
                            toBeFilled[i + 1][j] = true;
                        }
                        if(j != size - 1 && filled[i][j] && rock[i][j + 1] == false)
                        {
                            toBeFilled[i][j + 1] = true;
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
            if(filled[size - 1][size - 1] == false)
            {
                System.out.println(answer);
                flag = true;
            }
        }
            
        
        System.out.println();
    }
}