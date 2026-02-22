import java.util.*;
import java.io.*;

public class AOC_2015_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            String scaned = scn.nextLine();
            /*
            int valose = 0;
            
            for(int i = 0; i < scaned.length(); i = i + 1)
            {
                if(scaned.charAt(i) == 97 || scaned.charAt(i) == 101 || scaned.charAt(i) == 105 || scaned.charAt(i) == 111 || scaned.charAt(i) == 117)
                {
                    valose = valose + 1;
                }
            }
            */
            boolean good = false;
            
            for(int k = 2; k < scaned.length(); k = k + 1)
            {
                if(scaned.charAt(k - 2) == scaned.charAt(k))
                {
                    good = true;
                }
            }
            
            boolean goody = false;
            for(int a = 0; a < scaned.length(); a = a + 1)
            {
                for(int b = 0; b < scaned.length(); b = b + 1)
                {
                    for(int c = 0; c < scaned.length(); c = c + 1)
                    {
                        for(int d = 0; d < scaned.length(); d = d + 1)
                        {
                            if(scaned.charAt(a) == scaned.charAt(c) && scaned.charAt(b) == scaned.charAt(d) && a == b - 1 && c == d - 1 && a != c && a != d && b != c && b != d)
                            {
                                goody = true;
                            }
                        }
                    }
                }
            }
            /*
            boolean bad = false;
            
            for(int j = 1; j < scaned.length(); j = j + 1)
            {
                if(scaned.charAt(j - 1) == scaned.charAt(j) - 1)
                {
                    if(scaned.charAt(j - 1) == 97 && scaned.charAt(j) == 98)
                    {
                        bad = true;
                    }
                    else if(scaned.charAt(j - 1) == 99)
                    {
                        bad = true;
                    }
                    else if(scaned.charAt(j - 1) == 112)
                    {
                        bad = true;
                    }
                    else if(scaned.charAt(j - 1) == 'x')
                    {
                        bad = true;
                    }                    
                }
            }
            */
            
            if(good == true && goody == true)
            {
                answer = answer + 1;
            }
        }
        
        System.out.println(answer);
    }
}