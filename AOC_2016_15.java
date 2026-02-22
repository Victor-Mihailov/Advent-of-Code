import java.util.*;
import java.io.*;

public class AOC_2016_15
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[] positions = new int[7];
        positions[6] = 11;
        int[] startP = new int[7];
        startP[6] = 0;
        for(int i = 1; i <= 6; i = i + 1)
        {
            String line = scn.nextLine();
            line = line.replace("Disc #" + i + " has " , "");
            line = line.replace(" positions; at time=0, it is at position ", " ");
            line = line.replace(".", "");
            
            String[] sTemp = line.split(" ");
            startP[i - 1] = Integer.parseInt(sTemp[1]);
            positions[i - 1] = Integer.parseInt(sTemp[0]);
        }
        boolean flag = false;
        while(flag == false)
        {
            for(int i = 0; i < 7; i = i + 1)
            {
                // gona need flag???
                if((startP[i] + i + 1 + answer) % positions[i] == 0)
                {
                    if(i == 6)
                    {
                        flag = true;
                    }
                }
                else
                {
                    break;
                }
            }
            answer = answer + 1;
        }
        
        System.out.println(answer - 1);
    }
}