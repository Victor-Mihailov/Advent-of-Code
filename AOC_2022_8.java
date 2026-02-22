import java.util.*;
import java.io.*;

public class AOC_2022_8
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int tree = 0;
        int[][] forest = new int[99][99];
        String scaned;
        int big = 0;
        for(int i = 0; i < 99; i = i + 1)
        {
            scaned = scn.nextLine();
            for(int j = 0; j < 99; j = j + 1)
            {
                forest[i][j] = scaned.charAt(j) - 48;
            }
        }
        
        for(int c = 0; c < 99; c = c + 1)
        {
            for(int r = 0; r < 99; r = r + 1)
            {
                if(r == 98 || c == 98)
                {
                    answer = answer + 1;
                    // Mite need to do if I get the wrong answer
                }
                else
                {
                    tree = forest[c][r];
                    
                    int bigR = 0;
                    boolean flagR = false;
                    for(int p = r + 1; p < 99; p = p + 1)
                    {
                        if(forest[c][p] <= tree && flagR == false)
                        {
                            bigR = bigR + 1;
                        }
                        
                        if(forest[c][p] >= tree)
                        {
                            flagR = true;
                        }
                        
                        
                    }
                    
                    int bigL = 0;
                    boolean flagL = false;
                    for(int l = r - 1; l >= 0; l = l - 1)
                    {
                        if(forest[c][l] <= tree && flagL == false)
                        {
                            bigL = bigL + 1;
                        }
                        
                        if(forest[c][l] >= tree)
                        {
                            flagL = true;
                        }
                        
                        
                    }
                    
                    int bigU = 0;
                    boolean flagU = false;
                    for(int u = c + 1; u < 99; u = u + 1)
                    {
                        if(forest[u][r] <= tree && !flagU)
                        {
                            bigU = bigU + 1;
                        }
                        
                        if(forest[u][r] >= tree)
                        {
                            flagU = true;
                        }
                        
                        
                    }
                    
                    int bigD = 0;
                    boolean flagD = false;
                    for(int d = c - 1; d >= 0; d = d - 1)
                    {
                        if(forest[d][r] <= tree && !flagD)
                        {
                            bigD = bigD + 1;
                        }
                        
                        if(forest[d][r] >= tree)
                        {
                            flagD = true;
                        }
                    }
                    
                    if(flagR == false || flagL == false || flagU == false || flagD == false)
                    {
                        answer = answer + 1;
                    }
                    
                    if(bigR * bigL * bigU * bigD > big)
                    {
                        big = bigR * bigL * bigU * bigD;
                    }
                }
            }
        }
        System.out.println(big);
    }
}