package gameplay;

import java.awt.Color;

import backend.*;
import backpack.Manager;
import monsters.*;
public class DungeonTwo {
	    public static RPGRunner run;
	    public static int direction = 0;
	    public static int UDDirection;
	    public static boolean select;
	    public static boolean entrance;
	    public static int mineFloor = 0;
	    public static int craftFloor = 0;
	    public static boolean quit;
	    public static boolean mineChoice;
	    public static boolean mainMenu;
	    public static boolean menu;
	    private static boolean headBack;
	    
	public DungeonTwo(RPGRunner r)
	 {
	    this.run = r;
	 }
	
	public static void mine() throws Exception
	 {
		
		 backpack.Manager.add("Iron Bar",3);
		Playlist.playSong("/sounds/MineTheme.wav");
		run.output.setText("");
	       boolean exit = false;
	  while(exit == false && Player.alive == true)
	  {     boolean proceed = false;
	      while(proceed == false && Player.alive == true)
	      {
	          run.output.setText("");
	       direction = 1;
	       entrance = true;
	       menu = true;
	           run.fontSize(30);
	                          run.output.setText("Location: The Grand Mines");
	           run.append("\n\n\n                   =============   =============  \n");
	           run.append(      "                    > Explore        Head Back   \n");
	           run.append(      "                   =============   =============  \n");
	           run.append("");
	           select = false;
	           while(select == false)
	       {
	        	   System.out.println("KeyHandler Looping");
	           if(direction == 1)
	           {
	               run.output.setText("Location: The Grand Mines");
	            run.append("\n\n\n                   =============   =============  \n");
	            run.append(      "                    > Explore        Head Back   \n");
	            run.append(      "                   =============   =============  \n");
	               direction = -2;
	            }
	           if(direction == 2)
	           {
	                           run.output.setText("Location: The Grand Mines");
	            run.append("\n\n\n                   =============   =============  \n");
	            run.append(      "                      Explore      > Head Back   \n");
	            run.append(      "                   =============   =============  \n");
	               direction = -1;
	            }
	        }
	         if(direction == -1)
	         {
	        	 proceed = true;
	        	 entrance = false;
	        	 exit = true;
	        	 menu = false;
	         }
	         else
	         {
	             proceed = true;
	             entrance = false;
	             menu = false;
	         }
	 }
	      
	      if(exit == false)
	      {
	    	  Player.part = 19;
	         run.output.setText("");
	            Story.textEffect("You stumble across a massive cavern.");
	         run.pause(2000);
	         run.output.setText("");
	         if(mineFloor == 0)
	         {
	        	
	         	run.fontSize(20);
	         	Story.textEffect("The cavern is well lit with oil lamps.\n");
	         	pause(2000);
	         	Story.textEffect("*You conclude that this is the central mining area.*\n");
	         	userWait();
	         	run.output.setText("");
	         	Story.textEffect("In front of you lies multiple levels with old rusty minecart tracks\n");
	         	Story.textEffect("weaving in and out of dark tunnels.");
	         	pause(2500);
	         	userWait();
	         	run.output.setText("");
	         	Story.textEffect("At the lowest level lies a golden door embedded into the wall.\n");
	         	pause(2000);
	         	userWait();
	         	run.output.setText("");
	         	Story.textEffect("*You notice a spiraling staircase next to you, leading to who knows where.\n");
	         	pause(2000);
	         	userWait();
	         	run.output.setText("");
	         	mineFloor++;
	         }
	         
	     }
	      boolean finish = false;
	      quit = false;

	        while(finish == false && Player.alive == true && quit == false && exit == false)
	        {
	        	headBack = false;
	             select = false;
	             menu = true;
	            mainMenu = true;
	            mineChoice = true;
	            direction = 1;
	            run.output.setText("");
	            run.fontSize(30);
	            run.append("\n\n                         Choose where to go");
	      run.append("\n\n\n           ==========        ==========        ==========\n");
	            run.append("           > Stairs           Explore!         Shiny Door\n");
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
	                            run.append("           > Stairs           Explore!         Shiny Door\n");
	                            run.append("           ==========        ==========        ==========\n");
	                            run.append("\n\n\n\n\n\n                                                      [SHIFT] to quit");
	                            direction = -3;
	             }
	             else if(direction == 2)
	             {
	                            run.output.setText("");
	                            run.append("\n\n                         Choose where to go");
	                            run.append("\n\n\n           ==========        ==========        ==========\n");
	                            run.append("             Stairs         > Explore!         Shiny Door\n");
	                            run.append("           ==========        ==========        ==========\n");
	                            run.append("\n\n\n\n\n\n                                                      [SHIFT] to quit");
	                            direction = -2;
	             }
	             else if(direction == 3)
	             {
	                             run.output.setText("");
	                            run.append("\n\n                         Choose where to go");
	                            run.append("\n\n\n           ==========        ==========        ==========\n");
	                            run.append("             Stairs           Explore!       > Shiny Door\n");
	                            run.append("           ==========        ==========        ==========\n");
	                            run.append("\n\n\n\n\n\n                                                      [SHIFT] to quit");
	                            direction = -1;
	             }
	         }
	         mineChoice = false;
	         select = false;
	         menu = false;
	         mainMenu = false;
	         if(direction == -1 && quit == false) {
                 run.fontSize(20);
                 run.output.setText("");
              if(mineFloor == 1){
	        	 Player.part = 20;
	        	 Story.deathMsg = "You will not be missed...\n";
	        	 Story.textEffect("You proceed down to the entrance of the golden door...\n");
	        	 pause(2000);
	        	 run.append("You've been ambushed by dwarves!");
	        	 userWait();
	        	 run.output.setText("");
	        	 MonsterManager.spawn(new DwarfMiner());
	        	 MonsterManager.spawn(new DwarfMiner());
	        	 MonsterManager.spawn(new DwarfMiner());
	        	 Story.mainFight();
                     if(Player.alive == true){
                         MonsterManager.winLoot();
                         MonsterManager.spawn(new DwarfMaster());
                         Story.mainFight();
                         if(Player.alive == true) {
                        	 MonsterManager.winLoot();
                             run.output.setText("");
                             Story.textEffect("What a bruiser!");
                             pause(1000);
                             run.output.setText("");
                             mineFloor++;
                             Story.saveAsk();
                             run.output.setText("");
                          }
                         }
                      }
                 }
	        	 if(mineFloor == 2){
                     Story.textEffect("You continue walking through the mineshaft...");
                     userWait();
                     run.output.setText("");
                     run.append("Mysterious Voice: ",Color.BLUE,20,true);
                     pause(500);
                     Story.textEffect("What you did to those poor dwarves back there wasn't nice!\n\n");
                     pause(2500);
                     run.append("Mysterious Voice: ",Color.BLUE,20,true);
                     pause(500);
                     Story.textEffect("They were only following my orders after all...\n");
                     pause(2000);
                     Story.textEffect("                  I guess I'll just have to punish you!\n");
                     userWait();
                     run.output.setText("");
                     Story.bossScreen();
                     run.output.setText("");
                     Story.textEffect("\n\n\n\n\n                      INFO: Punish him instead!",Color.WHITE,30,true);
                     pause(3000);
                     run.output.setText("");
                     Story.deathMsg = " Mysterious Figure: \"What a disappointment\"\n";
                     MonsterManager.spawn(new MysteriousFigure());
                        Story.mainFight();
                        if(Player.alive == true){
                        	MonsterManager.winLoot();
                         Playlist.stopSong();
                         run.output.setText("You: ");
                         Story.textEffect("Well that was weird...");
                         userWait();
                         run.output.setText("");
                         run.fontSize(40);
                            Playlist.playEffect("/sounds/JoshLaugh.wav");
                         for(int i = 0;i<10;i++) {
                             run.append("\n\n\n\n                    YOU THOUGHT!",Color.RED,40,true);
                             pause(100);
                             run.output.setText("");
                             pause(100);
                         }
                         run.fontSize(20);
                         run.output.setText("");
                         run.append("Mysterious Figure: ",Color.BLUE,20,true);
                            Story.textEffect("It's gonna take a lot more than that to defeat me!\n");
                            userWait();
                         if(backpack.Manager.checkItem("*Archangel Rune",1) == true){
                        	 run.output.setText("");
                             run.append("Mysterious Figure: ",Color.BLUE,20,true);
                             Story.textEffect("So, your the one who defeated Ryan...\n");
                             pause(2000);
                             if(backend.SetUp.censor == false)
                           Story.textEffect("                   Damn, is that pathetic or what!?\n");
                             else
                           Story.textEffect("                   Wow, that's just pathetic!\n");
                             userWait();
                             run.output.setText("");
                          run.append("Mysterious Figure: ",Color.BLUE,20,true);
                             pause(300);
                          Story.textEffect("Don't worry I'm not mad, if you managed to get the best of him\n                   then he deserved to die.\n");
                             userWait();
                         }
                            else{
                            	run.output.setText("");
                             run.append("Mysterious Figure: ",Color.BLUE,20,true);
                             Story.textEffect("Good effort though, you're almost as strong as a penguin!\n");
                             userWait();

                         }
                         	run.output.setText("");
                            run.append("Mysterious Figure: ",Color.BLUE,20,true);
                            Story.textEffect("Anyway, I have dwarves to manage and children to abuse.\n");
                            pause(1000);
                            run.append("Mysterious Figure: ",Color.BLUE,20,true);
                            Story.textEffect("Carry on little hero. Get in my way if you dare...\n");
                            userWait();
                            run.output.setText("");
                            Story.textEffect("*The mysterious man throws a penguin shaped pendant at you and dissapears into the shadows.*\n");
                            pause(2000);
                            Story.textEffect("*You chase after him but he is no where to be found.*\n");
                            userWait();
                            backpack.Manager.add("*Penguin Pendant",1);
                            mineFloor++;
                            Story.saveAsk();
                            run.output.setText("");
                            Story.textEffect("That cloaked man might be able to tell you more.\n");
                            pause(1500);
       	        		 	Story.textEffect("So many questions need to be answered!\n");
       	        		 	userWait();
       	        		 	run.output.setText("");
       	        		 	Playlist.playSong("/sounds/MineTheme.wav");
                        }

                 }
	        	 if(mineFloor == 3){
	        		 Story.textEffect("*You reach the end of the mining tunnel and come out to the bottom of a large ravine*\n");
	        		 userWait();
	        		 run.output.setText("");
	        		 run.append("Simon the Trader: ",Color.ORANGE,20,true);
	        		 pause(500);
	        		 Story.textEffect("How in god's name did you get down here?\n\n");
	        		 pause(2000);
	        		 run.append("You: ",Color.GREEN,20,true);
	        		 pause(500);
	        		 Story.textEffect("I should be asking you the same thing...\n\n");
	        		 pause(2000);
	        		 run.append("Simon the Trader: ",Color.ORANGE,20,true);
	        		 pause(500);
	        		 if(SetUp.censor == true)
	        			 Story.textEffect("Whatever, just buy my crap nerd!\n");
	        		 else
	        			 Story.textEffect("Whatever, just buy my shit nerd!\n");		
	        		 userWait();
	        		 run.output.setText("");
	        		 mineFloor++;
	        	 }
	        	 if(mineFloor >= 4){
	        		 boolean complete = false;
	        		 while(complete == false)
	                 {
	        			 select = false;
	        			 menu = true;
	                   mineChoice = true;
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
	              menu = false;
	            mineChoice = false;
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
	                       if(mineFloor == 4) {
	                           mineFloor = 5;
	                           
	                       }
	                       
	                   }
	                 
	               }
	        	 
	        	 }
	         
	         else if(direction == -2 && quit == false)
	         {
	        	 run.output.setText("");
	        	 run.output.setText("You recklessly dive into random tunnels...");
	             run.pause(2500);
	             run.output.setText("");          
	                 run.fontSize(20);
	                 int times = (int)(Math.random() * 3) + 2;
	                 for(int i = 0;i < times;i++)
	                 {
	                     if(Player.alive == true)
	                     {
	                         if(Player.level <= 15)
	                         {
	                        	 int foe = (int)(Math.random() * 4) + 1;
	                        	 
	                        	 if(foe == 1)
	                        	 {
                                     Story.deathMsg = " You've been gutted!\n";
                                     MonsterManager.spawn(new Goblin());
                                     MonsterManager.spawn(new Goblin());
	                        		 Story.mainFight();
	                        		 if(Player.alive == true && RPGRunner.flee == false)
	                                     MonsterManager.winLoot();
	                                   RPGRunner.flee = false;
	                        	 }
	                        	 if(foe == 2)
	                        	 {
	                        		 Story.deathMsg = " Your flesh was absorbed\n";
	                        		 MonsterManager.spawn(new ToxicSludge());
	                        		 Story.mainFight();
	                        		 if(Player.alive == true && RPGRunner.flee == false)
	                                     MonsterManager.winLoot();
	                                   RPGRunner.flee = false;
	                        	 }
	                        	 if(foe == 3)
	                        	 {
                                     Story.deathMsg = " You've been gutted!\n";
                                     MonsterManager.spawn(new SavageGoblin());
	                        		 Story.mainFight();
	                        		 if(Player.alive == true && RPGRunner.flee == false)
	                                     MonsterManager.winLoot();
	                                   RPGRunner.flee = false;
	                        	 }
	                        	 if(foe == 4)
	                        	 {
                                     Story.deathMsg = " Dwarf Miner: \"I'm sorry. I was forced too\"!\n";
                                     MonsterManager.spawn(new DwarfMiner());
	                        		 Story.mainFight();
	                        		 if(Player.alive == true && RPGRunner.flee == false)
	                                     MonsterManager.winLoot();
	                                   RPGRunner.flee = false;
	                        	 }
	                         }
	                            else
	                         {
	                            	int foe = (int)(Math.random() * 3) + 1;
		                        	 
		                        	 if(foe == 1)
		                        	 {
                                         Story.deathMsg = " You've been disciplined.\n";
                                         MonsterManager.spawn(new DwarfMaster());
                                         MonsterManager.spawn(new DwarfMiner());
		                        		 Story.mainFight();
		                        		 if(Player.alive == true && RPGRunner.flee == false)
		                                     MonsterManager.winLoot();
		                                   RPGRunner.flee = false;
		                        	 }
		                        	 if(foe == 2)
		                        	 {
                                         Story.deathMsg = " Your body was smashed to bits\n";
                                         MonsterManager.spawn(new RockGolem());
		                        		 Story.mainFight();
		                        		 if(Player.alive == true && RPGRunner.flee == false)
		                        		 {
		                                     MonsterManager.winLoot();
		                                   RPGRunner.flee = false;
		                                   MonsterManager.spawn(new RockGolemMini());
		                                   MonsterManager.spawn(new RockGolemMini());
			                        		 Story.mainFight();
				                        		 if(Player.alive == true && RPGRunner.flee == false)
				                        		 {
				                                     MonsterManager.winLoot();
				                                   RPGRunner.flee = false;
				                        		 }
			                        		 }
		                        		 }
		                        	 
                                 if(foe == 3)
                                 {
                                     Story.deathMsg = " You've been gutted!\n";
                                     MonsterManager.spawn(new Goblin());
                                     MonsterManager.spawn(new Goblin());
                                     MonsterManager.spawn(new SavageGoblin());
                                     Story.mainFight();
                                     if(Player.alive == true && RPGRunner.flee == false)
                                         MonsterManager.winLoot();
                                     RPGRunner.flee = false;
                                 }
	                         }
	                     }
	                 }
	         }
	         else if(direction == -3 && quit == false)
	         {
	        	 run.output.setText("");
	        	 Story.textEffect("You descend down the steps...\n");
        		 pause(1500);
	        	 run.fontSize(22);
	        	 if(craftFloor == 0)
	        	 {
	        		 run.output.setText("");
	        		 
	        		 Story.textEffect("You come across a door with 3 empty slots.\n");
	        		 pause(1500);
	        		 userWait();
	        		 run.output.setText("");
	        		 if(Story.lockedDoor("Iron Bar",3,true) == true)
	        		 {
	        			 run.output.setText("");
	        			Story.textEffect("The door unlocks with a satisfying creak...\n");
	        		 	pause(1500);
	        		 	run.append("You gained: 10 exp");
	        		 	Player.exp = Player.exp + 10;
	        		 	userWait();
	        		 	run.output.setText("");
	        		 	gameplay.Level.tryLevelUp();
	        		 	run.output.setText("");
	        		 	Story.textEffect("The door leads to a narrow passage way filled with stalagmites.\n");
		        		 pause(1500);
		        		 userWait();
			             run.output.setText("");
	        			 craftFloor++;
	        		 }
	        	 }
	        	 if(craftFloor == 1)
	        	 {
	        		 
	        		 run.output.setText("");
		             Story.textEffect("You feel a sticky ooze drip down from the cave ceiling...\n");
		             pause(2500);
		             Story.textEffect("You've been ambushed by spiders!");
		             pause(1500);
		             
	        		 userWait();
		             run.output.setText("");
		             MonsterManager.spawn(new CaveSpider());
		             MonsterManager.spawn(new CaveSpider());
		             MonsterManager.spawn(new CaveSpider());
		             Story.mainFight();
			             if(Player.alive == true)
			             {
			            	 MonsterManager.winLoot();
			            	 Playlist.playSong("/sounds/MineTheme.wav");
			            	 craftFloor++;
			             }
		             }
	        	 }
	        	 if(craftFloor == 2){
	        		 run.output.setText("");
	        		 Story.textEffect("You encounter another door at the end of the tunnel.\n");
	        		 pause(1500);
	        		 Story.textEffect("*You notice has a pickaxe-shaped hole in the middle of the door*");
	        		 pause(500);
	        		 if(Story.lockedDoor("Weapon: Pickaxe",1,true) == true)
	        		 {
	        			 run.output.setText("");
		        			Story.textEffect("The door unlocks with a satisfying creak...\n");
		        		 	pause(1500);
		        		 	run.append("You gained: 15 exp");
		        		 	Player.exp = Player.exp + 15;
		        		 	userWait();
		        		 	run.output.setText("");
		        		 	gameplay.Level.tryLevelUp();
		        		 	run.output.setText("");
		        			 craftFloor++;
	        		 }
	        	 }
	        	 if(craftFloor == 3){
	        		 run.output.setText("");
	        		 Story.textEffect("You enter a large chamber.");
	        		 userWait();
		             run.output.setText("");
		             Story.textEffect("Beastial Voice: GRRRAGH?");
		             pause(2200);
		             MonsterManager.spawn(new Minotaur());
		             Story.mainFight();
		             if(Player.alive == true)
		             {
		            	 MonsterManager.winLoot();
		            	 Playlist.playSong("/sounds/MineTheme.wav");
		            	 craftFloor++;
		            	 Story.textEffect("What a truly horrific creature...\n");
		        		 pause(1500);
		             }
		           
	        	 }
	        	 if(craftFloor == 4){
	        		 String activePlate = "\u26AA \u26AA \u26AA";
	        		 int count = 0;
	        		 int[] code = new int[3];
	        		 boolean correct = false;
	        		 run.output.setText("");
	        		 Story.textEffect("You notice 3 pressure plates on the floor.\n");
	        		 pause(1500);
	        		 Story.textEffect("They have the pictures of a Pickaxe, a Minotaur, and a Spider.\n");
	        		 userWait();
	        		
	        		 while(correct == false && quit == false)
	        		 {
	        		 run.output.setText("");
	        		 select = false;
		             menu = true;
		            mainMenu = true;
		            mineChoice = true;
		            direction = 1;
		            run.output.setText("");
		            run.fontSize(30);
		            run.append("Activated: " + activePlate +"\n");
		        run.append("\n\n                    Activate the Pressure Plates");
		      run.append("\n\n\n            =========        ==========        ==========\n");
		            run.append("           > Pickaxe          Minotaur           Spider\n");
		            run.append("            =========        ==========        ==========\n");
		            run.append("\n\n\n\n\n                                                      [SHIFT] to quit");
		            
		        while(select == false)
		         {
		     	   System.out.println("KeyHandler Looping");
		             if(direction == 1)
		             {
		                            run.output.setText("");
		                            run.append("Activated: " + activePlate);
		                            run.append("\n\n\n                    Activate the Pressure Plates");
		              		      run.append("\n\n\n            =========        ==========        ==========\n");
		              		            run.append("           > Pickaxe          Minotaur           Spider\n");
		              		            run.append("            =========        ==========        ==========\n");
		              		            run.append("\n\n\n\n\n                                                      [SHIFT] to quit");
		                            direction = -3;
		             }
		             else if(direction == 2)
		             {
		                            run.output.setText("");
		                            run.append("Activated: " + activePlate);
		                            run.append("\n\n\n                    Activate the Pressure Plates");
		              		      run.append("\n\n\n            =========        ==========        ==========\n");
		              		            run.append("             Pickaxe        > Minotaur           Spider\n");
		              		            run.append("            =========        ==========        ==========\n");
		              		            run.append("\n\n\n\n\n                                                      [SHIFT] to quit");
		                            direction = -2;
		             }
		             else if(direction == 3)
		             {
		                             run.output.setText("");
		                             run.append("Activated: " + activePlate);
		                             run.append("\n\n\n                    Activate the Pressure Plates");
		               		      run.append("\n\n\n            =========        ==========        ==========\n");
		               		            run.append("             Pickaxe          Minotaur         > Spider\n");
		               		            run.append("            =========        ==========        ==========\n");
		               		            run.append("\n\n\n\n\n                                                      [SHIFT] to quit");
		                            direction = -1;
		             }
		         }

		        	if(count < 3)
		        	   code[count] = direction;
		        	count++;
		        	if(count == 1)
		        		activePlate = "\u235F \u26AA \u26AA";
		        	else if(count == 2)
		        		activePlate = "\u235F \u235F \u26AA";
		        	else if(count == 3)
		        		activePlate = "\u235F \u235F \u235F";
		        
		        if(count == 3 && (code[0] != -1 || code[1] != -3 || code[2] != -2))
		        {
		        	
		        	run.output.setText("");
		        	run.append("Activated: " + activePlate +"\n");
			        run.append("\n\n                    Activate the Pressure Plates");
			      run.append("\n\n\n            =========        ==========        ==========\n");
			            run.append("             Pickaxe          Minotaur           Spider\n");
			            run.append("            =========        ==========        ==========\n");
			            run.append("\n\n\n\n\n                                                      [SHIFT] to quit");
			            pause(1000);
			            run.output.setText("");
		        	Story.textEffect("Nothing happens...");
		        	pause(1000);
		        	activePlate = "\u26AA \u26AA \u26AA";
	        		 count = 0;
		        }
		        else if(count == 3 && (code[0] == -1 && code[1] == -3 && code[2] == -2))
		        {
		        	
		        	
		        	mineChoice = false;
			         select = false;
			         menu = false;
			         mainMenu = false;
		        	run.output.setText("");
		        	run.append("Activated: " + activePlate +"\n");
			        run.append("\n\n                    Activate the Pressure Plates");
			      run.append("\n\n\n            =========        ==========        ==========\n");
			            run.append("             Pickaxe          Minotaur           Spider\n");
			            run.append("            =========        ==========        ==========\n");
			            run.append("\n\n\n\n\n                                                      [SHIFT] to quit");
			            pause(1000);
			            run.output.setText("");
			            Playlist.playEffect("/sounds/StoneMove.wav");
		        	Story.textEffect("A massive slab of stone moves into the ground,\nrevealing another set of stairs.");
		        	pause(800);
		        	userWait();
		        	run.output.setText("");
		        	correct = true;
		        	craftFloor++;
		        	activePlate = "\u26AA \u26AA \u26AA";
		        }
		         mineChoice = false;
		         select = false;
		         menu = false;
		         mainMenu = false;
	        		 }
	        	 }
	        	 if(craftFloor == 5){
	        		 run.output.setText("");
	        		 run.fontSize(23);
	        		 Story.textEffect("You go down the steps and find a small room.\n");
	        		 userWait();
			        	run.output.setText("");
			         Story.textEffect("The room is well lit with candles.\n");
			         pause(1000);
			         Story.textEffect("There's a lot of workbenches, papers, and chairs scattered everywhere\n");
			         pause(2000);
			         Story.textEffect("*You see buckets of mysterious dark goo in the corner*");
			         pause(1000);
			         userWait();
			         run.output.setText("");
			         Story.textEffect("*A large metal contraption at the back of the room catches your eye*");
			         pause(1000);
			         userWait();
			         run.output.setText("");
				       direction = 1;
				       menu = true;
				       entrance = true;
				           run.fontSize(30);
				       run.append("\n\n\n\n\n                   =============   =============  \n");
				           run.append(      "                    > Inspect        Head Back   \n");
				           run.append(      "                   =============   =============  \n");
				           run.append("");
				           select = false;
				           while(select == false)
				       {
				        	   System.out.println("KeyHandler Looping");
				           if(direction == 1)
				           {
				        	   run.output.setText("");
				        run.append("\n\n\n\n\n                   =============   =============  \n");
				            run.append(      "                    > Inspect        Head Back   \n");
				            run.append(      "                   =============   =============  \n");
				               direction = -2;
				            }
				           if(direction == 2)
				           {
				        	   run.output.setText("");
				        run.append("\n\n\n\n\n                   =============   =============  \n");
				            run.append(      "                      Inspect      > Head Back   \n");
				            run.append(      "                   =============   =============  \n");
				               direction = -1;
				            }
				        }
				     if(direction == -2) {
				    	 run.output.setText("");
				    	 Story.textEffect("You approach the machine...");
				    	 pause(2000);
				    	 menu = false;
					       entrance = false;
					       select = false;
					       craftFloor++;
				     }
				     else if(direction == -1) {
				    	 run.output.setText("");
				    	 menu = false;
					       entrance = false;
					       select = false;
				     }
	        	 }
	        	 if(craftFloor >= 6)
	        		 crafting();
	         }
   }
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
        run.getReset();
        run.append("\n'Press Enter to Continue'\n");
        run.getString();
    }
    public static void checkDirection(int min,int max,int d)
    {
    	System.out.print(direction + "before method");
        direction = direction + d + max;
        System.out.print(direction + "direction math");
        if(direction < min)
        {
            direction = max - 1;
        }
        if(direction >= max)
        {
        	System.out.print(direction + "MAXED");
             direction = min;
        }
        System.out.print(direction + "after method");
    }

    public static void crafting() throws InterruptedException
    {
    	run.output.setText("");
    	run.fontSize(33);
    	
    	 direction = 1;
	       entrance = true;
	       menu = true;
	                run.output.setText("==========================GREAT=FORGE=======================================");
	           run.append("\n\n\n\n                 =============   =============  \n");
	           run.append(      "                  > Recipes        Head Back   \n");
	           run.append(      "                 =============   =============  \n");
	           run.append("");
	           select = false;
	           while(select == false)
	       {
	        	   System.out.println("KeyHandler Looping");
	           if(direction == 1)
	           {
	        	     run.output.setText("==========================GREAT=FORGE=======================================");
	            run.append("\n\n\n\n                 =============   =============  \n");
	            run.append(      "                  > Recipes        Head Back   \n");
	            run.append(      "                 =============   =============  \n");
	               direction = -2;
	            }
	           if(direction == 2)
	           {
	        	     run.output.setText("==========================GREAT=FORGE=======================================");
	            run.append("\n\n\n\n                 =============   =============  \n");
	            run.append(      "                    Recipes      > Head Back   \n");
	            run.append(      "                 =============   =============  \n");
	               direction = -1;
	            }
	        }
	           if(direction == -2)
	           {
	        	   
	        	   crafting.List.display();
	        	   menu = false;
			       entrance = false;
			       select = false;
	           }
	           else if(direction == -1) {
			    	 run.output.setText("");
			    	 menu = false;
				       entrance = false;
				       select = false;
			     }
    }

    public static void checkEnter(boolean b)
    {
        select = b;
    }

    public static void setDirection(int d)
    {
        direction = d;
    }
    public static void checkQuit(boolean b)
    {
       quit = b;
    }
}