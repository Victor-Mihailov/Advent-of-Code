import java.util.*;
import java.io.*;

public class AOC_2017_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int distR = 0;
        for(int n = 1; n * n < 325489; n = n + 2)
        {
            distR = n -17;//(325489 - n * n) - (3 * (n+1));
        }
        
        System.out.println(distR);
    }
}
