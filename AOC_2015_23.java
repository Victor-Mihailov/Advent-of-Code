import java.util.*;
import java.io.*;

public class AOC_2015_23
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int size = 47;
        String[] comands = new String[size];
        for(int fill = 0; fill < size; fill = fill + 1)
        {
            comands[fill] = scn.nextLine();
        }
        
        int a = 1;
        int b = 0;
        for(int i = 0; i < size; i = i + 1)
        {
            System.out.println(i);
            if(comands[i].substring(0, 3).equals("inc")) // Don't need b checks for other comands, because there is only 1 b;
            {
                if(comands[i].substring(4, 5).equals("a"))
                {
                    a = a + 1;
                }
                else if(comands[i].substring(4, 5).equals("b"))
                {
                    b = b + 1;
                }
            }
            else if(comands[i].equals("tpl a"))
            {
                a = a * 3;
            }
            else if(comands[i].equals("hlf a")) // May go wrong if odd number;
            {
                a = a / 2;
                //System.out.println(a);
            }
            else if(comands[i].substring(0, 3).equals("jmp"))
            {
                i = i + Integer.parseInt(comands[i].substring(4)) - 1;
            }
            else if(comands[i].equals("jie a, +4") && a % 2 == 0)
            {
                i = i + 3; //Integer.parseInt(comands[i].substring(7)) - 1;
            }
            else if(comands[i].substring(0, 3).equals("jio") && a == 1)
            {
                i = i + Integer.parseInt(comands[i].substring(7)) - 1;
            }
            //System.out.println(a);
            //System.out.println(i);
        }
        
        System.out.println(b);
    }
}