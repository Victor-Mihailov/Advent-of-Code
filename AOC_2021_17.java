import java.util.*;
import java.io.*;

public class AOC_2021_17
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        //ArrayList<Integer> ys = new ArrayList<Integer>();
        //ArrayList<Integer> xs = new ArrayList<Integer>();
        int answer = 0;
        for(int y = -100; y < 100; y = y + 1)
        {
            for(int x = 0; x < 1000; x = x + 1)
            {
                int ySpeed = y;
                int yp = 0;
                int xSpeed = x;
                int xp = 0;
                boolean flag = false;
                for(int steps = 0; steps < 1000; steps = steps + 1)
                {
                    yp = yp + ySpeed;
                    ySpeed = ySpeed - 1;
                    xp = xp + xSpeed;
                    if(xSpeed > 0)
                    {
                        xSpeed = xSpeed - 1;
                    }
                    else if(xSpeed < 0)
                    {
                        xSpeed = xSpeed + 1;
                    }
                    
                    if(yp >= -98 && yp <= -73 && xp >= 137 && xp <= 171 && flag == false)
                    {
                        flag = true;
                        answer = answer + 1;
                    }
                }
            }
        }
        
        int hight = 0;
        for(int y = 97; y > 0;)
        {
            hight = hight + y;
            y = y - 1;
        }
        System.out.println(answer);
        
    }
}
