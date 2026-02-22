import java.util.*;
import java.io.*;

public class AOC_2015_15
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[][] ingreatents = new int[4][5];
        for(int item = 0; item < 4; item = item + 1)
        {
            String line = scn.nextLine();
            
            line = line.replace(": capacity ", "");
            line = line.replace(" durability ", "");
            line = line.replace(" flavor ", "");
            line = line.replace(" texture ", "");
            line = line.replace(" calories ", "");
            
            line = line.replace("Sugar", "");
            line = line.replace("Sprinkles", "");
            line = line.replace("Candy", "");
            line = line.replace("Chocolate", "");
            
            String[] temp = line.split(",");
            for(int i = 0; i < 5; i = i + 1)
            {
                ingreatents[item][i] = Integer.parseInt(temp[i]);
            }
        }
        
        for(int sugar = 0; sugar <= 100; sugar = sugar + 1)
        {
            for(int sprinkles = 0; sprinkles <= 100; sprinkles = sprinkles + 1)
            {
                for(int candy = 0; candy <= 100; candy = candy + 1)
                {
                    for(int chocolate = 0; chocolate <= 100; chocolate = chocolate + 1)
                    {
                        if(sugar + sprinkles + candy + chocolate == 100)
                        {
                            int goodness = 1;
                            for(int i = 0; i < 4; i = i + 1)
                            {
                                int curentCatigory = (sugar * ingreatents[0][i]) + (sprinkles * ingreatents[1][i]) + (candy * ingreatents[2][i]) + (chocolate * ingreatents[3][i]);
                                if(curentCatigory <= 0)
                                {
                                    curentCatigory = 0;
                                }
                                goodness = goodness * curentCatigory;
                            }
                            if(goodness > answer && (sugar * ingreatents[0][4]) + (sprinkles * ingreatents[1][4]) + (candy * ingreatents[2][4]) + (chocolate * ingreatents[3][4]) == 500)
                            {
                                answer = goodness;
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}