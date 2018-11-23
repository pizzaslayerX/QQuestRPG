package Weapon;
import Run.*;
public class Pickaxe
{
   public static String weaponName = "Pickaxe";
    public static int dmg = 20;
   public static int crit = 6;
   //id,dmg,duration,trigger percent
   public static int[] ability;
   public static String triggerMsg = "None";
   public static String aName = "None";
   public static int price = 510;
   public static String Desc = "Good at mining precious metals";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
