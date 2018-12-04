package consumables;

import java.awt.Color;

import backend.MainFightPanel;
import backend.RPGRunner;
import gameplay.Player;

public class Ultramarine extends Consumable
{  
	
	
   public Ultramarine() {
		super(name,desc,price);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Ultramarine";
   private static String desc = "Restores 50% of mana. Re-Do Turn";
   private static int price = 100;
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new Ultramarine());
   }
        
   public static void lootItem() throws InterruptedException{
	   gameplay.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.mana += Player.maxMana/2;
       if(Player.mana > Player.maxMana)
    	   Player.mana = Player.maxMana;
       Player.items.remove(this);
       
          
   }
}
