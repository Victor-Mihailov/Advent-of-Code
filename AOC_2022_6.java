import java.util.*;
import java.io.*;

public class AOC_2022_6
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        String mesage = scn.nextLine();
        
        for (int i = 14; i < mesage.length(); i = i + 1)
        {
            
            String subMesage = mesage.substring(i - 14, i);
            
            boolean notEqual = true;
            for(int c = 0; c < subMesage.length(); c = c + 1)
            {
                for(int k = 0; k < subMesage.length(); k = k + 1)
                {
                    if (subMesage.charAt(c) == subMesage.charAt(k) && c != k) 
                    {
                        notEqual = false;
                    }
                }
            }
            if (notEqual == true)
            {
                break;
            }
            else
            {
                answer = answer + 1;
            }
        }
        
            System.out.println(answer + 14);
        
    }    
}
