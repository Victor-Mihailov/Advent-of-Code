import java.util.*;
import java.io.*;

public class AOC_2024_14
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;
        while (scn.hasNextLine())
        {
            String[] input = scn.nextLine().replace("p=" , "").replace(" v=" , ",").split(",");
            int[] nums = new int[4];
            for(int convert = 0; convert < 4; convert = convert + 1)
            {
                nums[convert] = Integer.parseInt(input[convert]);
            }
            
            for(int sec = 0; sec < 100; sec = sec + 1)
            {
                if(nums[0] + nums[2] >= 101)
                {
                    nums[0] = (nums[0] + nums[2]) % 101; 
                }
                else if(nums[0] + nums[2] < 0)
                {
                    nums[0] = 101 + (nums[0] + nums[2]);
                }
                else
                {
                    nums[0] = nums[0] + nums[2];
                }
                
                if(nums[1] + nums[3] >= 103)
                {
                    nums[1] = (nums[1] + nums[3]) % 103; 
                }
                else if(nums[1] + nums[3] < 0)
                {
                    nums[1] = 103 + (nums[1] + nums[3]);
                }
                else
                {
                    nums[1] = nums[1] + nums[3];
                }
            }
            if(nums[0] > 50)
            {
                if(nums[1] > 51)
                {
                    q1 = q1 + 1;
                }
                else if(nums[1] < 51)
                {
                    q2 = q2 + 1;
                }
            }
            else if(nums[0] < 50)
            {
                if(nums[1] > 51)
                {
                    q3 = q3 + 1;
                }
                else if(nums[1] < 51)
                {
                    q4 = q4 + 1;
                }
            }
        }
        
        answer = q1 * q2 * q3 * q4;
        
        System.out.println(answer);
    }
}