import java.util.*;
import java.io.*;

public class AOC_2021_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int counter0 = 0;
        int counter1 = 0;
        int answer = 0;
        int[][] code = new int[12][1000];
        
        for(int i = 0; i < 1000; i = i + 1)
        {
            String scaned = scn.nextLine();
            for(int j = 0; j < 12; j = j + 1)
            {
                
                code[j][i] = scaned.charAt(j) - '0';

            }
        }
        
        for(int n = 0; n < 12; n = n + 1)
        {
            for(int m = 0; m < 1000; m = m + 1)
            {
                if(code[n][m] == 1)
                {
                    counter1 = counter1 + 1;
                }
                else if(code[n][m] == 0)
                {
                    counter0 = counter0 + 1;
                }
            }
            if(counter1 > counter0 && counter1 != 1)
            {
                for(int t = 0; t < 1000; t = t + 1)
                {
                    if(code[n][t] == 1)
                    {
                        for(int f = 0; f < 12; f = f + 1)
                        {
                            code[f][t] = 2;
                        }
                    }
                }
            }
            else if(counter0 > counter1 && counter0 != 1)
            {
                for(int t = 0; t < 1000; t = t + 1)
                {
                    if(code[n][t] == 0)
                    {
                        for(int f = 0; f < 12; f = f + 1)
                        {
                            code[f][t] = 2;
                        }
                    }
                }
            }
            else 
            {
                for(int t = 0; t < 1000; t = t + 1)
                {
                    if(code[n][t] == 1)
                    {
                        for(int f = 0; f < 12; f = f + 1)
                        {
                            code[f][t] = 2;
                        }
                    }
                }
            }
            counter1 = 0;
            counter0 = 0;
        }
        
        for(int i = 0; i < 1000; i = i + 1)
        {
            for(int j = 0; j < 12; j = j + 1)
            {
                if(code[j][i] != 2)
                {
                    System.out.print(code[j][i]);
                }
            }
        }
        
    }
}