import java.util.*;
import java.io.*;

public class AOC_2024_12
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int size = 140;
        char[][] map = new char[size][size];
        for(int i = 0; i < size; i = i + 1)
        {
            String line = scn.next();
            for(int j = 0; j < size; j = j + 1)
            {
                map[i][j] = line.charAt(j);
            }
        }
        
        boolean[][] gone = new boolean[size][size];
        int[][] group = new int[size][size];
        group[0][0] = 1;
        int cg = 1;
        int perimiter = 0;
        int area = 0;
        for(int i = 0; i < size; i = i + 1)
        {
            for(int j = 0; j < size; j = j + 1)
            {
                int[] stuff = direction(map, gone, i, j);
                answer = answer + (stuff[0] * stuff[1]);
            }
        }
        
        System.out.println(answer);
    }
    
    public static int[] direction(char[][] map, boolean[][] gone, int i, int j)
    {
        if(gone[i][j])
        {
            return new int[2];
        }
        gone[i][j] = true;
        
        int perimiter = 0;
        int area = 1;
        if(i == 0 || map[i][j] != map[i - 1][j])
        {
            perimiter = perimiter + 1;
        }
        else if(map[i][j] == map[i - 1][j])
        {
            int[] naber = direction(map, gone, i - 1, j);
            area = area + naber[0];
            perimiter = perimiter + naber[1];
        }
        if(i == map.length - 1 || map[i][j] != map[i + 1][j])
        {
            perimiter = perimiter + 1;
        }
        else if(map[i][j] == map[i + 1][j])
        {
            int[] naber = direction(map, gone, i + 1, j);
            area = area + naber[0];
            perimiter = perimiter + naber[1];
        }
        if(j == 0 || map[i][j] != map[i][j - 1])
        {
            perimiter = perimiter + 1;
        }
        else if(map[i][j] == map[i][j - 1])
        {
            int[] naber = direction(map, gone, i, j - 1);
            area = area + naber[0];
            perimiter = perimiter + naber[1];
        }
        if(j == map.length - 1 || map[i][j] != map[i][j + 1])
        {
            perimiter = perimiter + 1;
        }
        else if(map[i][j] == map[i][j + 1])
        {
            int[] naber = direction(map, gone, i, j + 1);
            area = area + naber[0];
            perimiter = perimiter + naber[1];
        }
        
        return new int[]{area, perimiter};
    }
}