package consumables;
import java.awt.Color;
import java.util.Scanner;

import backend.*;
import gameplay.Player;

public class ItemManager
{
	private static final Color LIGHT_BLUE = new Color(0,166,255);
	public static boolean opened = false;
	public static int direction;
	public static boolean select = false;
    public static boolean slot4unlock = false;
    public static boolean slot5unlock = false;
    public static int slotCount = 3;
   public static boolean heal;
   public static boolean strength;
   public static boolean elixer;
   public static int healUp;
   public static int strengthUp;
   public static String name;
   public static String[] itemSlot = {"none","none","none","none","none"};
   public static String desc;
   public static boolean marine;
   public static RPGRunner run;
   public static boolean full;
    public ItemManager(RPGRunner r)
    {
        this.run = r;
    }
  public static void newItem(boolean h, boolean s, boolean e, int hu, int su, String n,String d,boolean m)
   {
    heal = h;
    strength = s;
    elixer = e;
    healUp = hu;
    strengthUp = su;
    name = n;
    desc = d;
    marine = m;
   }
   public static boolean heal1;
   public static boolean marine1;
   public static boolean strength1;
   public static boolean elixer1;
   public static int healUp1;
   public static int strengthUp1;
   
   public static boolean heal2;
   public static boolean strength2;
   public static boolean marine2;
   public static boolean elixer2;
   public static int healUp2;
   public static int strengthUp2;
   
   public static boolean heal3;
   public static boolean marine3;
   public static boolean strength3;
   public static boolean elixer3;
   public static int healUp3;
   public static int strengthUp3;
   
   public static boolean heal4;
   public static boolean marine4;
   public static boolean strength4;
   public static boolean elixer4;
   public static int healUp4;
   public static int strengthUp4;
   
   public static boolean heal5;
   public static boolean marine5;
   public static boolean strength5;
   public static boolean elixer5;
   public static int healUp5;
   public static int strengthUp5;
   
 
   
   public static void useItems(int i)
   {
	   MainFightPanel.append(MainFightPanel.user,"\n\n\n\n");
     
       if(i == 1)
       {
           if(itemSlot[0].equals("none"))
           {
               MainFightPanel.append(MainFightPanel.user,"You don't have an item in this slot");
               pause(3000);
               MainFightPanel.clearDisplay();
            }
            else{
          if(marine1 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used an ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[0].substring(0, itemSlot[0].indexOf(" |")),LIGHT_BLUE,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[0].substring(itemSlot[0].indexOf(" |")));
              gameplay.Player.mana = gameplay.Player.mana + (gameplay.Player.maxMana / 2);
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(heal1 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used a ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[0].substring(0, itemSlot[0].indexOf(" |")),Color.GREEN,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[0].substring(itemSlot[0].indexOf(" |")));
              gameplay.Player.health = gameplay.Player.health + (int)(gameplay.Player.maxHealth * (healUp1 / 100.0));
              if(gameplay.Player.health > gameplay.Player.maxHealth)
              {
                  gameplay.Player.health = gameplay.Player.maxHealth;
              }
              RPGRunner.eTurn = true;
              RPGRunner.pTurn = false;
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(strength1 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used a ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[0].substring(0, itemSlot[0].indexOf(" |")),Color.RED,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[0].substring(itemSlot[0].indexOf(" |")));
              Player.baseDmg = Player.baseDmg +  (int)(Player.getDmg() * (strengthUp1 / 100.0));
              RPGRunner.eTurn = true;
              RPGRunner.pTurn = false;
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(elixer1 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used an ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[0].substring(0, itemSlot[0].indexOf(" |")),Color.ORANGE,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[0].substring(itemSlot[0].indexOf(" |")));
              gameplay.Player.health = gameplay.Player.maxHealth;
              gameplay.Player.mana = gameplay.Player.maxMana;
              pause(3000);
               MainFightPanel.clearDisplay();
          }
          String result = itemSlot[0].substring(0, itemSlot[0].indexOf(" |"));
          backpack.Manager.remove("Item: " + result, 1);
           itemSlot[0] = "none";
           heal1 = false;
           marine1 = false;
           strength1 = false;
           elixer1 = false;
           healUp1 = 0;
           strengthUp1 = 0;
           
        }
    }
       else if(i == 2)
       {
           if(itemSlot[1].equals("none"))
           {
               MainFightPanel.append(MainFightPanel.user,"You don't have an item in this slot");
              pause(3000);
               MainFightPanel.clearDisplay();
            }
            else {
           if(heal2 == true)
          {
        	   MainFightPanel.append(MainFightPanel.user,"You used a ");
               MainFightPanel.append(MainFightPanel.user,itemSlot[1].substring(0, itemSlot[1].indexOf(" |")),Color.GREEN,20,true);
               MainFightPanel.append(MainFightPanel.user,itemSlot[1].substring(itemSlot[1].indexOf(" |")));
              gameplay.Player.health = gameplay.Player.health + (int)(gameplay.Player.maxHealth * (healUp2 / 100.0));
              if(gameplay.Player.health > gameplay.Player.maxHealth)
              {
                  gameplay.Player.health = gameplay.Player.maxHealth;
              }
              RPGRunner.eTurn = true;
              RPGRunner.pTurn = false;
              pause(3000);
               MainFightPanel.clearDisplay();
           }
           if(marine2 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used an ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[1].substring(0, itemSlot[1].indexOf(" |")),LIGHT_BLUE,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[1].substring(itemSlot[1].indexOf(" |")));
              gameplay.Player.mana = gameplay.Player.mana + (gameplay.Player.maxMana / 2);
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(strength2 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used a ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[1].substring(0, itemSlot[1].indexOf(" |")),Color.RED,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[1].substring(itemSlot[1].indexOf(" |")));
              Player.baseDmg = Player.baseDmg + (int)(Player.getDmg() * (strengthUp2 / 100.0));
              RPGRunner.eTurn = true;
              RPGRunner.pTurn = false;
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(elixer2 == true)
          {
        	  MainFightPanel.append(MainFightPanel.user,"You used an ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[1].substring(0, itemSlot[1].indexOf(" |")),Color.ORANGE,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[1].substring(itemSlot[1].indexOf(" |")));
              gameplay.Player.health = gameplay.Player.maxHealth;
              gameplay.Player.mana = gameplay.Player.maxMana;
              pause(3000);
               MainFightPanel.clearDisplay();
          }
          String result = itemSlot[1].substring(0, itemSlot[1].indexOf(" |"));
          backpack.Manager.remove("Item: " + result, 1);
           itemSlot[1] = "none";
           heal2 = false;
           strength2 = false;
           marine2 = false;
           elixer2 = false;
           healUp2 = 0;
           strengthUp2 = 0;
       }
    }
       else if (i == 3)
       {
           if(itemSlot[2].equals("none"))
           {
               MainFightPanel.append(MainFightPanel.user,"You don't have an item in this slot");
              pause(3000);
               MainFightPanel.clearDisplay();
            }
            else{
           if(heal3 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used a ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[2].substring(0, itemSlot[2].indexOf(" |")),Color.GREEN,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[2].substring(itemSlot[2].indexOf(" |")));
              gameplay.Player.health = gameplay.Player.health + (int)(gameplay.Player.maxHealth * (healUp3 / 100.0));
              if(gameplay.Player.health > gameplay.Player.maxHealth)
              {
                  gameplay.Player.health = gameplay.Player.maxHealth;
              }
              RPGRunner.eTurn = true;
              RPGRunner.pTurn = false;
              pause(3000);
               MainFightPanel.clearDisplay();
           }
           if(marine3 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used an ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[2].substring(0, itemSlot[2].indexOf(" |")),LIGHT_BLUE,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[2].substring(itemSlot[2].indexOf(" |")));
              gameplay.Player.mana = gameplay.Player.mana + (gameplay.Player.maxMana / 2);
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(strength3 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used a ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[2].substring(0, itemSlot[2].indexOf(" |")),Color.RED,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[2].substring(itemSlot[2].indexOf(" |")));
              Player.baseDmg = Player.baseDmg + (int)(Player.getDmg() * (strengthUp3 / 100.0));
              RPGRunner.eTurn = true;
              RPGRunner.pTurn = false;
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(elixer3 == true)
          {
        	  MainFightPanel.append(MainFightPanel.user,"You used an ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[2].substring(0, itemSlot[2].indexOf(" |")),Color.ORANGE,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[2].substring(itemSlot[2].indexOf(" |")));
              gameplay.Player.health = gameplay.Player.maxHealth;
              gameplay.Player.mana = gameplay.Player.maxMana;
              pause(3000);
               MainFightPanel.clearDisplay();
          }
          String result = itemSlot[2].substring(0, itemSlot[2].indexOf(" |"));
          backpack.Manager.remove("Item: " + result, 1);
           itemSlot[2] = "none";
           heal3 = false;
           marine3 = false;
           strength3 = false;
           elixer3 = false;
           healUp3 = 0;
           strengthUp3 = 0;
        }
    }
    else if (i == 4 && slot4unlock == true)
       {
           if(itemSlot[3].equals("none"))
           {
               MainFightPanel.append(MainFightPanel.user,"You don't have an item in this slot");
              pause(3000);
               MainFightPanel.clearDisplay();
            }
            else{
           if(heal4 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used a ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[3].substring(0, itemSlot[3].indexOf(" |")),Color.GREEN,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[3].substring(itemSlot[3].indexOf(" |")));
              gameplay.Player.health = gameplay.Player.health + (int)(gameplay.Player.maxHealth * (healUp4 / 100.0));
              if(gameplay.Player.health > gameplay.Player.maxHealth)
              {
                  gameplay.Player.health = gameplay.Player.maxHealth;
              }
              RPGRunner.eTurn = true;
              RPGRunner.pTurn = false;
              pause(3000);
               MainFightPanel.clearDisplay();
           }
           if(marine4 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used an ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[3].substring(0, itemSlot[3].indexOf(" |")),LIGHT_BLUE,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[3].substring(itemSlot[3].indexOf(" |")));
              gameplay.Player.mana = gameplay.Player.mana + (gameplay.Player.maxMana / 2);
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(strength4 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used a ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[3].substring(0, itemSlot[3].indexOf(" |")),Color.RED,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[3].substring(itemSlot[3].indexOf(" |")));
              Player.baseDmg = Player.baseDmg + (int)(Player.getDmg() * (strengthUp4 / 100.0));
              RPGRunner.eTurn = true;
              RPGRunner.pTurn = false;
              pause(3000);
               MainFightPanel.clearDisplay();
           }
          if(elixer4 == true)
          {
              MainFightPanel.append(MainFightPanel.user,"You used an ");
              MainFightPanel.append(MainFightPanel.user,itemSlot[3].substring(0, itemSlot[3].indexOf(" |")),Color.ORANGE,20,true);
              MainFightPanel.append(MainFightPanel.user,itemSlot[3].substring(itemSlot[3].indexOf(" |")));
              gameplay.Player.health = gameplay.Player.maxHealth;
              gameplay.Player.mana = gameplay.Player.maxMana;
              pause(3000);
               MainFightPanel.clearDisplay();
          }
          String result = itemSlot[3].substring(0, itemSlot[3].indexOf(" |"));
          backpack.Manager.remove("Item: " + result, 1);
           itemSlot[3] = "none";
           heal4 = false;
           marine4 = false;
           strength4 = false;
           elixer4 = false;
           healUp4 = 0;
           strengthUp4 = 0;
        }
    }
    else if (i == 5 && slot5unlock == true)
    {
        if(itemSlot[4].equals("none"))
        {
            MainFightPanel.append(MainFightPanel.user,"You don't have an item in this slot");
           pause(3000);
            MainFightPanel.clearDisplay();
         }
         else{
        if(heal5 == true)
       {
           MainFightPanel.append(MainFightPanel.user,"You used a ");
           MainFightPanel.append(MainFightPanel.user,itemSlot[4].substring(0, itemSlot[4].indexOf(" |")),Color.GREEN,20,true);
           MainFightPanel.append(MainFightPanel.user,itemSlot[4].substring(itemSlot[4].indexOf(" |")));
           gameplay.Player.health = gameplay.Player.health + (int)(gameplay.Player.maxHealth * (healUp5 / 100.0));
           if(gameplay.Player.health > gameplay.Player.maxHealth)
           {
               gameplay.Player.health = gameplay.Player.maxHealth;
           }
           RPGRunner.eTurn = true;
           RPGRunner.pTurn = false;
           pause(3000);
            MainFightPanel.clearDisplay();
        }
        if(marine5 == true)
       {
           MainFightPanel.append(MainFightPanel.user,"You used an ");
           MainFightPanel.append(MainFightPanel.user,itemSlot[4].substring(0, itemSlot[4].indexOf(" |")),LIGHT_BLUE,20,true);
           MainFightPanel.append(MainFightPanel.user,itemSlot[4].substring(itemSlot[4].indexOf(" |")));
           gameplay.Player.mana = gameplay.Player.mana + (gameplay.Player.maxMana / 2);
           pause(3000);
            MainFightPanel.clearDisplay();
        }
       if(strength5 == true)
       {
           MainFightPanel.append(MainFightPanel.user,"You used a ");
           MainFightPanel.append(MainFightPanel.user,itemSlot[4].substring(0, itemSlot[4].indexOf(" |")),Color.RED,20,true);
           MainFightPanel.append(MainFightPanel.user,itemSlot[4].substring(itemSlot[4].indexOf(" |")));
           Player.baseDmg = Player.baseDmg + (int)(Player.getDmg() * (strengthUp4 / 100.0));
           RPGRunner.eTurn = true;
           RPGRunner.pTurn = false;
           pause(3000);
            MainFightPanel.clearDisplay();
        }
       if(elixer5 == true)
       {
    	   MainFightPanel.append(MainFightPanel.user,"You used an ");
           MainFightPanel.append(MainFightPanel.user,itemSlot[4].substring(0, itemSlot[4].indexOf(" |")),Color.ORANGE,20,true);
           MainFightPanel.append(MainFightPanel.user,itemSlot[4].substring(itemSlot[4].indexOf(" |")));
           gameplay.Player.health = gameplay.Player.maxHealth;
           gameplay.Player.mana = gameplay.Player.maxMana;
           pause(3000);
            MainFightPanel.clearDisplay();
       }
       String result = itemSlot[4].substring(0, itemSlot[4].indexOf(" |"));
       backpack.Manager.remove("Item: " + result, 1);
        itemSlot[4] = "none";
        heal5 = false;
        marine5 = false;
        strength5 = false;
        elixer5 = false;
        healUp5 = 0;
        strengthUp5 = 0;
     }
 }
    else
     MainFightPanel.clearDisplay();
   }
   
    public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
   
   public static void setItem() throws InterruptedException
   {
	   
       if(itemSlot[0].equals("none"))
      {
        itemSlot[0] = name + " | " + desc;
        heal1 = heal;
        strength1 = strength;
        elixer1 = elixer;
        healUp1 = healUp;
        strengthUp1 = strengthUp;
        marine1 = marine;
        String result = itemSlot[0].substring(0, itemSlot[0].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
      }
       else if(!(itemSlot[0].equals("none")) && itemSlot[1].equals("none"))
      {
        itemSlot[1] = name + " | " + desc;
        heal2 = heal;
        strength2 = strength;
        elixer2 = elixer;
        healUp2 = healUp;
        strengthUp2 = strengthUp;
        marine2 = marine;
        String result = itemSlot[1].substring(0, itemSlot[1].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
      }
       else if(!((itemSlot[0].equals("none")) && itemSlot[1].equals("none")) && itemSlot[2].equals("none"))
      {
        itemSlot[2] = name + " | " + desc;
        heal3 = heal;
        strength3 = strength;
        elixer3 = elixer;
        healUp3 = healUp;
        strengthUp3 = strengthUp;
        marine3 = marine;
        String result = itemSlot[2].substring(0, itemSlot[2].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
      }
      else if(!((itemSlot[0].equals("none")) && itemSlot[1].equals("none") && itemSlot[2].equals("none"))&& itemSlot[3].equals("none") && slot4unlock == true)
      {
        itemSlot[3] = name + " | " + desc;
        heal4 = heal;
        strength4 = strength;
        elixer4 = elixer;
        healUp4 = healUp;
        strengthUp4 = strengthUp;
        marine4 = marine;
        String result = itemSlot[3].substring(0, itemSlot[3].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
      }
      else if(!((itemSlot[0].equals("none")) && itemSlot[1].equals("none") && itemSlot[2].equals("none")&& itemSlot[3].equals("none")) && itemSlot[4].equals("none") && slot5unlock == true)
      {
        itemSlot[4] = name + " | " + desc;
        heal5 = heal;
        strength5 = strength;
        elixer5 = elixer;
        healUp5 = healUp;
        strengthUp5 = strengthUp;
        marine5 = marine;
        String result = itemSlot[4].substring(0, itemSlot[4].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
      }
        else
       {
           full = true;
            run.fontSize(20);
         RPGRunner.append("\nYou do not have enough space for the " + name + "\n");
         if(slot4unlock != true)
         RPGRunner.append("Would you like to replace an item [1][2][3] or Not[4]?\n");
         if(slot4unlock == true && slot5unlock == false)
             RPGRunner.append("Would you like to replace an item [1][2][3][4] or Not[5]?\n");
         if(slot5unlock == true)
             RPGRunner.append("Would you like to replace an item [1][2][3][4][5] or Not[6]?\n");
         printItems();
       int answer = run.getInt();
       if(answer == 1)
       {
           backpack.Manager.remove("Item: " + itemSlot[0].substring(0, itemSlot[0].indexOf(" |")), 1);
        itemSlot[0] = name + " | " + desc;
        heal1 = heal;
        strength1 = strength;
        elixer1 = elixer;
        healUp1 = healUp;
        marine1 = marine;
        strengthUp1 = strengthUp;
        String result = itemSlot[0].substring(0, itemSlot[0].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
        run.output.setText("");
       }
       else if(answer == 2)
       {
    	   backpack.Manager.remove("Item: " + itemSlot[1].substring(0, itemSlot[1].indexOf(" |")), 1);
        itemSlot[1] = name + " | " + desc;
        heal2 = heal;
        strength2 = strength;
        elixer2 = elixer;
        marine2 = marine;
        healUp2 = healUp;
        strengthUp2 = strengthUp;
        String result = itemSlot[1].substring(0, itemSlot[1].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
        run.output.setText("");
       }
       else if(answer == 3)
       {
    	   backpack.Manager.remove("Item: " + itemSlot[2].substring(0, itemSlot[2].indexOf(" |")), 1);
        itemSlot[2] = name + " | " + desc;
        heal3 = heal;
        strength3 = strength;
        elixer3 = elixer;
        healUp3 = healUp;
        strengthUp3 = strengthUp;
        marine3 = marine;
        String result = itemSlot[2].substring(0, itemSlot[2].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
        run.output.setText("");
        }
        else if(answer == 4 && slot4unlock == true)
       {
        	backpack.Manager.remove("Item: " + itemSlot[3].substring(0, itemSlot[3].indexOf(" |")), 1);
        itemSlot[3] = name + " | " + desc;
        heal4 = heal;
        strength4 = strength;
        elixer4 = elixer;
        healUp4 = healUp;
        strengthUp4 = strengthUp;
        marine4 = marine;
        String result = itemSlot[3].substring(0, itemSlot[3].indexOf(" |"));
 	   backpack.Manager.add("Item: " + result, 1);
        run.output.setText("");
        }
        else if(answer == 5 && slot5unlock == true)
        {
        	backpack.Manager.remove("Item: " + itemSlot[4].substring(0, itemSlot[4].indexOf(" |")), 1);
         itemSlot[4] = name + " | " + desc;
         heal5 = heal;
         strength5 = strength;
         elixer5 = elixer;
         healUp5 = healUp;
         strengthUp5 = strengthUp;
         marine5 = marine;
         String result = itemSlot[4].substring(0, itemSlot[4].indexOf(" |"));
  	   backpack.Manager.add("Item: " + result, 1);
         run.output.setText("");
         }
       else
       {
        RPGRunner.append("You have decided to discard your newly aquired " + name + ".\n");
 
        gameplay.Player.userWait();
        run.output.setText("");
       }
       if(gameplay.Shop.shopOpen == true)
            run.fontSize(30);
       full = false;
     }
     
   }
   public static int fightPrintItems() {
	   opened = true;
	   select = false;
	   int holder = 0;
	   direction = 1;
	   while(select == false) {
		   System.out.println("Looping...");
		   if(holder != direction) {
			   MainFightPanel.clearDisplay();
		        MainFightPanel.append(MainFightPanel.user,"\n\n'Select an option'\n",Color.WHITE,25,false);
	   MainFightPanel.append(MainFightPanel.user,"\n================ITEMS===============\n",Color.WHITE,20,false);
	   
	   for(int i = 1;i<=slotCount+1;i++) {
		   
		   if(direction == i && i < slotCount+1)
			   MainFightPanel.append(MainFightPanel.user,consumables.ItemManager.itemSlot[i-1] + "\n",Color.WHITE,20,true);
		   else if(direction != i && i < slotCount + 1)
			   MainFightPanel.append(MainFightPanel.user,consumables.ItemManager.itemSlot[i-1] + "\n",Color.GRAY,20,false);
		   else if(direction == i && i == slotCount+1)
			   MainFightPanel.append(MainFightPanel.user,"<--Back\n",Color.WHITE,20,true);
		   else if(direction != i && i == slotCount+1)
			   MainFightPanel.append(MainFightPanel.user,"<--Back\n",Color.GRAY,20,false);

	   }
	   direction = direction - slotCount - 2;
	   holder = direction;
	   MainFightPanel.append(MainFightPanel.user,"====================================\n",Color.WHITE,20,false);
		   }
	  }
	   opened = false;
	   return direction + slotCount + 1;
   }
   
   public static void printItems()
   {
	   run.append("================ITEMS===============");
       for(int i = 0;i<slotCount;i++)
       {
           run.append("\n[" + (i+1) +"]: " + consumables.ItemManager.itemSlot[i]); 
       }
       run.append("\n====================================\n");
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
