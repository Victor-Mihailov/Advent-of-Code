import java.util.*;
import java.io.*;

public class AOC_2015_6
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[][] lights = new int[1000][1000];
        
        while (scn.hasNextLine())
        {
            String scaned = scn.nextLine();
            scaned = scaned.replace(",", " ");
            Scanner scan = new Scanner(scaned);
            String word = scan.next();
            
            String xWord = "0";
            String yWord = "0";
            String wordX = "0";
            String wordY = "0";
            
            if(word.equals("turn"))
            {
                word = scan.next();
                
                xWord = scan.next();
                yWord = scan.next();
                scan.next();
                wordX = scan.next();
                wordY = scan.next();
                
                if(word.equals("off"))
                {
                    for(int x = Integer.parseInt(xWord); x <= Integer.parseInt(wordX); x = x + 1)
                    {
                        for(int y = Integer.parseInt(yWord); y <= Integer.parseInt(wordY); y = y + 1)
                        {
                            if(lights[x][y] > 0)
                            {
                                lights[x][y] = lights[x][y] - 1;
                            }
                        }
                    }
                }
                else
                {
                    for(int x = Integer.parseInt(xWord); x <= Integer.parseInt(wordX); x = x + 1)
                    {
                        for(int y = Integer.parseInt(yWord); y <= Integer.parseInt(wordY); y = y + 1)
                        {
                            lights[x][y] = lights[x][y] + 1;
                        }
                    }
                }
            }
            else
            {
               xWord = scan.next();
               yWord = scan.next();
               scan.next();
               wordX = scan.next();
               wordY = scan.next();
               
               for(int x = Integer.parseInt(xWord); x <= Integer.parseInt(wordX); x = x + 1)
               {
                   for(int y = Integer.parseInt(yWord); y <= Integer.parseInt(wordY); y = y + 1)
                   {
                        lights[x][y] = lights[x][y] + 2;
                   }
               }
            }
        }
        
        for(int x = 0; x < 1000; x = x + 1)
        {
            for(int y = 0; y < 1000; y = y + 1)
            {
                answer = answer + lights[x][y];
            }
        }
        
        System.out.println(answer);
    }
}