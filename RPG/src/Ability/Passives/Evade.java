package Ability.Passives;
import backend.*;
import gameplay.Player;
public class Evade
{
    public static String name = "Evade";
    public static int evadeChance = 15;
    public static boolean evade = false;
    public static boolean unlock = false;
    public static boolean firstUse = true;
   public static void use()
   {
       if(firstUse == true && unlock == true)
       {
           if(List.names.equals("None"))
           List.names = name;
           else
           List.names = List.names + " | " + name;
           firstUse = false;
           Player.evadeChance += 15;
        }
       /*
       if(unlock == true)
       {
           int threshold = 1 + (int)(Math.random() * 100);
           if(threshold < evadeChance)
            evade = true;
        }*/
    }
}
