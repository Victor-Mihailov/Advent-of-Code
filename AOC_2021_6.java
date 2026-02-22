import java.util.*;
import java.io.*;

public class AOC_2021_6
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        long[] days = new long[9];
        
        String scand = scn.nextLine();
        //scand = scand.replaceAll(",", " ");
        String[] fish = scand.split(",");
        for(int i = 0; i < fish.length; i = i + 1)
        {
            days[Integer.parseInt(fish[i])] += 1;
            /*
            for(int j = 0; j < 9; j = j + 1)
            {
                if(Integer.parseInt(fish[i]) == j)
                {
                    days[j] = days[j] + 1;
                }
            }
            */
        }
        
        
        for(int day = 0; day < 256; day = day + 1)
        {
            long[] lWeak = new long[9];
            for(int i = 8; i > 0; i = i - 1)
            {
                lWeak[i - 1] = days[i];
            }
            lWeak[8] = days[0];
            lWeak[6] = lWeak[6] + days[0];
            for(int j = 0; j < 9; j = j + 1)
            {
                days[j] = lWeak[j];
            }
            
            /*
            int fakeDay = 0;
            int tempDay = fakeDay;
            fakeDay = days[7];
            days[7] = days[8];
            tempDay = days[6];
            days[6] = fakeDay;
            fakeDay = days[5];
            days[5] = tempDay;
            tempDay = days[4];
            days[4] = fakeDay;
            fakeDay = days[3];
            days[3] = tempDay;
            tempDay = days[2];
            days[2] = fakeDay;
            fakeDay = days[1];
            days[1] = tempDay;
            
            tempDay = days[0];
            days[0] = fakeDay;
            days[6] = days[6] + days[0];
            days[8] = days[8] + days[0];
            
            fakeDay = 0;
            tempDay = fakeDay;
            */
        }
        
        for(int i = 0; i < 9; i = i + 1)
        {
            answer = answer + days[i];
        }
        
        System.out.println(answer);
    }
}