package weapon;
import backend.*;
public class Whip
{
   public static String weaponName = "Whip";
    public static int dmg = 35;
   public static int crit = 8;
      //id,dmg,duration,trigger percent
   public static int[] ability = {3,0,1,50};
   public static String aName = "Oww! [Stuns for 1 turn]";
   public static String triggerMsg = "The hit stings!";
   public static int price = 900;
   public static String Desc = "Crafted from fine leather";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
