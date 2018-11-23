package Weapon;
import Run.*;
public class Bling
{
   public static String weaponName = "Bling Bling";
    public static int dmg = 20;
   public static int crit = 74;
   //id,dmg,duration,trigger percent
   public static int[] ability = {10,20,8,100};
   public static String triggerMsg = "Golden shower!";
   public static String aName = "Scavenger [Rewards 8-20 gold every hit]";
   public static int price = 2999;
   public static String Desc = "The great money maker";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
