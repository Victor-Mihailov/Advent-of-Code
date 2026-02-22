import java.util.*;
import java.io.*;

public class AOC_2019_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        
        while (scn.hasNextLine())
        {
            String scanned = scn.nextLine();
            int num = Integer.parseInt(scanned);
            
            while(num > 6)
            {
                boolean flag = true;
                while (flag == true)
                {
                    if( num % 3 == 0)
                    {
                        num = num / 3 - 2;
                        answer = num + answer;
                        flag = false;
                    }
                    else
                    {
                        num = num - 1;
                    }
                }  
            }
        }
        
        System.out.println(answer);
    }
}