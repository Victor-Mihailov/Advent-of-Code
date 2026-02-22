import java.util.*;
import java.io.*;

public class AOC_2024_9
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        ArrayList<Integer> drive = new ArrayList<Integer>();
        String line = scn.next();
        int ID = 0;
        
        for(int i = 0; i < line.length(); i = i + 1)
        {
            if(i % 2 == 1)
            {
                ID = ID + 1;
            }
            for(int j = 0; j < Integer.parseInt(line.charAt(i) + ""); j = j + 1)
            {
                if(i % 2 == 0)
                {
                    drive.add(ID);
                }
                else
                {
                    drive.add(-1);
                }
            }
        }
        
        for(int i = 0; i < drive.size(); i = i + 1)
        {
            if(drive.get(drive.size() - 1 - i) > -1) // May break at the end;
            {
                for(int j = 0; j < drive.size() && j < drive.size() - i - 1; j = j + 1)
                {
                    if(drive.get(j) == -1)
                    {
                        int tempF = drive.get(drive.size() - 1 - i);
                        int tempE = drive.get(j);
                        drive.set(drive.size() - 1 - i, tempE);
                        drive.set(j, tempF);
                        break;
                    }
                }
            }
        }
        
        for(int i = 0; i < drive.size(); i = i + 1)
        {
            if(drive.get(i) > -1)
            {
                answer = answer + (i * drive.get(i));
            }
        }
        
        System.out.println(answer);
    }
}