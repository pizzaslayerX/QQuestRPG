package weapon;
import backend.*;
public class ChocolateAxe
{
   public static String weaponName = "Chocolate Axe";
    public static int dmg = 27;
   public static int crit = 11;
   //id,dmg,duration,trigger percent
   public static int[] ability = {6,23,1,15};
   public static String triggerMsg = "The sweets empower you!";
   public static String aName = "Sugar Rush [+23 dmg for 1 turn]";
   public static int price = 1875;
   public static String Desc = "A battle axe made with fine craftsmanship.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
