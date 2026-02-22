import java.util.*;
import java.io.*;

public class AOC_2015_18
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int size = 100;
        boolean[][] onOff = new boolean[size][size];
        for(int i = 0; i < size; i = i + 1)
        {
            String line = scn.nextLine();
            for(int j = 0; j < size; j = j + 1)
            {
                if(line.charAt(j) == '#') // Changed input so the corners start on;
                {
                    onOff[i][j] = true;
                }
            }
        }
        
        for(int turn = 0; turn < size; turn = turn + 1)
        {
            boolean[][] toBeOnOff = new boolean[size][size];
            toBeOnOff[0][0] = true;
            toBeOnOff[0][size - 1] = true;
            toBeOnOff[size - 1][0] = true;
            toBeOnOff[size - 1][size - 1] = true;
            
            for(int i = 0; i < size; i = i + 1)
            {
                for(int j = 0; j < size; j = j + 1)
                {
                    int nabers = 0;
                    if(i != 0 && j != 0 && onOff[i - 1][j - 1] == true) // NW
                    {
                        nabers = nabers + 1;
                    }
                    if(i != 0 && onOff[i - 1][j] == true) // N
                    {
                        nabers = nabers + 1;
                    }
                    if(i != 0 && j != size - 1 && onOff[i - 1][j + 1] == true) // NE
                    {
                        nabers = nabers + 1;
                    }
                    if(j != size - 1 && onOff[i][j + 1] == true) // E
                    {
                        nabers = nabers + 1;
                    }
                    if(i != size - 1 && j != size - 1 && onOff[i + 1][j + 1] == true) // SE
                    {
                        nabers = nabers + 1;
                    }
                    if(i != size - 1 && onOff[i + 1][j] == true) // S
                    {
                        nabers = nabers + 1;
                    }
                    if(i != size - 1 && j != 0 && onOff[i + 1][j - 1] == true) // SW
                    {
                        nabers = nabers + 1;
                    }
                    if(j != 0 && onOff[i][j - 1] == true) // W
                    {
                        nabers = nabers + 1;
                    }
                    
                    if(onOff[i][j] == true && nabers == 2 || onOff[i][j] == true && nabers == 3 || onOff[i][j] == false && nabers == 3)
                    {
                        toBeOnOff[i][j] = true;
                    }
                }
            }
            
            for(int i = 0; i < size; i = i + 1)
            {
                for(int j = 0; j < size; j = j + 1)
                {
                    if(toBeOnOff[i][j])
                    {
                        onOff[i][j] = true;
                    }
                    else
                    {
                        onOff[i][j] = false;
                    }
                }
            }
        }
        
        for(int i = 0; i < size; i = i + 1)
        {
            for(int j = 0; j < size; j = j + 1)
            {
                if(onOff[i][j])
                {
                    answer = answer + 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}