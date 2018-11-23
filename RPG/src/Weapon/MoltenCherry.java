package Weapon;
import Run.*;
public class MoltenCherry
{
   public static String weaponName=  "Molten Cherry";
    public static int dmg = 48;
   public static int crit = 19;
   //id,dmg,duration,trigger percent
   public static int[] ability = {1,8,3,20};
   public static String triggerMsg = "Your cherry popped. Out spews liquid fire!";
   public static String aName = "Fiery Burst [Deals 24 fire dmg over 3 turns]";
   public static int price = 1880;
   public static String Desc = "Warning: VERY Spicy";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
