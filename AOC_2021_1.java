import java.util.*;
import java.io.*;

public class AOC_2021_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int depthA = scn.nextInt();
        int depthB = scn.nextInt();
        int depthC = scn.nextInt();
        while (scn.hasNextLine())
        {
            
            int depthD = scn.nextInt();
            
            if (depthA + depthB + depthC < depthB + depthC + depthD)
            {
                answer += 1;
            }
            depthA = depthB;
            depthB = depthC;
            depthC = depthD;
        }
        
        System.out.println(answer);
    }
}
