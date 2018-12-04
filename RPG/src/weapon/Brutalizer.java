package weapon;
import backend.*;
public class Brutalizer
{
   public static String weaponName = "The Brutalizer";
    public static int dmg = 63;
   public static int crit = 17;
      //id,dmg,duration,trigger percent
   public static int[] ability = {6,15,1,34};
   public static String aName = "Advantage [+15 dmg for 1 turn]";
   public static String triggerMsg = "The enemy has been knocked down!";
   public static int price = 2001;
   public static String Desc = "A vicious club that knocks down the toughest of foes.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
