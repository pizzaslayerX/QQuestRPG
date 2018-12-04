package crafting;
import backend.*;
import gameplay.Story;
public class List {
	public static RPGRunner run;
	
	private static final Recipe ELIXER = new Recipe("Elixer","Uber Soul","Dark Dust","Light Dust","","","",1,10,10,0,0,0);
	private static final Recipe MOLTEN_CHERRY = new Recipe("Molten Cherry [WEAPON]","Weapon: Special Mace","Flaming Tear","Iron Bar","","","",1,15,6,0,0,0);
	private static final Recipe FORGED_AXE = new Recipe("Forged Axe [WEAPON]","Iron Bar","Wood","","","","",11,4,0,0,0,0);
	private static final Recipe HI_POTION = new Recipe("Hi-Potion","Item: Potion","","","","","",2,0,0,0,0,0);
	private static final Recipe POWER_POTION = new Recipe("Power Potion","Item: Potion","Greater Soul","","","","",1,1,0,0,0,0);
	private static final Recipe VIRUS_KNIFE = new Recipe("Viral Dagger [WEAPON]","Weapon: Glass Dagger","Dark Goo","Dark Dust","Eww Matter","","",1,8,12,15,0,0);
	public static boolean quit = false;
	public static boolean isOpen;
	private static int UDDirection = 1;
	private static int max = 0;
	private static boolean bPressed;
	private static boolean select;
	private static Recipe[] recipes = new Recipe[30];

	public static boolean buttonPress;
	public List(RPGRunner r)
    {
        this.run = r;
    }
	
	public static void display() throws InterruptedException
	{
		run.output.grabFocus();
		makeList();
		max = findEmpty();
		quit = false;
		isOpen = true;
		while(quit == false)
		{
			buttonPress = false;
		    run.output.setText(" Quit [SHIFT]                   SELECT A RECIPE              Open Backpack [b]");
		   run.fontSize(27);
		   run.append("\n====================================RECIPES====================================\n");
		 if(findEmpty() != 0)
		 {
			 for(int i = 0;i<findEmpty();i++)
			 {
				 if(i+1 == UDDirection)
				     run.append("[" + (i+1) + "] " + recipes[i].getRecipeName() + " <" +"\n");
				 else
					 run.append("[" + (i+1) + "] " + recipes[i].getRecipeName() + "\n");
				 run.append("===============================================================================\n");
			 }
			 
		 }
		 else
		 {
		 	RPGRunner.append("You have no recipes available!\n");
		 run.append("===============================================================================");
		 }
		   while(buttonPress != true  && quit != true)
		    System.out.println("Waiting\n");
		   if(bPressed == true)
		   {
			   backpack.Manager.open();
			   bPressed = false;
		   }
		   if(select == true)
		   {
			   run.input.grabFocus();
			   recipes[UDDirection-1].print();
			   select = false;
			   Recipe.isOpen = false;
		   }
		}
		
		isOpen = false;
		clearList();
	}
	public static void makeList()
	{
		if(MOLTEN_CHERRY.check() == true)
			recipes[findEmpty()] = MOLTEN_CHERRY;
		if(ELIXER.check() == true)
			recipes[findEmpty()] = ELIXER;
		if(FORGED_AXE.check() == true)
			recipes[findEmpty()] = FORGED_AXE;
		if(HI_POTION.check() == true)
			recipes[findEmpty()] = HI_POTION;
		if(POWER_POTION.check() == true)
			recipes[findEmpty()] = POWER_POTION;
		if(VIRUS_KNIFE.check() == true)
			recipes[findEmpty()] = VIRUS_KNIFE;
	}
	public static void clearList()
	{
		for(int i = 0;i<30;i++)
		{
			recipes[i] = null;
		}
		
	}
	private static int findEmpty()
	{
		int count = 0;
		for(Recipe r : recipes)
		  if(recipes[count] == null)
			return count;
		  else
			  count++;
		return count;
	}
	public static void getDirection(int d)
	{
		buttonPress = true;
			System.out.print(UDDirection + "before method");
		    UDDirection = UDDirection + d;
		    System.out.print(UDDirection + "UDDirection math");
		    if(UDDirection < 1)
		    {
		        UDDirection = max;
		    }
		    if(UDDirection > max)
		    {
		    	System.out.print(UDDirection + "MAXED");
		         UDDirection = 1;
		    }
		    System.out.print(UDDirection + "after method");
		    
	}
	public static int getMax()
	{
		return max;
	}
	public static void isBPressed(boolean b)
	{
		bPressed = b;	
		buttonPress = true;
	}
	public static void isSelected(boolean s)
	{
		select = s;	
		buttonPress = true;
	}
}
