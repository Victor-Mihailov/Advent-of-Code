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
        while(scn.hasNextLine()) // While loop to go over the imput. 
        {
            instructions.add(scn.nextLine()); // Adding the imput to a use able list
        }
        
        for(int b = 0; b < 10; b = b + 1) // A for loop to do every segment of the rope. 10 because there are 10 segments.
         {
            answer = 1; // This is to take into acount that the starting position counts to the total positions reached.
            ArrayList<String> path = new ArrayList<String>(); // 'Path' is the marking of the positions reached.
            int xF = 0; // xF is the 
            int xB = 0;
            int yF = 0;
            int yB = 0;
            String tale = xB + " " + yB;
            path.add(tale);
            ArrayList<String> directions = new ArrayList<String>();
            display(xF, yF, xB, yB, b);
            for(int c = 0; c < instructions.size(); c = c + 1)
            {
                //display(xF, yF, xB, yB, b);
                
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
    
    public static void display (int xF, int yF, int xB, int yB, int b)
    {
        for(int y = 15; y >= -5; y = y - 1) // ????? y
        {
            for(int x = -11; x < 14; x = x + 1)
            {
                if(x == xF && y == yF)
                {
                    System.out.print(b);
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