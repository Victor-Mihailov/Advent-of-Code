import java.util.*;
import java.io.*;

public class AOC_2022_18
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[][][] area = new int[30][30][30];
        boolean[][][] cubes = new boolean[30][30][30];
        while (scn.hasNextLine())
        {
           String[] cords = scn.next().split(",");
           int x = Integer.parseInt(cords[0]);
           int y = Integer.parseInt(cords[1]);
           int z = Integer.parseInt(cords[2]);
           
           answer = answer - area[x][y][z];
           cubes[x][y][z] = true;
           answer = answer + 6;
           if(x != 0)
           {
               area[x - 1][y][z] = area[x - 1][y][z] + 2;
           }
           area[x + 1][y][z] = area[x + 1][y][z] + 2;
           area[x][y - 1][z] = area[x][y - 1][z] + 2;
           area[x][y + 1][z] = area[x][y + 1][z] + 2;
           
           if(z != 0)
           {
               area[x][y][z - 1] = area[x][y][z - 1] + 2;
           }
           
           area[x][y][z + 1] = area[x][y][z + 1] + 2;
        }
        
        System.out.println(answer);
    }
}