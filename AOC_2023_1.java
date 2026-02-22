import java.util.*;
import java.io.*;

public class AOC_2023_1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            int wer = 0;
            String scanded = scn.nextLine();
            boolean flag = false;
            for (int j = 0; j < scanded.length(); j = j + 1)
            {
                if (flag) break;
                
                if(j <= scanded.length() - 3 && scanded.substring(j, j + 3).equals("one"))
                {
                    wer = 10;
                    flag = true;
                    answer = answer + wer;
                }
                else if(j <= scanded.length() - 3 && scanded.substring(j, j + 3).equals("two"))
                {
                    wer = 20;
                    flag = true;
                    answer = answer + wer;  
                }
                else if(j <= scanded.length() - 5 && scanded.substring(j, j + 5).equals("three"))
                {
                    wer = 30;
                    flag = true;
                    answer = answer + wer;  
                }
                else if(j <= scanded.length() - 4 && scanded.substring(j, j + 4).equals("four"))
                {
                    wer = 40;
                    flag = true;
                    answer = answer + wer;  
                }
                else if(j <= scanded.length() - 4 && scanded.substring(j, j + 4).equals("five"))
                {
                    wer = 50;
                    flag = true;
                    answer = answer + wer;  
                }
                else if(j <= scanded.length() - 3 && scanded.substring(j, j + 3).equals("six"))
                {
                    wer = 60;
                    flag = true;
                    answer = answer + wer;  
                }
                else if(j <= scanded.length() - 5 && scanded.substring(j, j + 5).equals("seven"))
                {
                    wer = 70;
                    flag = true;
                    answer = answer + wer;  
                }
                else if(j <= scanded.length() - 5 && scanded.substring(j, j + 5).equals("eight"))
                {
                    wer = 80;
                    flag = true;
                    answer = answer + wer;  
                }
                else if(j <= scanded.length() - 4 && scanded.substring(j, j + 4).equals("nine"))
                {
                    wer = 90;
                    flag = true;
                    answer = answer + wer;  
                }
                
                if (scanded.charAt(j) <= '9' && flag == false)
                {
                    wer = (scanded.charAt(j) - 48) * 10;
                    flag = true;
                    answer = answer + wer;
                }
            }
            flag = false;
            int ans = 0;
            for (int i = scanded.length() - 1; i >= 0; i = i - 1)  
            {
                if (flag) break;
                
                if(i + 1 >= 3 && scanded.substring(i - 3 + 1, i + 1).equals("one"))
                {
                    ans = 1;
                    flag = true;
                    answer = answer + ans;
                }
                else if(i + 1 >= 3 && scanded.substring(i - 3 + 1, i + 1).equals("two"))
                {
                    ans = 2;
                    flag = true;
                    answer = answer + ans;  
                }
                else if(i + 1 >= 5 && scanded.substring(i - 5 + 1, i + 1).equals("three"))
                {
                    ans = 3;
                    flag = true;
                    answer = answer + ans;  
                }
                else if(i + 1 >= 4 && scanded.substring(i - 4 + 1, i + 1).equals("four"))
                {
                    ans = 4;
                    flag = true;
                    answer = answer + ans;  
                }
                else if(i + 1 >= 4 && scanded.substring(i - 4 + 1, i + 1).equals("five"))
                {
                    ans = 5;
                    flag = true;
                    answer = answer + ans;  
                }
                else if(i + 1 >= 3 && scanded.substring(i - 3 + 1, i + 1).equals("six"))
                {
                    ans = 6;
                    flag = true;
                    answer = answer + ans;  
                }
                else if(i + 1 >= 5 && scanded.substring(i - 5 + 1, i + 1).equals("seven"))
                {
                    ans = 7;
                    flag = true;
                    answer = answer + ans;  
                }
                else if(i + 1 >= 5 && scanded.substring(i - 5 + 1, i + 1).equals("eight"))
                {
                    ans = 8;
                    flag = true;
                    answer = answer + ans;  
                }
                else if(i + 1 >= 4 && scanded.substring(i - 4 + 1, i + 1).equals("nine"))
                {
                    ans = 9;
                    flag = true;
                    answer = answer + ans;  
                }
                
                if(scanded.charAt(i) < 58 && flag == false)
                {
                    ans = scanded.charAt(i) - 48;
                    flag = true;
                    answer = answer + ans;
                }
            }
        }
            
        System.out.println(answer);
    
    }
}