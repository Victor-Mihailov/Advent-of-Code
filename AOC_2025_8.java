import java.util.*;
import java.io.*;

public class AOC_2025_8
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        final int NOP = 1000;
        ArrayList<int[]> pointList = new ArrayList<int[]>();
        while (scn.hasNextLine())
        {
            String[] temp = scn.nextLine().split(",");
            int[] point = new int[temp.length];
            for(int i = 0; i < point.length; i = i + 1)
            {
                point[i] = Integer.parseInt(temp[i]);
            }
            pointList.add(point);
        }
        
        ArrayList<int[]> lineList = new ArrayList<int[]>();
        for(int t = 0; t < 1000; t = t + 1)
        {
            int smallest = Integer.MAX_VALUE;
            int[] choosen = new int[2];
            for(int i = 0; i < NOP; i = i + 1)
            {
                for(int j = 1; j < NOP - i; j = j + 1)
                {
                    int fx = pointList.get(i)[0];
                    int sx = pointList.get(i + j)[0];
                    int fy = pointList.get(i)[1];
                    int sy = pointList.get(i + j)[1];
                    int fz = pointList.get(i)[2];
                    int sz = pointList.get(i + j)[2];
                    int lx = (fx - sx) * (fx - sx);
                    int ly = (fy - sy) * (fy - sy);
                    int lz = (fz - sz) * (fz - sz);
                    int line = lx + ly + lz;
                    int[] pair = new int[2];
                    pair[0] = i;
                    pair[1] = i + j;
                    smallest = (line < smallest && lineList.contains(pair) == false) ? line : smallest;
                    
                    choosen = (line < smallest && lineList.contains(pair) == false) ? pair : choosen;
                }
            }
            lineList.add(0, choosen);
            System.out.println(choosen[1]);
        }
        
        
        
        
        System.out.println(answer);
    }
}