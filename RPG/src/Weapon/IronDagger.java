package Weapon;
import Run.*;
public class IronDagger
{
   public static String weaponName = "Iron Dagger";
    public static int dmg = 10;
   public static int crit = 5;
   public static int price = 150;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static String Desc = "Better than the stone one.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
