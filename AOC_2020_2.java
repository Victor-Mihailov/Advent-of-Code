import java.util.*;
import java.io.*;

public class AOC_2020_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            String scaned = scn.next();
            scaned = scaned.replace("-" , " " );
            
            Scanner scan = new Scanner(scaned);
            scaned = scan.next();
            
            int min = Integer.parseInt(scaned);
            
            scaned = scan.next();
            
            int max = Integer.parseInt(scaned);
            
            scaned = scn.next();
            
            scaned = scaned.replace(":" , "");
            
            char letter = scaned.charAt(0);
            
            //scaned = scn.next();
            
            String code = scn.next();
            
            int counter = 0;
            
            if(code.charAt(min - 1) == letter)
            {
                counter = counter + 1;
            }
            if(code.charAt(max - 1) == letter)
            {
                counter = counter + 1;
            }
            
            if (counter == 1)
            {
                answer = answer + 1;
            }
            
            /*
            for(int i = 0; i < code.length(); i = i + 1)
            {
                if(code.charAt(i) == letter)
                {
                    counter = counter + 1;
                }
            }
            
            if(counter >= min && counter <= max)
            {
                answer = answer + 1;
            }
            */
        }
        
        System.out.println(answer);
    }
}