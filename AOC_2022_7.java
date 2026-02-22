import java.util.*;
import java.io.*;

public class AOC_2022_7
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        Node root = new Node("/", 0, null);
        Node current = root;
        
        
        while (scn.hasNextLine())
        {
            String scaned = scn.next();
            if(scaned.equals("$"))
            {
                scaned = scn.next();
                if(scaned.equals("cd"))
                {
                    scaned = scn.next();
                    if(scaned.equals("/"))
                    {
                        current = root;        
                    }
                    else if(scaned.equals(".."))
                    {
                        current = current.parent;
                    }
                    else
                    {
                        current = current.kidnap(scaned);
                    }
                }
            }
            else if(scaned.equals("dir"))
            {
                scaned = scn.next();
                current.kids.add(new Node(scaned, 0, current));
            }
            else
            {
                int value = Integer.parseInt(scaned);
                scaned = scn.next();
                current.kids.add(new Node(scaned, value, current));
            }
        }
        
        //answer = root.bob();
        int freeS = 70000000 - root.total();
        int num = 30000000 - freeS;
        answer = root.smallnis(num);
        System.out.println(answer);
    }   
}