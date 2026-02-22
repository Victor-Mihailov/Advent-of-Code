import java.util.*;
import java.io.*;

public class AOC_2022_3
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("input.txt");
        Scanner scn = new Scanner(file);
        
        int answer = 0;
        
        while (scn.hasNextLine())
        {
            
            String catagri1 = scn.nextLine();
            String catagri2 = scn.nextLine();
            String catagri3 = scn.nextLine();
            
            for (int h = 0; h < catagri1.length(); h = h + 1)
            {
                for (int i = 0; i < catagri2.length(); i = i + 1)
                {
                    for (int j = 0; j < catagri3.length(); j = j + 1)
                    {
                        if (catagri1.charAt(h) == catagri2.charAt(i) && catagri1.charAt(h) == catagri3.charAt(j))
                        {
                            if(catagri1.charAt(h) < 91)
                            {
                                answer = answer - 38 + catagri1.charAt(h);
                            }
                            else
                            {
                                answer = answer - 96 + catagri1.charAt(h);
                            }
                            
                            h = 9999;
                            i = 9999;
                            j = 9999;
                            
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
        
    }
}
//while (scn.hasNextLine())
     //   {
      //      String catagri = scn.nextLine();
            
      //      for (int i = catagri.length() / 2; i < catagri.length(); i = i + 1)
      //      {
       //         for (int j = 0; j < catagri.length() / 2; j = j + 1)
       //         {
       //             if (catagri.charAt(i) == catagri.charAt(j))
        //            {
          //              if(catagri.charAt(i) < 91)
            //            {
               //             answer = answer - 38 + catagri.charAt(i);
               //         }
               //         else
                //        {
                //            answer = answer - 96 + catagri.charAt(i);
                //        }
                        
                 //       i = 9999;
                 //       j = 9999;
                //    }
             //   }
          //  }
      //  }
