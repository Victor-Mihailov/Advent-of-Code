import java.util.*;
import java.io.*;

public class AOC_2019_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        for(int i = 272091; i <= 815432; i = i + 1)
        {
            String password = i + "";
            //boolean flag = false;
            if(password.charAt(0) <= password.charAt(1) && password.charAt(1) <= password.charAt(2) && 
            password.charAt(2) <= password.charAt(3) && password.charAt(3) <= password.charAt(4) && 
            password.charAt(4) <= password.charAt(5))
            {
                if(password.charAt(0) == password.charAt(1) && password.charAt(1) != password.charAt(2) 
                || password.charAt(1) == password.charAt(2) && password.charAt(1) != password.charAt(0) 
                && password.charAt(2) != password.charAt(3) || password.charAt(2) == password.charAt(3) 
                && password.charAt(1) != password.charAt(2) && password.charAt(3) != password.charAt(4) 
                || password.charAt(2) != password.charAt(3) && password.charAt(3) == password.charAt(4)
                && password.charAt(4) != password.charAt(5) || password.charAt(4) == password.charAt(5)
                && password.charAt(3) != password.charAt(4))
                {
                    answer = answer + 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}
