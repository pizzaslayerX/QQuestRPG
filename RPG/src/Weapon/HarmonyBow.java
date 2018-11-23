package Weapon;
import Run.*;
public class HarmonyBow
{
   public static String weaponName = "Bow of Harmony";
    public static int dmg = 66;
   public static int crit = 44;
   public static int price = 3450;
   public static String aName = "Blissful Trance [Heals 30 HP over 3 turns]";
   public static String triggerMsg = "You calmly reflect on your faults";
      //id,dmg,duration,trigger percent
   public static int[] ability = {8,10,3,20};
   public static String Desc = "Crafted from the finest trees and purest lillies.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
