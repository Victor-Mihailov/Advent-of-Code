import java.util.*;
import java.io.*;

public class AOC_2025_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int with = 138;
        int length = scn.nextLine().length();
        boolean[][] map = new boolean[length][with];
        for(int y = 0; y < with; y = y + 1)
        {
            String line = scn.nextLine();
            for(int x = 0; x < length; x = x + 1)
            {
                map[x][y] = (line.charAt(x) == '@');
            }
        }
        boolean didy = true;
        while(didy)
        {
            didy = false;
            for(int y = 0; y < with; y = y + 1)
            {
                for(int x = 0; x < length; x = x + 1)
                {
                    if(map[x][y] == false) continue;
                    
                    int gaybers = 0;
                    gaybers += (y >= 1 && map[x][y - 1] == true) ? 1 : 0; // n
                    gaybers += (y < with - 1 && map[x][y + 1] == true) ? 1 : 0; // s
                    gaybers += (x >= 1 && map[x - 1][y] == true) ? 1 : 0; // w
                    gaybers += (x < length - 1 && map[x + 1][y] == true) ? 1 : 0; // e
                    gaybers += (y >= 1 && x >= 1 && map[x - 1][y - 1] == true) ? 1 : 0; // nw
                    gaybers += (y >= 1 && x < length - 1 && map[x + 1][y - 1] == true) ? 1 : 0; // ne
                    gaybers += (y < with - 1 && x >= 1 && map[x - 1][y + 1] == true) ? 1 : 0; // sw
                    gaybers += (y < with - 1 && x < length - 1 && map[x + 1][y + 1] == true) ? 1 : 0; // se
                    
                    answer += (gaybers < 4) ? 1 : 0;
                    didy = (didy || gaybers < 4);
                    map[x][y] = !(gaybers < 4);
                    // gaybers += gabers > 8 ? 54 : -3;
                }
            }
        }
            
        
        System.out.println(answer);
    }
}