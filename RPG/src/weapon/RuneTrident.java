package weapon;
import backend.*;
public class RuneTrident
{
   public static String weaponName = "Runic Trident";
    public static int dmg = 11;
   public static int crit = 15;
   public static int price = 950;
   public static String aName = "None";
   public static String triggerMsg = "None";
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String Desc = "Heavy and Valuable. It also hurts... Kinda";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
