package Item;

import java.awt.Color;

import Main.Player;
import Run.MainFightPanel;
import Run.RPGRunner;

public class HighPotion extends Consumable
{  
	
	
   public HighPotion() {
		super(name,desc);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Hi-Potion";
   private static String desc = "Heals 50% of health";
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new HighPotion());
   }
        
   public static void lootItem() throws InterruptedException{
	   Main.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.health += Player.maxHealth/2;
       if(Player.health > Player.maxHealth)
    	   Player.health = Player.maxHealth;
       Player.items.remove(this);
          
   }
}


