import java.util.*;
import java.io.*;

public class AOC_2016_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            String[] data = line.split("-");
            
            HashMap<Character, Integer> seal = new HashMap<Character, Integer>();
            for(int i = 0; i < Math.abs(data.length - 1); i = i + 1)
            {
                for(int j = 0; j <= data[i].length() - 1; j = j + 1)
                {
                    seal.put(data[i].charAt(j), seal.getOrDefault(data[i].charAt(j), 0) + 1);
                }
            }
            int id = Integer.parseInt(data[data.length - 1].substring(0, data[data.length - 1].indexOf("[")));
            String checksum = data[data.length - 1].substring(data[data.length - 1].indexOf("[") + 1, data[data.length - 1].length() - 1);
            
            boolean flag = false;
            for(int i = 0; i < checksum.length(); i = i + 1)
            {
                int big = -1;
                Character theChoosen1 = null;
                for(Character key : seal.keySet())
                {
                    if(seal.get(key) > big || big == seal.get(key) && key < theChoosen1) // comparing characters is wird
                    {
                        big = seal.get(key);
                        theChoosen1 = key;
                    }
                }
                if(theChoosen1 != checksum.charAt(i))
                {
                    flag = true;
                }
                else
                {
                    seal.remove(theChoosen1);
                }
            }
            if(flag == false)
            {
                System.out.println(id);
                for(int i = 0; i < data.length -1; i = i + 1)
                {
                    for(int j = 0; j < data[i].length(); j = j + 1)
                    {
                        char cur = (char)(((data[i].charAt(j) - 'a' + id) % 26) + 'a'); // weird stuff
                        System.out.print(cur);
                    }
                    System.out.print(" ");
                }
                answer = answer + id;
            }
        }
        
        System.out.println(answer);
    }
}