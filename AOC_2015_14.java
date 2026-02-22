import java.util.*;
import java.io.*;

public class AOC_2015_14
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int l = 9;
        int daTime = 2503;
        int answer = 0;
        int[][] daDistence = new int[l][daTime];
        int rainder = -1;
        
        while (scn.hasNextLine())
        {
            rainder = rainder + 1;
            String[] data = scn.nextLine().replace(" km/s for " , ",").replace(" seconds, but then must rest for " , ",").replace(" seconds." , "").split(",");
            int[] stat = new int[3];
            for(int convert = 0; convert < 3; convert = convert + 1)
            {
                stat[convert] = Integer.parseInt(data[convert]);
            }
            
            int distence = 0;
            for(int time = 0; time < daTime;) // Might need < 2503 to be <= 2503, similer problem for other for loops; The was less than?
            {
                for(int v = 0; v < stat[1] && time < daTime; time = time + 1, v = v + 1, distence = distence + stat[0])
                {
                    daDistence[rainder][time] = distence;
                }
                for(int r = 0; r < stat[2] && time < daTime; time = time + 1, r = r + 1)
                {
                    daDistence[rainder][time] = distence;
                }
            }
        }
        
        int[] rander = new int[l];
        for(int i = 0; i < daTime; i = i + 1)
        {
            int far = 0;
            for(int j = 0; j < l; j = j + 1)
            {
                if(daDistence[j][i] > far)
                {
                    far = daDistence[j][i];
                }
            }
            
            for(int k = 0; k < l; k = k + 1)
            {
                if(daDistence[k][i] == far)
                {
                    rander[k] = rander[k] + 1;
                }
            }
        }
        
        for(int i = 0; i < l; i = i + 1)
        {
            System.out.println(rander[i]);
            if(rander[i] > answer)
            {
                answer = rander[i];
            }
        }
        
        System.out.println(answer - 1);
    }
}