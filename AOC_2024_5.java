import java.util.*;
import java.io.*;

public class AOC_2024_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        boolean flag = false;
        while(scn.hasNextLine())
        {
            String line = scn.nextLine();
            if(line.equals("") && flag == false)
            {
                flag = true;
            }
            else if(flag == false)
            {
                left.add(Integer.parseInt(line.substring(0, 2)));
                right.add(Integer.parseInt(line.substring(3)));
            }
            else if (flag == true)
            {
                String[] temp = line.split(",");
                int[] page = new int[temp.length];
                for(int i = 0; i < page.length; i = i + 1)
                {
                    page[i] = Integer.parseInt(temp[i]);
                }
                
                boolean follow = true;
                for(int i = 0; i < left.size(); i = i + 1)
                {
                    int lp = -1;
                    int rp = -1;
                    for(int j = 0; j < page.length; j = j + 1)
                    {
                        if(page[j] == left.get(i))
                        {
                            lp = j;
                        }
                        if(page[j] == right.get(i))
                        {
                            rp = j;
                        }
                    }
                    if(lp == -1 || rp == -1 || lp < rp)
                    {
                        follow = follow;
                    }
                    else
                    {
                        follow = false;
                        int t = page[lp];
                        page[lp] = page[rp];
                        page[rp] = t;
                        i = -1;
                    }
                }
                if(follow == false)
                {
                    answer = answer + page[page.length / 2];
                }
            }  
        }
        
        System.out.println(answer);
    }
}