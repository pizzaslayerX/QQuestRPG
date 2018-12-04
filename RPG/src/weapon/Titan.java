package weapon;
import backend.*;
public class Titan
{
   public static String weaponName=  "Titan's Bane";
    public static int dmg = 39;
   public static int crit = 15;
   public static int price = 1331;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String triggerMsg = "None";
   public static String aName = "none";
   public static String Desc = "A scythe with a crystal edge sharp enough to hurt titans.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
