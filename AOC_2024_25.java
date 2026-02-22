import java.util.*;
import java.io.*;

public class AOC_2024_25
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        boolean[][][] filled = new boolean[500][7][5];
    
        for(int l = 0; l < 500; l = l + 1)
        {
            for(int i = 0; i < 7; i = i + 1)
            {
                String line = scn.nextLine();
                for(int j = 0; j < 5; j = j + 1)
                {
                    if(line.charAt(j) == '#')
                    {
                        filled[l][i][j] = true;
                    }
                }
            }
            scn.nextLine();
        }
        
        for(int com = 0; com < 500; com = com + 1)
        {
            for(int l = com + 1; l < 500; l = l + 1)
            {
                boolean flag = false;
                for(int i = 0; i < 7; i = i + 1)
                {
                    for(int j = 0; j < 5; j = j + 1)
                    {
                        if(filled[com][i][j] == true && filled[l][i][j] == true)
                        {
                            flag = true;
                        }
                    }
                }
                if(flag == false)
                {
                    answer = answer + 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}