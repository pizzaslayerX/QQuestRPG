package Weapon;
import Run.*;
public class LongBow
{
   public static String weaponName = "Long Bow";
    public static int dmg = 16;
   public static int crit = 50;
   public static int price = 470;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static String Desc = "A huge bow that penetrates the toughest armor.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
