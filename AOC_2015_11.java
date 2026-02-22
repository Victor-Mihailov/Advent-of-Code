import java.util.*;
import java.io.*;
// Do later maybe, do not understand letter changing;
public class AOC_2015_11
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);

        String password = "cqjxxyzz";
        char[] code = new char[password.length()];
        for(int i = 0; i < password.length(); i = i + 1)
        {
            code[i] = password.charAt(i);
        }
        
        boolean flag = false;
        while(flag == false)
        {
            code[7] += 1;
            for(int i = 7; i >= 0; i = i - 1)
            {
                if(code[i] > 'z')
                {
                    code[i] = 'a';
                    code[i - 1] += 1;
                }
            }
            
            for(int i = 1; i <= 7; i = i + 1)
            {
                for(int j = (password.length() - i) - 2; j >= 1; j = j - 1)
                {
                    if(code[password.length() - i] == code[(password.length() - i) - 1])
                    {
                        if(code[j] == code[j - 1])// First three if statements are for duble same
                        {
                            if(code[password.length() - i] != code[j])
                            {
                                for(int a = 0; a < 6; a = a + 1)
                                {
                                    int b = a + 1;
                                    int c = b + 1;
                                    if(code[a] == code[b] - 1 && code[b] == code[c] - 1)
                                    {
                                        boolean sFlag = false;
                                        for(int check = 0; check < 8; check = check + 1)
                                        {
                                            if(code[check] == 'i' || code[check] == 'o' || code[check] == 'l')
                                            {
                                                sFlag = true;
                                            }
                                        }
                                        if(sFlag == false)
                                        {
                                            flag = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < 8; i = i + 1)
        {
            System.out.println(code[i]);
        }
        
        
    }
}