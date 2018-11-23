package Weapon;
import Run.*;
public class RockBasher
{
   public static String weaponName = "Rock Basher";
    public static int dmg = 59;
   public static int crit = 0;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static int price = 1775;
   public static String Desc = "A large club forged from a Rock Golem's Heart";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
