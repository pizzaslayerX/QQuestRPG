package Item;

import java.awt.Color;

import Main.Player;
import Run.MainFightPanel;
import Run.RPGRunner;

public class MegaPotion extends Consumable
{  
	
	
   public MegaPotion() {
		super(name,desc);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Mega-Potion";
   private static String desc = "Heals 80% of health";
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new MegaPotion());
   }
        
   public static void lootItem() throws InterruptedException{
	   Main.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.health += Player.maxMana * 0.8;
       if(Player.health > Player.maxHealth)
    	   Player.health = Player.maxHealth;
       Player.items.remove(this);
   }
}
