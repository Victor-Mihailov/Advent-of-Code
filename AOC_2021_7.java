import java.util.*;
import java.io.*;

public class AOC_2021_7
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int fuel = Integer.MAX_VALUE;
        String scaned = scn.nextLine();
        String[] crab = scaned.split(",");
        int[] crabs = new int[crab.length];
        
        for(int i = 0; i < crab.length; i = i + 1)
        {
            crabs[i] = Integer.parseInt(crab[i]);
        }
        
        for(int pos = 0; pos <= 2000; pos = pos + 1)
        {
            int posFuel = 0;
            for(int i = 0; i < crab.length; i = i + 1)
            {
                posFuel = posFuel + (int)(((1 + Math.abs(crabs[i] - pos)) / 2.0) * Math.abs(crabs[i] - pos));
            }
            
            if(posFuel < fuel)
            {
                fuel = posFuel;
            }
            
            
        }
        System.out.println(fuel);
    }
}
