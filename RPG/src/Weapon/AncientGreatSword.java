package Weapon;
import Run.*;
public class AncientGreatSword
{
   public static String weaponName=  "Ancient Great Sword";
    public static int dmg = 19;
   public static int crit = 10;
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static int price = 120;
   public static int[] ability = {0,0,0,0};
   public static String Desc = "Looks like an Ancient Sword, just much longer.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
