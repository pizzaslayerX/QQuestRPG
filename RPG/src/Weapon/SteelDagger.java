package Weapon;
import Run.*;
public class SteelDagger
{
   public static String weaponName = "Steel Dagger";
    public static int dmg = 14;
   public static int crit = 8;
   public static int price = 215;
   public static String aName = "None";
   public static String triggerMsg = "None";
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String Desc = "Better than the Iron Dagger.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
