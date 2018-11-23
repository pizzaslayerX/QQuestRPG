package Weapon;
import Run.*;
public class BalloonLauncher
{
   public static String weaponName = "Balloon Launcher 9000";
    public static int dmg = 30;
   public static int crit = 20;
   public static int price = 1669;
   public static String aName = "Rapid Fire [Dmg: 20-40]";
   public static String triggerMsg = "Balloon Party!";
      //id,dmg,duration,trigger percent
   public static int[] ability = {5,4,10,20};
   public static String Desc = "Puts em' where it hurts the most!";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
