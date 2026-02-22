import java.util.*;
import java.io.*;

public class AOC_2020_8
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        String[] directions = new String[638];
        
        for(int i = 0; i < 638; i = i + 1)
        {
            directions[i] = scn.nextLine();
        }
        /*
        HashMap<String, Long> map = new HashMap();
        map.put("a", 0l);
        map.put("b", 0l);
        map.put("c", 1l);
        map.put("d", (long)0);
        
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        */
        ArrayList<Long> is = new ArrayList<Long>();
        
        for(long i = 0; i < 638; i = i + 1)
        {
            Scanner scan = new Scanner(directions[(int)i]);
            String cmd = scan.next();
            if(is.contains(i))
            {
                break;
            }
            
            is.add(i);
            if(cmd.equals("acc"))
            {
                String letter = scan.next();
                answer = answer + Long.parseLong(letter);
            }
            
            else if(cmd.equals("jmp"))
            {
                String num = scan.next();
                i = i + Long.parseLong(num) - 1;
                
            }
        }
        
        System.out.println();
    }
}
