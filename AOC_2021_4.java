import java.util.*;
import java.io.*;

public class AOC_2021_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0; // The final answer witch will be printed at the very end.
        
        String[] wordNums = (scn.nextLine().split(",")); // Parces the imput numbers into a string[].
        int[] nums = new int[wordNums.length]; // Makes the [] for the numbers as ints, also givse that [] the same length.
        for(int i = 0; i < wordNums.length; i = i + 1) // A for loop to go through all of the numbers in the string[].
        {
            nums[i] = Integer.parseInt(wordNums[i]); // Actelly fills the int[] with the parced numbers from the string[].
            // System.out.println(nums[i]);
        }
        int[][][] boards = new int[5][5][100]; // An int 3d [] to represent the boards, the 5 by 5 to show the size of each boared and the 100 for the number of boards.
        for(int b = 0; b < 100; b = b + 1) // A for loop to go through each of the 100 boards.
        {
            for(int y = 0; y < 5; y = y + 1) // A for loop to go through each of the rows.
            {
                String[] line = scn.nextLine().trim().replaceAll("  ", " ").split(" "); // A line from the bingo board. Trim is to remove problematic first spaces. -->
                // Replace all turn problematic double spaces into single spaces. Split turns the string into a string[]; based on the spaces.
                //System.out.println(line);
                for(int x = 0; x < 5; x = x + 1) // For loop to go through each number in the bingo line.
                {
                    boards[x][y][b] = Integer.parseInt(line[x]); // Truning the string version of each number into it's int for; also putting it in the correct spot.
                    //System.out.print(boards[x][y][b] + " ");
                }
                //System.out.println();
            }
            scn.nextLine(); // Goes through the filler between boards. It makes me put 2 extra line at the end, no clue why?
        }
        boolean[][][] position = new boolean[5][5][100]; // Same as boards, but used to keep track witch spots are filled.
        boolean winner = false; // A boolean to see if the winning board has been found.
        int theBoard = -1; // The board that ends up winning. Starts at negitiv 1 as an intenshally impossible value.
        int theNum = -1; // The last number to be drawn.
        //System.out.println(nums.length);
        boolean[] blackList = new boolean[100];
        for(int n = 0; n < nums.length; n = n + 1)
        {
            //System.out.println(nums[n]);
            
            for(int b = 0; b < 100; b = b + 1)
            {
                for(int y = 0; y < 5; y = y + 1)
                {
                    for(int x = 0; x < 5; x = x + 1)
                    {
                        if(boards[x][y][b] == nums[n])
                        {
                            position[x][y][b] = true;
                        }
                    }
                }
                
                for(int y = 0; y < 5; y = y + 1)
                {
                    boolean row = true;
                    for(int x = 0; x < 5; x = x + 1)
                    {
                        if(position[x][y][b] == false)
                        {
                            row = false;
                        }
                    }
                    if(row == true && blackList[b] == false)
                    {
                        theBoard = b;
                        theNum = nums[n];
                        winner = true;
                        //blackList[b] = true;
                    }
                }
                for(int x = 0; x < 5; x = x + 1)
                {
                    boolean collem = true;
                    for(int y = 0; y < 5; y = y + 1)
                    {
                        if(position[x][y][b] == false)
                        {
                            collem = false;
                        }
                    }
                    if(collem == true && blackList[b] == false)
                    {
                        theBoard = b;
                        theNum = nums[n];
                        ///blackList[b] = true;
                        winner = true;
                    }
                }
                if(winner == true && blackList[b] == false)
                {
                    
                
                    int unmarked = 0;
                    for(int y = 0; y < 5; y = y + 1)
                    {
                        for(int x = 0; x < 5; x = x + 1)
                        {
                            if(position[x][y][theBoard] == false)
                            {
                                unmarked = unmarked + boards[x][y][theBoard];
                            }
                        }
                    }
                    answer = unmarked * theNum;
                    winner = false;
                    blackList[b] = true;
                }    
            }
        }
        
        System.out.println(answer);
    }
}