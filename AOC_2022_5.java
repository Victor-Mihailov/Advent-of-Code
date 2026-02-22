import java.util.*;
import java.io.*;

public class AOC_2022_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
            ArrayList<String> word1 = new ArrayList<String>();
            list.add(word1);
                word1.add("Q");
                word1.add("M");
                word1.add("G");
                word1.add("C");
                word1.add("L");
            ArrayList<String> word2 = new ArrayList<String>();
            list.add(word2);
                word2.add("R");
                word2.add("D");
                word2.add("L");
                word2.add("C");
                word2.add("T");
                word2.add("F");
                word2.add("H");
                word2.add("G");
            ArrayList<String> word3 = new ArrayList<String>();
            list.add(word3);
                word3.add("V");
                word3.add("J");
                word3.add("F");
                word3.add("N");
                word3.add("M");
                word3.add("T");
                word3.add("W");
                word3.add("R");
            ArrayList<String> word4 = new ArrayList<String>();
            list.add(word4);
                word4.add("J");
                word4.add("F");
                word4.add("D");
                word4.add("V");
                word4.add("Q");
                word4.add("P");
            ArrayList<String> word5 = new ArrayList<String>();
            list.add(word5);
                word5.add("N");
                word5.add("F");
                word5.add("M");
                word5.add("S");
                word5.add("L");
                word5.add("B");
                word5.add("T");
            ArrayList<String> word6 = new ArrayList<String>();
            list.add(word6);
                word6.add("R");
                word6.add("N");
                word6.add("V");
                word6.add("H");
                word6.add("C");
                word6.add("D");
                word6.add("P");
            ArrayList<String> word7 = new ArrayList<String>();
            list.add(word7);
                word7.add("H");
                word7.add("C");
                word7.add("T");
            ArrayList<String> word8 = new ArrayList<String>();
            list.add(word8);
                word8.add("G");
                word8.add("S");
                word8.add("J");
                word8.add("V");
                word8.add("Z");
                word8.add("N");
                word8.add("H");
                word8.add("P");
            ArrayList<String> word9 = new ArrayList<String>();
            list.add(word9);
                word9.add("Z");
                word9.add("F");
                word9.add("H");
                word9.add("G");
            
        while (scn.hasNextLine())
        {
            
            scn.next(); // skip over 'move'
            int times = scn.nextInt();
            scn.next();
            int from = scn.nextInt() - 1;
            scn.next();
            int to = scn.nextInt() - 1;
            
            for (; times > 0; times = times - 1)
            {
                list.get(to).add(list.get(from).remove(list.get(from).size() - times));
            }
        }
        
        for(int counter = 0; counter <= 8; counter = counter + 1)
            System.out.print(list.get(counter).get(list.get(counter).size() - 1));
    }
}