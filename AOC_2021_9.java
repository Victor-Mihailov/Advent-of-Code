import java.util.*;
import java.io.*;

public class AOC_2021_9
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int[][] map = new int[100][100];
        
        for(int i = 0; i < 100; i = i + 1)
        {
            String sand = scn.nextLine();
            for(int j = 0; j < 100; j = j + 1)
            {
                map[i][j] = sand.charAt(j) - 48;
            }
        }
        
        boolean[][] groop = new boolean[100][100];
        int[][] groopNum = new int[100][100];
        int x = 0;
        for(int p = 0; p < 100; p = p + 1)
        {
            for(int r = 0; r < 100; r = r + 1)
            {
                groop[p][r] = false;
                groopNum[p][r] = x;
                if(map[p][r] == 9)
                {
                    groopNum[p][r] = -1;
                }
            }
        }
        

        for(int c = 0; c < 100; c = c + 1)
        {
            for(int k = 0; k < 100; k = k + 1)
            {
                boolean flag = false;
                if(c != 0 && groop[c][k] != groop[c - 1][k] && map[c][k] != 9)
                {
                    flag = true;
                    groopNum[c][k] = groopNum[c - 1][k];
                }
                if(c != 99 && groop[c][k] != groop[c + 1][k] && map[c][k] != 9)
                {
                    flag = true;
                    groopNum[c][k] = groopNum[c + 1][k];
                }
                if(k != 0 && groop[c][k] != groop[c][k - 1] && map[c][k] != 9)
                {
                    flag = true;
                    groopNum[c][k] = groopNum[c][k - 1];
                }
                if(k != 99 && groop[c][k] != groop[c][k + 1] && map[c][k] != 9)
                {
                    flag = true;
                    groopNum[c][k] = groopNum[c][k + 1];
                }
                
                if(flag == true)
                {
                    groop[c][k] = true;
                }
                if(flag == false && map[c][k] != 9)
                {
                    x = x + 1;
                    groop[c][k] = true;
                    groopNum[c][k] = x;
                }
            }
        }
            
        for(int step = 0; step < 1000; step = step + 1)
        {
            for(int y = 0; y < 100; y = y + 1)
            {
                for(int X = 0; X < 100; X = X + 1)
                {
                    if(y != 0 && map[y][X] != 9 && map[y - 1][X] != 9 && groopNum[y][X] > groopNum[y - 1][X])
                    {
                        groopNum[y][X] = groopNum[y - 1][X];
                    }
                    if(y != 99 && map[y][X] != 9 && map[y + 1][X] != 9 && groopNum[y][X] > groopNum[y + 1][X])
                    {
                        groopNum[y][X] = groopNum[y + 1][X];
                    }
                    if(X != 0 && map[y][X] != 9 && map[y][X - 1] != 9 && groopNum[y][X] > groopNum[y][X - 1])
                    {
                        groopNum[y][X] = groopNum[y][X - 1];
                    }
                    if(X != 99 && map[y][X] != 9 && map[y][X + 1] != 9 && groopNum[y][X] > groopNum[y][X + 1])
                    {
                        groopNum[y][X] = groopNum[y][X + 1];
                    }
                }
            }
        }
        
        int big1 = 0;
        int big2 = 0;
        int big3 = 0;
        int fakeBig = 0;
        int transBig;
        for(; x >= 0; x = x - 1)
        {
            fakeBig = 0;
            for(int i = 0; i < 100; i = i + 1)
            {
                for(int j = 0; j < 100; j = j + 1)
                {
                    if(groopNum[i][j] == x)
                    {
                        fakeBig = fakeBig + 1;
                    }
                }
            }
            
            if(fakeBig > big3)
            {
                big3 = fakeBig;
            }
            if(big3 > big2)
            {
                transBig = big2;
                big2 = big3;
                big3 = transBig;
            }
            if(big2 > big1)
            {
                transBig = big1;
                big1 = big2;
                big2 = transBig;
            }
        }
            
        
        
        System.out.println(big1 * big2 * big3);
    }
}
