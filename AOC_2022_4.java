import java.util.*;
import java.io.*;

public class AOC_2022_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            line = line.replace( ",", "-");
            
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter("-");
            
            //System.out.println(line);
            
            int num1 = lineScan.nextInt();
            int num2 = lineScan.nextInt();
            int num3 = lineScan.nextInt();
            int num4 = lineScan.nextInt();
            
            if(num1 <= num4 && num2 >= num3 || num3 <= num2 && num4 >= num1)
            {
                answer = answer + 1;
            }

        }
        
        System.out.println(answer);
    }
}
            
            //num1 = scn.nextInt()
            //num2 = scn.nextInt()
            //num3 = scn.nextInt()
            //num4 = scn.nextInt()