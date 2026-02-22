import java.util.*;
import java.io.*;

public class AOC_2016_12
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        String[] directions = new String[23];
        
        for(int i = 0; i < 23; i = i + 1)
        {
            directions[i] = scn.nextLine();
        }
        HashMap<String, Long> map = new HashMap();
        map.put("a", 0l);
        map.put("b", 0l);
        map.put("c", 1l);
        map.put("d", (long)0);
        /*
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        */
        for(long i = 0; i < 23; i = i + 1)
        {
            Scanner scan = new Scanner(directions[(int)i]);
            String cmd = scan.next();
            if(cmd.equals("cpy"))
            {
                String num = scan.next();
                String letter = scan.next();
                if(num.equals("a") || num.equals("b") || num.equals("c") || num.equals("d")) 
                {
                    map.put(letter, map.get(num));
                }
                else 
                {
                    map.put(letter, Long.parseLong(num));
                }
            }
            else if(cmd.equals("inc"))
            {
                String letter = scan.next();
                map.put(letter, map.get(letter) + 1);
            }
            else if(cmd.equals("dec"))
            {
                String letter = scan.next();
                map.put(letter, map.get(letter) - 1);
            }
            else if(cmd.equals("jnz"))
            {
                String num = scan.next();
                if(num.equals("a") || num.equals("b") || num.equals("c") || num.equals("d")) 
                {
                    if(map.get(num) != 0)
                    {
                        num = scan.next();
                        i = i + Long.parseLong(num) - 1;
                    }
                }
                else if(Integer.parseInt(num) != 0)
                {
                    num = scan.next();
                    i = i + Long.parseLong(num) - 1;
                }
            }
        }
        
        System.out.println(map.get("a"));
    }
}
