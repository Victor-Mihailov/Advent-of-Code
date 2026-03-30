import java.util.*;
import java.io.*;

public class AOC_2025_8
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        final int NOP = 1000;
        ArrayList<int[]> pointList = new ArrayList<int[]>();
        while (scn.hasNextLine())
        {
            String[] temp = scn.nextLine().split(",");
            int[] point = new int[temp.length];
            for(int i = 0; i < point.length; i = i + 1)
            {
                point[i] = Integer.parseInt(temp[i]);
            }
        }
        
        ArrayList<int[]> lineList = new ArrayList<int[]>();
        for(int i = 0; i < NOP; i = i + 1)
        {
            for(int j = 0; j < NOP - i; j = j + 1)
            {
                
            }
        }
        
        
        
        System.out.println(answer);
    }
}