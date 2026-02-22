import java.util.*;
import java.io.*;

public class AOC_2021_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        int multiplingNew = 0;
        int aim = 0;
        int multiplingOld = 0;
        int depth = 0;
        while (scn.hasNextLine())
        {
            String direction = scn.next();
                        
            if (direction.equals("forward"))
            {
                multiplingNew = 0;
                multiplingNew = multiplingNew + scn.nextInt();
                multiplingOld = multiplingOld + multiplingNew;
                depth = depth + multiplingNew * aim;
            }
            else if (direction.equals("down"))
            {
                aim = aim + scn.nextInt();
            }
            else if (direction.equals("up"))
            {
                aim = aim - scn.nextInt();
            }
            else
            {
                System.out.println("this should not print");
            }
        }
        
        System.out.println(multiplingOld * depth);
    }
}
