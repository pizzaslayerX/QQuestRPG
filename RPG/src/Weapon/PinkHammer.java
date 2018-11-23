package Weapon;
import Run.*;
public class PinkHammer
{
   public static String weaponName = "Pink Hammer";
    public static int dmg = 45;
   public static int crit = 25;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static int price = 1234;
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static String Desc = "A pink slug inside of a hammer = OP";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
