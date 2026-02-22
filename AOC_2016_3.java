import java.util.*;
import java.io.*;

public class AOC_2016_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            int side1T1 = scn.nextInt();
            int side2T1 = scn.nextInt();
            int side3T1 = scn.nextInt();
            int side1T2 = scn.nextInt();
            int side2T2 = scn.nextInt();
            int side3T2 = scn.nextInt();
            int side1T3 = scn.nextInt();
            int side2T3 = scn.nextInt();
            int side3T3 = scn.nextInt();
            
            int loong = 0;
            if(side1T1 > loong)
            {
                loong = side1T1 ;
            }
            if(side1T2 > loong)
            {
                loong = side1T2;
            }
            if(side1T3 > loong)
            {
                loong = side1T3;
            }
            
            if(loong + loong - side1T1 - side1T2 - side1T3 < 0)
            {
                answer = answer + 1;
            }
            loong  = 0;
            
            if(side2T1 > loong)
            {
                loong = side2T1 ;
            }
            if(side2T2 > loong)
            {
                loong = side2T2;
            }
            if(side2T3 > loong)
            {
                loong = side2T3;
            }
            
            if(loong + loong - side2T1 - side2T2 - side2T3 < 0)
            {
                answer = answer + 1;
            }
            loong  = 0;
            
            if(side3T1 > loong)
            {
                loong = side3T1 ;
            }
            if(side3T2 > loong)
            {
                loong = side3T2;
            }
            if(side3T3 > loong)
            {
                loong = side3T3;
            }
            
            if(loong + loong - side3T1 - side3T2 - side3T3 < 0)
            {
                answer = answer + 1;
            }
        }
        
        System.out.println(answer);
    }
}