import java.util.*;
import java.io.*;

public class AOC_2023_6
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        // h for hold
        // g for go
        
        int race1 = 0;
        int race2 = 0;
        int race3 = 0;
        int race4 = 0;
        int race5 = 0;
        long answer = 0;
        
        for(long h = 38947970; h >= 0; h = h - 1)
        {
            long g = 38947970 - h;
            if(h * g >= 241154910741091l)
            {
                answer = answer + 1;
            }
        }
        
        /*
        for(int h = 38; h >= 0; h = h - 1)
        {
            int g = 38 - h;
            if(h * g > 241)
            {
                race1 = race1 + 1;
            }
        }
        
        for(int h = 94; h >= 0; h = h - 1)
        {
            int g = 94 - h;
            if(h * g > 1549)
            {
                race2 = race2 + 1;
            }
        }
        
        for(int h = 79; h >= 0; h = h - 1)
        {
            int g = 79 - h;
            if(h * g > 1074)
            {
                race3 = race3 + 1;
            }
        }
        
        for(int h = 70; h >= 0; h = h - 1)
        {
            int g = 70 - h;
            if(h * g > 1091)
            {
                race4 = race4 + 1;
            }
        }
        
        answer = race1 * race2 * race3 * race4;
        */
        System.out.println(answer);
    }
}
