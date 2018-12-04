package weapon;
import backend.*;
public class LifeWoodBow
{
   public static String weaponName = "Life Wood Bow";
    public static int dmg = 38;
   public static int crit = 33;
      //id,dmg,duration,trigger percent
   public static int[] ability = {8,6,1,75};
   public static String aName = "Leech Wood [Heals 6 HP]";
   public static String triggerMsg = "The bow heals you.";
   public static int price = 1980;
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
