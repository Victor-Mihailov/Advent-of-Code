import java.util.*;
import java.io.*;

public class AOC_2023_9
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        while(scn.hasNextLine())
        {
            
            String[] line = scn.nextLine().split(" ");
            int[] sequence = new int[line.length];
            for(int i = 0; i < line.length; i = i + 1)
            {
                sequence[i] = Integer.parseInt(line[i]);
            }
            
            boolean done = false;
            int toltal = 0;
            int track = 0;
            while(done == false)
            {
                int[] newSequence = new int[sequence.length - 1];
                for(int i = 0; i < newSequence.length; i = i + 1)
                {
                    newSequence[i] = sequence[i + 1] - sequence[i];
                }
                if(track % 2 == 0)
                {
                    toltal = toltal + sequence[0];
                }
                else if(track % 2 == 1)
                {
                    toltal = toltal - sequence[0];
                }
                track = track + 1;
                
                boolean zCheck = false;
                for(int j = 0; j < sequence.length; j = j + 1)
                {
                    zCheck = false;
                    if(sequence[j] == 0)
                    {
                        zCheck = true;
                    }
                    else
                    {
                        break;
                    }
                }
                if(zCheck)
                {
                    done = true;
                }
                sequence = newSequence;
            }
            answer = answer + toltal;
        }
        
        System.out.println(answer);
    }
}