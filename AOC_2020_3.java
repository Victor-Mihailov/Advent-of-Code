import java.util.*;
import java.io.*;

public class AOC_2020_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        char[][] rode = new char[323][31];
        for(int i = 0; i < 323; i = i + 1)
        {
            String scaned = scn.next();
            for(int j = 0; j < 31; j = j + 1)
            {
                rode[i][j] = scaned.charAt(j);
            }
        }
        
        int h = 0;
        int l = 0;
        
        while(h < 323)
        {
            if(l > 30)
            {
                l = l - 31;
            }
            
            if(rode[h][l] == '#')
            {
                answer = answer + 1;
            }
            h = h + 2;
            l = l + 1;
        }
        
        System.out.println(answer);
    }
}