import java.util.*;
import java.io.*;

public class AOC_2024_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int l = 0;
        boolean[] lines = new boolean[1000];
        while (scn.hasNextLine())
        {
            l = l + 1;
            String line = scn.nextLine();
            
            String[] arr = line.split(" ");
            boolean supFlag = false;
            for(int i = 0; i <= arr.length; i = i + 1)
            {
                line = "";
                for(int j = 0; j < arr.length; j = j + 1)
                {
                    if(i != j)
                    {
                        line = line + arr[j] + " "; // extra space on end - may brake everything; 
                    }
                }
                
                Scanner scan = new Scanner(line);
                String scaned = scan.next();
                String scaned2 = scan.next();
                boolean safe = true;
                boolean up = true;
                boolean down = true;
                if(Integer.parseInt(scaned) == Integer.parseInt(scaned2))
                {
                    down = false;
                    up = false;
                }
                if(Integer.parseInt(scaned) > Integer.parseInt(scaned2))
                {
                    up = false;
                    
                }
                if(Integer.parseInt(scaned) < Integer.parseInt(scaned2))
                {
                    down = false;
                }
                
                while (scan.hasNext() && safe == true)
                {
                    safe = false;
                    if(up == true && Integer.parseInt(scaned2) - Integer.parseInt(scaned) >= 1 && Integer.parseInt(scaned2) - Integer.parseInt(scaned) <= 3)
                    {
                        safe = true;
                    }
                    if(down == true && Integer.parseInt(scaned) - Integer.parseInt(scaned2) >= 1 && Integer.parseInt(scaned) - Integer.parseInt(scaned2) <= 3)
                    {
                        safe = true;
                    }
                    scaned = scaned2;
                    //System.out.println(Integer.parseInt(scaned));    
                    scaned2 = scan.next();
                }
                if(safe == true)
                {
                    safe = false;
                    if(up == true && Integer.parseInt(scaned2) - Integer.parseInt(scaned) >= 1 && Integer.parseInt(scaned2) - Integer.parseInt(scaned) <= 3)
                    {
                        safe = true;
                    }
                    if(down == true && Integer.parseInt(scaned) - Integer.parseInt(scaned2) >= 1 && Integer.parseInt(scaned) - Integer.parseInt(scaned2) <= 3)
                    {
                        safe = true;
                    }
                }
                if(safe == true && supFlag == false)
                {
                    answer = answer + 1;
                    lines[l-1] = true;
                    supFlag = true;
                }
            }
            
                
        }
        
        
        System.out.println(answer);
    }
}
