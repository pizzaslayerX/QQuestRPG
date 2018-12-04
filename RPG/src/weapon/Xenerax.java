package weapon;
import backend.*;
public class Xenerax
{
   public static String weaponName = "Xenerax the Vampire Blade";
    public static int dmg = 61;
   public static int crit = 16;
   //id,dmg,duration,trigger percent
   public static int[] ability = {9,10,0,33};
   public static String triggerMsg = "Xenerax drinks your blood!";
   public static String aName = "Leech [Sacrifices 15 HP]";
   public static int price = 2113;
   public static String Desc = "A cursed blade that constantly oozes blood.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
