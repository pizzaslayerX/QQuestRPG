package Main;
import Run.*;

import java.awt.Color;
import java.util.Scanner;

import Armor.Gem;
import Monsters.*;
import Main.*;
import BackPack.Manager;
public class Story
{
    public static RPGRunner run;
    public static String deathMsg;
    public static int direction = 0;
    public static int UDDirection;
    public static boolean select = false;
    public static boolean firstTime = true;
    public static boolean lockedDoor = false;
    public static boolean atRoads = false;
    public static boolean twoChoiceH = false;
    public static boolean bPressed = false;
    public static boolean complete = false;
    public static int path = 0;
    private static final Color LIGHT_BLUE = new Color(0,166,255);
    public static String[] location = {"El Carnival","The Grand Mines","Misty Mountains","Heaven's Door"};
    public Story(RPGRunner r)
    {
        this.run = r;
    }

    
    public static void part(int p) throws Exception
    {
        if(p == 1)
        {
        	Player.part = 1;
            Playlist.playSong("/sounds/CaveSound.wav");
            run.output.setText("");
            textEffect("Stripped bare with nothing but your fists and clothes on your back...\n");
            pause(1500);
            textEffect("God plops you right into the bottom of a well.\n");
            pause(1500);
            if(Run.SetUp.censor == false)
            textEffect("What an ass");
            else
            	textEffect("What a nub");
            userWait();
            run.output.setText("");
            run.append("You encounter a Slug! An EVIL Slug\n");
            run.append("FIGHT!\n");
            pause(3500);
            run.output.setText("");
            MonsterManager.spawn(new RPGSlug());
            run.fight();
            if(Player.alive == true )
            MonsterManager.winLoot();
            Main.Player.scene++;
        }
        if(p == 2)
        {
        	Player.part = 2;
            run.output.setText("");
            run.append("It looks like the slug left something!\n");
            run.getReset();
            pause(2000);
            run.getReset();
            run.append("The Slug vomitted a stone dagger [dmg:3][crit:5] during the fight.\n");
            run.getReset();
            Weapon.StoneDagger.setWeapon();
            Player.equipWeapon();
            run.output.setText("");
            run.append("You encounter two more slugs!");
            pause(3000);
            run.output.setText("");
            MonsterManager.spawn(new RPGSlug());
            MonsterManager.spawn(new RPGSlug());
            run.mainFight(); 
            
            if(Player.alive == true )
            {
            	MonsterManager.winLoot();
           }
           Main.Player.scene++;
        }
        if(p == 3)
        {
        	Player.part = 3;
           deathMsg = "Dying to any slug is just sad. Period.\n";
           while(Player.alive == true && complete == false)
            {
            if(Player.weapons[Player.equippedWeapon].name.equals("Stone Dagger"))
            run.append("*This new dagger is pretty effective*\n");
            else
            run.append("*A dagger sure would've been nice*\n");
            pause(2000);
            run.append("You wander around the tunnel beneath the well. It's cool, wet, and dark.\n");
            pause(2000);
            run.append("After walking straight for quite sometime, you can see the outline of 2 holes.\n");
            run.append("Go down right[r] or left[l] hole?\n");
            run.getReset();
            String answer = run.getString();
            run.output.setText("");
            if(answer.equals("l"))
            {
                run.append("You leap down the hole, landing roughly.\n");
                pause(2000);
                int chance = 1 + (int)(Math.random() * 2);
                if(Player.health > 4 && chance == 1)
                {
                    run.append("You took 1 damage\n");
                    pause(2000);
                    Player.health--;
                }
                run.append("You find a chest!\n");
                userWait();
                run.output.setText("");
                Chest.open(1);
                userWait();
            }
            else
            {
                run.append("You leap down the hole, landing roughly.\n");
                pause(2000);
                int chance = 1 + (int)(Math.random() * 3);
                if(Player.health > 4 && chance == 1)
                {
                    run.append("You took 1 damage\n");
                    pause(2000);
                    Player.health--;
                }
                run.append("You find a chest!\n");
                userWait();
                run.output.setText("");
                Chest.open(2);
                userWait();
            }
            run.output.setText("");
            run.append("You continue down the path...\n");
             pause(1500);
            run.append("You hear something very... Fat... Very... Dire...\n");
            userWait();        
            run.output.setText("");
            MonsterManager.spawn(new DireSlug());
            run.fight();
            if(Player.alive == true )
            {
            	MonsterManager.winLoot();;
           }
           complete = true;
          }
           complete = false;
           Main.Player.scene++;
           if(Player.alive == true)
           saveAsk();
        }
        if(p == 4)
        {
        	Player.part = 4;
            deathMsg = "Skeletons tend to be dangerous in groups...\n";
             while(Player.alive == true && complete == false)
            {
           run.append("*Noted: Dire Slugs are mean*");
           int boneCount = 0;
          
           run.append("\n*You pass a pile of bones*\n\n");
           boneCount++;
        
           pause(1500);
           run.append("\nYou've been wandering...\n");
           pause(1500);
           run.append("For a very...");
           pause(1500);
           run.append("Very...");
           pause(1500);
           run.append("Long time...\n");
           pause(1500);
           userWait();
           run.output.setText("");
           
           Chest.ranChestOpen(1,75);
            int boneChance = 1 + (int)(Math.random() * 2);
           if(boneChance == 1)
           {
           run.append("\n*You pass a pile of bones*\n\n");
           boneCount++;
           }
           run.append("The air grows still. You don't need anymore of this\n");
             boneChance = 1 + (int)(Math.random() * 4);
           if(boneChance == 1)
           {
           run.append("\n*You pass a pile of bones*\n\n");
           boneCount++;
          }
           pause(1500);
           run.append("Where's god when you need him?\n");
           pause(2500);
           textEffect("===============================","Right here. I've been watching.","===============================",Color.MAGENTA,Color.WHITE);
           userWait();
           run.output.setText("");
           textEffect("========================","My beautiful creation...","========================",Color.MAGENTA,Color.WHITE);
           userWait();
           run.output.setText("");
           textEffect("========================================================","You're much stronger than the others I based you off of.","========================================================",Color.MAGENTA,Color.WHITE);
           userWait();
           run.output.setText("");
           textEffect("==========================================================","You can say what you what you want, but you have a purpose","==========================================================",Color.MAGENTA,Color.WHITE);
           userWait();
           run.output.setText("");
           textEffect("====================================================","I'll grant you the gift of: Precision[1] or Force[2]","====================================================",Color.MAGENTA,Color.WHITE);
           int choice = run.getInt();

           if(choice == 1)
           {
        	   run.append("\n\n*A strange looking wand appears in your hand*");
               pause(1000);
               Weapon.CarnivalComet.setWeapon();
               Player.equipWeapon();
           }
            else
           {
                run.append("\n\n*A deadly blade appears in your hand*");
                pause(1000);
               Weapon.TheImpaler.setWeapon();
               Player.equipWeapon();
           }
           userWait();
           run.output.setText("");
           textEffect("=============================================","Hey, I have bad news, My presence gives life.","=============================================",Color.MAGENTA,Color.WHITE);
           userWait();
           run.output.setText("");
           textEffect("=============================================================","I'm going to go and create something. I'll take my leave now.","=============================================================",Color.MAGENTA,Color.WHITE);
           userWait();
           run.output.setText("");
           run.append("*You hear a rumble coming from nearby*\n");
           pause(1500);
           run.append("The bones grow restless\n");
           userWait();
           run.output.setText("");
           for(int i = 1;i <= boneCount;i++)
           {
               if(Player.alive == true)
            {
            	   MonsterManager.spawn(new RaggedSkeleton());
               run.fight();
            }
               if(Player.alive == true )
            {
               MonsterManager.winLoot();
            }
           }
            if(Player.alive == true)
            {
            complete = true;
           }
        }
            complete = false;
            
           Main.Player.scene++;
        }
        if(p == 5)
        { 
        	Player.part = 5;
            while(Player.alive == true && complete == false)
            {
            run.append("You can see a faint glow further down the corridor...\n");
            pause(1500);
            run.append("You continue in the direction of the light until you ");
            run.append("enter a rather large circular chamber.\n");
            userWait();
            run.output.setText("");
            Chest.ranChestOpen(1,80);
            run.append("Immediately, you notice 2 giant skeletons. The eyes look hollow.\n");
            pause(1500);
            run.append("In the middle of the chamber there's a pedastal with a skull that's emmitting a blue glow.\n");
            pause(1500);
            run.append("You approach the skull...");
            userWait();
            run.output.setText("");
            run.append("Suddenly, all of the bones scattered on the ground pull together at the pedastal.\n");
            pause(2000);
            run.append("The bones combine into the shape of a skeleton. A rather wizardy-lookin' skeleton.\n");
            pause(2000);
            run.append("It's eyes glow a faint blue...");
            userWait();
            run.output.setText("");
            run.append("Punch[p] the skeleton wizard or Stare[s]?");
            String answer = run.getString();
            if(answer.equals("s"))
            {
                run.output.setText("");
                deathMsg = "Beabzle is powerful. Silence him to make the fight easier!\n";
                run.append("You just stand there and stare... Waiting for something to happen.\n");
                pause(2500);
                run.append("...");
                pause(1500);
                run.append(" ...");
                pause(2000);
                run.append(" ...");
                pause(2500);
                run.append(" ...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("...");
                pause(200);
                run.append("\n\n Skele-Wiz: ",LIGHT_BLUE,20,true);
                textEffect("You know, you can't beat me.");
                pause(2000);
                run.append("\n\n Skele-Wiz: ",LIGHT_BLUE,20,true);
                textEffect("I don't need to blink? I don't have eyes.\n");
                pause(500);
                textEffect("            I'm the king of staring contests.\n");
                pause(1500);
                userWait();
                run.output.setText("");
                run.append("*Skele-Wiz sniffs you*\n\n");
                pause(1500);
                run.append("Skele-Wiz: ",LIGHT_BLUE,20,true);
                textEffect("Arghhh! You're an abomination! I don't smell a hint of mana in you!\n");
                userWait();
                run.output.setText("");
                run.append("You: ",Color.GREEN,20,true);
                textEffect("?\n\n");
                pause(2000);
                run.append("Skele-Wiz: ",LIGHT_BLUE,20,true);
                textEffect("You must be one of HIS creations!\n\n");
                pause(2000);
                run.append("Skele-Wiz(Beabzle): ",LIGHT_BLUE,20,true);
                textEffect("I, Beabzle, have no choice but to do what's right by destroying you!\n");
                userWait();
                bossScreen();
                MonsterManager.spawn(new Beabzle());
                run.beabzlefight();
                if(Player.alive == true)
            {
               MonsterManager.winLoot();
            }
            complete = true;
            }
            else
            {
                deathMsg = "Skeletons Warriors are tough! You probably shouldn't fight them right now.\n";
              run.output.setText("");
              run.append("Oddly, the skeleton wizard doesn't move when you hit it, but you notice the blue from it's eyes vanish\n");
              pause(2000);
              run.append("However");
              pause(2000);
              run.append(", the eyes of the giant skeletons light up.");
              userWait();
              run.output.setText("");
              MonsterManager.spawn(new SkeletonWarrior());
               run.fight();
               if(Player.alive == true)
            {
               MonsterManager.winLoot();
            
            RPGRunner.flee = false;
            MonsterManager.spawn(new SkeletonWarrior());
               run.fight();
               if(Player.alive == true )
               {
            	   MonsterManager.winLoot();
              
              RPGRunner.flee = false;
               deathMsg = "Beabzle is powerful. Silence him to make the fight easier!\n";
               run.append("You see the blue light leave the Skeleton Warrior's eyes, as their bodies crumble to dust.");
               userWait();
               run.output.setText("");
               run.append("Skele-Wiz: ",LIGHT_BLUE,20,true);
               textEffect("You killed my Frat-Brothers! You most certainly aren't human!\n");
               pause(2000);
               textEffect("           Only one of HIS creations would do something like that!\n\n");
               pause(2500);
               run.append("Skele-Wiz: ",LIGHT_BLUE,20,true);
                textEffect("I, Beabzle, have no choice but to do what's right by destroying you!\n");
                userWait(); 
                bossScreen();
                MonsterManager.spawn(new Beabzle());
                run.beabzlefight();
                if(Player.alive == true)
            {
                	MonsterManager.winLoot();
                	complete = true;
             }
             }
            }
           }
         }
         complete = false;
         Main.Player.scene++;
         if(Player.alive == true)
         saveAsk();
        }
        if(p == 6)
        {
        	Player.part = 6;
             while(Player.alive == true && complete == false)
            {
            run.append("Beabzle: ",LIGHT_BLUE,20,true);
            textEffect("That's enough!\n\n"); 
            pause(1500);
            run.append("*Beabzle goes to sit on the pedastal*\n");
            pause(2000);
            run.output.setText("");
            run.append("Beabzle: ",LIGHT_BLUE,20,true);
            textEffect("I grow tired. I'd rather not spend what little mana I have on you\n");
            pause(2000);
            textEffect("         Especially on something that doesn't have any mana of its own.\n\n");
            pause(2000);
            run.append("You: ",Color.GREEN,20,false);
            textEffect("Mana?\n\n");
            pause(2000);
            run.append("*Beabzle nods his head frantically*\n");
            pause(1000);
            userWait();
            run.output.setText("");
            run.append("Beabzle: ",LIGHT_BLUE,20,true);
            textEffect("Of course that being you call 'God' didn't tell you.\n\n");
            pause(2000);
            run.append("You: ",Color.GREEN,20,false);
            textEffect("What do you mean? God is great!\n");
            pause(2000);
            textEffect("     He's taught me many things and has given me many gifts.\n");
            pause(500);
            textEffect("     I would have died in this cave if it weren't for his guidance!\n");
            userWait();
            run.output.setText("");
            run.append("Beabzle: ",LIGHT_BLUE,20,true);
            textEffect("WHO PUT YOU IN THE CAVE IN THE FIRST PLACE!?!?\n");
            pause(2000);
            textEffect("         You are blind to the nature of things!\n");
            pause(1500);
            textEffect("         He gifts those that are of use to him.\n");
            pause(1500);
            textEffect("         As soon as you fullfill your purpose or waver from the destiny he has planned for you\n\n");
            pause(2000);
            textEffect("         HE WILL CAST YOU ASIDE...\n",Color.WHITE,30,true);
            userWait();
            run.output.setText("");
            run.append("Beabzle: ",LIGHT_BLUE,20,true);
            textEffect("Look, all I'm saying is that he isn't what you think!\n\n");
            pause(2000);
            run.append("*You look at him with genuine confusion*\n");
            pause(1000);
            userWait();
            run.output.setText("");
            run.append("Beabzle: ",LIGHT_BLUE,20,true);
            textEffect("BAH! Pointless!\n\n");
            pause(2000);
            run.append("Beabzle: ",LIGHT_BLUE,20,true);
            textEffect("I've worked my whole afterlife to overthrow his tyranny...\n");
            pause(1500);
            textEffect("         I can't do anything in my current state, so I'll use you, his chosen savior, against him!\n\n");
            pause(2500);
            run.append("Beabzle: ",LIGHT_BLUE,20,true);
            textEffect("You'll soon understand the truth...\n");
            userWait();
            run.output.setText("");
            run.append("*The blue light leaves Beabzle and floats into you*\n");
            pause(1000);
            userWait();
            run.output.setText("");
            run.append("*Beabzle crumbles into a pile of dust*\n");
            pause(2000);
            run.append("*You feel a jolt of energy... You've never felt so... alive*\n");
            pause(1000);
            userWait();
            run.output.setText("");
            run.append("You learned Cure.\n",Color.WHITE,30,true);
            pause(1000);
            userWait(); 
            Player.mana = Player.mana + 30;
            Player.maxMana = Player.maxMana + 30;
            Ability.Actives.Cure.equip();
            run.output.setText("");
            complete = true;
        }
        complete = false;
        Main.Player.scene++;
        if(Player.alive == true) {
        saveAsk();
        }
      }
      if(p == 7)
      {
    	  Player.part = 7;
          deathMsg = "Dying to any slug is just sad. Period.\n";
          while(Player.alive == true && complete == false)
            {

          run.append("*You have a lot of questions to ask God*");
          userWait();
          run.output.setText("");
          textEffect("~You aquired mana!~\n");
          pause(2000);
          textEffect("~Powerful abilities require mana~\n");
          pause(2000);
          textEffect("~During battle you regen 1/8 of you total mana every turn~");
          userWait();
          run.output.setText("");
          run.append("There's not a soul left in the chamber\n");
          pause(2000);
          String answer = "";
          boolean magic = false;
          boolean weapon = false;
          boolean loot = false;
          while(!(answer.equals("t")))
          {
              run.getReset();
          run.append("Look around some more [a] or turn around and leave [t]]");
          answer = run.getString();
          run.output.setText("");
          if(answer.equals("a"))
          {
              
              int threshold = 1 + (int)(Math.random() * 100);
              if(threshold < 20 && loot == false)
              {
                loot = true;
                Chest.ranChestOpen(2,95);
             }
              else if(threshold <= 40 && threshold >= 20 && magic == false)
             {
                 magic = true;
                  run.append("You find an old scroll.\n");
                  pause(2000);
                  threshold = 1 + (int)(Math.random() * 100);
                  if(threshold <= 50)
                  {
                  run.append("You learned Silence II.");
                  userWait();
                  Ability.Actives.SilenceTwo.equip();
                  run.output.setText("");
                }
                else
                {
                    run.append("You learned Stun.");
                    userWait();
                    Ability.Actives.Stun.equip();
                    run.output.setText("");
                }
             }
              else if(threshold < 50 && threshold > 40 && weapon == false)
             {
                   weapon = true;  
                   run.getReset();
                  run.append("You found a Bronze Mace! [dmg:21][crit:8]");
                  run.getReset();
                  run.append("\nPress [p] to pick up");
                  String choice = run.getString();
                if(choice.equals("p"))
              {
                  Weapon.BronzeMace.setWeapon();
                  Player.equipWeapon();
              }
                run.output.setText("");
             }
             else if(threshold <= 75 && threshold >= 50)
             {
                 run.append("You look around very hard\n");
                }
             else
             {
                 run.append("It's dark and scary.\n");
                }
         }
         
        }
        run.output.setText("");
         run.append("*Squish*");
         pause(1500);
         run.output.setText("");
         MonsterManager.spawn(new DireSlug());
         MonsterManager.spawn(new DireSlug());
         MonsterManager.spawn(new RPGSlug());
            run.mainFight();
            if(Player.alive == true )
            {
            	MonsterManager.winLoot();
           }
         run.append("You continue down the corridor. You come across mulitple paths.\n");
         pause(2000);
         run.getReset();
            run.append("Go right[r], left[l], or straight [s]\n");
            answer = run.getString();
            run.output.setText("");
            if(answer.equals("r"))
            {
                deathMsg = "Is it possible to die to a pink slug???\n";
               run.append("There's a trail of pink sludge...");
               pause(2000);
               run.output.setText("");
               MonsterManager.spawn(new PinkSlug());
               MonsterManager.spawn(new DireSlug());
               MonsterManager.spawn(new DireSlug());
             run.mainFight();
             if(Player.alive == true )
             {
            	 MonsterManager.winLoot();
             }
            }
            else if(answer.equals("s"))
            {
                deathMsg = "Skeleton Warriors are quite formiddable.\n";
              Chest.ranChestOpen(1,60);  
              run.append("You bump into something large and white...");
               pause(2000);
               run.output.setText("");
               MonsterManager.spawn(new SkeletonWarrior());
             run.fight();
             if(Player.alive == true )
             {
            	 MonsterManager.winLoot();
             }
            }
            else
            {
                deathMsg = "Skeleton Warriors are quite formiddable.\n";
              run.append("You bump into something large and white...");
               pause(2000);
               run.output.setText("");
               MonsterManager.spawn(new SkeletonWarrior());
             run.fight();
             if(Player.alive == true )
             {
            	 MonsterManager.winLoot();
             }
            }
            if(Player.alive == true)
                complete = true;
    }   
        complete = false;
        Main.Player.scene++;
        if(Player.alive == true)
        saveAsk();
  }
  if(p == 8)
   {
	  Player.part = 8;
       deathMsg = "The spiders enjoyed eating you.\n";
       while(Player.alive == true && complete == false)
       {
           
         run.output.setText("");
         run.append("You walk for miles... until you come across a large mossy room\n");
         pause(2000);
         Chest.ranChestOpen(1,55);
         run.append("There seems to be a door to outside at the other side of the room!\n");
         userWait();
         run.output.setText("");
         run.append("You sprint to the door! FREEDOM!\n");
         pause(2000);
         run.append("Webs from all directions shoot at you feet...");
         userWait();
         run.output.setText("");
         MonsterManager.spawn(new WellSpider());
             run.mainFight();
             if(Player.alive == true)
             {
              MonsterManager.winLoot();
             }
             if(Player.alive == true)
            {
             MonsterManager.spawn(new WellSpider());
             MonsterManager.spawn(new WellSpider());
             run.mainFight();	 
             if(Player.alive == true )
             {
            	 MonsterManager.winLoot();
              complete = true;
             }
            
         }
        }
        complete = false;
        Main.Player.scene++;
        if(Player.alive == true)
        saveAsk();
  }   
  if(p == 9)
  {
	  Player.part = 9;
      deathMsg = "Rasgoth is tough. Period.\n";
      while(Player.alive == true && complete == false)
       {
      run.append("You head for the exit...\n\n");
      pause(2500);
      textEffect("==========================================","Stop, you aren't ready for the real world.","==========================================",Color.MAGENTA,Color.WHITE);
      userWait();
      run.output.setText("");
      textEffect("You: Anything is better than here, I'm not waiting to be eaten!\n\n");
      pause(3000);
      textEffect("=================================================================================","Ignorant boy! There are people out there who could expose you to terrible things.","=================================================================================",Color.MAGENTA,Color.WHITE);
      userWait();
      run.output.setText("");
      run.append("*God breaks your legs*\n");
      pause(2000);
      run.append("*The pain is unimaginable!*\n");
      pause(2000);
      run.append("Use Cure to stop the pain!");
      pause(2500);
      run.output.setText("");
      Player.mana = Player.maxMana;
      boolean healed = false;
      while(healed == false)
      {
      RPGRunner.append("Mana: " + Player.mana + "/" + Player.maxMana + "\n");
        run.append("=====================PASSIVES=========================\n");
        run.append("" + Ability.Passives.List.show() + " | Pain\n");
        run.append("======================================================\n\n");
        run.append("=====================ACTIVES================================================================================================================\n");
        run.append("[1]: Cure | Heals 10% of HP without using a turn. Costs 20 mana\n");
        run.append("=============================================================================================================================================\n\n");
        run.append("'Enter a slot number to use an ability or [0] to exit'\n");
        int aSlot = run.getInt();
        if(aSlot == 1)
        {
            run.append("You used Cure.");
            pause(2000);
           run.output.setText("");
           run.append("Your wounds are mended\n");
           pause(2000);
           run.output.setText("You gained 10 HP");
           pause(2000);
           healed = true;
        }
        else
        {
            run.append("The pain is too great! You MUST Cure it!");
            pause(2000);
           run.output.setText("");
        }
    }
    run.output.setText("");
    textEffect("=====","What!","=====",Color.MAGENTA,Color.WHITE);
       userWait();
      run.output.setText("");
      run.append("*God looks as if Curing ended up hurting him*");
       userWait();
      run.output.setText("");
      textEffect("==================================================================","*Wincing* I see... You're a lost cause then. They've gotten to you","==================================================================",Color.MAGENTA,Color.WHITE);
      userWait();
      run.output.setText("");
      run.append("*God outbursts in a very ungodly manner*\n");
      pause(2500);
      textEffect("=====================================================================","THE ARROGANCE!!! To think that you, a mortal, would dare use my mana!","=====================================================================",Color.MAGENTA,Color.WHITE);
      userWait();
      run.output.setText("");
      run.append("*God materializes a wicked lookin' blade*\n");
      pause(2000);
      run.append("*The air in the room grows warmer*\n");
      userWait();
      run.output.setText("");
      textEffect("*God slices the ground open leaving a long fiery crack*\n");
      pause(2500);
      textEffect("*A demonic lizard hand shoots up from the cracks and grabs the blade from god*\n");
      userWait();
      run.output.setText("");
      textEffect("==========================================","Let's see how well your mana serves you...","==========================================\n",Color.MAGENTA,Color.WHITE);
      pause(3000);
      run.output.setText("");
            Playlist.playSong("/sounds/TheEncounter.wav");
      run.fontSize(35);
      run.append("\n\n\n\n                        ==========\n                         IN HELL!\n                        ==========\n\n",Color.RED,0,true);
      pause(2000);
      run.output.setText("");
      run.fontSize(20);
      run.append("*God vanishes in a flash of light*\n");
      pause(2000);
      run.append("*The demon rasgoth bellows!*");
      userWait();
      bossScreen();
      run.fontSize(30);
      textEffect("\n\n\n\n              INFO: Defeat the Demon Rasgoth and escape!!!",Color.WHITE,true);
      pause(3000);
      run.output.setText("");
      run.fontSize(20);
      MonsterManager.spawn(new Rasgoth());
      run.rasgothFight();
      if(Player.alive == true)
            {
               MonsterManager.winLoot();
               complete = true;
            }
            Playlist.stopSong();
   }
            complete = false;
            Main.Player.scene++;
            if(Player.alive == true)
            saveAsk();
    }
  if(p == 10)
   {
	  Player.part = 10;
       complete = false;
       deathMsg = "Wolves hit hard and are fast. Kill them with magic.\n";
    while(Player.alive == true && complete == false)
      {
      
       run.output.setText("");
       run.append("You burst out of the chamber, covered in soot and smoke\n");
       pause(2200);
       run.append("Only to run into a pack of wild wolves!");
       userWait();
       run.output.setText("");
       
      for(int i = 0;i<3;i++)
       {
       if(Player.alive == true)
       {
    	   MonsterManager.spawn(new ForestWolf());
        run.beastFight(5,2);
        if(Player.alive == true )
        {
           MonsterManager.winLoot();
          complete = true;
        }
       }
       }
       
       if(Player.alive == true)
      {
          
       run.output.setText("");
       run.append("Wolves are worse than slugs that's for sure.");
       userWait();
       run.output.setText("");
       run.append("*You here shouts in the woods*\n");
       pause(1500);
       run.getReset();
       run.append("Follow the voice[1] or Look for a road[2]");
       int choice = run.getInt();
      if(choice == 1)
       {
         run.append("\nYou decide to chase after the voice!\n");
         pause(2500);
         run.output.setText("");
         run.append("You arrive in a small clearing and find a middle aged man with a wagon full of equipment\n");
         pause(2500);
         textEffect("Man: Please, you have to help me!\n");
         userWait();
         run.output.setText("");
         run.output.setText("A giant wolf leeps out from beyond the trees. Threatening to eat you both.");
         userWait();
         run.output.setText("");
         run.fontSize(30);
         textEffect("\n\n\n\n\n                     INFO: Slay the Gray Wolf!",Color.WHITE,true);
         pause(3000);
         run.output.setText("");
         run.fontSize(20);
         MonsterManager.spawn(new GrayWolf());
         run.beastFight(4,5);
        if(Player.alive == true )
        {
           MonsterManager.winLoot();
        }
        if(Player.alive == true)
        {
            
        run.output.setText("");
        textEffect("Man: Oh thank you sir! May the heaven's bless you! THANK YOU THANK YOU!!!\n");
         pause(2200);
        textEffect("Man: My name is Simon, Simon the Trader.\n");
        pause(1500);
        textEffect("Man: As thanks for saving me, I'll give you this one time shopping discount!\n");
        pause(2500);
        Shop.openShop();
        run.output.setText("");
        textEffect("Simon the Trader: Well, I'll be taking my leave now\n");
        pause(2000);
        textEffect("Simon the Trader: There's a road not far from here, I recommend going there\n");
        pause(2500);
       }
      
     }
      else
      {
       textEffect("\nYou decide to ignore the screams of agony...\n");
       pause(2000);
      }
       if(Player.alive == true)
       {
      
      textEffect("*You spend some time looking for a road*");
      userWait();
      run.output.setText("");
      textEffect("*You arrive at a road branching off into 4 paths*\n");
      Chest.ranChestOpen(2,70);
      complete = true;
     }
    }
   }
       complete = false;
       Main.Player.scene++;
       if(Player.alive == true)
         saveAsk();
      
    }
  if(p == 11)
  {
	  Player.part = 11;
      complete = false;
      while(Player.alive == true && complete == false)
      {
      direction = 1;
      textEffect("*You notice a sign post near the road*\n");
      pause(2000);
      textEffect("It has the names of four locations.\n");
      pause(2000);
      textEffect("The real fun has just begun.");
      userWait();
      roadChoice();
      run.output.setText("");
      if(path != 0)
      {
      run.append("You feel insecure with your decision.\nYou decide to go to El Carnival!");
      pause(3500);
      run.output.setText("");
      path = 0;
      }
      textEffect("          \n\n\n\n\n         *You start heading towards " + "El Carnival" + "*");
      run.append("\n\n\n\n      'Press Enter to Conintue'");
      run.getReset();
      run.getString();
      run.output.setText("");
      run.fontSize(20);
      randEncounter(Player.level);
      if(Player.alive == true)
      {
      Chest.ranChestOpen(1,50);
      Chest.ranChestOpen(2,33);
      run.output.setText("");
      complete = true;
      Main.Player.scene++;
       if(Player.alive == true)
         saveAsk();
     }
    }
    complete = false;
 }
  if(p == 12)
  {
	  Player.part = 12;
       while(Player.alive == true && complete == false)
      {
      boolean leave;
      Playlist.playSong("/sounds/Carnival.wav");
          carnivalArrive();
           
       run.fontSize(20);
       textEffect("The area looks dark and depressing.\n");
       pause(1500);
       textEffect("There are hundreds of old red and white tents around you.\n");
       pause(1500);
       textEffect("Some look old and mouldy, others look tattered.\n");
       pause(1500);
       textEffect("One thing in particular catches your attention...\n");
       userWait();
       run.output.setText("");
       textEffect("*You see a giant tent the size of a football stadium in the center of all of the little tents*\n");
       pause(2000);
       textEffect("*You hear screams followed by maniacal laughter coming from within...*\n");
       userWait();
       run.output.setText("");
       boolean proceed = false;
      while(proceed == false)
      {
          run.output.setText("");
       direction = 1;
           run.fontSize(30);
           run.append("\n\n\n                   =============   =============  \n");
           run.append("                    > Explore        Head Back   \n");
           run.append("                   =============   =============  \n");
           run.append("");
           twoChoiceH = true;
           select = false;
           while(select == false)
       {
        	   System.out.println("KeyHandler Looping");
           if(direction == 1)
           {
               run.output.setText("");
            run.append("\n\n\n                   =============   =============  \n");
            run.append("                    > Explore        Head Back   \n");
            run.append("                   =============   =============  \n");
               direction = -2;
            }
           if(direction == 2)
           {
               run.output.setText("");
            run.append("\n\n\n                   =============   =============  \n");
            run.append("                      Explore      > Head Back   \n");
            run.append("                   =============   =============  \n");
               direction = -1;
            }
        }
       if(direction == -1)
       {
           run.output.setText("");
           direction = 0;
           twoChoiceH = false;
           leave = lockedDoor("Carnival Key",1,false);
       }
       else
       {
           proceed = true;
           twoChoiceH = false;
       }
     }
     run.output.setText("");
     run.fontSize(20);
     deathMsg = "Kill clowns as fast as possible...";
     textEffect("You search the fare grounds for several hours\n");
     pause(1500);
     textEffect("It's quiet... too quiet...\n");
     pause(1500);
     textEffect("You peep your head into one of the tents...\n");
     pause(1000);
     userWait();
     run.output.setText("");
     textEffect("A colorful hand grabs you by the neck and throws you to the ground!\n");
     pause(2500);
     textEffect("You should've known!\n");
     pause(2000);
     run.append("CLOWNS!!!");
     userWait();
     RPGRunner.flee = false;
     Playlist.playSong("/sounds/CarnivalFight.wav");
     for(int i=0;i<2;i++)
     {
      if(Player.alive == true)
        {
            run.output.setText("");
            MonsterManager.spawn(new BasicClown());
            run.clownFight(0,0,0,2,0,0,1,3);
            if(Player.alive == true)
             MonsterManager.winLoot();
      }
     }
     Playlist.playSong("/sounds/Carnival.wav");
     if(Player.alive == true)
     {
        run.output.setText("");
        textEffect("You hear a slow and sinister laugh come from behind you...\n");
        userWait();
        run.output.setText("");
        Playlist.playSong("/sounds/CarnivalFight.wav");
        MonsterManager.spawn(new KillerClown());
        run.clownFight(3,6,1,2,0,0,1,4);
        if(Player.alive == true)
        {
        	MonsterManager.winLoot();
            run.output.setText("");
            complete = true;
        }
     }

    }
    complete = false;
    Player.scene++;
    if(Player.alive == true)
    {
    saveAsk();
       }
 }
 
 if(p == 13)
 {
     firstTime = true;
     Shop.newVisit = true;
     while(complete == false && Player.alive == true)
    {
      if(firstTime == false)
      {
        roadChoice();
      run.output.setText("");
      textEffect("          \n\n\n\n\n         *You start heading towards " + location[path] + "*");
      run.append("\n\n\n\n      'Press Enter to Conintue'");
      run.getReset();
      run.getString();
      run.output.setText("");
      run.fontSize(20);
      randEncounter(Player.level);
    }
     if(path == 0 && Player.alive == true)
     {
        if(firstTime == false)
        {
            carnivalArrive();
          
        }
        Dungeon.carnival();
        firstTime = false;
     }
     if(path == 1 && Player.alive == true)
     {
    	 if(firstTime == false)
         {
    		 mineArrive();
         }
        DungeonTwo.mine();
      firstTime = false;
     }
    }
     
     run.output.setText("");
     run.fontSize(20);
    }
 
}


public static boolean lockedDoor(String n,int amt,boolean r) throws InterruptedException
{
    lockedDoor = true;
    boolean choice;
    boolean leave = false;
    while(leave == false)
    {
        direction = 0;
        choice = false;
        run.output.setText("                                                                       Open Backpack[b]\n");
        run.fontSize(22);
        run.append("          ______________\n");
        run.append("        |\\ ___________ /|\n");
        run.append("        | |  _ _ _ _  | |\n");
        run.append("        | | | | | | | | |\n");
        run.append("        | | |-+-+-+-| | |\n");
        run.append("        | | |-+-+=+%| | |\n");
        run.append("        | | |_|_|_|_| | |\n");
        run.append("        | |    ___    | |\n");
        run.append("        | |   [___] ()| |\n");
        run.append("        | |           | |\n");
        run.append("        | |         ||| |\n");
        run.append("        | |         ()| |\n");
        run.append("        | |           | |\n");
        run.append("        | |           | |\n");
        run.append("        | |           | |\n");
        run.append("        |_|___________|_|\n\n");

        run.append("    Requires: " + n + " x" + amt);
        run.append("                                      <----Back | Proceed---->");
       while(choice == false)
       {
    	   System.out.println("KeyHandler Looping");
        if(bPressed == true)
        {
            bPressed = false;
            choice = true;
            BackPack.Manager.open();
        }
        if(direction == -1)
        {
            lockedDoor =false;
            choice = true;
            leave = true;
            return false;
        }
        if(direction == 1)
        {
            if(BackPack.Manager.checkItem(n,amt) == true)
             {
                 choice = true;
                 leave = true;
                 if(r == true)
                    BackPack.Manager.remove(n,amt);
                 Playlist.playEffect("/sounds/DoorOpen.wav");
                 run.output.setText("                                                                       Open Backpack[b]\n");
                 run.fontSize(22);
                 run.append("          ______________\n");
                 run.append("        |\\ ___________ /|\n");
                 run.append("        | |  /|,| |   | |\n");
                 run.append("        | | |,x,| |   | |\n");
                 run.append("        | | |,x,' |   | |\n");
                 run.append("        | | |,x   ,   | |\n");
                 run.append("        | | |/    |   | |\n");
                 run.append("        | |    /] ,   | |\n");
                 run.append("        | |   [/ ()   | |\n");
                 run.append("        | |       |   | |\n");
                 run.append("        | |       |   | |\n");
                 run.append("        | |       |   | |\n");
                 run.append("        | |      ,'   | |\n");
                 run.append("        | |   ,'      | |\n");
                 run.append("        |_|,'_________|_|\n");
                 run.append("        |_|___________|_|\n\n");

                 run.append("    The door has been opened!");
                 run.append("                                      <----Back | Proceed---->");
                 pause(1500);
                 lockedDoor = false;
                 return true;
              }
            else
            {
                Playlist.playEffect("/sounds/Error.wav");
                run.append("\n You don't have the required materials!");
                pause(1500);
                choice = true;
                
            }
        }
      }
    }
    lockedDoor = false;
    return false;
}
 
public static void isBPressed(boolean b)
{
    bPressed = b;
}

public static void roadChoice()
{
    run.output.setText("");
    Playlist.playSong("/sounds/Nature.wav");
    direction = 1;
    select = false;
    atRoads = true;
    
    run.fontSize(30);
      textEffect("\n                       Which way will you go?\n\n");
      
      run.append("   =============   =============   =============   =============\n");
      run.append("  > El Carnival     Grand Mines      Misty Mts.    Heaven's Door\n");
      run.append("   =============   =============   =============   =============\n\n\n\n");
      run.append("                    <-----EASY------HARD----->");
      
      while(select == false)
    {
    	  System.out.println("KeyHandler Looping");
      if(direction == 1)
      {
          run.output.setText("");
      run.append("\n                       Which way will you go?\n\n");
      
      run.append("   =============   =============   =============   =============\n");
      run.append("  > El Carnival     Grand Mines      Misty Mts.    Heaven's Door\n");
      run.append("   =============   =============   =============   =============\n\n\n\n");
      run.append("                    <-----EASY------HARD----->");
      direction = -4;
      System.out.print(direction);
      path = 0;

     }
      else if(direction == 2)
      {
           run.output.setText("");
      run.append("\n                       Which way will you go?\n\n");
      
      run.append("   =============   =============   =============   =============\n");
      run.append("    El Carnival   > Grand Mines      Misty Mts.    Heaven's Door\n");
      run.append("   =============   =============   =============   =============\n\n\n\n");
      run.append("                    <-----EASY------HARD----->");
      direction = -3;
      path = 1;
     }
      else if(direction == 3)
      {
           run.output.setText("");
      run.append("\n                       Which way will you go?\n\n");
      
      run.append("   =============   =============   =============   =============\n");
      run.append("    El Carnival     Grand Mines    > Misty Mts.    Heaven's Door\n");
      run.append("   =============   =============   =============   =============\n\n\n\n");
      run.append("                    <-----EASY------HARD----->");
      direction = -2;
      path = 2;
     }
      else if(direction == 4)
      {
           run.output.setText("");
      run.append("\n                       Which way will you go?\n\n");
      
      run.append("   =============   =============   =============   =============\n");
      run.append("    El Carnival     Grand Mines      Misty Mts.  > Heaven's Door\n");
      run.append("   =============   =============   =============   =============\n\n\n\n");
      run.append("                    <-----EASY------HARD----->");
      direction = -1;
      path = 3;
     }
    }
    atRoads = false;
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



public static void checkEnter(boolean b)
{
    select = b;
}

public static void setDirection(int d)
{
    direction = d;
}



public static void saveAsk() throws InterruptedException
{
    boolean finish = false;
    while(finish == false){
    run.output.setText("");
    run.append("Would you like to save your progress? [y/n]");
    String answer = run.getString();
    run.output.setText("");
    if(answer.equals("y"))
    {
        run.append("Select a slot you wish to save your progress\n");
        for(int i = 0;i<Player.saveGameInfo.length;i++)
        {
            run.append("[" + (i+1) + "] - " + Player.saveGameInfo[i] + "\n");
        }
        int fileSlot = run.getInt();
        if(!(Player.saveGameInfo[fileSlot-1].equals("{Empty}")))
        {
            run.append("\nAre you sure you want to overright slot: " + fileSlot + "?[y/n]");
            answer = run.getString();
            if(answer.equals("y"))
            {
                run.append("\n\n Type your name to identify this save file as yours: ");
                String fileDesc = run.getString();
        
                Player.saveGameInfo[fileSlot-1] = "{" + fileDesc + " | Level: " + Player.level + " " + Player.title + " | chapter: " + Player.part + " | Difficulty: " + Player.adifficulty + "}";
                Player.save(fileSlot);
                run.append("\n\nGame successfully saved to slot: " + (fileSlot));
                Save.saveFile(Player.saveGameInfo);
                userWait();
                run.output.setText("");
                finish = true;
            }
        }
        else if(Player.saveGameInfo[fileSlot-1].equals("{Empty}"))
        {
        run.append("\n\n Type your name to identify this save file as yours: ");
        String fileDesc = run.getString();
        
        Player.saveGameInfo[fileSlot-1] = "{" + fileDesc + " | Level " + Player.level + ": " + Player.title + " | chapter: " + Player.part + " | Difficulty: " + Player.adifficulty + "}";
        Player.save(fileSlot);
        run.append("\n\nGame successfully saved to slot: " + (fileSlot));
        Save.saveFile(Player.saveGameInfo);
        userWait();
        run.output.setText("");
        finish = true;
    }
   }
   else
    finish = true;
    run.output.setText("");
  }
}



public static void textEffect(String n)
{
    for(int i = 0;i<n.length();i++)
    {
      run.append(n.substring(i,i+1));
      pause(10);
    }
}

public static void textEffect(String n,Color c,boolean b)
{
    for(int i = 0;i<n.length();i++)
    {
      run.append(n.substring(i,i+1),c,0,b);
      pause(10);
    }
}

public static void textEffect(String n,Color c,int s,boolean b)
{
    for(int i = 0;i<n.length();i++)
    {
      run.append(n.substring(i,i+1),c,s,b);
      pause(10);
    }
}

public static void textEffect(String n, String n2,String n3,Color c,Color cb)
{
	String output = "";
	String output2 = "";
	String output3 = "";
  if(n.length() == n2.length() && n.length() == n2.length()) {
	  
    for(int i = 0;i<n.length();i++)
    {
    	run.output.setText("");
    	output = n.substring(0,i+1) + "\n";
    	output2 = n2.substring(0,i+1) + "\n";
    	output3 = n3.substring(0,i+1) + "\n";
      run.append(output,output2,output3,c,cb);
      pause(10);
    } 
   }else
    	System.out.println(n.length()+ " " + n2.length() + " " + n3.length());
  
  }




public static String input() throws InterruptedException
{
	run.getReset();
	String s = run.getString();
	return s;
}


public static void randEncounter(int lvl) throws Exception
{
    int times = (int)(Math.random() * 3) + 1;
    for(int i = 0;i < times;i++)
    {
       if(Player.alive == true)
       {
       if(lvl < 17)
       {
           int foe = (int)(Math.random() * 5) + 1;
           if(foe == 1)
           {
               deathMsg = "Just wait and meet the Tesla cat...\n";
               MonsterManager.spawn(new PlasmaDog());
           run.ElectricBeastFight(3,3,5,2);
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
          if(foe == 2)
           {
             deathMsg = "Wolves hit hard and are fast. Kill them with magic.\n";
             MonsterManager.spawn(new ForestWolf());
           run.beastFight(4,5);
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
          if(foe == 3)
           {
               deathMsg = "Wolves hit hard and are fast. Kill them with magic.\n";
               MonsterManager.spawn(new Werewolf());
           run.beastFight(3,10);
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
          if(foe == 4)
           {
               deathMsg = "Your innards were stuffed into colorful socks...\n";
               MonsterManager.spawn(new SockDemon());
           run.TrollFight(10,2,2,2,1,5);
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
          if(foe == 5)
           {
               deathMsg = "Is it even possible to die to a pink slug???\n";
               MonsterManager.spawn(new PinkSlug());
           run.fight();
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
       }
       else if(lvl >= 17)
       {
           int foe = (int)(Math.random() * 5) + 1;
           if(foe == 1)
           {
           deathMsg = "Better. Faster. Stronger.\n";
           MonsterManager.spawn(new TeslaCat());
           run.ElectricBeastFight(3,8,6,4);
           if(Player.alive == true)
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
          if(foe == 2)
           {
               deathMsg = "Ogres are large and tanky. Bring fire and potions.\n";
               MonsterManager.spawn(new Ogre());
           run.beastFight(2,20);
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
          if(foe == 3)
           {
               deathMsg = "Your innards were stuffed into colorful socks...\n";
               MonsterManager.spawn(new SockDevil());
           run.TrollFight(13,3,2,2,3,10);
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
          if(foe == 4)
           {
               deathMsg = "Is it even possible to die to a pink slug???\n";
               MonsterManager.spawn(new PinkSlug());
           run.fight();
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
          if(foe == 5)
           {
               deathMsg = "The Gargoyle, a virgin's worst nightmare.\n";
               MonsterManager.spawn(new Gargoyle());
           run.fight();
           if(Player.alive == true )
        	   MonsterManager.winLoot();
            RPGRunner.flee = false;
          }
        }
      }
    }
    
}









public static void carnivalArrive() throws InterruptedException
{
     run.output.setText("");
          run.fontSize(30);
       run.append("                           @-.\n");
       run.append("                          _  )\\\\  _  \n");
       run.append("                          / \\/ | \\/ \\\n");
       run.append("                         @/`|/\\/\\/|`\\@\n");
       run.append("                            /~~~~~\\\n");
       run.append("                           |  ^ ^  |\n");
       run.append("                           |   .   |\n");
       run.append("                           | (\\_/) |\n");
       run.append("                        .-'-\\ \\_/ /-'-.\n");
       run.append("                       / .-. \\___/ .-. \\\n");
       run.append("                      @/` /.-.   .-.\\ `\\@\n");
       run.append("                         @`   \\ /   `@\n");
       run.append("                               @\n");
       pause(500);
       textEffect("\n               ~You have arrived at El Carnival~");
       pause(3300);
       run.output.setText("");
       Playlist.playEffect("/sounds/GateClose.wav");
       textEffect("\n\n\n\n               *The carnival gates close behind you...*");
       pause(2500);
       run.output.setText("");
}




public static void mineArrive() throws InterruptedException
{
     run.output.setText("");
          run.fontSize(30);
            run.append("                             ,-' ;  ! `-.");
          run.append("\n                            / :  !  :  . \\");
          run.append("\n                           |_ ;   __:  ;  |");
          run.append("\n                           )| .  :)(.  !  |");
          run.append("\n                           |\"    (##)  _  |");
          run.append("\n                           |  :  ;`'  (_) (");
          run.append("\n                           |  :  :  .     |");
          run.append("\n                           )_ !  ,  ;  ;  |");
          run.append("\n                           || .  .  :  :  |");
          run.append("\n                           |\" .  |  :  .  |");
          run.append("\n                           |._.._;----.___|");
       pause(500);
               textEffect("\n\n                ~You have arrived at The Grand Mines~");
       pause(3300);
       run.output.setText("");
       textEffect("\n\n\n\n                *It smells of sulfur and sadness...*");
       pause(2500);
       run.output.setText("");
}










	public static void mainFight() throws Exception
	{
		run.mainFight();
	}







    public static void bossScreen() throws InterruptedException
    {
    	
    for(int i=0;i<9;i++)
    {
        run.output.setText("");
     run.append(" |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n",Color.WHITE,20,false);
     run.append(" ||                                                                                                   ||\n",Color.WHITE,20,false);          
     run.append(" ||            ___    ____   _____   _____         ______  ___ ___  _______  _     _  _______         ||\n",Color.WHITE,20,false);
     run.append(" ||           |   |  |    | |       |             |           |     |        |     |     |            ||\n",Color.WHITE,20,false);
     run.append(" ||           |   /  |    | |       |             |           |     |        |     |     |            ||\n",Color.WHITE,20,false);
     run.append(" ||           |---   |    | |=====  |=====        |======     |     |   ___  |=====|     |            ||\n",Color.WHITE,20,false);
     run.append(" ||           |   \\  |    |       |       |       |           |     |      | |     |     |            ||\n",Color.WHITE,20,false);
     run.append(" ||           |___|  |____|  _____|  _____|       |        ___|___  |______| |     |     |            ||\n",Color.WHITE,20,false);
     run.append(" ||                                                                                                   ||\n",Color.WHITE,20,false);   
     run.append(" ||                                                                                                   ||\n",Color.WHITE,20,false);
     run.append(" |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n",Color.WHITE,20,false);
      run.append("                                                ____\n",Color.RED,20,false);
   run.append("                                              ,'   Y`.\n",Color.RED,20,false);
    run.append("                                             /        \\\n",Color.RED,20,false);                                            
     run.append("                                             \\ ()  () /\n",Color.RED,20,false);
     run.append("                                              `. /\\ ,'\n",Color.RED,20,false);
  run.append("                                          8====| '' |====8\n",Color.RED,20,false);
    run.append("                                               `LLLU'\n",Color.RED,20,false);
    
    pause(200);
    run.output.setText("");
    pause(100);
    
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
}
