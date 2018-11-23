package Main;
import java.util.ArrayList;

import Armor.ArmorManager;
import Run.*;
public class LootScreen
{
   public static RPGRunner run;
   public static int gainGold;
   public static int gainExp;
   public static int dmg;
    public static int crit;
    public static int price;
    public static String name;
    public static String waName;
   public static String triggerMsg;
     public static String aname;
    public static String desc;
    public static int[] ability;
    public static String miscName = "";
   public static String itemName = "";
   public static String announce = "";
   public static ArrayList<Weapon.WeaponManager> weaponLoot = new ArrayList<Weapon.WeaponManager>();
   public static ArrayList<ArmorManager> armorLoot = new ArrayList<ArmorManager>();
   public LootScreen(RPGRunner r)
    {
        this.run = r;
    }
   public static void setGold(int g)
   {
       gainGold += g;
       if(Ability.Passives.Midas.unlock == true)
    	   gainGold = gainGold + (gainGold / 10);
       
    }
    
   public static void setExp(int e)
   {
       gainExp += e;
    }
    
    public static void setLootMisc(String n,int q)
    {
        BackPack.Manager.add(n,q);
        miscName = miscName + "You found: " + n + " x" + q + " \n";
    }
    
    public static void notice(String n) {
    	announce += n + "\n";
    }
    
   public static void setLootWeapon(Weapon.WeaponManager w) throws InterruptedException
   {
         weaponLoot.add(w);
         
   }
   public static void setLootArmor(ArmorManager a) throws InterruptedException
   {
         armorLoot.add(a);
   }
    public static void setArmor(ArmorManager a) throws InterruptedException
    {
    	Player.addArmor(a);
    }
   public static void setLootItem(String n)
{
    itemName = itemName + "\nYou found a(n) " + n;
}
   public static void setModifier(String n)
   {
	   //dead Method
	   
   }

   public static void getModifier()
   {
	  //dead method
   }
   
    public static void setWeapon(Weapon.WeaponManager w) throws InterruptedException
    {
    	Player.addWeapon(w);
    }
    
    public static void battleLoot() throws InterruptedException{
    	Player.gold = Player.gold + gainGold;
        Player.exp = Player.exp + gainExp;
        Playlist.playEffect("/sounds/ItemGet.wav");
        run.getReset();
          RPGRunner.append("\n~~~VICTORY~~~\n");
          RPGRunner.append(announce + "\n");
          RPGRunner.append("You gained " + gainGold + " gold\n");
          RPGRunner.append("You gained " + gainExp + " experience" + itemName + "\n" + miscName);
          itemName = "";
         for(int i = 0;i<weaponLoot.size();i++) {
              run.getReset();
          run.append("\nYou found: " + weaponLoot.get(i).name);
          run.append("\nPress [p] to pick up weapon");
          String answer = run.getString();
          if(answer.equals("p"))
          {
              setWeapon(weaponLoot.get(i));
              Player.equipWeapon();
              if(Player.checkReplace == true && (armorLoot.size() > 0 || i != weaponLoot.size()-1)) {
            	  RPGRunner.output.setText("");
            	  RPGRunner.append("\n~~~VICTORY~~~\n");
              }
              Player.checkReplace = false;
              getModifier();
              answer = "";
           }else
        	   BackPack.Manager.remove("Weapon: " + weaponLoot.get(i).name,1);
           
           
         }
          run.getReset();
          for(int i = 0;i<armorLoot.size();i++) {
              run.getReset();
              run.append("\nYou found: " + armorLoot.get(i).name);
          run.append("\nPress [p] to pick up armor");
          String achoice = run.getString();
          if(achoice.equals("p"))
          {
              setArmor(armorLoot.get(i));
              Player.equipArmor();
              getModifier();
           }
      }
           run.append("\n");
          Player.userWait();
          RPGRunner.output.setText("");
          miscName = "";
          announce = "";
          gainGold = 0;
          gainExp = 0;
          weaponLoot.clear();
          armorLoot.clear();
          Level.tryLevelUp();
          
    }
    
    public static void open() throws InterruptedException{
     //dead Method
   }
   
}
