import java.util.*;
import java.io.*;

public class AOC_2024_7
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            line = line.replace(":", "");
            String[] strings = line.split(" ");
            
            long big = Long.parseLong(strings[0]);
            long[] nums = new long[strings.length - 1];
            for(int i = 0; i < strings.length - 1; i = i + 1)
            {
                nums[i] = Long.parseLong(strings[i + 1]); // i + 1 might break everything:?;
            }
            
            if(bob(big, nums))
            {
                answer = answer + big;
            }
        }
        
        System.out.println(answer);
    }
    
    public static boolean bob(long big, long[] nums)
    {
        if(nums.length == 1)
        {
            return nums[0] == big;
        }
            
        long[] n1 = new long[nums.length - 1];
        long[] n2 = new long[nums.length - 1];
        long[] n3 = new long[nums.length - 1];
        n1[0] = nums[0] + nums[1];
        n2[0] = nums[0] * nums[1];
        n3[0] = Long.parseLong(nums[0] + "" + nums[1]);
        for(int i = 2; i < nums.length; i = i + 1)
        {
            n1[i - 1] = nums[i];
            n2[i - 1] = nums[i];
            n3[i - 1] = nums[i];
        }
        
        return bob(big, n1) || bob(big, n2) || bob(big, n3);
    }
}
