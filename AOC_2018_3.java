import java.util.*;
import java.io.*;

public class AOC_2018_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int size = 1000;
        int[][] cloth = new int[size][size];
        
        while (scn.hasNextLine())
        {
            
            String line = scn.nextLine();
            
            line = line.replace("#", "");
            
            line = line.replace(" @ ", ",");
            line = line.replace(": ", ",");
            line = line.replace("x", ",");
            
            String[] wordyNumbers = line.split(",");
            
            for(int i = 1; i <= Integer.parseInt(wordyNumbers[3]); i = i + 1) // Might need to change < to <=; i = 1 is goofy;
            {
                int x = i + Integer.parseInt(wordyNumbers[1]); 
                for(int j = 1; j <= Integer.parseInt(wordyNumbers[4]); j = j + 1) // Might need to change < to <=; i = 1 is goofy;
                {
                    int y = j + Integer.parseInt(wordyNumbers[2]); 
                    cloth[x][y] = cloth[x][y] + 1;
                }
            }
        }
        
        Scanner scnn = new Scanner(file);
        int inputLength = 1331;
        boolean[] lostClaim = new boolean[inputLength];
        int claimCount = 0;
        while (scnn.hasNextLine())
        {
            
            String line = scnn.nextLine();
            
            line = line.replace("#", "");
            
            line = line.replace(" @ ", ",");
            line = line.replace(": ", ",");
            line = line.replace("x", ",");
            
            String[] wordyNumbers = line.split(",");
            
            for(int i = 1; i <= Integer.parseInt(wordyNumbers[3]); i = i + 1) // Might need to change < to <=; i = 1 is goofy;
            {
                int x = i + Integer.parseInt(wordyNumbers[1]); 
                for(int j = 1; j <= Integer.parseInt(wordyNumbers[4]); j = j + 1) // Might need to change < to <=; i = 1 is goofy;
                {
                    int y = j + Integer.parseInt(wordyNumbers[2]); 
                    if(cloth[x][y] > 1)
                    {
                        lostClaim[claimCount] = true;
                    }
                }
            }
            claimCount = claimCount + 1;
        }
        
        for(int i = 0; i < inputLength; i = i + 1)
        {
            if(lostClaim[i] == false)
            {
                System.out.println(i);
            }
        }
        
        
    }
}