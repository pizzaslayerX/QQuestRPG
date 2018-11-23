package Weapon;
import Run.*;
public class AncientSword
{
   public static String weaponName = "Ancient Sword";
    public static int dmg = 14;
   public static int crit = 0;
   public static int price = 100;
   public static String aName = "None";
   public static String triggerMsg = "None";
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String Desc = "The sword was once great. Still looks cool.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
