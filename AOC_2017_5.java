import java.util.*;
import java.io.*;

public class AOC_2017_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[] direc = new int[1074];
        for(int i = 0; i < 1074; i = i + 1)
        {
            direc[i] = scn.nextInt();
        }
        int position = 0;
        while(position < 1074)
        {
            if(direc[position] < 3)
            {
               direc[position] = direc[position] + 1; 
               position = direc[position] + position - 1;
            }
            else
            {
                direc[position] = direc[position] - 1; 
               position = direc[position] + position + 1;
            }
            
            answer = answer + 1;
        }
        System.out.println(answer);
    }
}
