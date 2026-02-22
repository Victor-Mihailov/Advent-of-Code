import java.util.*;
import java.io.*;

public class AOC_2021_10
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        ArrayList<Long> answer = new ArrayList<Long>();
        
        while (scn.hasNextLine())
        {
            
            boolean corrupted = false;
            String line = scn.nextLine();       
            
            for(int i = 1; i < line.length(); i = i + 1) // i is the position of the closing bracket;
            {
                if(line.charAt(i) == line.charAt(i - 1) + 1 || line.charAt(i) == line.charAt(i - 1) + 2)
                {
                    line = line.substring(0, i - 1) + line.substring(i + 1);
                    i = 0;
                }
            }
            //System.out.println(line);
            for(int j = 0; j < line.length(); j = j + 1)
            {
                if(line.charAt(j) == ')')
                {
                    corrupted = true;
                    break;
                }
                else if(line.charAt(j) == ']')
                {
                    corrupted = true;
                    break;
                }
                else if(line.charAt(j) == '}')
                {
                    corrupted = true;
                    break;
                }
                else if(line.charAt(j) == '>')
                {
                    corrupted = true;
                    break;
                }
            }
            
            if(corrupted == false)
            {
                long currentAnswer = 0;
                for(int i = line.length() - 1; i >= 0; i = i - 1)
                {
                    if(line.charAt(i) == '(')
                    {
                        currentAnswer = currentAnswer * 5 + 1;
                    }
                    else if(line.charAt(i) == '[')
                    {
                        currentAnswer = currentAnswer * 5 + 2;
                    }
                    else if(line.charAt(i) == '{')
                    {
                        currentAnswer = currentAnswer * 5 + 3;
                    }
                    else if(line.charAt(i) == '<')
                    {
                        currentAnswer = currentAnswer * 5 + 4;
                    }
                }
                answer.add(currentAnswer);
                
                System.out.println(line);
            }
            //System.out.println(line);
            
            
        }
        
        long[] orderedAnswer = new long[answer.size()];
        for(int convert = 0; convert < answer.size(); convert = convert + 1)
        {
            orderedAnswer[convert] = answer.get(convert);
            //System.out.println(orderedAnswer[0]);
        }
        //System.out.println(orderedAnswer[25]);
        boolean hasWork = true;
        while(hasWork)
        {
            hasWork = false;
            for(int sort = 0; sort < answer.size() - 1; sort = sort + 1)
            {
                long temp = 0;
                if(orderedAnswer[sort] > orderedAnswer[sort + 1])
                {
                    temp = orderedAnswer[sort];
                    orderedAnswer[sort] = orderedAnswer[sort + 1];
                    orderedAnswer[sort + 1] = temp;
                    hasWork = true;
                }
            }    
        }
            
        int half = (answer.size() - 1) / 2;
        System.out.println(orderedAnswer[half]);
        //System.out.println(answer);
    }
}