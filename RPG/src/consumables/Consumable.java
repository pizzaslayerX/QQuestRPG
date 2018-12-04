package consumables;
import java.awt.Color;
import java.util.Scanner;

import backend.*;
import gameplay.Player;
import gameplay.Shoppable;

import java.io.Serializable;

public abstract class Consumable implements Serializable,Shoppable{

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
   public int price;
   public String name;
   public String desc;

    
  public Consumable(String n,String d,int p)
   {
	  name = n;
	  desc = d;
	  price = p;
   }
   
  @Override
  public int sell() {
  	// TODO Auto-generated method stub
	  return (int)(price * 0.8);
  }

  @Override
  public int buy() {
  	// TODO Auto-generated method stub
  	return price;
  }

  @Override
  public String getDesc() {
  	// TODO Auto-generated method stub
  	return desc;
  }

  @Override
  public String getName() {
  	// TODO Auto-generated method stub
  	return name;
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
