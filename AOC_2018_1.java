import java.util.*;
import java.io.*;

public class AOC_2018_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        boolean flag = false;
        
        while (flag == false)
        {
            if(scn.hasNextLine() == false)
            {
                scn = new Scanner(file);
            }
            
            String scaned = scn.nextLine();
            if(scaned.charAt(0) == '+')
            {
                answer = answer + Integer.parseInt(scaned.substring(1));
            }
            else if(scaned.charAt(0) == '-')
            {
                answer = answer - Integer.parseInt(scaned.substring(1));
            }
            
            if(numbers.contains(answer) == true)
            {
                flag = true;
            }
            numbers.add(answer);
            
            //System.out.println(answer);
            
        }
        
        System.out.println(answer);
    }
}
