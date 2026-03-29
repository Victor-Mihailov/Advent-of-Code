import java.util.*;
import java.io.*;

public class AOC_2025_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        final int rn = 172;
        ArrayList<long[]> stuff = new ArrayList<long[]>();
        
        for(int l = 0; l < rn; l = l + 1)
        {
            String[] stemp = scn.nextLine().split("-");
            long[] temp = new long[2];
            temp[0] = Long.parseLong(stemp[0]);
            temp[1] = Long.parseLong(stemp[1]);
            stuff.add(temp);
        } 
        boolean sort = true;
        while(sort)
        { 
            sort = false;
            System.out.println("lol");
            for(int i = 1; i < rn; i = i + 1)
            {
                if(stuff.get(i)[0] < stuff.get(i - 1)[0])
                {
                    sort = true;
                    long[] temp = stuff.get(i);
                    stuff.set(i, stuff.get(i - 1));
                    stuff.set(i - 1, temp);
                    System.out.println("1");
                }
            }
        }
        
        boolean didy = true;
        while(didy)
        {
            didy = false;
            for(int i = 1; i < stuff.size(); i = i + 1)
            {
                long range1Left = stuff.get(i - 1)[0];
                long range1Right = stuff.get(i - 1)[1];
                long range2Left = stuff.get(i)[0];
                long range2Right = stuff.get(i)[1];
                
                long min = Math.min(range1Left, range2Left); // Looks at the two left positions to find whitch is smaller
                long max = Math.max(range1Right, range2Right); // Looks at the two right positions to find whitch is bigger
                if(range1Left <= range2Right && range1Left >= range2Left ||
                range1Right <= range2Right && range1Right >= range2Left || 
                range1Left <= range2Left && range1Right >= range2Right)
                {
                    didy = true;
                    long[] temp = new long[2];
                    temp[0] = min;
                    temp[1] = max;
                    stuff.set(i, temp);
                    stuff.remove(i - 1);
                    System.out.println("2");
                }
            }
        }
        
        for(int i = 0; i < stuff.size(); i = i + 1)
        {
            answer = answer + stuff.get(i)[1] - stuff.get(i)[0] + 1;
        }
        /*
        scn.nextLine();
        while(scn.hasNextLine())
        {
            long n = Long.parseLong(scn.nextLine());
            boolean flag = false;
            for(int i = 0; i < rn; i = i + 1)
            {
                if(n >= Long.parseLong(stuff.get(i).split("-")[0]) && n <= Long.parseLong(stuff.get(i).split("-")[1]))
                {
                    flag = true;
                }
            }
            if(flag)
            {
                answer = answer + 1;
            }
        }
        */
        System.out.println(answer);
    }
    
    
}