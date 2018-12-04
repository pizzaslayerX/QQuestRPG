package weapon;
import backend.*;
public class CarnivalComet
{
   public static String weaponName = "Carnival Comet";
    public static int dmg = 5;
   public static int crit = 50;
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static int price = 60;
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static String Desc = "How exactly does this hurt?";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
}
