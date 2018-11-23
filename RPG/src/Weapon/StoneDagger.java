package Weapon;
import Run.*;
public class StoneDagger
{
   public static String weaponName = "Stone Dagger";
    public static int dmg = 3;
   public static int crit = 5;
   public static String aName = "None";
   public static String triggerMsg = "None";
   public static int price = 20;
   public static int[] ability = {0,0,0,0};
   public static String Desc = "Old, small, and made of stone...";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
}
