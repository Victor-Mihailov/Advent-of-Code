import java.util.*;
import java.io.*;

public class AOC_2015_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        String map = scn.nextLine();
        
        int level = 0;
        for(int i = 0; i < map.length(); i++)
        {
            if (map.charAt(i) == '(')
            {
                level++;
            }
            else
            {
                level--;
            }
            if (level == -1)
            {
                System.out.println(i + 1);
            }
            
        }
    }
}
