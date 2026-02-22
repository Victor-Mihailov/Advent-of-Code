import java.util.*;
import java.io.*;

public class AOC_2025_2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        long answer = 0;
        
        String line = scn.nextLine();
        String[] ranges = line.split(",");
        
        for(int i = 0; i < ranges.length; i = i + 1)
        {
            long cid = Long.parseLong(ranges[i].substring(0, ranges[i].indexOf("-"))); // curent id
            System.out.println(cid);
            String cidw = cid + ""; // curent id as a word
            long cidl = cidw.length();
            long lvn = Long.parseLong(ranges[i].substring(ranges[i].indexOf("-") + 1)); // last valid number
            
            //boolean stop = false;
            if(cidl % 2 == 1)
            {
                cid = (long)Math.pow(10, cidl);
                System.out.println(cid);
                cidw = cid + "";
                cidl = cidw.length(); 
            }
            long fh = Long.parseLong(cidw.substring(0, cidw.length() / 2));
            long sh = Long.parseLong(cidw.substring(cidw.length() / 2));
            while(cid <= lvn)
            {
                if(fh < sh)
                {
                    fh = fh + 1;
                }
                sh = fh;
                cid = (fh * (long)Math.pow(10, (cidl / 2))) + sh;
                //System.out.println(cid);
                if(cid <= lvn)
                {
                    answer = answer + cid;
                    //System.out.println(cid);
                }
                
                
                if(cid == (long)Math.pow(10, cidl) - 1)
                {
                    cid = (long)Math.pow(10, (cidl + 1));
                }
                else
                {
                    fh = fh + 1;
                    sh = sh + 1;
                    cid = (fh * (long)Math.pow(10, (cidl / 2))) + sh;
                }
                cidw = cid + "";
                cidl = cidw.length();
                fh = Long.parseLong(cidw.substring(0, cidw.length() / 2));
                sh = Long.parseLong(cidw.substring(cidw.length() / 2));
            }
        }
        
        System.out.println(answer);
    }
}