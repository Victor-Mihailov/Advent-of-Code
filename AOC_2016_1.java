import java.util.*;
import java.io.*;

public class AOC_2016_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int x = 0;
        int y = 0;
        int dir = 1;
        String cords = x + " " + y;
        scn.useDelimiter(", ");
        HashMap <String, String> pount = new HashMap <String, String> ();
        
        while (scn.hasNext())
        {
            String line = scn.next();
            
            if(line.substring(0, 1).equals("L")) 
            {
                if(dir == 1)
                {
                   dir = 4;
                }
                else
                {
                    dir = dir - 1;
                }
            }
            else
            {
                if(dir == 4)
                {
                    dir = 1;
                }
                else
                {
                    dir = dir + 1;
                }
            }
            
            if(dir == 1)
            {
                for(int n = 0; n < Integer.parseInt(line.substring(1)); n = n + 1)
                {
                    y = y + 1;
                    cords = x + " " + y;
                    System.out.println(pount.get(cords));
                    pount.put(cords, cords);
                }
            }
            else if(dir == 2)
            {
                for(int n = 0; n < Integer.parseInt(line.substring(1)); n = n + 1)
                {
                    x = x + 1;
                    cords = x + " " + y;
                    System.out.println(pount.get(cords));
                    pount.put(cords, cords);
                }
            }
            else if(dir == 3)
            {
                for(int m = Integer.parseInt(line.substring(1)); m > 0; m = m - 1)
                {
                    y = y - 1;
                    cords = x + " " + y;
                    System.out.println(pount.get(cords));
                    pount.put(cords, cords);
                }
            }
            else if(dir == 4)
            {
                for(int n = Integer.parseInt(line.substring(1)); n > 0; n = n - 1)
                {
                    x = x - 1;
                    cords = x + " " + y;
                    System.out.println(pount.get(cords));
                    pount.put(cords, cords);
                }
            }
        }
        
    }
}
