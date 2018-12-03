package Item;

import java.awt.Color;

import Main.Player;
import Run.MainFightPanel;
import Run.RPGRunner;

public class Elixer extends Consumable
{  
	
	
   public Elixer() {
		super(name,desc,price);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Elixer";
   private static String desc = "Maxes out Mana and HP. Re-Do Turn";
   private static int price = 100;
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new Elixer());
   }
        
   public static void lootItem() throws InterruptedException{
	   Main.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.mana = Player.maxMana;
	   Player.health = Player.maxHealth;
	   Player.items.remove(this);
          
   }


}
