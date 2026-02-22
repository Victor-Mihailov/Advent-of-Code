import java.util.*;
import java.io.*;

public class AOC_2015_20
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        boolean flag = false;
        while(flag == false)
        {
            int size = 0;
            answer = answer + 1;
            for(int i = 1; i <= answer; i = i + 1)
            {
                if(answer % i == 0 && i * 50 >= answer)
                {
                    size = size + (i * 11);
                }
            }
            
            if(size >= 29000000)
            {
                flag = true;
            }
        }
        
        System.out.println(answer);
    }
}