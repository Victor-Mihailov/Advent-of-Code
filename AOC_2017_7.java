import java.util.*;
import java.io.*;

public class AOC_2017_7
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
                
        int answer = 0;
        
        HashMap<String, Node2> solServ = new HashMap<String, Node2>();
        HashMap<String, String> iAmYorFather = new HashMap<String, String>();
        
        while (scn.hasNextLine())
        {
            String scaned = scn.nextLine();
            Scanner lineScan = new Scanner(scaned);
            
            String givenName = lineScan.next();
            String fatString = lineScan.next();
            int fatniss = Integer.parseInt( fatString.substring(1, fatString.length()-1) );
            if(lineScan.hasNext())
            {
                scaned = lineScan.nextLine();
                scaned = scaned.substring(4);
                lineScan = new Scanner(scaned);
            }
            
            lineScan.useDelimiter(", ");  
            
            ArrayList<String> sons = new ArrayList<String>();
            
            while(lineScan.hasNext())
            {
               String son = lineScan.next();
               sons.add(son);
               iAmYorFather.put(son, givenName);
            }
            
            Node2 solnum = new Node2(givenName, fatniss, sons);
            
            solServ.put(givenName, solnum);
        }
        
        System.out.println(og(iAmYorFather));
    }
    
    public static String og(HashMap<String, String> getDad)
    {
        String kid = "ulzcu";
        while(getDad.get(kid) != null)
        {
            kid = getDad.get(kid);
        } 
        return kid;
    }
    
    public static String mistake(HashMap <String, Node2> mistakeMap, ArrayList<String> kids)
    {
        Boolean flag = false;
        for(int i = 1; i < kids.size(); i = i + 1)
        {
            if(mistakeMap.get(kids.get(i)).getTotal(mistakeMap) != mistakeMap.get(kids.get(i - 1)).getTotal(mistakeMap) && flag == false)
            {
                flag = true;
                ArrayList<String> temp = mistakeMap.get(kids.get(i)).children;
                for(int j = 0; j < temp.size(); j = j + 1)
                {
                    mistake(temp.get(j));
                }
            }
        }
    }
}