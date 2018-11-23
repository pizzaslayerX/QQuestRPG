package Weapon;
import Run.*;
public class GunShield
{
   public static String weaponName = "Gun Shield";
    public static int dmg = 33;
   public static int crit = 40;
      //id,dmg,duration,trigger percent
   public static int[] ability = {4,50,1,40};
   public static String aName = "Iron Guard [Reduces incoming dmg by half for 1 turn]";
   public static String triggerMsg = "Your weapon protects you.";
   public static int price = 1920;
   public static String Desc = "How does this work?";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
