package Item;

import java.awt.Color;

import Main.Player;
import Run.MainFightPanel;
import Run.RPGRunner;

public class Ultramarine extends Consumable
{  
	
	
   public Ultramarine() {
		super(name,desc);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Ultramarine";
   private static String desc = "Restores 50% of mana. Re-Do Turn";
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new Ultramarine());
   }
        
   public static void lootItem() throws InterruptedException{
	   Main.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.mana += Player.maxMana/2;
       if(Player.mana > Player.maxMana)
    	   Player.mana = Player.maxMana;
       Player.items.remove(this);
       
          
   }
}
