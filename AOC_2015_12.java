import java.util.*;
import java.io.*;
// Part 2 is anoying but can be done;
public class AOC_2015_12
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        String line = scn.nextLine();
        String num = "";
        for(int i = 0; i < line.length(); i = i + 1)
        {
            if(line.charAt(i) == '-' || line.charAt(i) >= 48 && line.charAt(i) <= 57) // 48 is 0 char and 57 is the char for 9
            {
                num = num + line.charAt(i);
            }
            else
            {
                if(num.equals("") == false)
                {
                    answer = answer + Integer.parseInt(num);
                    num = "";
                }
            }
        }
        
        System.out.println(answer);
    }
}