import java.util.*;
import java.io.*;

public class AOC_2024_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int size = 140;
        int answer = 0;
        char[][] letters = new char[size][size];
        
        for(int i = 0; i < size; i = i + 1)
        {
            String scaned = scn.nextLine();
            for(int j = 0; j < size; j = j + 1)
            {
                letters[i][j] = scaned.charAt(j);
            }
        }
        
        for(int r = 0; r < 4; r = r + 1)
        {
            char[][] newLetters = new char[size][size];
            int x = size;
            for(int i = 0; i < size; i = i + 1)
            {
                x = x - 1;
                int y = -1;
                for(int j = 0; j < size; j = j + 1)
                {
                    y = y + 1;
                    newLetters[y][x] = letters[i][j];
                }
            }
            letters = newLetters;
            
            for(int a = 1; a < size - 1; a = a + 1)
            {
                for(int b = 1; b < size - 1; b = b + 1)
                {
                    if(letters[a][b] == 'A' && letters[a - 1][b + 1] == 'M' && letters[a - 1][b - 1] == 'M' && letters[a + 1][b + 1] == 'S'  && letters[a + 1][b - 1] == 'S')
                    {
                        answer = answer + 1;
                    }
                    
                    
                    
                    
                    
                    /*
                    if(a <= size - 4 && letters[a][b] == 'X' && letters[a + 1][b] == 'M' && letters[a + 2][b] == 'A' && letters[a + 3][b] == 'S') // may need <= not <;
                    {
                        answer = answer + 1;
                    }
                    if(a <= size - 4 && b <= size - 4 && letters[a][b] == 'X' && letters[a + 1][b + 1] == 'M' && letters[a + 2][b +2] == 'A' && letters[a + 3][b + 3] == 'S') // may need <= not <;
                    {
                        answer = answer + 1;
                    }
                    */
                }
            }
        }
            
        
        
        
        System.out.println(answer);
    }
}
