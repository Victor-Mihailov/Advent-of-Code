import java.util.*;
import java.io.*;

public class AOC_2015_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            Scanner scnL = new Scanner(scn.nextLine());
            scnL.useDelimiter("x");
            int l = scnL.nextInt();
            int w = scnL.nextInt();
            int h = scnL.nextInt();
            int small = Integer.MIN_VALUE;
            
            if(l > small)
            {
                small = l;
            }
            if(w > small)
            {
                small = w;
            }
            if(h > small)
            {
                small = h;
            }
            //small = (l * w * h) / small;
            //answer = answer + small + (2 * l * w) + (2 * w * h) + (2 * h * l);
            answer = answer + l * w * h + 2 * h + 2 * w + 2 * l - 2 * small;
        }
        
        System.out.println(answer);
    }
}