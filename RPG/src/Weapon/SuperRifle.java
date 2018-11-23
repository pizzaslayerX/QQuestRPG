package Weapon;
import Run.*;
public class SuperRifle
{
   public static String weaponName = "Superior Rifle";
    public static int dmg = 45;
   public static int crit = 45;
      //id,dmg,duration,trigger percent
   public static int[] ability = {5,30,1,15};
   public static String aName = "Snipe Shot [Attack again for 15-30 dmg]";
   public static String triggerMsg = "You focus your efforts into one shot.";
   public static int price = 2120;
   public static String Desc = "A collector's weapon from a lost era.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
