import java.util.*;
import java.io.*;

public class AOC_2019_8
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        int layer = 0;
        int with = 25;
        int depth = 6;
        int layerSize = with * depth;
        
        boolean done = false;
        
        String line = scn.nextLine();
        
        boolean[][] cords = new boolean[with][depth];
        int[][] toBePrint = new int[with][depth];
        while(done == false)
        {
            int counter = 0;
            for(int i = 0; i < depth; i = i + 1)
            {
                for(int j = 0; j < with; j = j + 1)
                {
                    
                    if(line.charAt(layer * layerSize + counter) == '0' && cords[j][i] == false)
                    {
                        cords[j][i] = true;
                        toBePrint[j][i] = 0; // Unnesisiary;
                    }
                    else if(line.charAt(layer * layerSize + counter) == '1' && cords[j][i] == false)
                    {
                        cords[j][i] = true;
                        toBePrint[j][i] = 1;
                    }
                    counter = counter + 1; // might be broken;
                }
            }
            
            layer = layer + 1;
            if(layer * layerSize + layerSize - 1 >= line.length())//layerSize - 1 is goofy;
            {
                done = true;
            }
        }
        
        for(int i = 0; i < depth; i = i + 1)
        {
            for(int j = 0; j < with; j = j + 1)
            {
                System.out.print(toBePrint[j][i] == 1 ? "X" : " ");
                
            }
            System.out.println();
        }
        
    }
}