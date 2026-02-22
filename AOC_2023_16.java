import java.util.*;
import java.io.*;

public class AOC_2023_16
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        final int x = 110;
        final int y = 110;
        char[][] contraption = new char[x][y];
        for(int i = 0; i < y; i = i + 1)
        {
            String line = scn.nextLine();
            for(int j = 0; j < x; j = j + 1)
            {
                contraption[j][i] = line.charAt(j);
            }
        }
        
        for(int leftSide = 0; leftSide < y; leftSide = leftSide + 1)
        {
            boolean[][] energized = new boolean[x][y];
            boolean[][][] beams = new boolean[x][y][4];
            beams[0][leftSide][0] = true;
            System.out.println(leftSide);
            for(int step = 0; step < 100000; step = step + 1)
            {
                for(int i = 0; i < y; i = i + 1)
                {
                    for(int j = 0; j < x; j = j + 1)
                    {
                        for(int d = 0; d < 4; d = d + 1)
                        {
                            if(beams[j][i][d] == true)
                            {
                                energized[j][i] = true;
                                beams[j][i][d] = false;
                                if(contraption[j][i] == '.' || (contraption[j][i] == '-' && d % 2 == 0) || (contraption[j][i] == '|' && d % 2 == 1))
                                {
                                    if(d == 0)
                                    {
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '/')
                                {
                                    if(d == 0)
                                    {
                                        d = 1;
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        d = 0;
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        d = 3;
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        d = 2;
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '\\') // '\\' is goofy
                                {
                                    if(d == 0)
                                    {
                                        d = 3;
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        d = 2;
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        d = 1;
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        d = 0;
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '-')
                                {
                                    if(d == 1 || d == 3)
                                    {
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][0] = true;
                                        }
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][2] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '|')
                                {
                                    if(d == 0 || d == 2)
                                    {
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][1] = true;
                                        }
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][3] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int curentAnswer = 0;
            for(int a = 0; a < y; a = a + 1)
            {
                for(int b = 0; b < x; b = b + 1)
                {
                    if(energized[b][a] == true)
                    {
                        curentAnswer = curentAnswer + 1;
                    }
                }
            }
            if(curentAnswer > answer)
            {
                answer = curentAnswer;
            }
        }
        
        for(int rightSide = 0; rightSide < y; rightSide = rightSide + 1)
        {
            boolean[][] energized = new boolean[x][y];
            boolean[][][] beams = new boolean[x][y][4];
            beams[x - 1][rightSide][2] = true;
            System.out.println(rightSide);
            for(int step = 0; step < 100000; step = step + 1)
            {
                for(int i = 0; i < y; i = i + 1)
                {
                    for(int j = 0; j < x; j = j + 1)
                    {
                        for(int d = 0; d < 4; d = d + 1)
                        {
                            if(beams[j][i][d] == true)
                            {
                                energized[j][i] = true;
                                beams[j][i][d] = false;
                                if(contraption[j][i] == '.' || (contraption[j][i] == '-' && d % 2 == 0) || (contraption[j][i] == '|' && d % 2 == 1))
                                {
                                    if(d == 0)
                                    {
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '/')
                                {
                                    if(d == 0)
                                    {
                                        d = 1;
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        d = 0;
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        d = 3;
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        d = 2;
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '\\') // '\\' is goofy
                                {
                                    if(d == 0)
                                    {
                                        d = 3;
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        d = 2;
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        d = 1;
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        d = 0;
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '-')
                                {
                                    if(d == 1 || d == 3)
                                    {
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][0] = true;
                                        }
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][2] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '|')
                                {
                                    if(d == 0 || d == 2)
                                    {
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][1] = true;
                                        }
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][3] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int curentAnswer = 0;
            for(int a = 0; a < y; a = a + 1)
            {
                for(int b = 0; b < x; b = b + 1)
                {
                    if(energized[b][a] == true)
                    {
                        curentAnswer = curentAnswer + 1;
                    }
                }
            }
            if(curentAnswer > answer)
            {
                answer = curentAnswer;
            }
        }
        
        for(int bottomSide = 0; bottomSide < x; bottomSide = bottomSide + 1)
        {
            boolean[][] energized = new boolean[x][y];
            boolean[][][] beams = new boolean[x][y][4];
            beams[bottomSide][y - 1][1] = true;
            System.out.println(bottomSide);
            for(int step = 0; step < 100000; step = step + 1)
            {
                for(int i = 0; i < y; i = i + 1)
                {
                    for(int j = 0; j < x; j = j + 1)
                    {
                        for(int d = 0; d < 4; d = d + 1)
                        {
                            if(beams[j][i][d] == true)
                            {
                                energized[j][i] = true;
                                beams[j][i][d] = false;
                                if(contraption[j][i] == '.' || (contraption[j][i] == '-' && d % 2 == 0) || (contraption[j][i] == '|' && d % 2 == 1))
                                {
                                    if(d == 0)
                                    {
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '/')
                                {
                                    if(d == 0)
                                    {
                                        d = 1;
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        d = 0;
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        d = 3;
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        d = 2;
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '\\') // '\\' is goofy
                                {
                                    if(d == 0)
                                    {
                                        d = 3;
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        d = 2;
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        d = 1;
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        d = 0;
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '-')
                                {
                                    if(d == 1 || d == 3)
                                    {
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][0] = true;
                                        }
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][2] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '|')
                                {
                                    if(d == 0 || d == 2)
                                    {
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][1] = true;
                                        }
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][3] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int curentAnswer = 0;
            for(int a = 0; a < y; a = a + 1)
            {
                for(int b = 0; b < x; b = b + 1)
                {
                    if(energized[b][a] == true)
                    {
                        curentAnswer = curentAnswer + 1;
                    }
                }
            }
            if(curentAnswer > answer)
            {
                answer = curentAnswer;
            }
        }
        
        for(int topSide = 0; topSide < x; topSide = topSide + 1)
        {
            boolean[][] energized = new boolean[x][y];
            boolean[][][] beams = new boolean[x][y][4];
            beams[topSide][0][3] = true;
            System.out.println(topSide);
            for(int step = 0; step < 100000; step = step + 1)
            {
                for(int i = 0; i < y; i = i + 1)
                {
                    for(int j = 0; j < x; j = j + 1)
                    {
                        for(int d = 0; d < 4; d = d + 1)
                        {
                            if(beams[j][i][d] == true)
                            {
                                energized[j][i] = true;
                                beams[j][i][d] = false;
                                if(contraption[j][i] == '.' || (contraption[j][i] == '-' && d % 2 == 0) || (contraption[j][i] == '|' && d % 2 == 1))
                                {
                                    if(d == 0)
                                    {
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '/')
                                {
                                    if(d == 0)
                                    {
                                        d = 1;
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        d = 0;
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        d = 3;
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        d = 2;
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '\\') // '\\' is goofy
                                {
                                    if(d == 0)
                                    {
                                        d = 3;
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][d] = true;
                                        }
                                    }
                                    else if(d == 1)
                                    {
                                        d = 2;
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][d] = true;
                                        }
                                    }
                                    else if(d == 2)
                                    {
                                        d = 1;
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][d] = true;
                                        }
                                    }
                                    else if(d == 3)
                                    {
                                        d = 0;
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][d] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '-')
                                {
                                    if(d == 1 || d == 3)
                                    {
                                        if(j + 1 < x)
                                        {
                                            beams[j + 1][i][0] = true;
                                        }
                                        if(j - 1 >= 0)
                                        {
                                            beams[j - 1][i][2] = true;
                                        }
                                    }
                                }
                                else if(contraption[j][i] == '|')
                                {
                                    if(d == 0 || d == 2)
                                    {
                                        if(i - 1 >= 0)
                                        {
                                            beams[j][i - 1][1] = true;
                                        }
                                        if(i + 1 < y)
                                        {
                                            beams[j][i + 1][3] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int curentAnswer = 0;
            for(int a = 0; a < y; a = a + 1)
            {
                for(int b = 0; b < x; b = b + 1)
                {
                    if(energized[b][a] == true)
                    {
                        curentAnswer = curentAnswer + 1;
                    }
                }
            }
            if(curentAnswer > answer)
            {
                answer = curentAnswer;
            }
        }
        
        System.out.println(answer);
    }
}