package Weapon;
import Run.*;
public class HumanityBane
{
   public static String weaponName = "Humanity's Bane";
    public static int dmg = 24;
   public static int crit = 33;
   public static int price = 940;
      //id,dmg,duration,trigger percent
      public static String aName = "None";
      public static String triggerMsg = "None";
   public static int[] ability = {0,0,0,0};
   public static String Desc = "The souls of cursed humans can be heard inside...";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
