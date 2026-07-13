import java.util.*;
import java.io.*;

public class AOC_2022_9
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
         // I am going to comment my code cause I have no clue what to do.
        int answer = 0; // Answer is the thing that will be printed. It is supposed to be the number of unique tiles the tail has visited.
        ArrayList<String> instructions = new ArrayList<String>(); // The instructions on where the head should go.
        for(int i = 0; i < 8; i = i + 1)
        {
            String ogScaned = scn.nextLine();
            instructions.add(ogScaned);
        }
        
        for(int b = 0; b < 53; b = b + 1) // 9????
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
                //display(xF, yF, xB, yB);
                
                //System.out.println(xB);
                Scanner scan = new Scanner(instructions.get(c));
                String scaned = scan.next();
                if(scaned.equals("R"))
                {
                    // System.out.println(xB);
                    scaned = scan.next();
                    for(int m = 0; m < Integer.parseInt(scaned); m = m + 1)
                    {
                        xF = xF + 1;
                        if(xB + 1 < xF)
                        {
                            xB = xB + 1;
                            if(yB < yF)
                            {
                                directions.add("U 1");
                            }
                            else if(yB > yF)
                            {
                                directions.add("D 1");
                            }
                            yB = yF;
                            directions.add("R 1");
                            tale = xB + " " + yB;
                            if(path.contains(tale) == false)
                            {
                                answer = answer + 1;
                                path.add(tale); // Made answer go up
                            }
                        }
                    }
                }
                else if(scaned.equals("L"))
                {
                    // System.out.println(xB);
                    scaned = scan.next();
                    for(int m = 0; m < Integer.parseInt(scaned); m = m + 1)
                    {
                        xF = xF - 1;
                        if(xB - 1 > xF)
                        {
                            xB = xB - 1;
                            if(yB < yF)
                            {
                                directions.add("U 1");
                            }
                            else if(yB > yF)
                            {
                                directions.add("D 1");
                            }
                            yB = yF;
                            directions.add("L 1");
                            tale = xB + " " + yB;
                            if(path.contains(tale) == false)
                            {
                                answer = answer + 1;
                                path.add(tale);// Made answer go up
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
                        if(yB + 1 < yF)
                        {
                            yB = yB + 1;
                            if(xB < xF)
                            {
                                directions.add("R 1");
                            }
                            else if(xB > xF)
                            {
                                directions.add("L 1");
                            }
                            xB = xF;
                            directions.add("U 1");
                            tale = xB + " " + yB;
                            if(path.contains(tale) == false)
                            {
                                answer = answer + 1;
                                path.add(tale); // Made answer go up
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
                        if(yB - 1 > yF)
                        {
                            yB = yB - 1;
                            if(xB < xF)
                            {
                                directions.add("R 1");
                            }
                            else if(xB > xF)
                            {
                                directions.add("L 1");
                            }
                            xB = xF;
                            directions.add("D 1");
                            tale = xB + " " + yB;
                            if(path.contains(tale) == false)
                            {
                                answer = answer + 1;
                                path.add(tale); // Made answer go up
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
    
    public static void display (int xF, int yF, int xB, int yB)
    {
        for(int y = 50; y >= -50; y = y - 1) // ????? y
        {
            for(int x = -50; x < 50; x = x + 1)
            {
                if(x == xF && y == yF)
                {
                    System.out.print("H");
                }
                else if(x == xB && y == yB)
                {
                    System.out.print("T");
                }
                else
                {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}