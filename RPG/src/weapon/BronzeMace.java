package weapon;
import backend.*;
public class BronzeMace
{
   public static String weaponName = "Bronze Mace";
    public static int dmg = 21;
   public static int crit = 8;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static int price = 415;
   public static String Desc = "Hard. Shiny. Spiky.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
}
