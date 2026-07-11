import java.util.*;
import java.io.*;

public class AOC_2021_15
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[][] riskMap = new int[100][100];
        for(int y = 0; y < 100; y = y + 1)
        {
            String line = scn.nextLine();
            for(int x = 0; x < 100; x = x + 1)
            {
                riskMap[y][x] = line.charAt(x) - '0';
            }
        }
        
        int[][] riskToReachMap = new int[100][100];
        while(riskToReachMap[99][99] == 0)
        {
            
        }
        
        System.out.println(riskToReachMap[99][99]);
    }
}