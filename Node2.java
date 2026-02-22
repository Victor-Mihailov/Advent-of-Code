import java.util.*;

public class Node2
{
    // instance variables - replace the example below with your own
    String name;
    int weight;
    ArrayList<String> children = new ArrayList<String>();
    
    public Node2(String eman, int thgiew, ArrayList<String> nerdlihc)
    {
        name = eman;
        weight = thgiew;
        children = nerdlihc;
    }

    public int getTotal(HashMap<String, Node2> nameMap)
    {
        int t = weight;
        //for(int i = 0; i < children.size(); i = i + 1)
        for (String kidName : children)
        {
            t = t + nameMap.get(kidName).getTotal(nameMap);
        }
        return t;
    }
    
}