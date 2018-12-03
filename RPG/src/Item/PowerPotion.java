package Item;


import java.awt.Color;

import Main.Player;
import Run.MainFightPanel;
import Run.RPGRunner;

public class PowerPotion extends Consumable
{  
	
	
   public PowerPotion() {
		super(name,desc,price);
		// TODO Auto-generated constructor stub
   }

   private static String name = "Power-Potion";
   private static String desc = "Increase Damage by 20% for 1 fight";
   private static int price = 100;
   
   public static void newItem() throws InterruptedException
   {
       Consumable.newItem(new PowerPotion());
   }
        
   public static void lootItem() throws InterruptedException{
	   Main.LootScreen.setLootItem((name + " | " + desc));
       newItem(); 
   }

        
   public void useItems() {   	
	   Player.baseDmg = Player.baseDmg + (int)(Player.getDmg() * (20 / 100.0)); 
	   Player.items.remove(this);
          
   }
}
