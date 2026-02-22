import java.util.*;
import java.io.*;

public class AOC_2024_8
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int size = 50;
        boolean[][] filled = new boolean[size][size];
        HashMap<String, ArrayList<int[]>> daMap = new HashMap<String, ArrayList<int[]>>();
        for(int i = 0; i < size; i = i + 1)
        {
            String line = scn.nextLine();
            for(int j = 0; j < size; j = j + 1)
            {
                if(line.substring(j, j  + 1).equals("."))
                {
                    
                }
                else 
                {
                    daMap.
                }
            }
        }
        
        System.out.println(answer);
    }
}