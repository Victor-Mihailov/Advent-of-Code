import java.util.*;
import java.io.*;

public class AOC_2020_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[] money = new int[200];
        
        for(int i = 0; i < 200; i = i + 1)
        {
            money[i] = Integer.parseInt(scn.nextLine());
        }
        
        for(int j = 0; j < 200; j = j + 1)
        {
            for(int k = 0; k < 200; k = k + 1)
            {
                for(int m = 0; m < 200; m = m + 1)
                {
                    if(money[j] + money[k] + money[m] == 2020)
                    {
                        answer = money[j] * money[k] * money[m];
                    }
                }
            }
        }
        
        
        System.out.println(answer);
    }
}
