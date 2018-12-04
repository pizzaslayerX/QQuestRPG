package consumables;

import java.awt.Color;

import backend.MainFightPanel;
import backend.RPGRunner;
import gameplay.Player;

public class HighPotion extends Consumable
{  
	
	
   public HighPotion() {
		super(name,desc,price);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Hi-Potion";
   private static String desc = "Heals 50% of health";
   private static int price = 100;
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new HighPotion());
   }
        
   public static void lootItem() throws InterruptedException{
	   gameplay.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.health += Player.maxHealth/2;
       if(Player.health > Player.maxHealth)
    	   Player.health = Player.maxHealth;
       Player.items.remove(this);
          
   }
}


