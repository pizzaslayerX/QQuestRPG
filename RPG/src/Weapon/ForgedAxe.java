package Weapon;
import Run.*;
public class ForgedAxe
{
   public static String weaponName = "Forged Axe";
    public static int dmg = 37;
   public static int crit = 10;
   //id,dmg,duration,trigger percent
   public static int[] ability = {0,0,0,0};
   public static String triggerMsg = "None";
   public static String aName = "None";
   public static int price = 1275;
   public static String Desc = "A battle axe made with fine craftsmanship.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
