package Weapon;
import Run.*;
public class SuperSockStaff
{
   public static String weaponName = "Super Sock Staff";
    public static int dmg = 34;
   public static int crit = 78;
   public static int price = 2470;
      //id,dmg,duration,trigger percent
   public static int[] ability = {5,5,16,33};
   public static String aName = "Sock Tornado [Dmg:32-80]";
   public static String triggerMsg = "A mighty sock tornado splits the sky";
   public static String Desc = "A Sock Devil's greatest joy";
    public static void setWeapon() throws InterruptedException
    {
       WeaponManager.setWeapon(weaponName,dmg,crit,price,Desc,ability,aName,triggerMsg);
    }
    public static void lootWeapon() throws InterruptedException
    {
        WeaponManager.lootWeapon(dmg,crit,price,weaponName,Desc,ability,aName,triggerMsg);
    }
}
