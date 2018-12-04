package weapon;
import backend.*;
public class SpikedBoomerang
{
   public static String weaponName=  "Spiked Boomerang";
    public static int dmg = 14;
   public static int crit = 30;
   public static int price = 644;
   public static String aName = "Throw Boomerang [Dmg:14-28]";
   public static String triggerMsg = "You skillfully throw your boomerang!";
      //id,dmg,duration,trigger percent
   public static int[] ability = {5,14,2,50};
   public static String Desc = "A heavy metal boomerang with many, many spikes.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
