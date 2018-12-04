package weapon;
import java.io.Serializable;
import java.util.ArrayList;

import backend.*;
import gameplay.Player;
public class WeaponManager implements Serializable
{ 
	public String modifier;
    public int dmg;
    public static int strPlus = 0;
    public int bonusDmg = 0;
    public int potionDmg = 0;
    public int crit;
    public String aName;
   public String triggerMsg;
    public int price;
    public int[] ability = new int[4];
    public String name = "";
    public String desc;
    
    public WeaponManager(String n, int d, int c, int p,String dc,int[] a,String an,String tm) {
    	bonusDmg = 0;
 	   if(!(name.equals("Fists") || name.equals("")))
 	      backpack.Manager.remove("Weapon: " + name, 1);
        name = n;
        dmg = d;
        crit = c;
        price = p;
        desc = dc;
        ability = a;
        modifier= "";
        aName = an;
        triggerMsg = tm;
        name = n;
        if(!(name.equals("Fists") || name.equals("")))
          backpack.Manager.add("Weapon: " + name, 1);
       if(ability == null)
    	   ability = new int[4];
       if(aName == null)
    	   aName = "None";
       if(triggerMsg == null)
    	   triggerMsg = "None";
    }
    
   public static void setWeapon(String n, int d, int c, int p,String dc,int[] a,String an,String tm) throws InterruptedException
   {
       Player.addWeapon(new WeaponManager(n,d,c,p,dc,a,an,tm));
   }
   public static void lootWeapon(int d,int c,int p, String n, String dc,int[] a,String an,String tm) throws InterruptedException
   {
       gameplay.LootScreen.setLootWeapon(new WeaponManager(n,d,c,p,dc,a,an,tm));
    }
 
   public void useAbility() throws InterruptedException
   {
       int chance = ability[3];
       int threshold = (int)(Math.random() * 100) + 1;
       if(threshold <= chance)
       {
           gameplay.Story.pause(500);
           MainFightPanel.append(MainFightPanel.user,"\n\n" + triggerMsg);
           gameplay.Story.pause(2000);
           MainFightPanel.append(MainFightPanel.user,"\n" + name + "'s ability has activated!\n");
           statusEffect.Identifier.set(ability[0],ability[1],ability[2]);
        }
    }
}
