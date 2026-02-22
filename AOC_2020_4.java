import java.util.*;
import java.io.*;

public class AOC_2020_4
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        int fall = 0;
        
        boolean byrFlag = false;
        boolean iyrFlag = false;
        boolean eyrFlag = false;
        boolean hgtFlag = false;
        boolean hclFlag = false;
        boolean eclFlag = false;
        boolean pidFlag = false;
        boolean cidFlag = false;
        
        while (scn.hasNextLine())
        {
            String scanedLine = scn.nextLine();
            
            if(scanedLine.equals(""))
            {
                if(byrFlag == true && iyrFlag == true && eyrFlag == true && hgtFlag == true && hclFlag ==
                true && eclFlag == true && pidFlag == true)
                {
                    answer = answer + 1;
                }
                
                byrFlag = false;
                iyrFlag = false;
                eyrFlag = false;
                hgtFlag = false;
                hclFlag = false;
                eclFlag = false;
                pidFlag = false;
                cidFlag = false;
            }
            else
            {
                Scanner passportScn = new Scanner(scanedLine);
                
                while(passportScn.hasNext())
                {
                    String scaned = passportScn.next();
                    
                    if(scaned.substring(0, 3).equals("byr") && Integer.parseInt(scaned.substring(4, 8)) >= 1920 && 
                    Integer.parseInt(scaned.substring(4, 8)) <= 2002)
                    {
                        byrFlag = true;
                    }
                    else if(scaned.substring(0, 3).equals("iyr") && Integer.parseInt(scaned.substring(4, 8)) >= 2010 && 
                    Integer.parseInt(scaned.substring(4, 8)) <= 2020)
                    {
                        iyrFlag = true;
                    }
                    else if(scaned.substring(0, 3).equals("eyr") && Integer.parseInt(scaned.substring(4, 8)) >= 2020 
                    && Integer.parseInt(scaned.substring(4, 8)) <= 2030)
                    {
                        eyrFlag = true;
                    }
                    else if(scaned.substring(0, 3).equals("hgt") && 
                    scaned.substring(scaned.length() - 2).equals("cm") && 
                    Integer.parseInt(scaned.substring(4, scaned.length() - 2)) >= 150 && 
                    Integer.parseInt(scaned.substring(4, scaned.length() - 2)) <= 193 || 
                    scaned.substring(0, 3).equals("hgt") && 
                    scaned.substring(scaned.length() - 2).equals("in") && 
                    Integer.parseInt(scaned.substring(4, scaned.length() - 2)) >= 59 && 
                    Integer.parseInt(scaned.substring(4, scaned.length() - 2)) <= 76)
                    
                    {
                        hgtFlag = true;
                    }
                    else if(scaned.substring(0, 5).equals("hcl:#") && scaned.charAt(5) >= 48 && scaned.charAt(5) <= 57 && 
                    scaned.charAt(6) >= 48 && scaned.charAt(6) <= 57 && scaned.charAt(7) >= 48 && scaned.charAt(7) <= 57 && 
                    scaned.charAt(8) >= 48 && scaned.charAt(8) <= 57  && scaned.charAt(9) >= 48 && scaned.charAt(9) <= 57
                    && scaned.charAt(10) >= 48 && scaned.charAt(10) <= 57 || scaned.substring(0, 5).equals("hcl:#") && 
                    scaned.charAt(5) >= 97 && scaned.charAt(5) <= 102 && 
                    scaned.charAt(6) >= 97 && scaned.charAt(6) <= 102 && scaned.charAt(7) >= 97 && scaned.charAt(7) <= 102 && 
                    scaned.charAt(8) >= 97 && scaned.charAt(8) <= 102  && scaned.charAt(9) >= 97 && scaned.charAt(9) <= 102
                    && scaned.charAt(10) >= 97 && scaned.charAt(10) <= 102)
                    {
                        hclFlag = true;
                    }
                    else if(scaned.substring(0, 3).equals("ecl") && scaned.substring(4).equals("amb") || 
                    scaned.substring(0 , 3).equals("ecl") && scaned.substring(4).equals("blu") || 
                    scaned.substring(0).equals("ecl:brn") || scaned.equals("ecl:gry") || 
                    scaned.equals("ecl:grn") || scaned.equals("ecl:hzl") || scaned.equals("ecl:oth"))
                    {
                        eclFlag = true;
                    }
                    else if(scaned.substring(0, 3).equals("pid") && scaned.length() == 13)
                    {
                        int pidyflag = 0;
                        for(int p = 4; p < 13; p = p + 1)
                        {
                            if(scaned.charAt(p) >= 48 && scaned.charAt(p) <= 57)
                            {
                                pidyflag = pidyflag + 1;
                            }
                        }
                        if(pidyflag == 9)
                        {
                            pidFlag = true;
                        }
                    }
                    else if(scaned.substring(0, 3).equals("cid"))
                    {
                        cidFlag = true;
                    }
                    else
                    {
                        fall = fall + 1;
                    }
                }
            }
        }
        
        System.out.println(answer);
        System.out.println(fall);
    }
}