package weapon;
import backend.*;
public class TheImpaler
{
   public static String weaponName = "The Impaler";
    public static int dmg = 7;
   public static int crit = 15;
   public static int price = 60;
   public static String aName = "None";
   public static String triggerMsg = "None";
      //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String Desc = "A thin blade. Has an insanely sharp point.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
}
