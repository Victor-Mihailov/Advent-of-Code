import java.util.*;
import java.io.*;

public class AOC_2022_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        int a = 1;
        int b = 2;
        int c = 3;
        int wins = 0;
        
        while (scn.hasNextLine())
        {
            String move = scn.nextLine();
            if (move.equals("A X"))
            {
                wins = wins + c + 0;
            }
            else if (move.equals("A Y"))
            {
                wins = wins + a + 3;
            }
            else if (move.equals("A Z"))
            {
                wins = wins + b + 6;
            }
            else if (move.equals("B X"))
            {
                wins = wins + a + 0;
            }
            else if (move.equals("B Y"))
            {
                wins = wins + b + 3;
            }
            else if (move.equals("B Z"))
            {
                wins = wins + c + 6;
            }
            else if (move.equals("C X"))
            {
                wins = wins + b + 0;
            }
            else if (move.equals("C Y"))
            {
                wins = wins + c + 3;
            }
            else if (move.equals("C Z"))
            {
                wins = wins + a + 6;
            }
        }
        
        System.out.println(wins);
    }
}
