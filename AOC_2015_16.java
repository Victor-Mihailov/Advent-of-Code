import java.util.*;
import java.io.*;

public class AOC_2015_16
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        /*
            children: 3
            cats: 7
            samoyeds: 2
            pomeranians: 3
            akitas: 0
            vizslas: 0
            goldfish: 5
            trees: 3
            cars: 2
            perfumes: 1
        */
        
        
        int answer = 0;
        boolean flag = false;
        while(flag == false)
        {
            answer = answer + 1;
            
            int sueniss = 0;
            String line = scn.nextLine();
            if(line.contains("children: 3"))
            {
                sueniss = sueniss + 1;
            }
            boolean haveCat = false;
            for(int more = 7; more <= 10; more = more + 1)
            {
                if(line.contains("cats: " + more) && haveCat == false)
                {
                    haveCat = true;
                    sueniss = sueniss + 1;
                }
            }                
            if(line.contains("samoyeds: 2"))
            {
                sueniss = sueniss + 1;
            }
            boolean havePomeranians = false;
            for(int less = 3; less >= 0; less = less - 1)
            {
                if(line.contains("pomeranians: " + less) && havePomeranians == false)
                {
                    havePomeranians = true;
                    sueniss = sueniss + 1;
                }
            }    
            if(line.contains("akitas: 0"))
            {
                sueniss = sueniss + 1;
            }
            if(line.contains("vizslas: 0"))
            {
                sueniss = sueniss + 1;
            }
            boolean haveFish = false;
            for(int less = 5; less >= 0; less = less - 1)
            {
                if(line.contains("goldfish: " + less) && haveFish == false)
                {
                    haveFish = true;
                    sueniss = sueniss + 1;
                }
            }
            boolean haveTree = false;
            for(int more = 3; more <= 10; more = more + 1)
            {
                if(line.contains("trees: " + more) && haveTree == false)
                {
                    haveTree = true;
                    sueniss = sueniss + 1;
                }
            }                
            if(line.contains("cars: 2"))
            {
                sueniss = sueniss + 1;
            }
            if(line.contains("perfumes: 1"))
            {
                sueniss = sueniss + 1;
            }
            
            if(sueniss == 3)
            {
                flag = true;
                System.out.println(answer);
            }
        }
        
        
    }
}