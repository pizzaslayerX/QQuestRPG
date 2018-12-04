package weapon;
import backend.*;
public class Imperius
{
   public static String weaponName=  "Imperius";
    public static int dmg = 33;
   public static int crit = 10;
   public static int price = 1250;
   public static String aName = "King's Aura [+10 Defense for 3 turns]";
      //id,dmg,duration,trigger percent
   public static int[] ability = {4,10,3,15};
   public static String triggerMsg = "The blade of kings has awoken!";
   public static String Desc = "A blade fit for a king.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
