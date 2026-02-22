import java.util.*;
import java.io.*;

public class AOC_2016_6
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        char[][] letters = new char[650][8];
        String scaned;
        
        String code = "";
        
        for(int d = 0; d < 650; d = d + 1)
        {
            scaned = scn.nextLine();
            for(int l = 0; l < 8; l = l + 1)
            {
                letters[d][l] = scaned.charAt(l);
            }
        }
        
        for(int i = 0; i < 8; i = i + 1)
        {
            int[] num = new int[26];
            for(int j = 0; j < 650; j = j + 1)
            {
                // System.out.println("letter: " + letters[j][i]);
                for(int c = 0; c < 26; c = c + 1)
                {
                    if(letters[j][i] == 97 + c)
                    {
                        num[c] = num[c] + 1;
                        // System.out.println(c);
                    }
                }
            }
            
            int big = 99999;
            char colCode = '?';
            for(int k = 0; k < 26; k = k + 1)
            {
                if(num[k] < big && num[k] != 0)
                {
                    big = num[k];
                    colCode = (char) (k + 97);
                }
            }
            
            code = code + colCode; 
        }
        
        System.out.println(code);
    }
}