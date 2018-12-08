package Ability.Actives;
import java.awt.Color;
import java.io.IOException;
import java.util.Scanner;

import backend.*;
import gameplay.Player;
import monsters.MonsterManager;
public class Manager
{
	public static boolean opened = false, switchOpened = false;
	public static int direction;
	public static boolean select = false;
    public static int pageCount = 3;
    public static String[] pageName = {"Page One","Page Two","Page Three"};
    public static Special[][] pages = new Special[3][5];
    public static RPGRunner run;
    public static boolean full;
    public Manager(RPGRunner r)
    {
        this.run = r;
    }
    private static int identify;

  
  public static void setAbility(Special s) {
	  System.out.println("Equipped: " + s.name);
	  for(int r = 0;r<pages.length;r++)
		  for(int c = 0;c<pages[r].length;c++)
			  if(pages[r][c] == null) {
				  pages[r][c] = s;
				  return;
			  }
				 
				  
  }
  
  
  public static void useAbility(int c) throws Exception
    {
	  c--;
        if(!(c > 4 || pages[Player.equippedPage][c] == null) )
       {
       
         if(pages[Player.equippedPage][c].limit == true && pages[Player.equippedPage][c].use == false)
        {
          if(pages[Player.equippedPage][c].manaCost <= gameplay.Player.mana)
          {
          gameplay.Player.mana = gameplay.Player.mana - pages[Player.equippedPage][c].manaCost;
          pages[Player.equippedPage][c].use = true;
          doAbility(c);
        }
        else
        {
            MainFightPanel.append(MainFightPanel.user,"\n\nYou don't have enough mana!\n");
            run.pause(2000);
          MainFightPanel.clearDisplay();
        }
        }
        else if(pages[Player.equippedPage][c].limit == true && pages[Player.equippedPage][c].use == true)
        {
          MainFightPanel.append(MainFightPanel.user,"\n\nYou can only use " + pages[Player.equippedPage][c].name + " once per fight!");
          run.pause(2000);
          MainFightPanel.clearDisplay();
        }
        else if(pages[Player.equippedPage][c].limit == false)
        {
          if(pages[Player.equippedPage][c].manaCost <= gameplay.Player.mana)
          {
          gameplay.Player.mana = gameplay.Player.mana - pages[Player.equippedPage][c].manaCost;
          doAbility(c);
          }
         else
          {
            MainFightPanel.append(MainFightPanel.user,"\n\nYou don't have enough mana!\n");
            run.pause(2000);
          MainFightPanel.clearDisplay();
          }
         }
        }

        else if(pages[Player.equippedPage][c] == null)
        {
            MainFightPanel.append(MainFightPanel.user,"\n\nYou don't have an ability in this slot!"); 
           run.pause(2000);
           MainFightPanel.clearDisplay();
        }
        else 
        {
           MainFightPanel.clearDisplay();
        }
    }
   
  
    
  public static void doAbility(int c) throws Exception
  {
	  MainFightPanel.clearDisplay();
	  
  if(pages[Player.equippedPage][c].targetAll == true) {
	  MainFightPanel.append(MainFightPanel.user,"\n\n" + pages[Player.equippedPage][c].atkDesc + "\n");
	     run.pause(1500);
    for(int m = 0;m<monsters.MonsterManager.enemies.size();m++) {
    	RPGRunner.target = m;
    	if(m > 0 && MonsterManager.enemies.get(m).id != MonsterManager.enemies.get(m-1).id)
    		MainFightPanel.changePic(MonsterManager.enemies.get(m).getPic());
    	MainFightPanel.clearEnemyDisplay();
     if(pages[Player.equippedPage][c].doesDmg == true)
     {
       if(pages[Player.equippedPage][c].pureDmg == true)
       {
         monsters.MonsterManager.enemies.get(m).setHealth(monsters.MonsterManager.enemies.get(m).getHealth() - pages[Player.equippedPage][c].dmg);
         MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(m).getName() + " lost ");
         MainFightPanel.append(MainFightPanel.enemyStatOutput,pages[Player.equippedPage][c].dmg+"",Color.RED,20,true);
          MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
         run.pause(2000);
         MainFightPanel.clearEnemyDisplay();
       }
       else
       {
         monsters.MonsterManager.enemies.get(m).setDmgTaken(pages[Player.equippedPage][c].dmg);
         monsters.MonsterManager.enemies.get(m).getResist();
         monsters.MonsterManager.enemies.get(m).loseHealth();
         MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(m).getName() + " lost ");
         MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(m).getDmgTaken()+"",Color.RED,20,true);
          MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
         run.pause(2000);
         MainFightPanel.clearEnemyDisplay();
       }
     }
     if(pages[Player.equippedPage][c].statusEffect == true)
     {
         int eNum = 0;
         for(int i = 0; i < pages[Player.equippedPage][c].statusVal[0]; i++)
         {
         
         int one = pages[Player.equippedPage][c].statusVal[1 + eNum];
         int two = pages[Player.equippedPage][c].statusVal[2 + eNum];
         int three = pages[Player.equippedPage][c].statusVal[3 + eNum];
        	 statusEffect.Identifier.set(one,two,three);
         eNum = eNum + 3;
        }
     }
     if(pages[Player.equippedPage][c].heal > 0 || pages[Player.equippedPage][c].percentHeal > 0)
     {
         if(pages[Player.equippedPage][c].heal > 0)
         {
         gameplay.Player.health = gameplay.Player.health + pages[Player.equippedPage][c].heal;
         if(gameplay.Player.health > gameplay.Player.maxHealth)
            gameplay.Player.health = gameplay.Player.maxHealth;
         MainFightPanel.append(MainFightPanel.user,"\nYou gained ");
         MainFightPanel.append(MainFightPanel.user,pages[Player.equippedPage][c].heal+"",Color.GREEN,20,true);
        		 MainFightPanel.append(MainFightPanel.user," HP!");
         run.pause(2500);
         MainFightPanel.clearDisplay();
       }
       if(pages[Player.equippedPage][c].percentHeal > 0)
       {
        gameplay.Player.health = gameplay.Player.health + (int)(gameplay.Player.maxHealth * (pages[Player.equippedPage][c].percentHeal/100.0));
        if(gameplay.Player.health > gameplay.Player.maxHealth)
            gameplay.Player.health = gameplay.Player.maxHealth;
        MainFightPanel.append(MainFightPanel.user,"\nYou gained ");
        MainFightPanel.append(MainFightPanel.user,(int)(gameplay.Player.maxHealth * (pages[Player.equippedPage][c].percentHeal/100.0))+"",Color.GREEN,20,true);
       		 MainFightPanel.append(MainFightPanel.user," HP!");
        run.pause(2500);
        MainFightPanel.clearDisplay();
      }
     }
    }
   }
  else {
	 if(MainFightPanel.getTarget() == true) {
		  MainFightPanel.append(MainFightPanel.user,"\n\n" + pages[Player.equippedPage][c].atkDesc + "\n");
		     run.pause(1500);
	  if(pages[Player.equippedPage][c].doesDmg == true)
	     {
	       if(pages[Player.equippedPage][c].pureDmg == true)
	       {
	         monsters.MonsterManager.enemies.get(RPGRunner.target).setHealth(monsters.MonsterManager.enemies.get(RPGRunner.target).getHealth() - pages[Player.equippedPage][c].dmg);
	         MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(RPGRunner.target).getName() + " lost ");
	         MainFightPanel.append(MainFightPanel.enemyStatOutput,pages[Player.equippedPage][c].dmg+"",Color.RED,20,true);
	          MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
	         run.pause(2000);
	         MainFightPanel.clearEnemyDisplay();
	       }
	       else
	       {
	         monsters.MonsterManager.enemies.get(RPGRunner.target).setDmgTaken(pages[Player.equippedPage][c].dmg);
	         monsters.MonsterManager.enemies.get(RPGRunner.target).getResist();
	         monsters.MonsterManager.enemies.get(RPGRunner.target).loseHealth();
	         MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(RPGRunner.target).getName() + " lost ");
	         MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(RPGRunner.target).getDmgTaken()+"",Color.RED,20,true);
	          MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
	         run.pause(2000);
	         MainFightPanel.clearEnemyDisplay();
	       }
	     }
	     if(pages[Player.equippedPage][c].statusEffect == true)
	     {
	         int eNum = 0;
	         for(int i = 0; i < pages[Player.equippedPage][c].statusVal[0]; i++)
	         {
	         int one = pages[Player.equippedPage][c].statusVal[1 + eNum];
	         int two = pages[Player.equippedPage][c].statusVal[2 + eNum];
	         int three = pages[Player.equippedPage][c].statusVal[3 + eNum];
	         if(one != 17)
	        	 statusEffect.Identifier.set(one,two,three);
	         else
	        	 run.newLibra(monsters.MonsterManager.enemies.get(RPGRunner.target));
	         eNum = eNum + 3;
	        }
	     }
	     if(pages[Player.equippedPage][c].heal > 0 || pages[Player.equippedPage][c].percentHeal > 0)
	     {
	         if(pages[Player.equippedPage][c].heal > 0)
	         {
	         gameplay.Player.health = gameplay.Player.health + pages[Player.equippedPage][c].heal;
	         if(gameplay.Player.health > gameplay.Player.maxHealth)
	            gameplay.Player.health = gameplay.Player.maxHealth;
	         MainFightPanel.append(MainFightPanel.user,"\nYou gained ");
	         MainFightPanel.append(MainFightPanel.user,pages[Player.equippedPage][c].heal+"",Color.GREEN,20,true);
	        		 MainFightPanel.append(MainFightPanel.user," HP!");
	         run.pause(2500);
	         MainFightPanel.clearDisplay();
	       }
	       if(pages[Player.equippedPage][c].percentHeal > 0)
	       {
	        gameplay.Player.health = gameplay.Player.health + (int)(gameplay.Player.maxHealth * (pages[Player.equippedPage][c].percentHeal/100.0));
	        if(gameplay.Player.health > gameplay.Player.maxHealth)
	            gameplay.Player.health = gameplay.Player.maxHealth;
	        MainFightPanel.append(MainFightPanel.user,"\nYou gained ");
	        MainFightPanel.append(MainFightPanel.user,(int)(gameplay.Player.maxHealth * (pages[Player.equippedPage][c].percentHeal/100.0))+"",Color.GREEN,20,true);
	       		 MainFightPanel.append(MainFightPanel.user," HP!");
	        run.pause(2500);
	        MainFightPanel.clearDisplay();
	      }
	     }
	  
        }
     }
    
  	if(pages[Player.equippedPage][c].useTurn == true) {
 	 RPGRunner.pTurn = false;
 	 RPGRunner.eTurn = true;
   }
  }
    
   public static void resetAbility()
    {
       for(int r = 0;r<pages.length;r++)
    	   for(int c = 0;c<pages[r].length;c++) {
    		   if(pages[r][c] != null)
    		   pages[r][c].use = false;
    	   }
       Player.weapons[Player.equippedWeapon].potionDmg = 0;
       Ability.Passives.Guardian.battleUse = false;
    } 

    public static int fightPrint() {
 	   opened = true;
 	   select = false;
 	   int holder = 0;
 	   direction = 1;
 	   while(select == false) {
 		   System.out.println("Looping...");
 		   if(holder != direction) {
 			   MainFightPanel.clearDisplay();
 		        MainFightPanel.append(MainFightPanel.user,"\n\n'Select an option'\n\n",Color.WHITE,20,true);
 		       MainFightPanel.append(MainFightPanel.user,"=====================PASSIVES====================================================================================\n",Color.WHITE,18,false);
 		    	 MainFightPanel.append(MainFightPanel.user,"" + Ability.Passives.List.show() + "\n",Color.WHITE,18,false);
 		    	 MainFightPanel.append(MainFightPanel.user,"=================================================================================================================\n",Color.WHITE,18,false);
 		    	 MainFightPanel.append(MainFightPanel.user,"=====================ACTIVES==============================================================================================\n",Color.WHITE,18,false);
 	   
 	   for(int i = 1;i<=5+2;i++) {
 		   if(direction == i && i < 5+1) {
 			   if(pages[Player.equippedPage][i-1] != null) {
 			   MainFightPanel.append(MainFightPanel.user,pages[Player.equippedPage][i-1].name,Color.WHITE,18,true);
 			   MainFightPanel.append(MainFightPanel.user," | " + pages[Player.equippedPage][i-1].desc,Color.WHITE,11,true);
 			   MainFightPanel.append(MainFightPanel.user,"\n",Color.WHITE,18,true);
 			   }else
 				  MainFightPanel.append(MainFightPanel.user,"None\n",Color.WHITE,18,true);
 				   
 		   }
 		   else if(direction != i && i < 5 + 1) {
 			  if(pages[Player.equippedPage][i-1] != null) {
 			  MainFightPanel.append(MainFightPanel.user,pages[Player.equippedPage][i-1].name,Color.GRAY,18,false);
 			  MainFightPanel.append(MainFightPanel.user," | " +pages[Player.equippedPage][i-1].desc + "\n",Color.GRAY,11,false);
 			  }else
 				 MainFightPanel.append(MainFightPanel.user,"None\n",Color.GRAY,18,false);
 		   }
 		  else if(direction == i && i == 5+1) {
			   MainFightPanel.append(MainFightPanel.user,"-Switch Ability Set-\n",Color.WHITE,18,true);
		   }
		   else if(direction != i && i == 5+1) {
			   MainFightPanel.append(MainFightPanel.user,"-Switch Ability Set-\n",Color.GRAY,18,false);
		   }
 		   else if(direction == i && i == 5+2) {
 			   MainFightPanel.append(MainFightPanel.user,"<--Back\n",Color.WHITE,18,true);
 		   }
 		   else if(direction != i && i == 5+2) {
 			   MainFightPanel.append(MainFightPanel.user,"<--Back\n",Color.GRAY,18,false);
 		   }

 	   }
 	   direction = direction - 5 - 3;
 	   holder = direction;
 	   MainFightPanel.append(MainFightPanel.user,"========================================================================================================================\n",Color.WHITE,18,false);
 		   }
 	  }
 	   opened = false;
 	   return direction + 5 + 2;
    }
    
    public static void switchPage() {
    	 switchOpened = true;
  	   	 select = false;
    	 int holder = 0;
    	 direction = Player.equippedPage+1;
    	while(select == false) {
    		 System.out.println("Looping..." + direction);
    	   if(holder != direction) {
    		   MainFightPanel.clearDisplay();
    		   if(pageCount == 1) {
    			   MainFightPanel.append(MainFightPanel.user,"\n\n\nYou don't have any other ability sets.",Color.WHITE,20,false);
    			   run.pause(1400);
    			   MainFightPanel.clearDisplay();
    			   return;
    		   }
    	    MainFightPanel.append(MainFightPanel.user,"\n\n 	   	   ~Select an ability set~\n===========================================================\n",Color.WHITE,20,false);
    	    for(int i = 0;i<pageCount;i++) {
    	    	if(direction-1 == i) {
    	    		MainFightPanel.append(MainFightPanel.user,"["+pageName[i]+"]",Color.WHITE,22,true);
    	    		if(i == Player.equippedPage)
    	    			MainFightPanel.append(MainFightPanel.user,"[EQUIPPED]",Color.WHITE,22,true);
    	    	}
    	    	else {
    	    		MainFightPanel.append(MainFightPanel.user,"["+pageName[i]+"]",Color.GRAY,20,false);
    	    		if(i == Player.equippedPage)
    	    			MainFightPanel.append(MainFightPanel.user,"[EQUIPPED]",Color.GRAY,20,false);
    		}
    		
    		MainFightPanel.append(MainFightPanel.user,"\n",Color.WHITE,22,false);
    	}
    	MainFightPanel.append(MainFightPanel.user,"==========================================================\n",Color.WHITE,20,false);
    	MainFightPanel.append(MainFightPanel.user,"                  EQUIPPED ABILITIES\n",Color.WHITE,20,false);
    	 for(int i = 0;i<5;i++)
         {
    		 if(pages[direction-1][i] != null) {
    			 MainFightPanel.append(MainFightPanel.user,"\n   " + pages[direction-1][i].name,Color.LIGHT_GRAY,15,true); 
    			 MainFightPanel.append(MainFightPanel.user," | "+ pages[direction-1][i].desc+"\n",Color.LIGHT_GRAY,11,false); 
    		 }
         }
    	   direction = direction - pageCount-1;
     	   holder = direction;
       } 	
     }
    	switchOpened = false;
    	if(Player.equippedPage != direction  + pageCount) {
    		Player.equippedPage = direction + pageCount;
    		MainFightPanel.clearDisplay();
    		MainFightPanel.append(MainFightPanel.user,"\n\n Ability set changed to: ",Color.WHITE,20,false);
    		MainFightPanel.append(MainFightPanel.user,pageName[Player.equippedPage],Color.ORANGE,20,true);
    		run.pause(1500);
    		if(gameplay.Player.armorSet[gameplay.Player.equippedArmor].timeScore() < 4) {
    			RPGRunner.pTurn = false;
    			RPGRunner.eTurn = true;
    		}	
    	}
    }
    
    public static void print()
    {
    	 run.append("=====================PASSIVES====================\n");
    	 run.append("" + Ability.Passives.List.show() + "\n");
    	 run.append("=================================================\n\n");
    	 run.append("=====================ACTIVES==============================================================================================\n");
        for(int i = 0;i<5;i++)
        {
            run.append("\n[" + (i+1) +"] " + pages[Player.equippedPage][i].name +" | "+ pages[Player.equippedPage][i].desc); 
        }
        run.append("\n========================================================================================================================\n");
    }
    public static void checkDirection(int min,int max,int d)
    {
    direction = direction + d + max;
    if(direction < min)
        direction = max - 1;
    if(direction == (max))
         direction = min;
        
 }

 public static void checkEnter(boolean b)
 {
    select = b;
 }
}
