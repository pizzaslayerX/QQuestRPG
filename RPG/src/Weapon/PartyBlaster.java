package Weapon;
import Run.*;
public class PartyBlaster
{
   public static String weaponName = "Party Blaster";
    public static int dmg = 29;
   public static int crit = 15;
   public static int price = 1060;
   public static String aName = "Stun Impact [Stuns for 1 turn]";
   public static String triggerMsg = "BOOM! Confetti!";
      //id,dmg,duration,trigger percent
   public static int[] ability = {3,0,1,25};
   public static String Desc = "A large barrel filled with surprises";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
