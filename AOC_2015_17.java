import java.util.*;
import java.io.*;

public class AOC_2015_17
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        ArrayList<Integer> cups = new ArrayList<Integer>();
        while (scn.hasNextLine())
        {
            cups.add( scn.nextInt() );
        }
        int literLeft = 150;
        int depth = 0;
        for(int macDapth = 0; answer == 0; macDapth = macDapth + 1)
        {
            answer = eggnog(cups, literLeft, depth, macDapth);
        }
        
        System.out.println(answer);
    }
    
    public static int eggnog(ArrayList<Integer> cups, int litersLeft, int depth, int maxDepth)
    {
        if(maxDepth < depth)
        {
            return 0;
        }
        if(litersLeft == 0)
        {
            return 1;
        }
        if(litersLeft < 0)
        {
            return 0;
        }
        int answer = 0;
        depth = depth + 1;
        for(int i = 0; i < cups.size(); i = i + 1)
        {
            ArrayList<Integer> cups2 = new ArrayList<Integer>();
            for(int j = 0; j < cups.size(); j = j + 1)
            {
                if(j != i && j < i)
                {
                    cups2.add(cups.get(j));
                }
            }
            
            answer = answer + eggnog(cups2, litersLeft - cups.get(i), depth, maxDepth);
        }
        return answer;
    }
}