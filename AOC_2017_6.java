import java.util.*;
import java.io.*;

public class AOC_2017_6
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        
        int answer = 0;
        int[] list = new int[16];
        ArrayList<String> lists = new ArrayList<String>();
        
        for(int i = 0; i < 16; i = i + 1)
        {
            list[i] = scn.nextInt();        
        }
        
        while(lists.contains(pic(list)) == false)
        {
            lists.add(pic(list)); 
            
            int rich = 0;
            int p = 0;
            for(int j = 0; j < 16; j = j + 1)
            {
                if(list[j] > rich)
                {
                    rich = list[j];
                    p = j;
                }
            }
                        
            list = commies(list, rich, p);
            answer = answer + 1;           
        }
        
        answer = answer - lists.indexOf(pic(list));
        System.out.println(answer);
    }
    
    public static int[] commies(int[] list, int rich, int p)
    {
        list[p] = 0;
        
        for(int i = 1; i <= rich; i = i + 1)
        {
            list[(p + i) % 16] = list[(p + i) % 16] + 1;
        }
        return list;
    }
    
    
    public static String pic(int[] list)
    {
        String pic = "v";
        for(int i = 0; i < 16; ++i)
        {
            pic = pic + "v" + list[i];
        }
        return pic;
    }
}