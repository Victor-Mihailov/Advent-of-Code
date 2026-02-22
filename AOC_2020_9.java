import java.util.*;
import java.io.*;

public class AOC_2020_9
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        ArrayList<Integer> trail = new ArrayList<Integer>();
        ArrayList<Integer> bigTrail = new ArrayList<Integer>();
        while(answer == 0)
        {
            int num = scn.nextInt();
            
            if(trail.size() == 25)
            {
                boolean allGood = false;
                for(int i = 0; i < trail.size(); i = i + 1)
                {
                    for(int j = i + 1; j < trail.size(); j = j + 1)
                    {
                        if(trail.get(i) + trail.get(j) == num)
                        {
                            allGood = true;
                        }
                    }
                }
                if(allGood == false)
                {
                    answer = num;
                }
                else
                {
                    bigTrail.add(num);
                }
            }
            else
            {
                bigTrail.add(num);
            }
            
            trail.add(num);
            if(trail.size() > 25)
            {
                trail.remove(0);
            }
        }
        System.out.println(answer);
        
            for(int numLength = 0; numLength < bigTrail.size(); numLength = numLength + 1) // <= || <
            {
                //System.out.println("hi");
                for(int i = 0; i < bigTrail.size() - numLength; i = i + 1) // <= || <
                {
                    int num = 0;
                    for(int count = i; count <= numLength + i; count = count + 1) // <= || <;
                    {
                        num = num + bigTrail.get(count);
                    }
                    if(num == answer)
                    {
                        int small = Integer.MAX_VALUE;
                        int big = Integer.MIN_VALUE;
                        for(int check = i; check < numLength + i; check = check + 1) // < || <=
                        {
                            if(small > bigTrail.get(check))
                            {
                                small = bigTrail.get(check);
                            }
                            if(big < bigTrail.get(check))
                            {
                                big = bigTrail.get(check);
                            }
                        }
                        System.out.println(small + big);
                    }
                }
             }
        
        
    }
}