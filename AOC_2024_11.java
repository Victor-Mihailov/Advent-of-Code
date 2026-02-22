import java.util.*;
import java.io.*;

public class AOC_2024_11
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        
        HashMap<String, Long> sMap = new HashMap<String, Long>();
        
        while(scn.hasNext() == true)
        {
            String scaned = scn.next();
            sMap.put(scaned, 1l);
        }
        
        
        for(int i = 0; i < 75; i = i + 1)
        {
            HashMap<String, Long> temp = new HashMap<String, Long>();
            for(String key : sMap.keySet())
            {
                String gone = "";
                
                if(key.equals("0"))
                {
                    temp.put("1", sMap.get("0") + temp.getOrDefault("1", 0l));
                }
                else if(key.length() % 2 == 0)
                {
                    // key = Long.parseLong(key) + "";
                    
                    gone = key.substring(0, key.length() / 2);
                    // gone = Long.parseLong(gone) + "";
                    temp.put(gone, sMap.get(key) + temp.getOrDefault(gone, 0l));
                    
                    gone = key.substring(key.length() / 2);
                    gone = Long.parseLong(gone) + "";
                    temp.put(gone, sMap.get(key) + temp.getOrDefault(gone, 0l));
                }
                else
                {
                    temp.put((Long.parseLong(key) * 2024) + "", sMap.get(key) + temp.getOrDefault((Long.parseLong(key) * 2024) + "", 0l));
                }
            }
            sMap = temp;
            //System.out.println();
        }
        
        for(String key : sMap.keySet())
        {
            answer = answer + sMap.get(key);
        }
        
        System.out.println(answer);
    }
}