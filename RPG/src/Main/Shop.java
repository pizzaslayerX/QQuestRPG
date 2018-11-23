package Main;
import Run.*;
import java.awt.event.*;

public class Shop
{
    public static boolean newVisit = true;
    public static RPGRunner run;
    public static boolean shopOpen = false;
    public static int direction = 0;
    public static int UDDirection = 5;
    public static boolean selection = false;
    public static boolean buying = false;
    public static int choice = 2;
    public static boolean quit = false;
            public static String[] weaponStock = new String[5];
        public static int[] weaponStockPrice = new int[5];
    public Shop(RPGRunner r)
    {
        this.run = r;
    }
        
    
    public static void openShop() throws InterruptedException
    {
        buying = false;
        shopOpen = true;
        quit = false;
       if(Player.scene >= 10)
       {
           
           run.output.setText("");
          run.fontSize(30);
          run.append("\n\n                              Welcome to\n");
          run.append("                            --------------\n");
          run.append("                         ~Simon's Trade Post~\n\n");
          run.append("                ===========                ==========\n");
          run.append("                   Shop                      Leave\n");
          run.append("                ===========                ==========\n");
           selection = false;
           pause(500);
                while(selection == false)
         {
                	 System.out.println("KeyHandler Looping");
          if(direction == 1)
          {
              run.output.setText("");
              run.append("\n\n                              Welcome to\n");
          run.append("                            --------------\n");
          run.append("                         ~Simon's Trade Post~\n\n");
          run.append("                ===========                ==========\n");
          run.append("                 > Shop                      Leave\n");
          run.append("                ===========                ==========\n");
          direction = 0;
          choice = 1;
          }
          if(direction == 2)
          {
              run.output.setText("");
              run.append("\n\n                              Welcome to\n");
          run.append("                            --------------\n");
          run.append("                         ~Simon's Trade Post~\n\n");
          run.append("                ===========                ==========\n");
          run.append("                   Shop                    > Leave\n");
          run.append("                ===========                ==========\n");
          direction = 0;
          choice = 2;
          }
          
        }
     
        if(choice == 1)
       {
           while(quit == false)
        {
            buying = false;
            choice = 0;
            direction = 0;
            selection = false;
          run.output.setText("");
          run.append("\n\n\n\n                ===========                ==========\n");
                  run.append("                    Buy                       Sell\n");
                  run.append("                ===========                ==========\n");
                  run.append("\n\n\n\n\n\n Leave [SHIFT]");
                  pause(200);
       
             
            
        while(selection == false)
          {
        	 System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                run.output.setText("");
             run.append("\n\n\n\n                ===========                ==========\n");
                     run.append("                  > Buy                       Sell\n");
                     run.append("                ===========                ==========\n"); 
                     run.append("\n\n\n\n\n\n Leave [SHIFT]");
                     direction = 0;
              choice = 1;
            }
            if(direction == 2)
            {
                run.output.setText("");
             run.append("\n\n\n\n                ===========                ==========\n");
                     run.append("                    Buy                     > Sell\n");
                     run.append("                ===========                ==========\n"); 
                     run.append("\n\n\n\n\n\n Leave [SHIFT]");
                     direction = 0;
              choice = 2;
            }
            }
        if(quit == false && choice == 1)
        {
            printShop();
        }
        else
        {
            run.output.setText("");
            
            direction = 0;
            choice = 0;
        while(quit == false && direction != 1)
        {
            UDDirection = 1;
            selection = false;
            while(selection == false && (direction != 1))
          {
            	 System.out.println("KeyHandler Looping");
           if(UDDirection == 1 || UDDirection == 3 || UDDirection == 5)
            {
                run.output.setText("");
            run.append("_________________________________________________________________________________________________________________________\n");
             run.append("Sell " + Player.weapons[Player.equippedWeapon].name + " for: " + Player.weapons[Player.equippedWeapon].price/2 + " gold <");
            run.append("\n[dmg:" + Player.weapons[Player.equippedWeapon].dmg + "][crit:" + Player.weapons[Player.equippedWeapon].crit + "]");
            run.append("\n_________________________________________________________________________________________________________________________\n");
            run.append("Sell " + Player.armor[Player.equippedArmor].name + " for: " + Player.armor[Player.equippedArmor].price/2 + " gold");
            run.append("\n[def:" + Player.armor[Player.equippedArmor].def + "]");
            run.append("\n_________________________________________________________________________________________________________________________");
            run.append("\n\n\n Your Gold: " + Player.gold + "\n <---- Back");
                     UDDirection = 0;
              choice = 1;
            }
            if(UDDirection == 2 || UDDirection == 4)
            {
                run.output.setText("");
            run.append("_________________________________________________________________________________________________________________________\n");
             run.append("Sell " + Player.weapons[Player.equippedWeapon].name + " for: " + Player.weapons[Player.equippedWeapon].price/2 + " gold");
            run.append("\n[dmg:" + Player.weapons[Player.equippedWeapon].dmg + "][crit:" + Player.weapons[Player.equippedWeapon].crit + "]");
            run.append("\n_________________________________________________________________________________________________________________________\n");
            run.append("Sell " + Player.armor[Player.equippedArmor].name + " for: " + Player.armor[Player.equippedArmor].price/2 + " gold <");
            run.append("\n[def:" + Player.armor[Player.equippedArmor].def + "]");
            run.append("\n_________________________________________________________________________________________________________________________");
            run.append("\n\n\n Your Gold: " + Player.gold + "\n <---- Back");
                     UDDirection = 0;
              choice = 2;
           }
          }
          run.output.setText("");
          if(choice == 1 && selection == true)
          {
              Player.gold = Player.gold + Player.weapons[Player.equippedWeapon].price/2;
              Weapon.Fist.setWeapon();
            }
           if(choice == 2 && selection == true)
          {
              Player.gold = Player.gold + Player.armor[Player.equippedArmor].price/2;
              Armor.None.setArmor();
            } 
        }  
       }
       }
       buying = false;
            shopOpen = false;
        run.output.setText("");
            
            Story.textEffect("\n\n\n                       Simon: Come back soon!");
            pause(2500);
            run.output.setText("");
            run.fontSize(20);
        
      }
        else
        {
            buying = false;
            shopOpen = false;
        run.output.setText("");
            Story.textEffect("\n\n\n                       Simon: Come back soon!");
            pause(2500);
            run.output.setText("");
            run.fontSize(20);
        }
      }
    }
    
    
    public static void printShopTwo() throws InterruptedException
    {
        buying = true;
        run.output.setText("");
        direction = 0;
        UDDirection = 5;
        String[]weaponList = new String[5];
        int[] weaponPrice = new int[5];
        String[]armorList = new String[4];
        int[] armorPrice = new int[4];
        String[]scrollList = new String[3];
        int[] scrollPrice = new int[3];
      if(Player.level < 11)
      {
        String[] weaponList1 = {"Iron Dagger [dmg:10][crit:5]","Party Blaster [dmg:29][crit:15][Stun]","Long Bow [dmg:16][crit:50]","Reinforced Long Bow [dmg:22][crit:48]","Ancient Rifle [dmg:30][crit:55]"};
        int [] weaponPrice1 = {150,800,570,772,1300};
        String[] armorList1 = {"Studded Leather [def:25]","Chain Mail [def:28]","Paper Armor [def:5]","Clown Suit [def:30]"};
        int[] armorPrice1 = {500,650,80,830};
        String[] scrollList1 = {"Eruption Scroll","Regenerate Scroll","Poison Scroll"};
        int[] scrollPrice1 = {1050,1100,450};
        
        weaponList = weaponList1;
        weaponPrice = weaponPrice1;
        armorList = armorList1;
        armorPrice = armorPrice1;
        scrollList = scrollList1;
        scrollPrice = scrollPrice1;
    }
    else if(Player.level >= 11 && Player.level < 16)
    {
        String[] weaponList2 = {"Steel Dagger [dmg:14][crit:8]","Party Blaster [dmg:29][crit:15][Stun]","The Executioner [dmg:37][crit:15][Opress]","Reinforced Long Bow [dmg:22][crit:48]","Ancient Rifle [dmg:30][crit:55]"};
        int [] weaponPrice2 = {215,800,1580,672,1300};
        String[] armorList2 = {"Studded Leather [def:25]","Chain Mail [def:28]","Iron Plated[def:33]","Clown Suit [def:30]"};
        int[] armorPrice2 = {500,650,1100,830};
        String[] scrollList2 = {"Explosion Scroll","Stun+ Scroll","Triple Threat Scroll"};
        int[] scrollPrice2 = {1850,900,1333};
        
        weaponList = weaponList2;
        weaponPrice = weaponPrice2;
        armorList = armorList2;
        armorPrice = armorPrice2;
        scrollList = scrollList2;
        scrollPrice = scrollPrice2;
    }
    else if(Player.level > 16)
    {
        String[] weaponList2 = {"Glass Dagger [dmg:17][crit:85]","Winter's Bane [dmg:41][crit:10][Ice Wind]","The Executioner [dmg:37][crit:15][Opress]","Superior Rifle [dmg:45][crit:45][Snipe]","Fire Hydrant [dmg:55][crit:0][???]"};
        int [] weaponPrice2 = {615,1680,1580,2120,1213};
        String[] armorList2 = {"Wooden Armor [def:22]","Armor of the Master [def:40]","Steel Coat[def:38]","Mining Helmet [def:35]"};
        int[] armorPrice2 = {380,1750,1500,1050};
        String[] scrollList2 = {"Uber Cure","Icicle Shower","Invincibility"};
        int[] scrollPrice2 = {1650,1470,1999};
        
        weaponList = weaponList2;
        weaponPrice = weaponPrice2;
        armorList = armorList2;
        armorPrice = armorPrice2;
        scrollList = scrollList2;
        scrollPrice = scrollPrice2;
    }
        selection = false;
        quit = false;
   if(newVisit == true)
   {
        for(int i = 0;i<weaponStock.length;i++)
        {
         int ran = (int)(Math.random() * 3);
         switch(ran)
         {
            case 0:
                ran = (int)(Math.random() * weaponList.length);
                         weaponStock[i] = weaponList[ran];
                         weaponStockPrice[i] = weaponPrice[ran];
                     for(int e = 0;e<i;e++)
                     {
                         while(weaponStock[e] == weaponList[ran])
                         {
                             ran = (int)(Math.random() * weaponList.length);
                           weaponStock[i] = weaponList[ran];
                           weaponStockPrice[i] = weaponPrice[ran];
                            }
                        }
                break;
            case 1:
                ran = (int)(Math.random() * armorList.length);
               
                         weaponStock[i] = armorList[ran];
                         weaponStockPrice[i] = armorPrice[ran];
                        for(int e = 0;e<i;e++)
                     {
                         while(weaponStock[e] == armorList[ran])
                         {
                             ran = (int)(Math.random() * armorList.length);
                           weaponStock[i] = armorList[ran];
                           weaponStockPrice[i] = armorPrice[ran];
                            }
                        }
                break;
            case 2:
                ran = (int)(Math.random() * scrollList.length);
                
                         weaponStock[i] = scrollList[ran];
                         weaponStockPrice[i] = scrollPrice[ran];
                         
                  break;
            case 3:
                ran = (int)(Math.random() * scrollList.length);
                
                         weaponStock[i] = scrollList[ran];
                         weaponStockPrice[i] = scrollPrice[ran];
                         
                break;
        }
    }
    newVisit = false;
   }
         while(quit == false && direction != 1)
    {
      while(selection == false && quit == false && direction != 1)
      {
    	  System.out.println("KeyHandler Looping");
      if(UDDirection == 5)
      {
          run.output.setText("");
        for(int i = 0;i<weaponStock.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i == 0)
        {
        run.append(weaponStock[0] + ": " + weaponStockPrice[0] + " gold <");
       }
        if(i>0)
          run.append(weaponStock[i] + ": " + weaponStockPrice[i] + " gold");
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\n<----- Back");
      UDDirection = 0;
     }
     if(UDDirection == 4)
      {
          run.output.setText("");
        for(int i = 0;i<weaponStock.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i==0)
        {
         run.append(weaponStock[0] + ": " + weaponStockPrice[0] + " gold");
        }
        if(i==1)
        {
         run.append(weaponStock[1] + ": " + weaponStockPrice[1] + " gold <");
        }
        if(i > 1)
        run.append(weaponStock[i] + ": " + weaponStockPrice[i] + " gold");
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\n<----- Back");
      UDDirection = -1;
     }
     if(UDDirection == 3)
      {
          run.output.setText("");
        for(int i = 0;i<weaponStock.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i==0)
        {
         run.append(weaponStock[0] + ": " + weaponStockPrice[0] + " gold");
        }
        if(i==1)
        {
         run.append(weaponStock[1] + ": " + weaponStockPrice[1] + " gold");
        }
        if(i > 2)
        run.append(weaponStock[i] + ": " + weaponStockPrice[i] + " gold");
        if(i == 2)
        {
            run.append(weaponStock[2] + ": " + weaponStockPrice[2] + " gold <");
        }
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\n<----- Back");
      UDDirection = -2;
     }
     if(UDDirection == 2)
      {
          run.output.setText("");
        for(int i = 0;i<weaponStock.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i==0)
        {
         run.append(weaponStock[0] + ": " + weaponStockPrice[0] + " gold");
        }
        if(i==1)
        {
         run.append(weaponStock[1] + ": " + weaponStockPrice[1] + " gold");
        }
        if(i > 3)
        run.append(weaponStock[i] + ": " + weaponStockPrice[i] + " gold");
        if(i == 2)
        {
            run.append(weaponStock[2] + ": " + weaponStockPrice[2] + " gold");
        }
        if(i == 3)
         run.append(weaponStock[3] + ": " + weaponStockPrice[3] + " gold <");
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\n<----- Back");
      UDDirection = -3;
     }
     if(UDDirection == 1)
      {
          run.output.setText("");
        for(int i = 0;i<weaponStock.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i==0)
        {
         run.append(weaponStock[0] + ": " + weaponStockPrice[0] + " gold");
        }
        if(i==1)
        {
         run.append(weaponStock[1] + ": " + weaponStockPrice[1] + " gold");
        }
        if(i > 4)
        run.append(weaponStock[i] + ": " + weaponStockPrice[i] + " gold");
        if(i == 2)
        {
            run.append(weaponStock[2] + ": " + weaponStockPrice[2] + " gold");
        }
        if(i == 3)
         run.append(weaponStock[3] + ": " + weaponStockPrice[3] + " gold");
         if(i==4)
          run.append(weaponStock[4] + ": " + weaponStockPrice[4] + " gold <");
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\n<----- Back");
      UDDirection = -4;
     }
     
    }
    
    if(Player.gold >= weaponStockPrice[(UDDirection * -1)] && selection == true && quit == false)
    {
     Player.gold = Player.gold - weaponStockPrice[(UDDirection * -1)];
          run.output.setText("");
     buyItem((UDDirection * -1));
     for(int i = 0;i<weaponStock.length;i++)
     {
        run.append("______________________________________________________________________________________________\n");
        if(i == 0)
        {
        run.append(weaponStock[0] + ": " + weaponStockPrice[0] + " gold <");
       }
        if(i>0)
          run.append(weaponStock[i] + ": " + weaponStockPrice[i] + " gold");
        run.append("\n");
     }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      if(weaponStockPrice[UDDirection * -1] == 0)
      {
          Playlist.playEffect("/sounds/Error.wav");
        run.append("  ~Unable to Purchase~");
        run.append("\n<----- Back");
      }
      else
      {
        Playlist.playEffect("/sounds/ItemGet.wav");
       run.append("   Purchased: " + weaponStock[(UDDirection *-1)]);
      run.append("\n<----- Back");
        weaponStock[(UDDirection *-1)] = "[Out of Stock]";
        weaponStockPrice[(UDDirection *-1)] = 0;
     }
      UDDirection = 0;
    }
    else if((Player.gold < weaponStockPrice[(UDDirection * -1)]) && (selection == true && quit == false))
    {
        run.output.setText("");
        for(int i = 0;i<weaponStock.length;i++)
     {
        run.append("______________________________________________________________________________________________\n");
        if(i == 0)
        {
        run.append(weaponStock[0] + ": " + weaponStockPrice[0] + " gold <");
       }
        if(i>0)
          run.append(weaponStock[i] + ": " + weaponStockPrice[i] + " gold");
        run.append("\n");
     }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
       Playlist.playEffect("/sounds/Error.wav");
        run.append("  ~Unable to Purchase~");
      run.append("\n<----- Back");
      UDDirection = 0;
    }
    
   }
   if(quit != true && direction == 1)
    printShop();
 }
    
 
    
 public static void buyItem(int n) throws InterruptedException
 {
	 
      if(weaponStock[n].equals("Iron Dagger [dmg:10][crit:5]"))
            Weapon.IronDagger.setWeapon();
        if(weaponStock[n].equals("Party Blaster [dmg:29][crit:15][Stun]"))
            Weapon.PartyBlaster.setWeapon();
        if(weaponStock[n].equals("Long Bow [dmg:16][crit:50]"))
            Weapon.LongBow.setWeapon();
        if(weaponStock[n].equals("Reinforced Long Bow [dmg:22][crit:53]"))
            Weapon.LongBowPlus.setWeapon();
        if(weaponStock[n].equals("Ancient Rifle [dmg:30][crit:60]"))
            Weapon.AncientRifle.setWeapon();
        if(weaponStock[n].equals("Studded Leather [def:25]"))
            Armor.Studded.setArmor();
        if(weaponStock[n].equals("Chain Mail [def:28]"))
            Armor.ChainMail.setArmor();
        if(weaponStock[n].equals("Paper Armor [def:5]"))
            Armor.Paper.setArmor();
        if(weaponStock[n].equals("Clown Suit [def:30]"))
            Armor.ClownSuit.setArmor();
        if(weaponStock[n].equals("Eruption Scroll"))
            Ability.Actives.Eruption.equip();
        if(weaponStock[n].equals("Blessing Scroll"))
            Ability.Actives.Blessing.equip();
        if(weaponStock[n].equals("Poison Scroll"))
            Ability.Actives.Poison.equip();
        if(weaponStock[n].equals("Stun+ Scroll"))
            Ability.Actives.StunPlus.equip();
        if(weaponStock[n].equals("Explosion Scroll"))
            Ability.Actives.Explosion.equip();
        if(weaponStock[n].equals("Regenerate Scroll"))
            Ability.Actives.Regenerate.equip();  
        if(weaponStock[n].equals("Triple Threat Scroll"))
            Ability.Actives.TripleThreat.equip();
        if(weaponStock[n].equals("Stun+ Scroll"))
            Ability.Actives.StunPlus.equip();
        if(weaponStock[n].equals("Iron Plated[def:33]"))
            Armor.Iron.setArmor();
        if(weaponStock[n].equals("Steel Dagger [dmg:14][crit:8]"))
            Weapon.SteelDagger.setWeapon();
        if(weaponStock[n].equals("The Executioner [dmg:37][crit:15][Opress]"))
            Weapon.Executioner.setWeapon();
        if(weaponStock[n].equals("Glass Dagger [dmg:17][crit:85]"))
            Weapon.GlassDagger.setWeapon();
        if(weaponStock[n].equals("Winter's Bane [dmg:41][crit:10][Ice Wind]"))
            Weapon.WinterBane.setWeapon();
        if(weaponStock[n].equals("Superior Rifle [dmg:45][crit:45][Snipe]"))
            Weapon.SuperRifle.setWeapon();
        if(weaponStock[n].equals("Fire Hydrant [dmg:55][crit:0][???]"))
            Weapon.FireHydrant.setWeapon();
        if(weaponStock[n].equals("Wooden Armor [def:22]"))
            Armor.Wood.setArmor();
        if(weaponStock[n].equals("Armor of the Master [def:40]"))
            Armor.Master.setArmor();
        if(weaponStock[n].equals("Steel Coat[def:38]"))
            Armor.Steel.setArmor();
        if(weaponStock[n].equals("Mining Helmet [def:35]"))
            Armor.MiningHelmet.setArmor();
        if(weaponStock[n].equals("Uber Cure"))
            Ability.Actives.UberCure.equip();
        if(weaponStock[n].equals("Icicle Shower"))
        	Ability.Actives.IceShower.equip();
        if(weaponStock[n].equals("Invincibility"))
        	Ability.Actives.Invincibility.equip();


       selection = false;
       run.output.setText("");
 }
    
    

    
    
    
    
    
    
    
    public static void printShop() throws InterruptedException
    {
        buying = true;
        run.output.setText("");
        direction = 0;
        UDDirection = 5;
        String[] itemList = {"Potion","Hi-Potion","Mega-Potion","Power Potion","Ultramarine"};
        int[] itemPrice = {110,300,500,320,410};
      
        selection = false;
        quit = false;
    while(quit == false  && direction != 1)
    {
      while(selection == false && quit == false && direction != 1)
      {
    	  System.out.println("KeyHandler Looping");
      if(UDDirection == 5)
      {
          run.output.setText("");
        for(int i = 0;i<itemList.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i == 0)
        {
        run.append(itemList[0] + ": " + itemPrice[0] + " gold <");
       }
        if(i>0)
          run.append(itemList[i] + ": " + itemPrice[i] + " gold");
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\nBack <-----> Next Page");
      UDDirection = 0;
     }
     if(UDDirection == 4)
      {
          run.output.setText("");
        for(int i = 0;i<itemList.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i==0)
        {
         run.append(itemList[0] + ": " + itemPrice[0] + " gold");
        }
        if(i==1)
        {
         run.append(itemList[1] + ": " + itemPrice[1] + " gold <");
        }
        if(i > 1)
        run.append(itemList[i] + ": " + itemPrice[i] + " gold");
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\nBack <-----> Next Page");
      UDDirection = -1;
     }
     if(UDDirection == 3)
      {
          run.output.setText("");
        for(int i = 0;i<itemList.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i==0)
        {
         run.append(itemList[0] + ": " + itemPrice[0] + " gold");
        }
        if(i==1)
        {
         run.append(itemList[1] + ": " + itemPrice[1] + " gold");
        }
        if(i > 2)
        run.append(itemList[i] + ": " + itemPrice[i] + " gold");
        if(i == 2)
        {
            run.append(itemList[2] + ": " + itemPrice[2] + " gold <");
        }
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\nBack <-----> Next Page");
      UDDirection = -2;
     }
     if(UDDirection == 2)
      {
          run.output.setText("");
        for(int i = 0;i<itemList.length;i++)
        {
        run.append("______________________________________________________________________________________________\n");
        if(i==0)
        {
         run.append(itemList[0] + ": " + itemPrice[0] + " gold");
        }
        if(i==1)
        {
         run.append(itemList[1] + ": " + itemPrice[1] + " gold");
        }
        if(i > 3)
        run.append(itemList[i] + ": " + itemPrice[i] + " gold");
        if(i == 2)
        {
            run.append(itemList[2] + ": " + itemPrice[2] + " gold");
        }
        if(i == 3)
         run.append(itemList[3] + ": " + itemPrice[3] + " gold <");
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\nBack <-----> Next Page");
      UDDirection = -3;
     }
     if(UDDirection == 1)
      {
          run.output.setText("");
        for(int i = 0;i<itemList.length;i++)
        {
        run.append("_______________________________________________________________________________________________\n");
        if(i==0)
        {
         run.append(itemList[0] + ": " + itemPrice[0] + " gold");
        }
        if(i==1)
        {
         run.append(itemList[1] + ": " + itemPrice[1] + " gold");
        }
        if(i > 4)
        run.append(itemList[i] + ": " + itemPrice[i] + " gold");
        if(i == 2)
        {
            run.append(itemList[2] + ": " + itemPrice[2] + " gold");
            
        }
        if(i == 3)
         run.append(itemList[3] + ": " + itemPrice[3] + " gold");
         if(i==4)
          run.append(itemList[4] + ": " + itemPrice[4] + " gold <");
        run.append("\n");
       }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
      run.append("\nBack <-----> Next Page");
      UDDirection = -4;
     }
     if(direction == 2)
     {
         printShopTwo();
      }
    }
    if(Player.gold >= itemPrice[(UDDirection * -1)] && selection == true && quit == false)
    {
     Player.gold = Player.gold - itemPrice[(UDDirection * -1)];
          run.output.setText("");
          
     switch(UDDirection)
     {
       case 0:
        Item.Potion.newItem();
        break;
       case -1:
        Item.HighPotion.newItem();
        break;
       case -2:
        Item.MegaPotion.newItem();
        break;
       case -3:
        Item.PowerPotion.newItem();
        break;
       case -4:
        Item.Ultramarine.newItem();
        break;
     }
          
          
          for(int i = 0;i<itemList.length;i++)
     {
        run.append("______________________________________________________________________________________________\n");
        if(i == 0)
        {
        run.append(itemList[0] + ": " + itemPrice[0] + " gold <");
       }
        if(i>0)
          run.append(itemList[i] + ": " + itemPrice[i] + " gold");
        run.append("\n");
     }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
        
       run.append("   Purchased: " + itemList[(UDDirection *-1)]);
      run.append("\nBack <-----> Next Page");
      Playlist.playEffect("/sounds/ItemGet.wav");
      UDDirection = 0;
    }
    else if(Player.gold < itemPrice[(UDDirection * -1)] && selection == true && quit == false)
    {
        run.output.setText("");
        for(int i = 0;i<itemList.length;i++)
     {
        run.append("______________________________________________________________________________________________\n");
        if(i == 0)
        {
        run.append(itemList[0] + ": " + itemPrice[0] + " gold <");
       }
        if(i>0)
          run.append(itemList[i] + ": " + itemPrice[i] + " gold");
        run.append("\n");
     }
       run.append("______________________________________________________________________________________________\n");
       run.append("\nYour gold: " + Player.gold);
        Playlist.playEffect("/sounds/Error.wav");
        run.append("  ~Unable to Purchase~");
      run.append("\nBack <-----> Next Page");
      UDDirection = 0;
    }
    selection = false;
   }
  }
    
    
    public static void checkUDDirection(int d)
    {
        if(UDDirection < -4)
        UDDirection = 5;
        if(UDDirection > 5)
        UDDirection = 1;
        else if(UDDirection <=5 && UDDirection >= -4)
       {
        if(d == 1)
         UDDirection = UDDirection + (d + 5);
        if(d == -1)
         UDDirection = UDDirection + (d + 5);
         if(UDDirection == 0)
         UDDirection = 5;
         if(UDDirection == 6)
         UDDirection = 1;
        }
    }
    public static void checkDirection(int d)
    {
       direction = d;
    }
    public static void checkEnter(boolean s)
    {
       selection = s;
    }
    public static void checkQuit(boolean s)
    {
       quit = s;
    }
    public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void userWait() throws InterruptedException
    {
        run.append("\n'Press Enter to Continue'\n");
        while(selection = false)
        {
        }
    }
}
