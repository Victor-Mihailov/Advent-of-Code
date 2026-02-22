import java.util.*;
import java.io.*;

public class AOC_2022_10
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        int size = 138;
        int X = 1;
        int answer = 0;
        String[] directions = new String[size];
        
        for(int i = 0; i < size; i = i + 1)
        {
            directions[i] = scn.nextLine();
        }
        
        int cycle = 0;
        int perod = 0;
        int trustMeBro = 0;
        for(int i = 0; i < size; i = i + 1)
        {
            cycle++;
            
            Scanner scan = new Scanner(directions[i]);
            String cmd = scan.next();
            if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220)
            {
                /*
                System.out.println(cycle);
                System.out.println(perod);
                System.out.println(X);
                System.out.println(i);
                System.out.println( );*/
                
                answer = answer + (((perod * 40) + 20) * X);
                perod = perod + 1;
            }
            
            if (trustMeBro != 0)
            {
                X += trustMeBro;
                trustMeBro = 0;
                
                System.out.println(X + " " + cycle);
                
                i--;
            }
            else if(cmd.equals("addx"))
            {
                String num = scan.next();
                trustMeBro = Integer.parseInt(num);
            }
        }
        
        System.out.println(answer);
    }
}
