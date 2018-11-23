package Weapon;
import Run.*;
public class AncientRifle
{
   public static String weaponName = "Ancient Rifle";
    public static int dmg = 30;
   public static int crit = 55;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static int price = 1120;
   public static String Desc = "A gun from long ago that possesses deadly accuracy.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
