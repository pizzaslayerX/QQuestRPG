package weapon;
import backend.*;
public class ChubbyTitan
{
   public static String weaponName=  "The Chubby Titan";
    public static int dmg = 12;
   public static int crit = 66;
   public static int price = 350;
   public static String aName = "None";
   public static String triggerMsg = "None";
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String Desc = "A sword with a tiny hilt, and a fat as f*ck blade";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
