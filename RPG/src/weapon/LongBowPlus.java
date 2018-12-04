package weapon;
import backend.*;
public class LongBowPlus
{
   public static String weaponName = "Reinforced Long Bow";
    public static int dmg = 22;
   public static int crit = 48;
   public static int price = 672;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static String Desc = "The Long Bow 2.0!";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
