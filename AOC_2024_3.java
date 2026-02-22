import java.util.*;
import java.io.*;

public class AOC_2024_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        boolean doFlag = true;
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            for(int i = 0; i < line.length(); i = i + 1)
            {
                if(i + 4 < line.length() && line.substring(i, i + 4).equals("do()")) // may need to be i + 3;
                {
                    doFlag = true;
                }
                else if(i + 7 < line.length() && line.substring(i, i + 7).equals("don't()")) // may need to be i + 6;
                {
                    doFlag = false;
                }
                if(i + 3 < line.length() && line.substring(i, i + 4).equals("mul(") && doFlag)
                {
                    boolean flag = false;
                    String num1 = "";
                    for(int j = i + 4; flag == false; j = j + 1)
                    {
                        if(j < line.length() && line.charAt(j) <= '9' && line.charAt(j) >= '0')
                        {
                            num1 = num1 + line.charAt(j);
                        }
                        else if(j < line.length() && line.charAt(j) == ',')
                        {
                            flag = true;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if(flag == true && num1.length() > 0)
                    {
                        flag = false;
                        String num2 = "";
                        for(int j = i + 4 + num1.length() + 1; flag == false; j = j + 1)
                        {
                            if(j < line.length() && line.charAt(j) <= '9' && line.charAt(j) >= '0')
                            {
                                num2 = num2 + line.charAt(j);
                            }
                            else if(j < line.length() && line.charAt(j) == ')')
                            {
                                flag = true;
                            }
                            else
                            {
                                break;
                            }
                        }
                        if(flag == true && num2.length() > 0)
                        {
                            answer = answer + (Integer.parseInt(num1) * Integer.parseInt(num2));
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}