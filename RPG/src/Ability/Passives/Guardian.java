package Ability.Passives;
import Run.*;
public class Guardian
{
    public static String name = "Guardian Angel";
    public static boolean unlock = false;
    public static boolean firstUse = true;
    public static boolean battleUse = false;
   public static boolean use()
   {
       if(firstUse == true && unlock == true)
       {
           if(List.names.equals("None"))
           List.names = name;
           else
           List.names = List.names + " | " + name;
           firstUse = false;
        }
       if(unlock == true && battleUse == false)
         return true;
        
        return false;
    }
    }

