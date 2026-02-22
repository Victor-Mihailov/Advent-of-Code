import java.util.*;
import java.io.*;

public class AOC_2024_22
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        
        while (scn.hasNextLine())
        {
            long s = Integer.parseInt(scn.next());
            for(int i = 0; i < 2000; i = i + 1)
            {
                s = (((s * 64)^s) % 16777216);
                s = (((s / 32)^s) % 16777216);
                s = (((s * 2048)^s) % 16777216);
            }
            answer = answer + s;
        }
        
        System.out.println(answer);
    }
}