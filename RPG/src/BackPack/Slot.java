package BackPack;
import Run.*;
import java.io.*;
public class Slot implements Serializable
{
    public String[] item = new String[99];
    public String id;
    public int total = 0;
    public Slot()
    {
        item[0] = "";
        id = "";
        total = 0;
    }
    
    public void addItem(String n)
    {
        boolean success;
        success = false;
        for(int i=0;i<item.length;i++)
        {
            if(item[i] == null && success == false)
            {
                item[i] = n;
                success = true;
            }
        }
        if(success == false)
            RPGRunner.append("\nBackpack is too full to add: " + n + "\n");
    }
    
    public String getItem(int n)
    {
        return item[n];
    }
    
    public int getTotal()
    {
        total = 0;
        for(int i=0;i<item.length;i++)
        {
            if(item[0].equals(item[i]))
               total++;
        }
        return total;

    }
    
    public void setItem(int n,String s)
    {
        item[n] = s;
    }
    
    
    public void setIdItem(String n)
    {
        id = n;
        item[0] = n;
    }
    
    public String getIdItem()
    {
        return id;
    }
}
