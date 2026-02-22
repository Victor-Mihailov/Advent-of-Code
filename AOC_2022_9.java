import java.util.*;
import java.io.*;

public class AOC_2022_9
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        ArrayList<String> instructions = new ArrayList<String>();
        for(int i = 0; i < 2000; i = i + 1)
        {
            String ogScaned = scn.nextLine();
            instructions.add(ogScaned);
        }
        
        for(int b = 0; b < 10; b = b + 1)
        {
            answer = 1;
            ArrayList<String> path = new ArrayList<String>();
            int xF = 0;
            int xB = 0;
            int yF = 0;
            int yB = 0;
            String tale = xB + " " + yB;
            path.add(tale);
            ArrayList<String> directions = new ArrayList<String>();
            for(int c = 0; c < instructions.size(); c = c + 1)
            {
                Scanner scan = new Scanner(instructions.get(c));
                String scaned = scan.next();
                if(scaned.equals("R"))
                {
                    scaned = scan.next();
                    for(int m = 0; m < Integer.parseInt(scaned); m = m + 1)
                    {
                        xF = xF + 1;
                        if(xB + 1 < xF)
                        {
                            xB = xB + 1;
                            yB = yF;
                            directions.add("R 1");
                            tale = xB + " " + yB;
                            if(path.contains(tale) == false)
                            {
                                answer = answer + 1;
                                path.add(tale);
                            }
                        }
                    }
                }
                else if(scaned.equals("L"))
                {
                    scaned = scan.next();
                    for(int m = 0; m < Integer.parseInt(scaned); m = m + 1)
                    {
                        xF = xF - 1;
                        if(xB - 1 > xF)
                        {
                            xB = xB - 1;
                            yB = yF;
                            directions.add("L 1");
                            tale = xB + " " + yB;
                            if(path.contains(tale) == false)
                            {
                                answer = answer + 1;
                                path.add(tale);
                            }
                        }
                    }
                }
                else if(scaned.equals("U"))
                {
                    scaned = scan.next();
                    for(int m = 0; m < Integer.parseInt(scaned); m = m + 1)
                    {
                        yF = yF + 1;
                        if(xB + 1 < xF)
                        {
                            yB = yB + 1;
                            xB = xF;
                            directions.add("U 1");
                            tale = xB + " " + yB;
                            if(path.contains(tale) == false)
                            {
                                answer = answer + 1;
                                path.add(tale);
                            }
                        }
                    }
                }
                else if(scaned.equals("D"))
                {
                    scaned = scan.next();
                    for(int m = 0; m < Integer.parseInt(scaned); m = m + 1)
                    {
                        yF = yF - 1;
                        if(xB - 1 > xF)
                        {
                            yB = yB - 1;
                            xB = xF;
                            directions.add("D 1");
                            tale = xB + " " + yB;
                            if(path.contains(tale) == false)
                            {
                                answer = answer + 1;
                                path.add(tale);
                            }
                        }
                    }
                }
            }
            
            path.clear();
            instructions = directions;
        }
        
        System.out.println(answer);
    }
}