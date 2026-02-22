import java.util.*;
import java.io.*;

public class AOC_2024_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        int[] left = new int[1000];
        int[] right = new int[1000];
        
        for(int i = 0; i < 1000; i = i + 1)
        {
            left[i] = Integer.parseInt(scn.next());
            right[i] = Integer.parseInt(scn.next());
        }
        
        for(int i = 0; i < 1000; i = i + 1)
        {
            int ls = 0;
            int rs = 0;
            for(int l = 0; l < 1000; l = l + 1)
            {
                if(left[l] == left[i])
                {
                    ls = ls + 1;
                }
            }
            for(int r = 0; r < 1000; r = r + 1)
            {
                if(right[r] == left[i])
                {
                    rs = rs + 1;
                }
            }
            
            answer = answer + (rs * left[i]);
            
            /*
            if(rs < ls)
            {
                answer = answer + (rs * left[i]);
            }
            else if(ls < rs)
            {
                answer = answer + (ls * left[i]);
            }
            else
            {
                answer = answer + (rs * left[i]);
            }
                
            
            
            /*
            int smallL = 999999999;
            int smallR = 999999999;
            for(int l = 0; l < 1000; l = l + 1)
            {
                if(left[l] < smallL)
                {
                    smallL = left[l];
                }
            }
            for(int r = 0; r < 1000; r = r + 1)
            {
                if(right[r] < smallR)
                {
                    smallR = right[r];
                }
            }
            
            answer = answer + Math.abs(smallL - smallR);
            
            boolean flagL = false;
            boolean flagR = false;
            for(int c = 0; c < 1000; c = c + 1)
            {
                if(left[c] == smallL && flagL == false)
                {
                    left[c] = 999999999;
                    flagL = true;
                }
                if(right[c] == smallR && flagR == false)
                {
                    right[c] = 999999999;
                    flagR = true;
                }
            }
            */
        }
        
        System.out.println(answer);
    }
}
