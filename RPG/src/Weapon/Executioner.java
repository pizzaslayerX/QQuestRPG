package Weapon;
import Run.*;
public class Executioner
{
   public static String weaponName=  "The Executioner";
    public static int dmg = 37;
   public static int crit = 15;
   //id,dmg,duration,trigger percent
   public static int[] ability = {2,0,1,25};
   public static String triggerMsg = "The enemy is too pained to speak";
   public static String aName = "Opression [Silence for 1 turn]";
   public static int price = 1580;
   public static String Desc = "A curved blade that radiates despair.";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
