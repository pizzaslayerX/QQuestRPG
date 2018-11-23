package Main;
import java.awt.Color;

import Monsters.*;
import Run.*;
public class Dungeon
{
    public static RPGRunner run;
    public static int direction = 0;
    public static int UDDirection;
    public static boolean headBack;
    public static boolean twoChoiceH = false;
    public static boolean select;
    public static boolean fee = false;
    public static int carnivalFloor = 0;
    public static boolean jokerDeal;
    public static boolean quit;
    public static boolean mainMenu;
    
    public static boolean carnivalChoice;
 public Dungeon(RPGRunner r)
 {
    this.run = r;
 }
 public static void carnival() throws Exception
 {
     int songChoice = (int)(Math.random() * 100);
        if(songChoice < 100)
          Playlist.playSong("/sounds/Carnival.wav");
        else
        {
          Playlist.playSong("/sounds/Carnival2.wav");
        }
       run.output.setText("");
       boolean exit = false;
  while(exit == false && Player.alive == true)
  {     boolean proceed = false;
      while(proceed == false && Player.alive == true)
      {
          mainMenu = false;
          run.output.setText("");
       direction = 1;
           run.fontSize(30);
                          run.output.setText("Location: El Carnival");
           run.append("\n\n\n                   =============   =============  \n");
           run.append(      "                    > Explore        Head Back   \n");
           run.append(      "                   =============   =============  \n");
           run.append("");
           twoChoiceH = true;
           select = false;
           while(select == false)
       {
        	   System.out.println("KeyHandler Looping");
           if(direction == 1)
           {
               run.output.setText("Location: El Carnival");
            run.append("\n\n\n                   =============   =============  \n");
            run.append(      "                    > Explore        Head Back   \n");
            run.append(      "                   =============   =============  \n");
               direction = -2;
            }
           if(direction == 2)
           {
                           run.output.setText("Location: El Carnival");
            run.append("\n\n\n                   =============   =============  \n");
            run.append(      "                      Explore      > Head Back   \n");
            run.append(      "                   =============   =============  \n");
               direction = -1;
            }
        }
       if(direction == -1)
       {
           run.output.setText("");
           direction = 0;
           twoChoiceH = false;
           boolean leave = Story.lockedDoor("Carnival Key",1,false);
           if(leave == true)
           {
               run.output.setText("");
               proceed = true;
               exit = true;
               Story.firstTime = false;
            }
       }
       else
       {
           proceed = true;
           twoChoiceH = false;
       }
    }
     boolean finish = false;
     quit = false;
     if(exit == false)
     {
        run.output.setText("");
           Story.textEffect("You arrive at a clearing");
        run.pause(2000);
    }
       while(finish == false && Player.alive == true && quit == false && exit == false)
       {
            
           mainMenu = true;
           headBack = false;
           carnivalChoice = true;
           direction = 1;
           run.output.setText("");
           run.fontSize(30);
           run.append("\n\n                         Choose where to go");
           run.append("\n\n\n           ==========        ==========        ==========\n");
           run.append("           > Gamble           Explore!         Large Tent\n");
           run.append("           ==========        ==========        ==========\n");
           run.append("\n\n\n\n\n\n                                                      [SHIFT] to quit");
           
       while(select == false)
        {
    	   System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                           run.output.setText("");
                           run.append("\n\n                         Choose where to go");
                           run.append("\n\n\n           ==========        ==========        ==========\n");
                           run.append("           > Gamble           Explore!         Large Tent\n");
                           run.append("           ==========        ==========        ==========\n");
                           run.append("\n\n\n\n\n\n                                                      [SHIFT] to quit");
                           direction = -3;
            }
            else if(direction == 2)
            {
                           run.output.setText("");
                           run.append("\n\n                         Choose where to go");
                           run.append("\n\n\n           ==========        ==========        ==========\n");
                           run.append("             Gamble         > Explore!         Large Tent\n");
                           run.append("           ==========        ==========        ==========\n");
                           run.append("\n\n\n\n\n\n                                                      [SHIFT] to quit");
                           direction = -2;
            }
            else if(direction == 3)
            {
                            run.output.setText("");
                           run.append("\n\n                         Choose where to go");
                           run.append("\n\n\n           ==========        ==========        ==========\n");
                           run.append("             Gamble           Explore!       > Large Tent\n");
                           run.append("           ==========        ==========        ==========\n");
                           run.append("\n\n\n\n\n\n                                                      [SHIFT] to quit");
                           direction = -1;
            }
        }
        carnivalChoice = false;
        select = false;
     if(quit == false)
    {
       if(direction == -3)
       {
           mainMenu = false;
          gamble();
        }
       else if(direction == -2)
       {
           mainMenu = false;
           run.output.setText("You begin exploring the surrounding tents...");
           run.pause(2500);
           run.output.setText("");
          
               run.fontSize(20);
               int times = (int)(Math.random() * 3) + 1;
               for(int i = 0;i < times;i++)
               {
                   if(Player.alive == true)
                   {
                       if(Player.level <= 12)
                       {
                           int foe = (int)(Math.random() * 3) + 1;
                           if(foe == 1)
                           {
                               Story.deathMsg = "Clowns are scary.\n";
                               MonsterManager.spawn(new BasicClown());
                               run.clownFight(0,0,0,2,0,0,1,3);
                               if(Player.alive == true && RPGRunner.flee == false)
                                 MonsterManager.winLoot();
                               RPGRunner.flee = false;
                  }
                            if(foe == 2)
                            {
                                Story.deathMsg = "Killer Clowns are mean. Put em' down fast before it's stats boost.\n";
                                MonsterManager.spawn(new KillerClown());
                                run.clownFight(3,6,1,2,0,0,1,5);
                                if(Player.alive == true && RPGRunner.flee == false)
                                	MonsterManager.winLoot();
                                RPGRunner.flee = false;
                  }
                            if(foe == 3)
                            {
                                Story.deathMsg = "Yea.. They explode.\n";
                                MonsterManager.spawn(new DireClown());
                                run.clownFight(4,5,3,0,12,20,2,3);
                                if(Player.alive == true && RPGRunner.flee == false)
                                	MonsterManager.winLoot();
                                RPGRunner.flee = false;
                  }  
             }
             else if(Player.level > 12)
             {
                  int foe = (int)(Math.random() * 3) + 1;
                           if(foe == 1)
                           {
                               Story.deathMsg = "Killer Clowns are mean. Put em' down fast before it's stats boost.\n";
                               MonsterManager.spawn(new KillerClown());
                                run.clownFight(4,7,2,2,0,0,1,5);
                                if(Player.alive == true && RPGRunner.flee == false)
                                 MonsterManager.winLoot();
                                RPGRunner.flee = false;
                            }
                            if(foe == 2)
                           {
                               Story.deathMsg = "The Chummy's only purpose is to explode...\n";
                               MonsterManager.spawn(new Chummy());
                                run.clownFight(0,0,0,0,30,85,0,0);
                                if(Player.alive == true && RPGRunner.flee == false)
                                	MonsterManager.winLoot();
                                RPGRunner.flee = false;
                            }
                             if(foe == 3)
                            {
                                 Story.deathMsg = "Clowns are scary.\n";
                                 MonsterManager.spawn(new BasicClown());
                               run.clownFight(0,0,0,3,0,0,1,3);
                               if(Player.alive == true && RPGRunner.flee == false)
                            	   MonsterManager.winLoot();
                               RPGRunner.flee = false;
                  }
                }
            }
               
           }
           if(Player.alive == true)
           {
              Chest.ranChestOpen(2,75);
                   run.output.setText("");
                   run.fontSize(20);
                   Story.saveAsk();
                   run.output.setText("");
                   run.fontSize(30);
                }
       }
       else if(direction == -1)
       {
           mainMenu = false;
           run.output.setText("");
           run.fontSize(20);
           Story.textEffect("You walk up to the entrance of the large tent...");   
           Story.userWait();
           run.output.setText("");
           if(carnivalFloor == 0)
          {
        	   Player.part = 13;
           run.append("Joker:",Color.YELLOW,20,true);
           run.pause(500);
           Story.textEffect(" Hey you!\n\n");
           run.pause(800);
           run.append("You:",Color.GREEN,20,true);
           run.pause(500);
           Story.textEffect(" ?\n\n");
           run.pause(500);
           run.append("Joker:",Color.YELLOW,20,true);
           run.pause(500);
           Story.textEffect(" Yea you!\n\n");
           Story.userWait();
           run.output.setText("");
           run.append("Joker:",Color.YELLOW,20,true);
           run.pause(500);
           Story.textEffect(" You look like a pretty sketchy fella\n\n");
           run.pause(2000);
           run.append("Joker:",Color.YELLOW,20,true);
           run.pause(500);
           Story.textEffect(" If you can kill my friends and harvest they're balls\n");
           Story.textEffect("       I'll reward you handsomely.\n");
           run.pause(2500);
           Story.userWait();
           run.output.setText("");
           carnivalFloor++;
         }
         if(carnivalFloor > 0)
         {
             fee = false;
             carnivalChoice = true;
           direction = 1;
           run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("  ================       ====================       ================\n");
           run.append("> Speak with Joker       Enter Tent(100 gold)       Turn Back Around  \n");
           run.append("  ================       ====================       ================\n");
        
           while(select == false)
         {
        	   System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("  ================       ====================       ================\n");
           run.append("> Speak with Joker       Enter Tent(100 gold)       Turn Back Around  \n");
           run.append("  ================       ====================       ================\n");
                           direction = -3;
            }
            else if(direction == 2)
            {
                     
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("  ================       ====================       ================\n");
           run.append("  Speak with Joker     > Enter Tent(100 gold)       Turn Back Around  \n");
           run.append("  ================       ====================       ================\n");
                           direction = -2;
            }
            else if(direction == 3)
            {
                     run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("  ================       ====================       ================\n");
           run.append("  Speak with Joker       Enter Tent(100 gold)     > Turn Back Around  \n");
           run.append("  ================       ====================       ================\n");
                           direction = -1;
            }
         }
         carnivalChoice = false;
         select = false;
         if(direction == -3 && jokerDeal == false)
         {
             boolean over = false;
            while(over == false)
            {
              run.fontSize(30);
            run.output.setText("                                                     Open Backpack [b]\n\n");
            run.append("                   Joker: Do you have the balls!?\n");
            run.append("=============================Requirements=============================\n");
            run.append("-Red Ball x10\n");
            run.append("-Blue Ball x10\n");
            run.append("-Green Ball x5\n");
            run.append("-Purple Ball x1\n");
            run.append("======================================================================\n");
            run.append("\n\n\n\nYes[y] or No[n]");
            run.getReset();
            String ball = run.getString();
            if(ball.equals("y") && BackPack.Manager.checkItem("Red Ball",10) == true &&   BackPack.Manager.checkItem("Blue Ball",10) == true
                && BackPack.Manager.checkItem("Green Ball",5) == true && BackPack.Manager.checkItem("Purple Ball",1) == true)
            {
                run.output.setText("");
                run.fontSize(20);
                BackPack.Manager.remove("Red Ball",10);
                BackPack.Manager.remove("Blue Ball",10);
                BackPack.Manager.remove("Green Ball",5);
                BackPack.Manager.remove("Purple Ball",1);
                Playlist.playEffect("/sounds/JokerLaugh.wav");
                run.append("Joker:",Color.YELLOW,20,true);
                Story.textEffect(" Wow! I feel so... JUICY!!!\n\n");
                Story.pause(2000);
                run.getReset();
                run.append("Joker:",Color.YELLOW,20,true);
                Story.pause(200);
                Story.textEffect(" Here here, take this! I have no need for trinkets anymore\n\n");
                run.pause(3000);
                run.getReset();
                run.append("You earned: Elixer x1\n");
                run.append("Press [e] to equip: Rainbow Particle Launcher [dmg:44][crit:18]\n");
                ball = run.getString();
                if(ball.equals("e"))
                    Weapon.RainbowBall.setWeapon();
                run.append("\n\n");
                Story.userWait();
                run.output.setText("");
                jokerDeal = true;
                over = true;
            }
            else if(ball.equals("y") && !(BackPack.Manager.checkItem("Red Ball",10) == true &&   BackPack.Manager.checkItem("Blue Ball",10) == true
                && BackPack.Manager.checkItem("Green Ball",5) == true && BackPack.Manager.checkItem("Purple Ball",1) == true))
                {
            run.output.setText("                                                     Open Backpack [b]\n\n");
            run.append("                   Joker: Do you have the balls!?\n");
            run.append("=============================Requirements=============================\n");
            run.append("-Red Ball x10\n");
            run.append("-Blue Ball x10\n");
            run.append("-Green Ball x5\n");
            run.append("-Purple Ball x1\n");
            run.append("======================================================================\n");
            run.append("\n\n\n\nYou don't have what I want!");
            run.pause(2500);
                }
             else if(ball.equals("b"))
                BackPack.Manager.open();
            else
            {
                run.output.setText("");
                run.pause(500);
                run.append("Joker:",Color.YELLOW,20,true);
                run.pause(200);
                Story.textEffect(" *quack* make yourself useful next time\n\n");
                run.pause(2500);
                over = true;
                run.output.setText("");
            }
           }
         }
         else if(direction == -3 && jokerDeal == true)
         {
             run.output.setText("");
             run.fontSize(20);
             Story.textEffect("*The mad joker just smiles at you*");
             run.pause(2800);
             run.output.setText("");
            }
         else if(direction == -2)
         {
             run.fontSize(20);
            if(Player.gold < 100)
            {
                run.output.setText("");
                run.append("Joker:",Color.YELLOW,20,true);
                run.pause(300);
                Story.textEffect(" You can't afford admission!\n\n");
                run.pause(2000);
                run.append("Joker:",Color.YELLOW,20,true);
                run.pause(300);
                Story.textEffect(" *quack* make yourself useful next time");
                run.pause(2500);
                run.output.setText("");
            }
            if(Player.gold >= 100)
            {
                Player.gold = Player.gold - 100;
                fee = true;
            }
             if(carnivalFloor == 1 && fee == true)
            {
            	 Player.part = 14;
                Player.gold = Player.gold - 100;
                run.output.setText("");
                run.append("Joker:",Color.YELLOW,20,true);
                run.pause(300);
                Story.textEffect(" Good luck in there!\n");
                run.pause(2000);
                run.append("Joker:",Color.YELLOW,20,true);
                run.pause(300);
                Story.textEffect(" I hear there are those that have long since abandoned god...\n");
                run.pause(2500);
                run.append("Joker:",Color.YELLOW,20,true);
                run.pause(300);
                Story.textEffect(" AHAHAHAHAHAHAHAHAHAHAHAHAHAHA\n");
                run.pause(1000);
                Story.textEffect("       AHAHAHAHHAHAHAHAHAHAHAHAHHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHHAHHAHAHAHAHAHAHAHAHAHAHAHAH\n\n");
                run.pause(3500);
                run.output.setText("*You decide to leave Joker to his laughing*");
                Story.userWait();
                run.output.setText("");
                Story.textEffect("*You go inside the tent and get lost*\n");
                 Story.userWait();
                run.output.setText("");
                Story.textEffect("It's dimly lit in here\n");
                run.pause(2000);
                Story.textEffect("Judging from the blood and rats\n");
                run.pause(1000);
                Story.textEffect("you can infer that this place didn't pass inspection...");
                run.pause(2000);
                Story.userWait();
                run.output.setText("");
                run.append("Raspy voice:",Color.RED,20,true);
                run.pause(300);
                Story.textEffect(" Heh? You aren't suppose to be in here...\n");
                run.pause(3000);
                run.append("Raspy voice:",Color.RED,20,true);
                run.pause(300);
                Story.textEffect(" REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE!!!");
                Story.userWait();
                run.output.setText("");
                run.fontSize(30);
                Story.textEffect("\n\n\n\n\n                  INFO: Defeat all of the enemies!");
                 run.pause(2500);
                run.output.setText("");
                run.fontSize(20);
                MonsterManager.spawn(new BalloonImp());
                run.clownFight(0,0,0,3,0,0,0,2);
                if(Player.alive == true)
                {
                    MonsterManager.winLoot();
                    MonsterManager.spawn(new BalloonImp());
                    run.clownFight(0,0,0,3,0,0,0,2);
                    if(Player.alive == true)
                {
                    MonsterManager.winLoot();
                    MonsterManager.spawn(new BasicClown());
                    run.clownFight(0,0,1,2,0,0,1,3);
                    if(Player.alive == true)
                 {
                    MonsterManager.winLoot();
                    carnivalFloor++;
                    Story.saveAsk();
                    run.output.setText("");
                 }
                }
              }
            }
            if(carnivalFloor == 2 && fee == true)
            {
            	Player.part = 15;
                run.output.setText("");
                Story.textEffect("*You cut the last imp in half*\n");
                run.pause(2000);
                Story.textEffect("You found a map from its disheveled body\n");
                run.pause(2000);
                run.append("You recieved: Carnival Map x1\n\n");
                run.pause(1500);
                BackPack.Manager.add("Carnival Map",1);
                run.append("     Open Map[m]");
                run.getReset();
                String wait = run.getString();
                if(wait.equals("m"))
                    openMap(carnivalFloor);
                run.output.setText("");
                carnivalFloor++;
            }
            if(carnivalFloor == 3 && fee == true && Player.alive == true)
            {
                boolean complete = false;
                while(complete == false)
              {
                
                carnivalChoice = true;
           direction = 1;
           run.output.setText("\n\n\n\n");                                    
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Continue             Head Back              Open Map  \n");
           run.append("     ==============       ===============       ===============\n");
        
           while(select == false)
         {
        	   System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Continue             Head Back              Open Map  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -3;
            }
            else if(direction == 2)
            {
                     
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Continue           > Head Back              Open Map  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -2;
            }
            else if(direction == 3)
            {
                     run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Continue             Head Back            > Open Map  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -1;
            }
         }
         carnivalChoice = false;
         select = false;
             if(direction == -1)
                openMap(carnivalFloor);
                if(direction == -2)
                 complete = true;
             if(direction == -3)
                {
            	 Player.part = 16;
                    complete = true;
                    run.output.setText("");
                    run.fontSize(20);
                    Story.textEffect("You continue down a hallway...\n\n");
                    Story.userWait();
                    run.output.setText("");
                    run.append("Killer Clown:",Color.RED,20,true);
                    run.pause(300);
                    Story.textEffect(" HEHEHEHEHEHEH I'll have all of YOUR BUTTS!!!");
                    run.pause(3000);
                    run.output.setText("");
                    MonsterManager.spawn(new KillerClown());
                    run.clownFight(3,9,1,0,0,0,1,5);
                if(Player.alive == true)
                {
                    MonsterManager.winLoot();
                    MonsterManager.spawn(new BalloonImp());
                    run.clownFight(0,0,0,3,0,0,0,2);
                    if(Player.alive == true)
                {
                    MonsterManager.winLoot();
                    carnivalFloor = 4;
                    Story.saveAsk();
                    run.output.setText("");
                    complete = true;
                 }
                }
              }
            }
            }
             if(carnivalFloor == 4 && fee == true)
            {
            	 Player.part = 17;
                
                run.output.setText("");
                Story.textEffect("*You continue down the path*\n");
                run.pause(2000);
                Story.textEffect("*You turn to your left and head to a room labeled: \"Dressing Room\"*");
                Story.userWait();
                run.output.setText("");
                run.append("Simon the Trader: ",Color.ORANGE,20,true);
       		 	run.pause(300);
                Story.textEffect(" Hello there!\n\n");
                run.pause(1500);
                run.append("You: ",Color.GREEN,20,true);
       		 	run.pause(300);
                Story.textEffect(" Simon! What are you doing here???\n\n");
                run.pause(2000);
                run.append("Simon the Trader: ",Color.ORANGE,20,true);
       		 	run.pause(300);
                Story.textEffect(" I don't know... What is a carnival doing in the middle of nowhere?\n\n");
                run.pause(3000);
                run.append("Simon the Trader: ",Color.ORANGE,20,true);
       		 	run.pause(300);
                Story.textEffect(" Anyway, are you going to buy something or not?\n\n");
                run.pause(2000);
                Story.userWait();
                run.output.setText("");
                carnivalFloor++;
            }
                
             if(carnivalFloor >= 5 && fee == true)
                 {
                boolean complete = false;
                while(complete == false)
              {
                carnivalChoice = true;
           direction = 1;
           run.output.setText("\n\n\n\n");                                    
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Continue             Head Back               Trade  \n");
           run.append("     ==============       ===============       ===============\n");
        
           while(select == false)
         {
        	   System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Continue             Head Back               Trade  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -3;
            }
            else if(direction == 2)
            {
                     
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Continue           > Head Back               Trade  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -2;
            }
            else if(direction == 3)
            {
                     run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Continue             Head Back             > Trade  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -1;
            }
         }
         carnivalChoice = false;
         select = false;
                if(direction == -1)
                    Shop.openShop();
                else if(direction == -2)
                {
                    complete = true;
                    headBack = true;
                }
                else if(direction == -3)
                {
                    complete = true;
                    if(carnivalFloor == 5)
                        carnivalFloor = 6;
                }
              
            }
           }
           
           if(carnivalFloor == 6 && fee == true && headBack == false)
           {
               run.output.setText("");
                boolean complete = false;
                while(complete == false)
              {
                carnivalChoice = true;
           direction = 1;
           run.output.setText("\n\n\n\n");                                    
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Open Map             Head Back               Fight  \n");
           run.append("     ==============       ===============       ===============\n");
        
           while(select == false)
         {
        	   System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Open Map             Head Back               Fight  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -3;
            }
            else if(direction == 2)
            {
                     
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Open Map           > Head Back               Fight  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -2;
            }
            else if(direction == 3)
            {
                     run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Open Map             Head Back             > Fight  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -1;
            }
         }
         carnivalChoice = false;
         select = false;
            if(direction == -3)
                openMap(carnivalFloor);
            else if(direction == -2)
                complete = true;
            else if(direction == -1)
            {
                complete = true;
                run.output.setText("");
                run.fontSize(20);
                Story.textEffect("*You go and confront the clowns in the hallway*\n\n");
                run.pause(1500);
                 Story.userWait();
                run.output.setText("");
                run.fontSize(30);
                Story.textEffect("\n\n\n\n\n                  INFO: Defeat all of the enemies!");
                 run.pause(2500);
                run.output.setText("");
                run.fontSize(20);
                for(int i=0;i<3;i++)
                {
                    if(Player.alive == true)
                    {
                    	MonsterManager.spawn(new DireClown());
                        run.clownFight(4,7,2,0,15,25,2,4);
                    }
                    if(Player.alive == true)
                    {
                        MonsterManager.winLoot();
                    }
                }
                if(Player.alive == true)
                {
                    run.output.setText("");
                    Story.textEffect("That seems to be the last of them.\n");
                    run.pause(2000);
                    Story.textEffect("*You notice a note on the ground*\n\n");
                    run.pause(2000);
                    run.getReset();
                    run.append("    Read note[n]");
                    String answer = run.getString();
                    if(answer.equals("n"))
                    {
                        run.output.setText("");
                        run.append(" ___________________________________________________\n");
                        run.append("|                                                   |\n");
                        run.append("|     Help... It may already be too late.           |\n");
                        run.append("|     They came so fast what were we suppose to do. |\n");
                        run.append("|     It hurts... so much. It hurts...              |\n");
                        run.append("|     He poisoned our minds we can't go on          |\n");  
                        run.append("|     It hurts. It hurts......                      |\n"); 
                        run.append("|___________________________________________________|\n\n\n");
                        Story.userWait();
                        run.output.setText("");
                     }
                     carnivalFloor++;
                     Player.part = 18;
                    Story.saveAsk();
                    complete = true;
                    
                }
                
            }
           }
         }
         if(carnivalFloor == 7 && fee == true && headBack == false)
         {
              run.output.setText("");
                boolean complete = false;
                while(complete == false)
              {
                carnivalChoice = true;
           direction = 1;
           run.output.setText("\n\n\n\n");                                    
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Open Map             Head Back               Fight  \n");
           run.append("     ==============       ===============       ===============\n");
        
           while(select == false)
         {
        	   System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Open Map               Left                  Right  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -3;
            }
            else if(direction == 2)
            {
                              run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Open Map             > Left                  Right  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -2;
            }
            else if(direction == 3)
            {
                                      run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Open Map               Left                > Right  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -1;
            }
         }
         carnivalChoice = false;
         select = false;
             if(direction == -3)
                openMap(carnivalFloor);
             else if(direction == -2)
             {
                complete = true;
                 run.output.setText("");
                 run.fontSize(20);
                 run.append("*You decide to head to the left*\n\n");
                 Story.userWait();
                 run.output.setText("");
                 run.append("Unknown Voice:",Color.RED,20,true);
        		 	run.pause(300);
                 Story.textEffect(" Tweetle-Dee Doo... Doo Doo Doo.\n\n");
                 run.pause(2000);
                 run.append("Unknown Voice:",Color.RED,20,true);
     		 		run.pause(300);
                 Story.textEffect(" hehehehehe\n\n");
                 run.pause(2000);
                 Story.textEffect("*You get closer. You see a massive clown*\n\n");
                 run.pause(2000);
                 Story.userWait();
                 run.output.setText("");
                 run.append("BIG CLOWN:",Color.RED,20,true);
     		 		run.pause(300);
                 Story.textEffect(" Heh whose there?\n\n");
                 run.pause(2000);
                 run.append("BIG CLOWN:",Color.RED,20,true);
     		 	run.pause(300);
                 Story.textEffect(" ARGHHHH! We don't want anyone!\n\n");
                 run.pause(3000);
                 run.append("BIG CLOWN:",Color.RED,20,true);
     		 	run.pause(300);
                 Story.textEffect(" REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE\n\n");
                 run.pause(1000);
                 Story.userWait();
                  run.output.setText("");
                run.fontSize(30);
                Story.textEffect("\n\n\n\n\n                    INFO: Defeat the huge clown!");
                 run.pause(2500);
                run.output.setText("");
                run.fontSize(20);
                MonsterManager.spawn(new BigTim());
                run.clownFight(0,0,2,1,0,0,1,3);
                if(Player.alive == true)
                {
                   run.output.setText("");
                   run.append("BIG TIM:",Color.RED,20,true);
       		 	run.pause(300);
                   Story.textEffect(" WEEEEEEEEEEE. WOE IS ME!!!!!!!!!!\n\n");
                   run.pause(2500);
                   Story.textEffect("*The oversized clown collapsed into a pile of sadness*\n\n");
                   run.pause(1000);
                   Story.userWait();
                   run.output.setText("");
                   MonsterManager.winLoot();
                   carnivalFloor++;
                   Story.saveAsk();
                   run.output.setText("");
                }
                }
             else if(direction == -1)
             {
                 complete = true;
                 run.output.setText("");
                 run.fontSize(20);
                 run.append("*You decide to head to the right*\n\n");
                 Story.userWait();
                 run.output.setText("");
                 run.append("Unknown Voice 1:",Color.RED,20,true);
     		 		run.pause(300);
                 Story.textEffect(" Hehehe babies...\n\n");
                 run.pause(2000);
                 run.append("Unknown Voice 2:",Color.MAGENTA,20,true);
  		 		run.pause(300);
                 Story.textEffect(" Shut up. ARGHHHG!\n\n");
                 run.pause(2000);
                 run.append("Unknown Voice 1:",Color.RED,20,true);
  		 			run.pause(300);
                 Story.textEffect(" Timmy no like that?\n\n");
                 run.pause(2000);
                 run.append("Unknown Voice 2:",Color.MAGENTA,20,true);
   		 		run.pause(300);
                 Story.textEffect(" Yes, yes, I agree. Timmy hates it.\n\n");
                 run.pause(2000);
                 Story.textEffect("*You start coming closer*\n\n");
                 Story.userWait();
                 run.output.setText("");
                 run.append("little clown:",Color.MAGENTA,20,true);
   		 		run.pause(300);
                 Story.textEffect(" Heh?! Master won't like this...\n\n");
                 run.pause(2000);
                 run.append("little clown:",Color.MAGENTA,20,true);
    		 		run.pause(300);
                 Story.textEffect(" What do you say we share this, this, PAIN!\n\n");
                 run.pause(2000);
                 run.append("BIG CLOWN:",Color.RED,20,true);
  		 		run.pause(300);
                 Story.textEffect(" Hehehe I agree. REEEEEEEEEEEEEEEEEEEEEE!!!!!!!!!!!\n\n");
                 run.pause(2000);
                 Story.userWait();
                 run.output.setText("");
                 run.fontSize(30);
                Story.textEffect("\n\n\n\n\n                  INFO: Defeat the ugly clown duo!");
                 run.pause(2500);
                run.output.setText("");
                run.fontSize(20);
                Story.deathMsg = "Tiny Tim explodes at 20 HP.";
                MonsterManager.spawn(new TinyTim());
                run.clownFight(5,5,0,2,35,70,0,4);
                if(Player.alive == true)
                {
                    Story.deathMsg = "Burst Big Tim down fast. Otherwise, bring plenty of healing items.";
                   MonsterManager.winLoot();
                     run.output.setText("");
                   Story.textEffect("Big Tim: REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE\nEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE\n");
                   run.pause(2000);
                   Story.userWait();
                   run.output.setText("");
                   run.pause(100);
                   MonsterManager.spawn(new BigTim());
                   run.pause(100);
                 run.clownFight(0,0,2,2,0,0,1,3);
                 if(Player.alive == true)
                 {
                   run.output.setText("");
                   run.append("BIG TIM:",Color.RED,20,true);
      		 		run.pause(300);
                   Story.textEffect(" REEEEEEEEEEE.! We are one! WHY!? REEEEE\n\n");
                   run.pause(2500);
                   Story.textEffect("*The oversized clown collapsed into a pile of sadness*\n\n");
                   run.pause(1000);
                   MonsterManager.winLoot();
                   Chest.open(3);
                   Story.userWait();
                   run.output.setText("");
                   Item.Elixer.newItem();
                   carnivalFloor++;
                   Story.saveAsk();
                   run.output.setText("");
                 }
                }
                }
          }
             
          }
          if(carnivalFloor == 8 && fee == true && headBack == false)
         {
             run.fontSize(20);
             run.output.setText("");
             Story.textEffect("*You enter the main hall...*\n");
             Story.userWait();
             run.output.setText("");
             Story.textEffect("The main hall looks like a typical circus stadium.\n");
             run.pause(2000);
             Story.textEffect("It has the eerily decorated walls and a circular pit surrounded by rows of seats.\n\n");
             run.pause(3000);
             Story.textEffect("*You see a tall and elegant figure in the middle laying on the ground*\n\n");
             Story.userWait();
             run.output.setText("");
                boolean complete = false;
                while(complete == false)
              {
                carnivalChoice = true;
           direction = 1;
           run.output.setText("\n\n\n\n");                                    
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Open Map             Head Back              Approach  \n");
           run.append("     ==============       ===============       ===============\n");
        
           while(select == false)
         {
        	   System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                             run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("      > Open Map             Head Back              Approach  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -3;
            }
            else if(direction == 2)
            {
                              run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Open Map           > Head Back              Approach  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -2;
            }
            else if(direction == 3)
            {
                                      run.output.setText("\n\n\n\n");
           run.fontSize(30);
           run.append("     ==============       ===============       ===============\n");
           run.append("        Open Map             Head Back            > Approach  \n");
           run.append("     ==============       ===============       ===============\n");
                           direction = -1;
            }
         }
         carnivalChoice = false;
         select = false;
             if(direction == -3)
               openMap(8);
             else if(direction == -2)
                complete = true;
             else if(direction == -1)
             {
                 complete = true;
                 run.output.setText("");
                 run.fontSize(20);
                 Story.textEffect("*You sense that this being is very powerful*\n");
                 run.pause(2000);
                 Story.textEffect("You hesitate... Do you really want to do this?\n\n");
                 run.pause(2000);
                 run.getReset();
                 run.append("   Yes[y] or No[n]");
                 String answer = run.getString();
                 if(!(answer.equals("y")))
                 {
                     run.output.setText("");
                     Story.textEffect("You decide to leave this thing alone for now...");
                     run.pause(2500);
                    }
                 else if(answer.equals("y"))
                {
                	 
                    run.output.setText("");
                    Story.textEffect("*Against your better judgement you approach the being*\n");
                    Playlist.stopSong();
                    Story.userWait();
                    run.output.setText("");
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" Hmmm? What business does a sane person like you have with an Archangel?\n\n");
                    run.pause(2500);
                    run.append("You:",Color.GREEN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" Archangel...?\n\n");
                    run.pause(2000);
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" What do you mean \"Archangel...?\", am I not the reason why you came here?\n\n");
                     run.pause(3000);
                     run.append("You:",Color.GREEN,20,true);
        		 		run.pause(300);
                    Story.textEffect(" I've never heard of you...\n\n");
                    run.pause(2500);
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" How can you be god's latest toy and not know who I am?\n");
                    run.pause(1800);
                    Story.textEffect("           Better yet, does this mean you just came and killed everyone for no reason?\n\n");
                    run.pause(3000);
                    run.append("You:",Color.GREEN,20,true);
    		 		run.pause(300);
                    Story.textEffect(" Not exactly...\n\n");
                    Story.userWait();
                    run.output.setText("");
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" *Smiles in disbelief*\n\n");
                    run.pause(2000);
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" You're sick you know that? Senseless murder really?\n\n");
                    run.pause(3000);
                    Story.textEffect("*You come to the conclusion that if this 'angel' is anything like God, you're in for a long night*\n\n");
                    Story.userWait();
                    run.output.setText("");
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" Well, let's see...\n\n");
                    run.pause(1500);
                    Story.textEffect("*The Archangel pulls out some high-tech device with an apple symbol on it*\n\n");
                    run.pause(2500);
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                        Story.textEffect(" Yep! It says it right here in my job description:\n");
                    run.pause(2500);
                        Story.textEffect("\"Thou shall punish thy who senselessly kill\"\n\n");
                    run.pause(2500);
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" I would say these clowns where killed senselessly even if it was out of self defense.\n\n");
                    Story.userWait();
                    
                    run.output.setText("");
                    run.append("Archangel:",Color.CYAN,20,true);
       		 		run.pause(300);
                    Story.textEffect(" Welp. I guess you know what that means.\n\n");
                    run.pause(2000);
                    if(Run.SetUp.censor == false) {
                    	run.append("You:",Color.GREEN,20,true);
           		 		run.pause(300);
                    	Story.textEffect(" Shit");
                    }
                    else {
                    	run.append("You:",Color.GREEN,20,true);
           		 		run.pause(300);
                    	Story.textEffect(" Crap");
                    }
                    run.pause(2000);
                    run.output.setText("");
                    Story.bossScreen();
                    run.output.setText("");
                    Story.deathMsg = "Archangel Ryan specializes in magic. Silencing him is his weakness.\n";
                    MonsterManager.spawn(new AngelRyan());
                    run.ryanFight();
                    if(Player.alive == true)
                    {
                        MonsterManager.winLoot();
                        BackPack.Manager.remove("Carnival Map",1);
                         songChoice = (int)(Math.random() * 100);
                        if(songChoice < 100)
                          Playlist.playSong("/sounds/Carnival.wav");
                        else
                        {
                            Playlist.playSong("/sounds/Carnival2.wav");
                        }
                        carnivalFloor++;
                        carnivalFloor = 9;
                        Story.saveAsk();
                        
                    }
                }
                }
         }
        }
        if(carnivalFloor == 9 && fee == true && headBack == false)
        {
            run.output.setText("");
            run.fontSize(20);
            Story.textEffect("*You feel that the carnival has nothing left to offer*\n\n");
            Story.userWait();
            run.output.setText("");
        }
        }
        }
    }
   }
  }
}
}

public static void openMap(int f) throws InterruptedException
{
    if(f < 4)
    {
      run.output.setText("");
      run.fontSize(20);
      run.append("       ___________________________________________________  \n"); 
      run.append("    ;,'           _____________                           | \n");
      run.append(" ,;'trance       |     ???     |                          | \n");
      run.append("|    |  |        |   __________|                          | \n");
      run.append("|    |  |        |  |                                     | \n");
      run.append("|    |  |        |  |                                     |\n");
      run.append("|  __|  |__      |  |                                     |  \n");
      run.append("| /    @   \\_____|  |                                     |\n"); 
      run.append("||_______________ * |                                     |  \n");
      run.append("| Entrance Hall  |  |                                     |\n");
      run.append("|                |  |                                     |  \n");
      run.append("|                |==|                                     |\n");
      run.append("|                |??|                                     |\n");
      run.append("|                 ??                       == = Stairs    |\n");
      run.append("|                                           @ = You       |  \n");
      run.append("|         ,-;',  ,                          * = Enemies   |\n");
      run.append("|_______-'     '  ,_______________________________________|  \n\n");
      Story.userWait();
      run.output.setText("");
    }
    if(f == 4)
    {
        run.output.setText("");
        run.fontSize(20);
      run.append("       ___________________________________________________  \n"); 
      run.append("    ;,'           _______________                         | \n");
      run.append(" ,;'trance       | Simons's Shop |                        | \n");
      run.append("|    |  |        |  @____________|                        | \n");
      run.append("|    |  |        |  |                                     | \n");
      run.append("|    |  |        |  |                                     |\n");
      run.append("|  __|  |__      |  |                                     |  \n");
      run.append("| /        \\_____|  |                                     |\n"); 
      run.append("||_______________   |                                     |  \n");
      run.append("| Entrance Hall  |  |                                     |\n");
      run.append("|                |  |                                     |  \n");
      run.append("|                |==|                                     |\n");
      run.append("|                |??|                                     |\n");
      run.append("|                 ??                       == = Stairs    |\n");
      run.append("|                                           @ = You       |  \n");
      run.append("|         ,-;',  ,                          * = Enemies   |\n");
      run.append("|_______-'     '  ,_______________________________________|  \n\n");
      Story.userWait();
      run.output.setText("");
        
    }
     if(f == 6)
    {
        run.output.setText("");
        run.fontSize(20);
      run.append("       ___________________________________________________  \n"); 
      run.append("    ;,'           _______________                         | \n");
      run.append(" ,;'trance       | Simons's Shop |                        | \n");
      run.append("|    |  |        |   ____________|                        | \n");
      run.append("|    |  |        |  |                                     | \n");
      run.append("|    |  |        |  |                                     |\n");
      run.append("|  __|  |__      |  |                                     |  \n");
      run.append("| /        \\_____|  |__________                           |\n"); 
      run.append("||_______________   ||   *____ ???                        |  \n");
      run.append("| Entrance Hall  |  || * |                                |\n");
      run.append("|                |  ||   |                                |  \n");
      run.append("|                |==|| * |                                |\n");
      run.append("|              __|  ||   |                                |\n");
      run.append("|             |          |                 == = Stairs    |\n");
      run.append("|             |   @      |                  @ = You       |  \n");
      run.append("|         ,-;',_ ,_______|                  * = Enemies   |\n");
      run.append("|_______-'     '  ,_______________________________________|  \n\n");
      Story.userWait();
      run.output.setText("");
        
    }
    if(f == 7)
    {
        run.output.setText("");
        run.fontSize(20);
      run.append("       ___________________________________________________  \n"); 
      run.append("    ;,'           ______________                          | \n");
      run.append(" ,;'trance       | Simon's Shop |                         | \n");
      run.append("|    |  |        |   ___________|__________               | \n");
      run.append("|    |  |        |  |           |   ____  *|              | \n");
      run.append("|    |  |        |  |           |  |    |  |              |\n");
      run.append("|  __|  |__      |  |           |  |    |??|              |  \n");
      run.append("| /        \\_____|  |___________|  |                      |\n"); 
      run.append("||_______________   ||    ______  @|                      |  \n");
      run.append("| Entrance Hall  |  ||   |      |  |                      |\n");
      run.append("|                |  ||   |      |  |    |??|              |  \n");
      run.append("|                |==||   |      |  |____|**|              |\n");
      run.append("|              __|  ||   |      |__________|              |\n");
      run.append("|             |          |                 == = Stairs    |\n");
      run.append("|             |Green Room|                  @ = You       |  \n");
      run.append("|         ,-;',_ ,_______|                  * = Enemies   |\n");
      run.append("|_______-'     '  ,_______________________________________|  \n\n");
      Story.userWait();
      run.output.setText("");
        
        
        
        
    }
    if(f == 8)
    {
        run.output.setText("");
        run.fontSize(20);
      run.append("       ___________________________________________________  \n"); 
      run.append("    ;,'           ______________                          | \n");
      run.append(" ,;'trance       | Simon's Shop |                         | \n");
      run.append("|    |  |        |   ___________|__________               | \n");
      run.append("|    |  |        |  |           |   ____   |              | \n");
      run.append("|    |  |        |  |           |  |    |  |              |\n");
      run.append("|  __|  |__      |  |           |  | ___|==|_________     |  \n");
      run.append("| /        \\_____|  |___________|  ||                |    |\n"); 
      run.append("||_______________   ||    ______   ||    @       *   |    |  \n");
      run.append("| Entrance Hall  |  ||   |      |  ||___    _________|    |\n");
      run.append("|                |  ||   |      |  |    |==|              |  \n");
      run.append("|                |==||   |      |  |____|  |              |\n");
      run.append("|              __|  ||   |      |__________|              |\n");
      run.append("|             |          |                 == = Stairs    |\n");
      run.append("|             |Green Room|                  @ = You       |  \n");
      run.append("|         ,-;',_ ,_______|                  * = Enemies   |\n");
      run.append("|_______-'     '  ,_______________________________________|  \n\n");
      Story.userWait();
      run.output.setText("");
        
        
        
        
    }
}



 public static void gamble() throws InterruptedException
 {
     Playlist.playSong("/sounds/Casino.wav");
     carnivalChoice = true;
     select = false;
     direction = 1;
      run.output.setText("");
           run.append("\n\n\n                     Welcome to Carnino's Casino!");
           run.append("\n                    What Game do you want to play?\n\n");
           run.append("     ==============         ==============         ==============\n");
           run.append("   > Wheel o' Death          Dice of Fate               Exit\n");
           run.append("     ==============         ==============         ==============\n");
        
      while(select == false)
      {
    	  System.out.println("KeyHandler Looping");
            if(direction == 1)
            {
                           run.output.setText("");
                           run.append("\n\n\n                     Welcome to Carnino's Casino!");
                           run.append("\n                    What Game do you want to play?\n\n");
                           run.append("     ==============         ==============         ==============\n");
                           run.append("   > Wheel o' Death          Dice of Fate               Exit\n");
                           run.append("     ==============         ==============         ==============\n");
                           direction = -3;
            }
            else if(direction == 2)
            {
                           run.output.setText("");
                           run.append("\n\n\n                     Welcome to Carnino's Casino!");
                           run.append("\n                    What Game do you want to play?\n\n");
                           run.append("     ==============         ==============         ==============\n");
                           run.append("     Wheel o' Death        > Dice of Fate               Exit\n");
                           run.append("     ==============         ==============         ==============\n");
                           direction = -2;
            }
            else if(direction == 3)
            {
                            run.output.setText("");
                           run.append("\n\n\n                     Welcome to Carnino's Casino!");
                           run.append("\n                    What Game do you want to play?\n\n");
                           run.append("     ==============         ==============         ==============\n");
                           run.append("     Wheel o' Death          Dice of Fate             > Exit\n");
                           run.append("     ==============         ==============         ==============\n");
                           direction = -1;
            }
        }
      if(direction == -3)
        Casino.wheel();
      if(direction == -2)
        Casino.dice();
        run.output.setText("");
        if(Player.gold >= 500)
        {
        Story.textEffect("Carino stole 35 gold from you!");
        run.pause(2000);
        Player.gold = Player.gold - 35;
       }
        int songChoice = (int)(Math.random() * 100);
        if(songChoice < 100)
          Playlist.playSong("/sounds/Carnival.wav");
        else
        {
          Playlist.playSong("/sounds/Carnival2.wav");
        }
        carnivalChoice = false;
    }
    
    
    
    
    
    
    public static void setDirection(int d)
{
    direction = d;
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

  public static void checkQuit(boolean b)
 {
    quit = b;
 }
 
    
}
