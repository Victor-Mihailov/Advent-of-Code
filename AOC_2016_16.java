import java.util.*;
import java.io.*;

public class AOC_2016_16
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        ArrayList<Integer> code = new ArrayList<Integer>();
        String input = scn.nextLine();
        for(int i = 0; i < input.length(); i = i + 1)
        {
            
            code.add(Integer.parseInt(input.charAt(i)));
        }
        int fileLength = 272;
        
        boolean done = false;
        while(done == false)
        {
            
        }
        
        System.out.println(answer);
    }
}