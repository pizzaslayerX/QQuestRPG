package consumables;

import java.awt.Color;

import backend.MainFightPanel;
import backend.RPGRunner;
import gameplay.Player;

public class MegaPotion extends Consumable
{  
	
	
   public MegaPotion() {
		super(name,desc,price);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Mega-Potion";
   private static String desc = "Heals 80% of health";
   private static int price = 100;
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new MegaPotion());
   }
        
   public static void lootItem() throws InterruptedException{
	   gameplay.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.health += Player.maxMana * 0.8;
       if(Player.health > Player.maxHealth)
    	   Player.health = Player.maxHealth;
       Player.items.remove(this);
   }
}
