package Item;
import Run.*;

import java.awt.Color;
import java.util.Scanner;

import Main.Player;

import java.io.Serializable;

public abstract class Consumable implements Serializable{

	private static final Color LIGHT_BLUE = new Color(0,166,255);
	public boolean opened = false;
	public int direction;
	public boolean select = false;
    //public static boolean slot4unlock = false;
    //public static boolean slot5unlock = false;
    //public static int slotCount = 3;
   public boolean heal;
   public boolean strength;
   public boolean elixer;
   public int healUp;
   public int strengthUp;
   public String name;
   public String desc;

    
  public Consumable(String n,String d)
   {
	  name = n;
	  desc = d;
   }
   
 
   
   
   public abstract void useItems();
   
  
   public static void newItem(Consumable c) throws InterruptedException{
	   c.setItem(c);
   }
   
   public void setItem(Consumable c) throws InterruptedException{   
	   
	   for(int i = 0; i < Player.amtItems; i++) {
		   if(Player.items.get(i) == null) {
			   Player.items.set(i, c);
			   break;
	   }
   }
	   

   }
}
