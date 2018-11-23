package Weapon;
import Run.*;
public class FireHydrant
{
   public static String weaponName = "Fire Hydrant";
    public static int dmg = 55;
   public static int crit = 0;
      //id,dmg,duration,trigger percent
   public static int[] ability = {15,0,0,50};
   public static String aName = "Neutralize [Removes all status effects]";
   public static String triggerMsg = "Your uniqueness is washed away";
   public static int price = 1213;
   public static String Desc = "Cheap. Helpful. Effective. USE WISELY";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
