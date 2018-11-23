package Weapon;
import Run.*;
public class WinterBane
{
   public static String weaponName = "Winter's Bane";
    public static int dmg = 41;
   public static int crit = 10;
   public static int price = 615;
   public static String aName = "Heart of the Tundra [Deals 26 frost dmg over 2 turns]";
   public static String triggerMsg = "Fozen winds plague the enemy!";
      //id,dmg,duration,trigger percent
   public static int[] ability = {12,13,2,31};
   public static String Desc = "A blue war axe that brings snow wherever it goes.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}