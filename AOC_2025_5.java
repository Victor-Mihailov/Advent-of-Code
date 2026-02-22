import java.util.*;
import java.io.*;

public class AOC_2025_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        final int rn = 172;
        ArrayList<String> stuff = new ArrayList<String>();
        for(int l = 0; l < rn; l = l + 1)
        {
            String line = scn.nextLine();
            
            String[] newParts = line.split("-");
            
            for(int i = 0; i < stuff.size(); i = i + 1)
            {
                String[] oldParts = stuff.get(i).split("-");
                if(Integer.parseInt(newParts[0]) <= Integer.parseInt(oldParts[0]) 
                && Integer.parseInt(oldParts[0]) <= Integer.parseInt(newParts[1])
                && Integer.parseInt(newParts[1]) <= Integer.parseInt(oldParts[1]))
                {
                    
                }
            }
            
        }
        
        System.out.println(answer);
    }
}