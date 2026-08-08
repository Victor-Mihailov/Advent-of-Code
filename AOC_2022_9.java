// Note to futer self. It seems the fundemental way I am doing the proble is wrong. I need to simulate the whole rope at once.



import java.util.*;
import java.io.*; //                                               |||||| 
 // I am going to comment my code cause I have no clue what to do. vvvvvv
public class AOC_2022_9
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file); 
        
        int answer = 0; // Answer is the thing that will be printed. It is supposed to be the number of unique tiles the tail has visited.
        ArrayList<String> instructions = new ArrayList<String>(); // The instructions on where the head should go.
        int[][] points = new int[2][10];
        while(scn.hasNextLine()) // While loop to go over the imput. 
        {
            instructions.add(scn.nextLine()); // Adding the imput to a useable list
        }
        
        HashSet<String> visited = new HashSet<String>(); // 'Path' is the marking of the positions reached.
        for(int c = 0; c < instructions.size(); c = c + 1) // A for loop to go over the instructions. Note - Can be made into a while loop.
        {            
            Scanner scan = new Scanner(instructions.get(c)); // A new scanner to go over a line of instructions
            String direction = scan.next();                  // Scanning the first part of the line to tell which direction
            int repititions = Integer.parseInt(scan.next()); // The number of steps to take in the given direction
            
            for(int m = 0; m < repititions; m = m + 1) // Goes over moving one position at a time, based on the total positions needed to be moved. Note - This whole thing could probely be done in a better way.
            {
                if(direction.equals("R")) // Cheaks if the direction of travel is right.
                {
                    points[0][0] = points[0][0] + 1;
                }
                else if(direction.equals("L"))
                {
                    points[0][0] = points[0][0] - 1;
                }
                else if(direction.equals("U"))
                {
                    points[1][0] = points[1][0] + 1;
                }
                else if(direction.equals("D"))
                {
                    points[1][0] = points[1][0] - 1;
                }
                
                for(int step = 0; step < 9; step = step + 1)
                {
                    int[] change = distanceToMove(points, step);
                    points[0][step + 1] = points[0][step + 1] + change[0];
                    points[1][step + 1] = points[1][step + 1] + change[1];
                }
                
                visited.add(points[0][9] + "," + points[1][9]);
            }
        }
        
        // path.clear();
        
        
        System.out.println(visited.size());
    }
    /*
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
    */
    public static int[] distanceToMove(int[][] points, int step)
    {
        int x = points[0][step] - points[0][step + 1];
        int y = points[1][step] - points[1][step + 1];
        
        if(x == 2 || x == -2 || y == 2 || y == -2)
        {
            x = (x == 0) ? 0 : (x / Math.abs(x));
            y = (y == 0) ? 0 : (y / Math.abs(y));
        
            return (new int[]{x, y});
        }
        
        return (new int[]{0,0});
    }
}