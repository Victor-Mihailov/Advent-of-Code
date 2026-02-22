import java.util.*;
import java.io.*;

public class AOC_2015_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int x = 0;
        int y = 0;
        String cords = x + " " + y;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        String scaned = scn.nextLine();
        
        for(int i = 2; i <= scaned.length(); i = i + 2)
        {
            if(scaned.charAt(i - 2) == '>')
            {
                x = x + 1;
            }
            else if(scaned.charAt(i - 2) == '<')
            {
                x = x - 1;
            }
            else if(scaned.charAt(i - 2) == '^')
            {
                y = y + 1;
            }
            else if(scaned.charAt(i - 2) == 'v')
            {
                y = y - 1;
            }
            cords = x + " " + y;
            if(map.get(cords) == null)
            {
                map.put(cords, true);
                answer = answer + 1;
            }
        }
        
        x = 0;
        y = 0;
        for(int j = 2; j <= scaned.length(); j = j + 2)
        {
            if(scaned.charAt(j - 1) == '>')
            {
                x = x + 1;
            }
            else if(scaned.charAt(j - 1) == '<')
            {
                x = x - 1;
            }
            else if(scaned.charAt(j - 1) == '^')
            {
                y = y + 1;
            }
            else if(scaned.charAt(j - 1) == 'v')
            {
                y = y - 1;
            }
            cords = x + " " + y;
            if(map.get(cords) == null)
            {
                map.put(cords, true);
                answer = answer + 1;
            }
        }
        System.out.println(answer);
    }
}