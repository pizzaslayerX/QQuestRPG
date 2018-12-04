package crafting;

import backend.Playlist;
import backend.RPGRunner;
import gameplay.Player;
import gameplay.Story;

public class Recipe {
	   public static boolean isOpen;
		private final String[] name = new String[6];
		private final int[] count = new int[6];
		private final String recipeName;
		
		public Recipe(String id,String n1,String n2,String n3,String n4,String n5,String n6,
				      int c1,int c2,int c3,int c4,int c5,int c6)
	    {
			recipeName = id;
	        name[0] = n1;
	        name[1] = n2;
	        name[2] = n3;
	        name[3] = n4;
	        name[4] = n5;
	        name[5] = n6;
	        
	        count[0] = c1;
	        count[1] = c2;
	        count[2] = c3;
	        count[3] = c4;
	        count[4] = c5;
	        count[5] = c6;
	    }

		public String getRecipeName()
		{
			return recipeName;
		}
		
		public void setName(String n, int i)
		{
			name[i] = n;
		}
		
		public void setCount(int n, int i)
		{
			count[i] = n;
		}
		
		public boolean check()
		{
			for(int i = 0;i<5;i++)
			{
				if(Player.checkWeapon(name[i]))
					return true;
				for(int b = 0;b<backpack.Manager.inventory.size();b++)
		        {
		           if((backpack.Manager.inventory.get(b).getIdItem().equals(name[i])))
		                return true;
		           }
			}
			return false;
		}
		
		public void print() throws InterruptedException
		{
			isOpen = true;
			RPGRunner.output.setText("");
			RPGRunner.append("Recipe: " + recipeName);
	    RPGRunner.append("\n\n==========================REQUIREMENTS===========================");
	       for(int i = 0;i<6;i++)
		   {
	    	   if(!(name[i].equals("")))
	    		   RPGRunner.append("\n-" + name[i] + " :: " + backpack.Manager.itemCount(name[i])+"/"+count[i]);
		    }
	      RPGRunner.append("\n=================================================================\n");
	       if(checkBackpack() == true)
	       {
	    	   RPGRunner.append("\nWould you like to forge this item?\n");
	    	   RPGRunner.append("\n  Yes[y] or No[n]");
	    	   String choice = Story.input();
	    	   if(choice.equals("y"))
	    	   {
	    		   for(int i = 0;i<6;i++)
	    		   {
	    			   if(!(name[i].equals("")) && !(name[i].equals(null)))
	    				   backpack.Manager.remove(name[i], count[i]);
	    		   }
	    		   getReward();
	    	   }
	       }
	       else
	       {
	    	   RPGRunner.append("\nYou are still missing materials!\n");
	    	   Story.userWait();
	    	   RPGRunner.output.setText("");
	       }
	       isOpen = false;
		}
		
		private boolean checkBackpack()
		{
			for(int i = 0;i<6;i++)
			{
				if(!(name[i].equals("")) && !(name[i].equals(null)))
					if(backpack.Manager.checkItem(name[i], count[i]) == false)
						return false;
				
			}
			return true;
		}
		
		public void getReward() throws InterruptedException
		{
			Playlist.playEffect("/sounds/ItemGet.wav");
			RPGRunner.output.setText("You've successfully forged: " + recipeName + "\n\n");
			if(recipeName.equals("Elixer"))
				consumables.Elixer.newItem();
			else if(recipeName.equals("Hi-Potion"))
				consumables.HighPotion.newItem();
			else if(recipeName.equals("Power Potion"))
				consumables.PowerPotion.newItem();
			else if(recipeName.equals("Molten Cherry [WEAPON]"))
			{
				RPGRunner.append("Would you like to equip " + recipeName + "[dmg:48][crit:19][Fiery Burst]?\n");
				RPGRunner.append("\n  Yes[y] or No[n]\n");
				String choice = Story.input();
				if(choice.equals("y"))
				weapon.MoltenCherry.setWeapon();
			}
			else if(recipeName.equals("Forged Axe [WEAPON]"))
			{
				RPGRunner.append("Would you like to equip " + recipeName + "[dmg:37][crit:10]?\n");
				RPGRunner.append("\n  Yes[y] or No[n]\n");
				String choice = Story.input();
				if(choice.equals("y"))
				weapon.ForgedAxe.setWeapon();
			}
			else if(recipeName.equals("Viral Dagger [WEAPON]"))
			{
				RPGRunner.append("Would you like to equip " + recipeName + "[dmg:21][crit:66][Viral Touch]?\n");
				RPGRunner.append("\n  Yes[y] or No[n]\n");
				String choice = Story.input();
				if(choice.equals("y"))
				weapon.VirusKnife.setWeapon();
			}
			Story.userWait();
			RPGRunner.output.setText("");
		}
}

