import java.util.*;
import java.io.*;

public class AOC_2025_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        final int rn = 172;
        ArrayList<String> stuff = new ArrayList<String>();
        for(int l = 0; l < rn; l = l + 1)
        {
            stuff.add(scn.nextLine());
        } 
        boolean didy = true;
        while(didy)
        {
            didy = false;
            for(int i = 1; i < stuff.size(); i = i + 1)
            {
                long min = Math.min(Long.parseLong(stuff.get(i - 1).split("-")[0]), Long.parseLong(stuff.get(i).split("-")[0]));
                long max = Math.max(Long.parseLong(stuff.get(i - 1).split("-")[1]), Long.parseLong(stuff.get(i).split("-")[1]));
            }
        }
        
        
        /*
        scn.nextLine();
        while(scn.hasNextLine())
        {
            long n = Long.parseLong(scn.nextLine());
            boolean flag = false;
            for(int i = 0; i < rn; i = i + 1)
            {
                if(n >= Long.parseLong(stuff.get(i).split("-")[0]) && n <= Long.parseLong(stuff.get(i).split("-")[1]))
                {
                    flag = true;
                }
            }
            if(flag)
            {
                answer = answer + 1;
            }
        }
        */
        System.out.println(answer);
    }
    
    
}