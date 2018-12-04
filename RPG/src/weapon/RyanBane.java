package weapon;
import backend.*;
public class RyanBane
{
   public static String weaponName = "~Ryan's Bane~";
    public static int dmg = 77;
   public static int crit = 22;
   public static int price = 4444;
   public static String aName = "Hollow [Silences for 5 turns]";
   public static String triggerMsg = "A Pseudo Vaccum is created";
      //id,dmg,duration,trigger percent
   public static int[] ability = {2,0,8,35};
   public static String Desc = "*It's sole purpose is to counter Archangel Ryan*";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
