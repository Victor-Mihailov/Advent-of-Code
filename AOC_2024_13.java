import java.util.*;
import java.io.*;

public class AOC_2024_13
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        for(int m = 0; m < 1280; m = m + 4)
        {
            String[] aButton = scn.nextLine().replace("Button A: X+" , "").replace(" Y+" , "").split(",");
            String[] bButton = scn.nextLine().replace("Button B: X+" , "").replace(" Y+" , "").split(",");
            String[] prize = scn.nextLine().replace("Prize: X=" , "").replace(" Y=" , "").split(",");
            scn.nextLine();
            int cheap = Integer.MAX_VALUE;
            for(int a = 0; a <= 100; a = a + 1)
            {
                for(int b = 0; b <= 100; b = b + 1)
                {
                    if((Integer.parseInt(aButton[0]) * a) + (Integer.parseInt(bButton[0]) * b) == Integer.parseInt(prize[0]) && 
                    (Integer.parseInt(aButton[1]) * a) + (Integer.parseInt(bButton[1]) * b) == Integer.parseInt(prize[1]))
                    {
                        cheap = ((a * 3) + b < cheap) ? ((a * 3) + b) : cheap; // Does if statment stuff, may break everything, but it's optimal for the computer;
                    }
                }
            }
            answer = answer + (cheap < Integer.MAX_VALUE ? cheap : 0); // Does if statment stuff, may break everything, but it's optimal for the computer;
        }
        
        System.out.println(answer);
    }
}