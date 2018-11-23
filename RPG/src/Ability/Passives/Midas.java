package Ability.Passives;
import Run.*;
public class Midas
{
    public static String name = "Midas Touch";
    public static boolean unlock = false;
    public static boolean firstUse = true;
    public static boolean battleUse = false;
   public static void use()
   {
       if(firstUse == true && unlock == true)
       {
           if(List.names.equals("None"))
           List.names = name;
           else
           List.names = List.names + " | " + name;
           firstUse = false;
        }
      
    }
    }

