package Weapon;
import Run.*;
public class HellFork
{
   public static String weaponName=  "Hell Fork";
    public static int dmg = 30;
   public static int crit = 9;
   //id,dmg,duration,trigger percent
   public static int[] ability = {1,2,2,20};
   public static String triggerMsg = "The fires of hell are unleashed!";
   public static String aName = "Small Ignite [Burn for 2 turns]";
   public static int price = 880;
   public static String Desc = "A super hot, super large pitch fork.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
