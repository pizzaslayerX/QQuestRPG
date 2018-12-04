package weapon;
import backend.*;
public class SockStaff
{
   public static String weaponName = "Sock Staff";
    public static int dmg = 17;
   public static int crit = 88;
   public static int price = 1470;
      //id,dmg,duration,trigger percent
   public static int[] ability = {5,5,8,33};
   public static String aName = "Sock Shower [Dmg:16-40]";
   public static String triggerMsg = "A horde of socks spew out the staff...";
   public static String Desc = "A Sock Demon's private parts...";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
