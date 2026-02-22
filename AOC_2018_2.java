import java.util.*;
import java.io.*;

public class AOC_2018_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        String[] codes = new String[250];
        for(int i = 0; i < 250; i = i + 1)
        {
            codes[i] = scn.nextLine();
        }
        
        
        for(int i = 0; i < 250; i = i + 1)
        {
            for(int j = 0; j < 250; j = j + 1)
            {
                int dei = 0;
                for(int k = 0; k < 26; k = k + 1)
                {
                    if(codes[i].charAt(k) != codes[j].charAt(k))
                    {
                        dei = dei + 1;
                    }
                }
                if(dei == 1)
                {
                    System.out.println(i);
                    System.out.println(j);
                    
                }
            }
        }
        
        
        /*
        int duble = 0;
        int trio = 0;
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            String scaned = scn.nextLine();
            int[] letters = new int[26];
            for(int i = 0; i < scaned.length(); i = i + 1)
            {
                
                for(int c = 0; c < 26; c = c + 1)
                {
                    if(scaned.charAt(i) == 97 + c)
                    {
                        letters[c] = letters[c] + 1;
                    }
                }
                
                
                
                
            }
            
            boolean flag = false;
            boolean flagg = false;
            
            for(int k = 0; k < 26; k = k + 1)
            {
                if(letters[k] == 2 && flag == false)
                {
                    duble = duble + 1;
                    flag = true;
                }
                System.out.println(trio);
                if(letters[k] == 3 && flagg == false)
                {
                    trio = trio + 1;
                    flagg = true;
                }
            }
            
        }
        
        System.out.println(duble * trio);
        */
    }
}