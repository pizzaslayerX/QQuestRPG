package Item;

import java.awt.Color;

import Main.Player;
import Run.MainFightPanel;
import Run.RPGRunner;

public class Potion extends Consumable
{  
	
	
   public Potion() {
		super(name,desc,price);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Mega-Potion";
   private static String desc = "Heals 30% of health";
   private static int price = 100;
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new Potion());
   }
        
   public static void lootItem() throws InterruptedException{
	   Main.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.health += Player.maxMana * 0.3;
       if(Player.health > Player.maxHealth)
    	   Player.health = Player.maxHealth;
       Player.items.remove(this);
          
   }
}
