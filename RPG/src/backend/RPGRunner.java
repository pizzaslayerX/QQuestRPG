package backend;
import java.util.Scanner; 
import static java.lang.System.*;
import java.util.concurrent.TimeUnit;

import backend.*;
import consumables.*;
import gameplay.*;
import monsters.MonsterManager;

import javax.swing.*;
import javax.swing.border.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;

public class RPGRunner extends JPanel
{

	public static MainFightPanel fightGUI;
	public static LibraScreen libraGUI;
    public static JTextPane output,enemyStatOutput;
    public JTextField input;
    public JFrame frame;
    public FlowLayout layout;
    public JLabel label;
    public static JPanel textPanel;
    public JPanel inputPanel,fightPanel;
    ActionHandler actionHandler = new ActionHandler(this);
    KeyHandler keyHandler = new KeyHandler(this);
    public static Story story;
    public static Level level;
    public static backpack.Manager backpack;
    public static Player player;
    public static Tutorial tutorial;
    public static ItemManager item;
    public static LootScreen loot;
    public static Shop shop;
    public static crafting.List list;


    public static Ability.Actives.Manager ability;
    public static monsters.Beabzle beabzle;
    public static Casino casino;
    public static DungeonTwo mine;
    public static Chest chest;
    public static Dungeon dungeon;
    
    public static boolean cutscene = false;
    public static boolean pTurn = true;
    public static boolean eTurn = false, mTurn,enemyDead = false;;
    public static boolean battle;
    public static boolean minion = false;
    public static int round = 1, target = 0, monsterTurn = 0;
    public static boolean flee = false;
    public RPGRunner() throws Exception
    {
       
        initialize();
       
        String appData = System.getenv("APPDATA");
        File f = new File(appData+ "/.manaquest/setUp.ser");
        if(f.exists())
           SetUp.loadDirectory();
        if(SetUp.dirDone == false)
        {
        	fontSize(35);
        	 Story.textEffect("Welcome.\n");
        	 pause(1000);
        	 Story.textEffect("Would you like to Censor Profanity? Yes[y] or No[n]\n");
         	Story.textEffect("This setting CANNOT be changed");
         	actionHandler.reset();
         	String censor = getString();
         	if(censor.equals("n"))
         		SetUp.censor = false;
         	else
         		SetUp.censor = true;
         	output.setText("");
             Story.textEffect("Please create a directory for ManaQuest to access.\n");
        	SetUp.newDirectory();
        	output.setText("");
        
        	fontSize(20);
        	
        }
        boolean correct = false;
        Player.newPlayer();
        gameplay.Save.loadFile();
        Playlist.init();
        
        append("\n\n\n                                      ManaQuest RPG(Alpha 1.6.1)\n");
              append("                                       Made By: Quincy Johnson");
        String dif = "";
        append("\n\n\n\n                            ==================          ==================");
        append("\n                               LOAD GAME(1)                 NEW GAME(2)");
        append("\n                            ==================          ==================");
        String answer;
        int manswer = getInt();
        if(manswer == 1)
        {
            output.setText("");
            gameplay.Player.load();
            fontSize(20);
            output.setText("");
        }
        else 
        { 
            output.setText("");
        while(correct == false){
                        actionHandler.reset();
            append("Select your difficulty: ");
            append("Easy",Color.GREEN,20,false);append("[e] ");
            append("Medium",Color.YELLOW,20,false);append("[m] ");
            append("Hard",Color.RED,20,false);append("[h]:\n");
            dif = getString();
            if(dif.equals("e"))
            {
                Player.adifficulty = "Easy";
                correct = true;
                append("You selected EASY mode. Enemies are much weaker.\n");
            }
            else if(dif.equals("m"))
            {
                Player.adifficulty = "Medium";   
                correct = true;
                append("You selected MEDIUM mode. Nothing else to say here.\n");
            }
            else if(dif.equals("h"))
            {
                Player.adifficulty = "Hard";
                correct = true;
                append("You selected HARD mode. Enemies are pretty brutal. For the best of gamers.\n");
            }
            else
                append("Please select an appropriate difficulty.\n"); 
        }
          monsters.SetStats.setDifficulty(dif);
          monsters.SetStats.setStats();
        pause(2000);
       actionHandler.reset();
        append("Would you like to view the tutorial [y/n]?\n");
        
        answer = getString();
        if(answer.equals("n")){
            output.setText("");
            
        }
        else {
            output.setText("");
            Tutorial.tutorFight();
        }
              
        }
        for(int chpt = gameplay.Player.scene;chpt < 20;chpt++)
        {
            story.part(chpt);
        if(player.alive == false)
        {
        	monsters.MonsterManager.enemies.clear();
        	monsters.MonsterManager.enemyStatuses.clear();
        	monsters.MonsterManager.deadEnemies.clear();
            fontSize(20);
            Player.mana = Player.maxMana;
            Player.health = Player.maxHealth;
            int goldFee = (Player.gold / 10);
            Player.gold = Player.gold - goldFee;
             append("Fee for reincarnation: " + goldFee + " gold\n");
            pause(2000);
             append("You recieved a random item out of pity\n");
             userWait();
            int threshold = 1 + (int)(Math.random() * 100);
            if(threshold < 5)
            consumables.Elixer.newItem();
            else if(threshold < 40 && threshold > 5)
            consumables.HighPotion.newItem();
            else if(threshold < 65 && threshold > 40)
            consumables.MegaPotion.newItem();
            else
            consumables.Potion.newItem();
            player.alive = true;
            chpt--;
            output.setText("");
        }
        }
   }
    
    
    
    
    
    
    
    public void mainFight() throws Exception
    {
    	target = 0;
    	flee = false;
        battle = true;
        if(monsters.MonsterManager.enemies.get(0).getSong() != null && !(monsters.MonsterManager.enemies.get(0).getSong().equals("")))
        	Playlist.playSong("/sounds/" + monsters.MonsterManager.enemies.get(0).getSong());
    	newFight(monsters.MonsterManager.enemies.get(0).getPic());
    	MonsterManager.setNames();
       
        
        while(battle == true && !(player.health <= 0 || monsters.MonsterManager.enemies.size() <= 0))
        {
        	target = 0;
        	for(int g =0;g<monsters.MonsterManager.enemies.get(target).getUseCounter().length;g++)
        	    System.out.println("\n" + monsters.MonsterManager.enemies.get(target).getUseCounter()[g]);
            output.setText("");
            System.out.println("\n Def:" + monsters.MonsterManager.enemies.get(target).getDef());
            statusEffect.Player.getEffects(round);
            while(pTurn == true && !(player.health <= 0 || monsters.MonsterManager.enemies.size() <= 0))
            {
            	
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                  
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                   else if(statusEffect.Player.disableActive == false && MainFightPanel.getTarget() == true) {
                    	MainFightPanel.clearDisplay();
                    if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(target).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(target).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(target).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(target).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(target).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(target).getDamage();
                    monsters.MonsterManager.enemies.get(target).getResist();
                    monsters.MonsterManager.enemies.get(target).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(target).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(target).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                  }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
                
            }
            for(int m = 0;m<monsters.MonsterManager.enemies.size();m++) {
            	if(monsters.MonsterManager.enemies.get(m).getDeath()){
            		for(int i=m;i<monsters.MonsterManager.enemies.size();i++) {
            			monsters.MonsterManager.enemyStatuses.get(i).id--;
            		}
            		m--;
            	}
            }
            eTurn = true;
            pTurn = false;
            pause(1500);
            		
           for(int m = 0;m<monsters.MonsterManager.enemies.size();m++) {
        	   target = m;
        	  
        		   MainFightPanel.changePic(MonsterManager.enemies.get(m).getPic());
               MainFightPanel.clearDisplay();
               MainFightPanel.clearEnemyDisplay();
            mTurn = true;
        	monsterTurn = m;
        	monsters.MonsterManager.enemyStatuses.get(m).getEffects(round);
        	
        	if(monsters.MonsterManager.enemies.get(m).getDeath()) {
                for(int i=m;i<monsters.MonsterManager.enemies.size();i++) {
                	monsters.MonsterManager.enemyStatuses.get(i).id--;
                }
                enemyDead = true;
            		m--;
        	}else
        		enemyDead = false;
        if(enemyDead == false) {
            String action = monsters.MonsterManager.enemies.get(m).action();
            while(mTurn == true && eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.size() <= 0))
            {
            	int abilityId = 99;
            	int statusSlot = 1;
            	int triggerSpotLow = 0;
            	int triggerSpotHigh = 1;
            	int abilityUsed = 1;
                int abilityMax = 0;
            	boolean fail = true;
            	int threshold = (int)(Math.random() * 100);
            	System.out.println("\n\n\n"+ threshold);
            if(monsters.MonsterManager.enemyStatuses.get(m).silenceActive == false)
            	for(int i = 0;i<monsters.MonsterManager.enemies.get(m).getTotal();i++)
            	{
            		System.out.println("total: " + monsters.MonsterManager.enemies.get(m).getTotal() + " | i = " + i);
            		abilityId++;
            		if(i > 0)
            		{
            			for(int p = 0;p<monsters.MonsterManager.enemies.get(m).getStatusEffect().length;p++)
            			{
            				if(monsters.MonsterManager.enemies.get(m).getStatusEffect()[p] == abilityId)
            					statusSlot = p + 1;
            			}
            			triggerSpotLow+=2;
            			triggerSpotHigh+=2;
            			abilityUsed+=2;
            			abilityMax+=2;
            		}
            		if(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(m).getHealth() <= 0))
            		{
            			fail = true;
            			if(threshold < monsters.MonsterManager.enemies.get(m).getTriggerRate()[triggerSpotHigh] && threshold >= monsters.MonsterManager.enemies.get(m).getTriggerRate()[triggerSpotLow] && monsters.MonsterManager.enemies.get(m).getUseCounter()[abilityUsed] < monsters.MonsterManager.enemies.get(m).getUseCounter()[abilityMax])
            			{
            				monsters.MonsterManager.enemies.get(m).getUseCounter()[abilityUsed]++;
            				fail = false;
            				MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(m).getAtkMsg()[i]+"\n");
            				Playlist.playEffect("/sounds/" + monsters.MonsterManager.enemies.get(m).getSound()[i]);
            				pause(2500);
            				if(monsters.MonsterManager.enemies.get(m).getDmg()[i] > 0)
            				{
            					MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
            					MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(m).getDmg()[i]+"",Color.RED,20,true);
            					MainFightPanel.append(MainFightPanel.user," HP.\n");
            					Player.health = Player.health - monsters.MonsterManager.enemies.get(m).getDmg()[i];
            					pause(2000);
            					MainFightPanel.clearDisplay();
            		            MainFightPanel.clearEnemyDisplay();
            				      
            				}
            				for(int w = 0;w<monsters.MonsterManager.enemies.get(m).getStatusEffect().length;w++)
            				{
            					if(monsters.MonsterManager.enemies.get(m).getStatusEffect()[w] == abilityId)
            					{
            						int eNum = 1;
            				         for(int q = 0; q < monsters.MonsterManager.enemies.get(m).getStatusEffect()[statusSlot]; q++)
            				         {
            				         int one = monsters.MonsterManager.enemies.get(m).getStatusEffect()[statusSlot + eNum];
            				         int two = monsters.MonsterManager.enemies.get(m).getStatusEffect()[statusSlot+ 1 + eNum];
            				         int three = monsters.MonsterManager.enemies.get(m).getStatusEffect()[statusSlot + 2 + eNum];
            				         statusEffect.Identifier.set(one,two,three);
            				         eNum = eNum + 3;
            				        }
            					}
            				}
            				
            				if(monsters.MonsterManager.enemies.get(m).getUseTurn()[i] == true)
            				{
            					mTurn = false;
            					break;
            				}
            				
            			}
            		}
            	}
            	if(fail == true)
            	{
            		MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(m).getName() + ": " + action + "\n");
                pause(1500);
                if(action.equals("attacks"))
                {
                    Ability.Passives.Evade.use();
                    if(Player.getEvade())
                    {
                        Playlist.playEffect("/sounds/Miss.wav");
                        MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + monsters.MonsterManager.enemies.get(m).getName());
                        MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    Ability.Passives.Evade.evade = false;
                    break;
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    player.getDamage(monsters.MonsterManager.enemies.get(m));
                    player.getResist();
                    player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                    Playlist.playEffect("/sounds/MultiHit.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(m).getName() + ": " + monsters.MonsterManager.enemies.get(m).getAttackNames()[ran] + " you.\n");
                    pause(1500);
                    MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                    MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.user, " HP\n");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    break;
                   }
                }
                else if(action.equals("flees"))
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\nThe enemy ran away!\n",Color.ORANGE,22,true);
                    
                    pause(3000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    MonsterManager.enemies.remove(m);
                    MonsterManager.enemyStatuses.remove(m);
                    for(int i=m;i<monsters.MonsterManager.enemies.size();i++) {
                    	monsters.MonsterManager.enemyStatuses.get(i).id--;
                    }
                    m--;
                    mTurn = false;
                }
            	}
             }
            }
           }
            round++;
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            if(Ability.Passives.Guardian.use() == true && Player.health <= 0)
            {
            	textPanel.setVisible(true);
            	fightGUI.setVisible(false);
            	input.grabFocus();
                Ability.Passives.Guardian.battleUse = true;
                Player.health = 1;
                Player.alive = true;
                append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
                output.setText("");
                pause(3000);
                 Playlist.playEffect("/sounds/Heal.wav");
                append("*You feel a fire growing inside you*\n");
                pause(2500);
                append("You can't give up now!\n\n",Color.GREEN,30,true);
                userWait();
                output.setText("");
                MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
                textPanel.setVisible(false);
            	fightGUI.setVisible(true);
            }
        }
        if(Story.path == 1)
        	Playlist.playSong("/sounds/MineTheme.wav");
        if(player.health <= 0)
        {
        	textPanel.setVisible(true);
        	fightGUI.setVisible(false);
            player.alive = false;
            input.grabFocus();
            Player.health = Player.maxHealth;
            append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
            pause(3000);
            output.setText("");
            append("" + Story.deathMsg,Color.WHITE,22,false);
            userWait();
            output.setText("");
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
        }
        else if(MonsterManager.enemies.size() == 0)
        {
        	textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            output.setText("");
        }
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        battle = true;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
    }
    	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void fight() throws Exception
    {
        flee = false;
        battle = true;
    	newFight(monsters.MonsterManager.enemies.get(0).getPic());
    	MonsterManager.setNames();
        while(battle == true && !(player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
        {
            
            statusEffect.Player.getEffects(round);
            while(pTurn == true && !(player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                	MainFightPanel.clearDisplay();
                  if(MainFightPanel.getTarget() == true) {
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                    else if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(0).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(0).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(0).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(0).getDamage();
                    monsters.MonsterManager.enemies.get(0).getResist();
                    monsters.MonsterManager.enemies.get(0).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(0).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                  }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
            }
            eTurn = true;
            pause(1500);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            monsters.MonsterManager.enemyStatuses.get(0).getEffects(round);
            String action = monsters.MonsterManager.enemies.get(0).action();
            while(eTurn == true && !(player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
            	MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": " + action + "\n");
                pause(1500);
                if(action.equals("attacks"))
                {
                    Ability.Passives.Evade.use();
                    if(Player.getEvade())
                    {
                        Playlist.playEffect("/sounds/Miss.wav");
                        MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + monsters.MonsterManager.enemies.get(0).getName());
                        MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    Ability.Passives.Evade.evade = false;
                    pTurn = true;
                    eTurn = false;
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    player.getDamage(monsters.MonsterManager.enemies.get(0));
                    player.getResist();
                    player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                    Playlist.playEffect("/sounds/MultiHit.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                    pause(1500);
                    MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                    MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.user, " HP\n");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                   }
                }
                else if(action.equals("flees"))
                {
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\nThe enemy ran away!\n",Color.ORANGE,22,true);
                    flee = true;
                    battle = false;
                    eTurn = false;
                    pause(3000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    MonsterManager.enemies.remove(0);
                    MonsterManager.enemyStatuses.remove(0);
                    textPanel.setVisible(true);
                	fightGUI.setVisible(false);
                	
                }
            }
            round++;
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            if(Ability.Passives.Guardian.use() == true && Player.health <= 0)
            {
                output.setText("");
                textPanel.setVisible(true);
            	fightGUI.setVisible(false);
            	input.grabFocus();
                Ability.Passives.Guardian.battleUse = true;
                Player.health = 1;
                Player.alive = true;
                append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
                output.setText("");
                pause(3000);
                 Playlist.playEffect("/sounds/Heal.wav");
                append("*You feel a fire growing inside you*\n");
                pause(2500);
                append("You can't give up now!\n\n",Color.GREEN,30,true);
                userWait();
                output.setText("");
                MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
                textPanel.setVisible(false);
            	fightGUI.setVisible(true);
            }
        }
        if(player.health <= 0)
        {
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
            player.alive = false;
            input.grabFocus();
            Player.health = Player.maxHealth;
            append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
            pause(3000);
            output.setText("");
            append("" + Story.deathMsg,Color.WHITE,22,false);
            userWait();
            output.setText("");
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
        }
        else if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            output.setText("");
            monsters.MonsterManager.enemies.get(0).getDeath();
        }
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        battle = true;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
    }

    
    
    
    
        public void rasgothFight() throws Exception
    {
        	
        int summonMinion = 0;
        battle = true;
        newFight(monsters.MonsterManager.enemies.get(0).getPic());
        MonsterManager.setNames();
        while(battle == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
        {
            statusEffect.Player.getEffects(round);
            while(pTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                	MainFightPanel.clearDisplay();
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                    else if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(0).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(0).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(0).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(0).getDamage();
                    monsters.MonsterManager.enemies.get(0).getResist();
                    monsters.MonsterManager.enemies.get(0).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(0).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
            }
            eTurn = true;
            pause(2000);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            monsters.MonsterManager.enemyStatuses.get(0).getEffects(round);
            while(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                int threshold = 1 + (int)(Math.random() * 100);
                 if(threshold < 50 && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                    {
                        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": uses an ability\n");
                        pause(1500);
                        threshold = 1 + (int)(Math.random() * 100);
                        if(threshold < 20 && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                        {
                            Playlist.playEffect("/sounds/Fire.wav");
                            MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + " uses: ");
                            MainFightPanel.append(MainFightPanel.enemyStatOutput,"Molten Shower!\n",Color.ORANGE,20,true);
                            Player.dmgTaken = 5;
                            Player.getResist();
                            Player.loseHealth();
                            pause(1500);
                            MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                            MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                            MainFightPanel.append(MainFightPanel.user, " HP\n");
                            pause(2000);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                            statusEffect.Player.startBurn(3,6);
                            pTurn = true;
                            eTurn = false;
                        }
                        else if(threshold < 40 && threshold > 20 && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                        {
                            Playlist.playEffect("/sounds/ScaryFace.wav");
                            MainFightPanel.append( MainFightPanel.enemyStatOutput,"A bright light erupts from " + monsters.MonsterManager.enemies.get(0).getName() + "\n");
                            statusEffect.Player.startStun(2,0);
                            pause(3500);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                            pTurn = true;
                            eTurn = false;
                        }
                        else if(threshold > 40 && threshold < 65 && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                        {
                        	 MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + " uses: ");
                             MainFightPanel.append(MainFightPanel.enemyStatOutput,"Nova!\n",Color.ORANGE,20,true);
                            Playlist.playEffect("/sounds/Explosion.wav");
                            pause(2000);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                            MainFightPanel.append(MainFightPanel.user,"\n\nA fiery blast hits you!\n");
                            pause(2500);
                            MainFightPanel.append(MainFightPanel.user,"You lost ");
                            MainFightPanel.append(MainFightPanel.user,"8",Color.RED,20,true);
                            MainFightPanel.append(MainFightPanel.user," HP.");
                            Player.health = Player.health - 8;
                            pause(2000);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                        }
                        else if(threshold > 65 && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false && summonMinion < 1)
                        {
                            Playlist.playEffect("/sounds/Attack3.wav");
                            MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + " summons: ");
                            MainFightPanel.append(MainFightPanel.enemyStatOutput,"Hell Bat",Color.MAGENTA,20,true);
                            MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
                            pTurn = true;
                            eTurn = false;
                            pause(2500);
                            MainFightPanel.clearEnemyDisplay();
                           
                        }
                        else 
                        {
                            Playlist.playEffect("/sounds/ScaryFace.wav");
                            MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + " uses: ");
                            MainFightPanel.append(MainFightPanel.enemyStatOutput,"Surprise!\n",Color.BLUE,20,true);
                            statusEffect.Player.startSilence(1,0);
                            pause(2500);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                            append("You lost 4 HP.");
                            MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                            MainFightPanel.append(MainFightPanel.user,"4",Color.RED,20,true);
                            MainFightPanel.append(MainFightPanel.user," HP.");
                            Player.health = Player.health - 4;
                             pause(2000);
                             MainFightPanel.clearDisplay();
                             MainFightPanel.clearEnemyDisplay();
                            pTurn = true;
                            eTurn = false;
                        }
                    }
                else if((threshold > 50 && eTurn == true) || (threshold < 50 && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == true))
                {
                    Ability.Passives.Evade.use();
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": attacks\n");
                    pause(1500);
                    if(Player.getEvade())
                    {
                        Playlist.playEffect("/sounds/Miss.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + monsters.MonsterManager.enemies.get(0).getName());
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    Ability.Passives.Evade.evade = false;
                    pTurn = true;
                    eTurn = false;
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    player.getDamage(monsters.MonsterManager.enemies.get(0));
                    player.getResist();
                    player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                    Playlist.playEffect("/sounds/MultiHit.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                    pause(1500);
                    MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                    MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.user, " HP\n");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                   }
                }
                else if(threshold > 50 && threshold < 65)
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": ");
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"heals",Color.GREEN,20,true);
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,".\n");
                    pause(2500);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    monsters.MonsterManager.enemies.get(0).setHealth(monsters.MonsterManager.enemies.get(0).getHealth() + 10);
                    pTurn = true;
                    eTurn = false;
                }
                else
                {
                	MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + " charges for an attack.");
                pause(2500);
                MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
                pTurn = true;
                 eTurn = false;
               }
                }
            round++;
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            }
          Playlist.stopSong();
        if(Player.health <= 0)
        {
             Playlist.playSong("/sounds/CaveSound.wav");
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
            player.alive = false;
            input.grabFocus();
            Player.health = Player.maxHealth;
            append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
            pause(3000);
            output.setText("");
            append("" + Story.deathMsg,Color.WHITE,22,false);
            userWait();
            output.setText("");
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
        }
        else if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            output.setText("");
            append(monsters.MonsterManager.enemies.get(0).getName() + " has been destroyed!\n");
            monsters.MonsterManager.enemies.get(0).getDeath();
        }
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        summonMinion = 0;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
    }
    
    
    
    
    
            public void beabzlefight() throws Exception
    {
        Playlist.playSong("/sounds/RowdyRumble.wav");
        flee = false;
        battle = true;
        newFight(monsters.MonsterManager.enemies.get(0).getPic());
        int actAbility = 1;
        MonsterManager.setNames();
        
        while(battle == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
        {
            statusEffect.Player.getEffects(round);
            while(pTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                	MainFightPanel.clearDisplay();
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                    else if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(0).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(0).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(0).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(0).getDamage();
                    monsters.MonsterManager.enemies.get(0).getResist();
                    monsters.MonsterManager.enemies.get(0).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(0).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
            }
            eTurn = true;
            pause(2000);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            monsters.MonsterManager.enemyStatuses.get(0).getEffects(round);
            
            String action = monsters.MonsterManager.enemies.get(0).action();
            while(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                 if(round == actAbility &&  monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                    {
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": uses an ability\n");
                        pause(1500);
                        int threshold = 1 + (int)(Math.random() * 100);
                        if(threshold < 30 &&  monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                        {
                            Playlist.playEffect("/sounds/Fire.wav");
                            statusEffect.Player.startBurn(3,2);
                            pause(1000);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                            pTurn = true;
                            eTurn = false;
                        }
                        else if(threshold < 50 && threshold > 30 &&  monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                        {
                            Playlist.playEffect("/sounds/SoulSuck.wav");
                            statusEffect.Player.startSilence(2,0);
                            pause(1000);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                            pTurn = true;
                            eTurn = false;
                        }
                        else if(threshold > 50 &&  monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                        {
                            Playlist.playEffect("/sounds/MultiHit.wav");
                            MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + " ignites your soul!\n");
                            pause(1500);
                            MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                            MainFightPanel.append(MainFightPanel.user,"3",Color.RED,20,true);
                            MainFightPanel.append(MainFightPanel.user, " HP\n");
                            Player.health = Player.health - 3;
                            pause(2000);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                        }
                        actAbility = actAbility + 2;
                    }
                 else if(round == actAbility && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == true)
                    actAbility = actAbility + 1;
                     int threshold = 1 + (int)(Math.random() * 100);
                if(action.equals("attacks") && threshold < 60 && eTurn == true)
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": " + action + "\n");
                    pause(1500);
                    Player.getDamage(monsters.MonsterManager.enemies.get(0));
                    Player.getResist();
                    Player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                                           Playlist.playEffect("/sounds/MultiHit.wav");
                    
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                    pause(1500);
                    MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                    MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.user, " HP\n");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                }
                else if(action.equals("cures") && threshold < 0)
                {
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + " looks at you with distaste.");
                pause(2000);
                MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
                pTurn = true;
                 eTurn = false;
               }
                }
            round++;
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            }
          
        if(Player.health <= 0)
        {
        	textPanel.setVisible(true);
        	fightGUI.setVisible(false);
            player.alive = false;
            input.grabFocus();
            Player.health = Player.maxHealth;
            append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
            pause(3000);
            output.setText("");
            append("" + Story.deathMsg,Color.WHITE,22,false);
            userWait();
            output.setText("");
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
        }
        else if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
        	textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            output.setText("");
            append(monsters.MonsterManager.enemies.get(0).getName() + " has been defeated!\n");
            MonsterManager.enemies.get(0).getDeath();
        }
        Playlist.stopSong();
        Playlist.playSong("/sounds/CaveSound.wav");
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        actAbility = 1;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
    }
    
    
            
            
            
    
     public void TrollFight(int hitCount, int hitDmg,int stunDur, int silenceDur,int dmgInc,int hpInc) throws Exception
    {
        Playlist.playSong("/sounds/RowdyRumble.wav");
        
        battle = true;
        flee = false;
        newFight(monsters.MonsterManager.enemies.get(0).getPic());
        MonsterManager.setNames();
        while(battle == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
        {
            statusEffect.Player.getEffects(round);
            while(pTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                	MainFightPanel.clearDisplay();
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                    else if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(0).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(0).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(0).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(0).getDamage();
                    monsters.MonsterManager.enemies.get(0).getResist();
                    monsters.MonsterManager.enemies.get(0).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(0).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
            }
            eTurn = true;
            pause(2000);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            monsters.MonsterManager.enemyStatuses.get(0).getEffects(round);
            String action = monsters.MonsterManager.enemies.get(0).action();
            while(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                     int threshold = 1 + (int)(Math.random() * 100);
                if(threshold < 20 && eTurn == true && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": Dissapeared...\n");
                    pause(2000);
                    Playlist.playEffect("/sounds/ScaryFace.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + " suddenly scares you from behind!\n");
                    pause(2500);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.startStun(stunDur,0);
                    pause(1000);
                    statusEffect.Player.startSilence(silenceDur,0);
                    pause(1000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                }
                else if((threshold < 45 && threshold >= 20) && eTurn == true && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/Miss.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+MonsterManager.enemies.get(0).getName() + ": chucks it's belongings at you\n");
                    pause(2500);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.doMultiHit(hitCount,hitDmg);
                    pTurn = true;
                    eTurn = false;
                }
                else if((threshold < 60 && threshold >= 45) && eTurn == true && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/JokerLaugh.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": taunts you.\n");
                    pause(2000);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": +");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,""+dmgInc,Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," dmg\n");
                    pause(2000);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": +");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,""+hpInc,Color.GREEN,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    monsters.MonsterManager.enemies.get(0).setAttack(monsters.MonsterManager.enemies.get(0).getAttack() + dmgInc);
                    monsters.MonsterManager.enemies.get(0).setHealth(monsters.MonsterManager.enemies.get(0).getHealth() + hpInc);
                    if(monsters.MonsterManager.enemies.get(0).getHealth() > monsters.MonsterManager.enemies.get(0).getMaxHealth())
                        monsters.MonsterManager.enemies.get(0).setHealth(monsters.MonsterManager.enemies.get(0).getMaxHealth());
                }
                else if(action.equals("attacks") && (threshold >= 60) && eTurn == true)
                {
                    Ability.Passives.Evade.use();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": " + action + "\n");
                    pause(1500);
                    if(Player.getEvade())
                    {
                    	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + monsters.MonsterManager.enemies.get(0).getName());
                         MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                         MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                         pause(2000);
                         MainFightPanel.clearDisplay();
                         MainFightPanel.clearEnemyDisplay();
                         Ability.Passives.Evade.evade = false;
                         pTurn = true;
                    	eTurn = false;
                    
                    
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    player.getDamage(monsters.MonsterManager.enemies.get(0));
                    player.getResist();
                    player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                       Playlist.playEffect("/sounds/MultiHit.wav");
                      MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                        pause(1500);
                        MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                        MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                      MainFightPanel.append(MainFightPanel.user, " HP\n");
                      pause(2000);
                     MainFightPanel.clearDisplay();
                      MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                   }
                }
                 else if(action.equals("cures") && threshold >= 1000)
                {
                    pTurn = true;
                    eTurn = false;
                }
                }
            round++;
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            if(Ability.Passives.Guardian.use() == true && Player.health <= 0)
            {
            	 output.setText("");
                 textPanel.setVisible(true);
             	fightGUI.setVisible(false);
             	input.grabFocus();
                 Ability.Passives.Guardian.battleUse = true;
                 Player.health = 1;
                 Player.alive = true;
                 append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
                 output.setText("");
                 pause(3000);
                  Playlist.playEffect("/sounds/Heal.wav");
                 append("*You feel a fire growing inside you*\n");
                 pause(2500);
                 append("You can't give up now!\n\n",Color.GREEN,30,true);
                 userWait();
                 output.setText("");
                 MainFightPanel.clearDisplay();
                 MainFightPanel.clearEnemyDisplay();
                 textPanel.setVisible(false);
             	fightGUI.setVisible(true);
            }
            }
          
        if(Player.health <= 0)
        {
        	textPanel.setVisible(true);
        	fightGUI.setVisible(false);
            player.alive = false;
            input.grabFocus();
            Player.health = Player.maxHealth;
            append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
            pause(3000);
            output.setText("");
            append("" + Story.deathMsg,Color.WHITE,22,false);
            userWait();
            output.setText("");
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
        }
        else if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            output.setText("");
            monsters.MonsterManager.enemies.get(0).getDeath();
        }
        Playlist.stopSong();
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
    }
    
    
    
    
    
    
      public void beastFight(int hitCount, int hitDmg) throws Exception
    {
        battle = true;
        flee = false;
        boolean sAttack = false;
        newFight(monsters.MonsterManager.enemies.get(0).getPic());
        MonsterManager.setNames();
        while(battle == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
        {
            statusEffect.Player.getEffects(round);
            while(pTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                	MainFightPanel.clearDisplay();
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                    else if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(0).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(0).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(0).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(0).getDamage();
                    monsters.MonsterManager.enemies.get(0).getResist();
                    monsters.MonsterManager.enemies.get(0).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(0).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
            }
            eTurn = true;
            pause(2000);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            monsters.MonsterManager.enemyStatuses.get(0).getEffects(round);
            String action = monsters.MonsterManager.enemies.get(0).action();
            while(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                     int threshold = 1 + (int)(Math.random() * 100);
                if(threshold > 60 && sAttack == false && eTurn == true  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/BeastGrowl.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": savagely slashes you with it's claws!");
                    pause(2200);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.doMultiHit(hitCount,hitDmg);
                    sAttack = true;
                    pTurn = true;
                    eTurn = false;
                }
                else if(action.equals("attacks") &&  eTurn == true)
                {
                    Ability.Passives.Evade.use();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": " + action + "\n");
                    pause(1500);
                    if(Player.getEvade())
                    {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + monsters.MonsterManager.enemies.get(0).getName());
                       MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                       MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                       pause(2000);
                       MainFightPanel.clearDisplay();
                       MainFightPanel.clearEnemyDisplay();
                    Ability.Passives.Evade.evade = false;
                    pTurn = true;
                    eTurn = false;
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    player.getDamage(monsters.MonsterManager.enemies.get(0));
                    player.getResist();
                    player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                       Playlist.playEffect("/sounds/MultiHit.wav");
                       MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                       pause(1500);
                       MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                       MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user, " HP\n");
                         pause(2000);
                      MainFightPanel.clearDisplay();
                     MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                   }
                }
                 else if(action.equals("flees") && eTurn == true)
                {
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nThe enemy ran away!\n");
                    flee = true;
                    battle = false;
                    eTurn = false;
                    pause(2000);
                    textPanel.setVisible(true);
                	fightGUI.setVisible(false);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                }
                }
            round++;
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            if(Ability.Passives.Guardian.use() == true && Player.health <= 0)
            {
            	 output.setText("");
                 textPanel.setVisible(true);
             	fightGUI.setVisible(false);
             	input.grabFocus();
                 Ability.Passives.Guardian.battleUse = true;
                 Player.health = 1;
                 Player.alive = true;
                 append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
                 output.setText("");
                 pause(3000);
                  Playlist.playEffect("/sounds/Heal.wav");
                 append("*You feel a fire growing inside you*\n");
                 pause(2500);
                 append("You can't give up now!\n\n",Color.GREEN,30,true);
                 userWait();
                 output.setText("");
                 MainFightPanel.clearDisplay();
                 MainFightPanel.clearEnemyDisplay();
                 textPanel.setVisible(false);
             	fightGUI.setVisible(true);
            }
            }
          
        if(Player.health <= 0)
        {
        	textPanel.setVisible(true);
        	fightGUI.setVisible(false);
            player.alive = false;
            input.grabFocus();
            Player.health = Player.maxHealth;
            append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
            pause(3000);
            output.setText("");
            append("" + Story.deathMsg,Color.WHITE,22,false);
            userWait();
            output.setText("");
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
        }
        else if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            output.setText("");
            monsters.MonsterManager.enemies.get(0).getDeath();
        }
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        sAttack = false;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
    }
    
      
     public void ElectricBeastFight(int stunDur, int hitCount,int hitDmg,int specialMax) throws Exception
    {
    	 battle = true;
        flee = false;
        int special = 0;
        newFight(monsters.MonsterManager.enemies.get(0).getPic());
        MonsterManager.setNames();
        while(battle == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
        {
            statusEffect.Player.getEffects(round);
            while(pTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                	MainFightPanel.clearDisplay();
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                    else if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(0).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(0).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(0).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(0).getDamage();
                    monsters.MonsterManager.enemies.get(0).getResist();
                    monsters.MonsterManager.enemies.get(0).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(0).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
            }
            eTurn = true;
            pause(2000);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            monsters.MonsterManager.enemyStatuses.get(0).getEffects(round);
            String action = monsters.MonsterManager.enemies.get(0).action();
            while(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                     int threshold = 1 + (int)(Math.random() * 100);
                if(threshold < 31 && special < specialMax && eTurn == true  &&  monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/ShockSound.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": savagely assaults you!");
                    pause(2200);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.doMultiHit(hitCount,hitDmg);
                    special++;
                    pTurn = true;
                    eTurn = false;
                }
                if((threshold <= 60 && threshold >= 31) && special < specialMax && eTurn == true &&  monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/ShockLong.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nA jolt of ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"electricity",Color.YELLOW,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," shoots out from " + monsters.MonsterManager.enemies.get(0).getName() + "\n");
                    pause(2000);
                            statusEffect.Player.startStun(stunDur,0);
                            pause(3000);
                            MainFightPanel.clearDisplay();
                            MainFightPanel.clearEnemyDisplay();
                            special++;
                            pTurn = true;
                            eTurn = false;
                }
                if(action.equals("attacks") && eTurn == true)
                {
                    Ability.Passives.Evade.use();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": " + action + "\n");
                    pause(1500);
                    if(Player.getEvade())
                    {
                                               Playlist.playEffect("/sounds/Miss.wav");
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + monsters.MonsterManager.enemies.get(0).getName());
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                                               pause(2000);
                                               MainFightPanel.clearDisplay();
                                               MainFightPanel.clearEnemyDisplay();
                    Ability.Passives.Evade.evade = false;
                    pTurn = true;
                    eTurn = false;
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    player.getDamage(monsters.MonsterManager.enemies.get(0));
                    player.getResist();
                    player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                                           Playlist.playEffect("/sounds/MultiHit.wav");
                                           MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                                           pause(1500);
                                           MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                                           MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                                         MainFightPanel.append(MainFightPanel.user, " HP\n");
                                             pause(2000);
                                          MainFightPanel.clearDisplay();
                                         MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                   }
                }
                 else if(action.equals("flees") && eTurn == true)
                {
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nThe enemy ran away!\n");
                     flee = true;
                     battle = false;
                     eTurn = false;
                     pause(2000);
                     textPanel.setVisible(true);
                 	fightGUI.setVisible(false);
                     MainFightPanel.clearDisplay();
                     MainFightPanel.clearEnemyDisplay();
                }
                }
            round++;
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            if(Ability.Passives.Guardian.use() == true && Player.health <= 0)
            {
            	 output.setText("");
                 textPanel.setVisible(true);
             	fightGUI.setVisible(false);
             	input.grabFocus();
                 Ability.Passives.Guardian.battleUse = true;
                 Player.health = 1;
                 Player.alive = true;
                 append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
                 output.setText("");
                 pause(3000);
                  Playlist.playEffect("/sounds/Heal.wav");
                 append("*You feel a fire growing inside you*\n");
                 pause(2500);
                 append("You can't give up now!\n\n",Color.GREEN,30,true);
                 userWait();
                 output.setText("");
                 MainFightPanel.clearDisplay();
                 MainFightPanel.clearEnemyDisplay();
                 textPanel.setVisible(false);
             	fightGUI.setVisible(true);
            }
            }
          
        if(Player.health <= 0)
        {
        	textPanel.setVisible(true);
        	fightGUI.setVisible(false);
            player.alive = false;
            input.grabFocus();
            Player.health = Player.maxHealth;
            append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
            pause(3000);
            output.setText("");
            append("" + Story.deathMsg,Color.WHITE,22,false);
            userWait();
            output.setText("");
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
        }
        else if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            output.setText("");
            monsters.MonsterManager.enemies.get(0).getDeath();
        }
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        special = 0;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
    }
    
    
    
    
    
    public void clownFight(int hitCount, int hitDmg,int silenceDur, int stunDur,int dDmg,int dChance,int dmgPlus,int tSpecial) throws Exception
    {
       if(!(monsters.MonsterManager.enemies.get(0).getName().equals("Big Tim")))
       {
        int songChoice = (int)(Math.random() * 100);
        if(songChoice < 33)
         Playlist.playSong("/sounds/CarnivalFight.wav");
        else if(songChoice >= 67)
         Playlist.playSong("/sounds/CarnivalFight2.wav");
        else
         Playlist.playSong("/sounds/CarnivalFight3.wav");
        }
       else
        Playlist.playSong("/sounds/BigTimTheme.wav");
       MonsterManager.setNames();
           
         battle = true;
        flee = false;
        int special = 0;
        
        newFight(monsters.MonsterManager.enemies.get(0).getPic());
        
        while(battle == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
        {
            statusEffect.Player.getEffects(round);
            while(pTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                	MainFightPanel.clearDisplay();
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                    else if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(0).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(0).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(0).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(0).getDamage();
                    monsters.MonsterManager.enemies.get(0).getResist();
                    monsters.MonsterManager.enemies.get(0).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(0).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
            }
            eTurn = true;
            pause(2000);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            monsters.MonsterManager.enemyStatuses.get(0).getEffects(round);
            String action = monsters.MonsterManager.enemies.get(0).action();
            while(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                     int threshold = 1 + (int)(Math.random() * 100);
                if(threshold < 15 && eTurn == true && (special < tSpecial) && hitCount > 0  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                     Playlist.playEffect("/sounds/PartyHorn.wav");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": Goes wild!");
                    pause(2200);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.doMultiHit(hitCount,hitDmg);
                    special++;
                    pTurn = true;
                    eTurn = false;
                }
                else if(threshold >= 15 &&  threshold < 31 && eTurn == true && (special < tSpecial) && silenceDur > 0  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                     Playlist.playEffect("/sounds/ScaryFace.wav");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": made a super scary face!");
                    pause(2200);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.startSilence(silenceDur,0);
                    special++;
                    pTurn = true;
                    eTurn = false;
                    pause(1000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                }
                else if(threshold >= 31 && threshold < 45 && eTurn == true && (special < tSpecial) && stunDur > 0  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/BalloonPop.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": popped a balloon in your face!");
                    pause(2200);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.startStun(stunDur,0);
                    special++;
                    pTurn = true;
                    eTurn = false;
                    pause(1000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                }
                else if(threshold >= 45 && threshold < 60 && eTurn == true && (special < tSpecial) && dmgPlus > 0 && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/ClownLaugh.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": is pissed off.\n");
                    pause(2200);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Dmg: +");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,""+dmgPlus,Color.RED,20,true);
                    pause(1500);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    monsters.MonsterManager.enemies.get(0).setAttack(monsters.MonsterManager.enemies.get(0).getAttack() + dmgPlus);
                    special++;
                }
               
                else if(action.equals("attacks") &&  eTurn == true)
                {
                    Ability.Passives.Evade.use();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": " + action + "\n");
                    pause(1500);
                    if(Player.getEvade())
                    {
                        Playlist.playEffect("/sounds/Miss.wav");
                        MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + monsters.MonsterManager.enemies.get(0).getName());
                        MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        MainFightPanel.clearEnemyDisplay();
                    Ability.Passives.Evade.evade = false;
                    pTurn = true;
                    eTurn = false;
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    player.getDamage(monsters.MonsterManager.enemies.get(0));
                    player.getResist();
                    player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                                           Playlist.playEffect("/sounds/MultiHit.wav");
                                           MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                                           pause(1500);
                                           MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                                           MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                                         MainFightPanel.append(MainFightPanel.user, " HP\n");
                                             pause(2000);
                                          MainFightPanel.clearDisplay();
                                         MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                   }
                }
                 else if(action.equals("cures"))
                {
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + " just stares at you.");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                }
                     threshold = 1 + (int)(Math.random() * 101);
                 if(threshold < dChance && monsters.MonsterManager.enemies.get(0).getHealth() <= 20)
                {
                    output.setText("");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": screams and explodes!\n");
                    Playlist.playEffect("/sounds/ClownScream.wav");
                    pause(1900);
                    Playlist.playEffect("/sounds/BloodBoom.wav");
                    monsters.MonsterManager.enemies.get(0).setHealth(0);
                    pause(2500);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                    MainFightPanel.append(MainFightPanel.user,dDmg+"",Color.RED,20,true);
                  MainFightPanel.append(MainFightPanel.user, " HP\n");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    Player.health = Player.health - dDmg;
                    pTurn = true;
                    eTurn = false;
                }
                }
            round++;
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            if(Ability.Passives.Guardian.use() == true && Player.health <= 0)
            {
            	 output.setText("");
                 textPanel.setVisible(true);
             	fightGUI.setVisible(false);
             	input.grabFocus();
                 Ability.Passives.Guardian.battleUse = true;
                 Player.health = 1;
                 Player.alive = true;
                 append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
                 output.setText("");
                 pause(3000);
                  Playlist.playEffect("/sounds/Heal.wav");
                 append("*You feel a fire growing inside you*\n");
                 pause(2500);
                 append("You can't give up now!\n\n",Color.GREEN,30,true);
                 userWait();
                 output.setText("");
                 MainFightPanel.clearDisplay();
                 MainFightPanel.clearEnemyDisplay();
                 textPanel.setVisible(false);
             	fightGUI.setVisible(true);
            }
            }
        Playlist.playSong("/sounds/Carnival.wav");
        if(Player.health <= 0)
        {
        	textPanel.setVisible(true);
        	fightGUI.setVisible(false);
            player.alive = false;
            input.grabFocus();
            Player.health = Player.maxHealth;
            append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
            pause(3000);
            output.setText("");
            append("" + Story.deathMsg,Color.WHITE,22,false);
            userWait();
            output.setText("");
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
        }
        else if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            append("You have slain " + monsters.MonsterManager.enemies.get(0).getName() + "\n");
            monsters.MonsterManager.enemies.get(0).getDeath();
            output.setText("");
            
        }
        
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        special = 0;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
    }
    
    
    
    
    
    
    
    
     public void ryanFight() throws Exception
    {
        battle = true;
        int rule = 0;
        boolean transition = false;
        boolean phase2 = false;
        Ability.Passives.Scan.unlock = true;
        MonsterManager.setNames();
        Playlist.playSong("/sounds/SinisterShadows.wav");
        pause(100);
        Playlist.playEffect("/sounds/ShieldSummon.wav");
        pause(200);
        newFight(monsters.MonsterManager.enemies.get(0).getPic());
        MainFightPanel.clearDisplay();
        MainFightPanel.clearEnemyDisplay();
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nCome to me my sacred shield!\n",Color.WHITE,21,true);
        pause(3000); 
        MainFightPanel.clearEnemyDisplay();
        /*
        Monsters.RyanShield.minionSummon();
        shieldFight();

        MainFightPanel.changePic(Monsters.AngelRyan.pic);
        if(Player.alive == true)
       {
        Monsters.RyanShield.getDrops();
        Ability.Passives.Scan.use();
        textPanel.setVisible(false);
    	fightGUI.setVisible(true);
    	pause(1500);
    	*/
        Playlist.playEffect("/sounds/PageTurn.wav");
        
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nDivine Rule #1: Thou shalt speak\n",Color.ORANGE,23,true);
                pause(3000);
                statusEffect.Player.startSilence(2,0);
                MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
        while(battle == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0) && Player.alive == true)
        {
            statusEffect.Player.getEffects(round);
            if(statusEffect.Player.silenceActive == false && rule == 0)
            {
                Playlist.playEffect("/sounds/PageTurn.wav");
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nDivine Rule #2: Thou shalt attack\n",Color.ORANGE,23,true);
                pause(3000);
                statusEffect.Player.startDisable(1,0);
                MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
                rule = 1;
            }
            if(statusEffect.Player.disableActive == false && rule == 1)
            {
                Playlist.playEffect("/sounds/PageTurn.wav");
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nDivine Rule #1: Thou shalt speak\n",Color.ORANGE,23,true);
                pause(3000);
                statusEffect.Player.startSilence(1,0);
                MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
                rule = 0;
            }
            while(pTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0) && Player.alive == true)
            {
                
            	int choice = 0;
        		Ability.Passives.Scan.use();
        		MainFightPanel.user.grabFocus();
                if(Player.mana > Player.maxMana)
                    Player.mana = Player.maxMana;
               choice = MainFightPanel.playerGUI();
                if(choice == -2)
                {
                	fightGUI.setVisible(false);
                	textPanel.setVisible(true);
                    player.getInventory();
                    textPanel.setVisible(false);
                	fightGUI.setVisible(true);
                }
                else if(choice == -5)
                {
                	MainFightPanel.clearDisplay();
                    int threshold = 1 + (int)(Math.random() * 100);
                    if(statusEffect.Player.disableActive == true)
                    {
                        Playlist.playEffect("/sounds/Error.wav");
                        
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use your weapon while Disabled!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        
                    }
                    else if(statusEffect.Player.disableActive == false && threshold <= monsters.MonsterManager.enemies.get(0).getEvade())
                   {
                       Playlist.playEffect("/sounds/Miss.wav");
                       MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false); //+ " with " + Main.player.weaponName + ".");
                       pause(2000);
                       MainFightPanel.append(MainFightPanel.user,"You ",Color.WHITE,25,false);
                       MainFightPanel.append(MainFightPanel.user,"missed ",Color.BLUE,25,true);
                       MainFightPanel.append(MainFightPanel.user,monsters.MonsterManager.enemies.get(0).getName() + "!",Color.WHITE,25,false);
                       eTurn = true;
                       pTurn = false;
                   }
                    else if(statusEffect.Player.disableActive == false && threshold > monsters.MonsterManager.enemies.get(0).getEvade())
                    {
                        attackSound();
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou attacked " + monsters.MonsterManager.enemies.get(0).getName() + "\n",Color.WHITE,25,false);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    monsters.MonsterManager.enemies.get(0).getDamage();
                    monsters.MonsterManager.enemies.get(0).getResist();
                    monsters.MonsterManager.enemies.get(0).loseHealth();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" +monsters.MonsterManager.enemies.get(0).getName() + " lost ",Color.WHITE,25,false);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getDmgTaken() + "",Color.RED,25,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n",Color.WHITE,25,false);
                    Player.weapons[Player.equippedWeapon].useAbility();
                    eTurn = true;
                    pTurn = false;
                   }
                }
                else if(choice == -3)
                {  
                    Player.getItems();
                }
                else if(choice == -4)
                {
                	MainFightPanel.clearDisplay();
                	if(statusEffect.Player.silenceActive == false)
                        Player.getAbilities();
                        else if(statusEffect.Player.silenceActive == true)
                        {
                            Playlist.playEffect("/sounds/Error.wav");
                        MainFightPanel.append(MainFightPanel.user,"\n\n\nYou can't use abilities while Silenced!",Color.RED,25,true);
                        pause(2000);
                        MainFightPanel.clearDisplay();
                        }
                }
                else if(choice == -1)
                {
                	MainFightPanel.clearDisplay();
                	pTurn = false;
                	eTurn = true;
                }
                else
                	MainFightPanel.clearDisplay();
            }
            eTurn = true;
            pause(2000);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            monsters.MonsterManager.enemyStatuses.get(0).getEffects(round);
           if(phase2 == false && Player.alive == true)
           {
            while(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                int threshold = (int)(Math.random() * 101);
                if(threshold < 15 && eTurn == true && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.ORANGE,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"A lunatic like you ought to be punished!\n\n",Color.WHITE,20,false);
                    pause(2000);
                    Playlist.playEffect("/sounds/Fire.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Archangel Ryan Casts: ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Eternal Flames\n",Color.RED,20,true);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.startBurn(99,11);
                    pause(1000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                }
                else if(threshold < 30 && threshold >= 15 && eTurn == true  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false && monsters.MonsterManager.enemyStatuses.get(0).fortifyActive == false)
                {
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.ORANGE,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"Your blade is weak!\n\n",Color.WHITE,20,false);
                    pause(2000);
                    Playlist.playEffect("/sounds/ForceField.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Archangel Ryan: Summons a protective aura\n");
                    pause(2500);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nDef: +15\n");
                    pause(1000);
                    MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                    MainFightPanel.append(MainFightPanel.user,"5",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.user, " HP\n");
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    Player.health = Player.health - 5;
                    monsters.MonsterManager.enemyStatuses.get(0).startFortify(3,15);
                    pause(1000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                }
                else if(threshold < 45 && threshold >= 30 && eTurn == true  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.ORANGE,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"I kind of feel bad hurting you...\n\n",Color.WHITE,20,false);
                    pause(2000);
                    Playlist.playEffect("/sounds/Heal.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"+10 ",Color.GREEN,20,true); 
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"HP\n");
                    monsters.MonsterManager.enemies.get(0).setHealth(monsters.MonsterManager.enemies.get(0).getHealth() + 10);
                    if( monsters.MonsterManager.enemies.get(0).getHealth() >  monsters.MonsterManager.enemies.get(0).getMaxHealth())
                         monsters.MonsterManager.enemies.get(0).setHealth(monsters.MonsterManager.enemies.get(0).getMaxHealth());
                    pause(1500);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    MainFightPanel.append(MainFightPanel.user,"\n\nYou have been stunned by his charm!");
                    pause(2000);
                    statusEffect.Player.startStun(1,0);
                    pause(1000);
                     pTurn = true;
                    eTurn = false;
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                }
                else if(threshold < 65 && threshold >= 45 && eTurn == true  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/ScaryFace.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.ORANGE,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"Dance with me!\n\n",Color.WHITE,20,false);
                    pause(2000);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Archangel Ryan assaults you with a flurry of dance moves!");
                     pause(2500);
                     MainFightPanel.clearDisplay();
                     MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.doMultiHit(5,8);
                    pTurn = true;
                    eTurn = false;
                }
                else if(threshold >= 65 && threshold < 80 && eTurn == true)
                {
                    Ability.Passives.Evade.use();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": attacks\n");
                    pause(1500);
                    if(Player.getEvade())
                    {
                                               Playlist.playEffect("/sounds/Miss.wav");
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput,""+monsters.MonsterManager.enemies.get(0).getName());
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                                               pause(2000);
                                               MainFightPanel.clearDisplay();
                                               MainFightPanel.clearEnemyDisplay();
                    Ability.Passives.Evade.evade = false;
                    pTurn = true;
                    eTurn = false;
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    player.getDamage(monsters.MonsterManager.enemies.get(0));
                    player.getResist();
                    player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                                           Playlist.playEffect("/sounds/MultiHit.wav");
                                           MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                                           pause(1500);
                                           MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                                           MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                                         MainFightPanel.append(MainFightPanel.user, " HP\n");
                                             pause(2000);
                                          MainFightPanel.clearDisplay();
                                         MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                   }
                    
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan charges up his ");
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"mana",Color.BLUE,20,true);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                     pTurn = true;
                    eTurn = false;
                }
                }
            
            
        }
        if(transition == false && monsters.MonsterManager.enemies.get(0).getHealth() <= monsters.MonsterManager.enemies.get(0).getMaxHealth() / 2 && monsters.MonsterManager.enemies.get(0).getHealth() > 0 && Player.alive == true)
        {
        	output.setText("");
            Playlist.stopSong();
            fightGUI.setVisible(false);
        	textPanel.setVisible(true);
            	append("Archangel Ryan: ",Color.CYAN,20,true);
            	Story.textEffect("Hold on a second, I'm getting a phone call\n",Color.WHITE,20,false);
            append("... ... ...");
            pause(5000);
            output.setText("");
            append("Archangel Ryan: ",Color.CYAN,20,true);
        	Story.textEffect("I'm needed elsewhere. Sorry, but this is going to have to end\n",Color.WHITE,20,false);
            pause(3000);
            Story.textEffect("                To think that I actually have to try now...\n");
            pause(2200);
             Playlist.playSong("/sounds/TheEncounter.wav");
            pause(300);
            Story.textEffect("\n                THAT REALLY PISSES ME OFF\n",Color.RED,25,true);
            pause(3000);
            output.setText("");
            Playlist.playEffect("/sounds/ShieldSummon.wav");
            fightGUI.setVisible(true);
        	textPanel.setVisible(false);
             MainFightPanel.clearDisplay();
             MainFightPanel.clearEnemyDisplay();
             /*
             MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nCome to me my sacred shield 2.0!\n",Color.WHITE,21,true);
             pause(2000); 
             Monsters.RyanShield.minionSummon();
             MainFightPanel.clearDisplay();
             MainFightPanel.clearEnemyDisplay();
             shieldFight();
             MainFightPanel.changePic(Monsters.AngelRyan.pic);
             if(Player.alive == true)
             {
                 Monsters.RyanShield.getDrops();
                output.setText("");
                MainFightPanel.clearDisplay();
                MainFightPanel.clearEnemyDisplay();
                fightGUI.setVisible(true);
             	textPanel.setVisible(false);
             	*/
            transition = true;
            phase2 = true;
        //}
            
        }
        if(phase2 == true && Player.alive == true)
           {
            while(eTurn == true && !(Player.health <= 0 || monsters.MonsterManager.enemies.get(0).getHealth() <= 0))
            {
                int threshold = (int)(Math.random() * 101);
                if((threshold < 15 && eTurn == true && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)&& statusEffect.Player.burnActive == false)
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.CYAN,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"A lunatic like you ought to be punished!\n\n",Color.WHITE,20,false);
                    pause(2000);
                    Playlist.playEffect("/sounds/Fire.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Archangel Ryan Casts: ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Eternal Flames\n",Color.RED,20,true);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.startBurn(99,11);
                    pause(1000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                }
                else if(threshold < 30 && threshold >= 15 && eTurn == true  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/Fairy.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.CYAN,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"Faires come hither!\n\n",Color.WHITE,20,false);
                    pause(2000);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Summoned blue faires\n",Color.BLUE,20,true);
                    pause(2000);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Summoned green faires\n",Color.GREEN,20,true);
                    pause(2000);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Summoned yellow faires\n",Color.YELLOW,20,true);
                    pause(3000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    monsters.MonsterManager.enemyStatuses.get(0).startHeal(5,10);
                    statusEffect.Player.startIce(5,10);
                    statusEffect.Player.startShock(5,10);
                    pTurn = true;
                    eTurn = false;
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                }
                else if(threshold < 45 && threshold >= 30 && eTurn == true  &&monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.CYAN,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"Go Prevailing Winds!\n\n",Color.WHITE,20,false);
                    pause(2000);
                    Playlist.playEffect("/sounds/Whirlwind.wav");
                    MainFightPanel.append(MainFightPanel.user,"\n\nA mighty whirlwind strikes you!\n");
                    pause(2000);
                    statusEffect.Player.startStun(1,0);
                    pause(1000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    statusEffect.Player.doMultiHit(15,4);
                    pTurn = true;
                    eTurn = false;
                }
                else if(threshold < 60 && threshold >= 45 && eTurn == true  &&monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.CYAN,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"I'll be giving some of your mana back to god!\n\n",Color.WHITE,20,false);
                    pause(2000);
                    Playlist.playEffect("/sounds/SoulSuck.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Archangel Ryan ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"stole ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"20",Color.BLUE,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," mana.\n");
                    pause(2000);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"+10",Color.GREEN,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP\n");
                     pause(2000);
                    Player.mana = Player.mana - 20;
                    if(Player.mana < 0)
                        Player.mana = 0;
                    monsters.MonsterManager.enemies.get(0).setHealth(monsters.MonsterManager.enemies.get(0).getHealth() + 10);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                    
                }
                else if(threshold < 75 && threshold >= 60 && eTurn == true  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan Casts: ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"Explosion",Color.ORANGE,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n\n");
                    pause(1500);
                    Playlist.playEffect("/sounds/Explosion.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"*A loud BOOM echoes through the stadium...*\n",Color.LIGHT_GRAY,20,true);
                    pause(2000);
                    MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                    MainFightPanel.append(MainFightPanel.user,"20",Color.RED,20,true);
                  MainFightPanel.append(MainFightPanel.user, " HP\n");
                    pause(2000);
                    Player.health = Player.health - 20;
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                }
                else if(threshold < 85 && threshold >= 75 && eTurn == true  && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false)
                {
                    Playlist.playEffect("/sounds/Kiss.wav");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan ",Color.CYAN,20,true);
                    MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"blows you a kiss\n\n",Color.WHITE,20,false);
                    pause(2000);
                    Playlist.playEffect("/sounds/Heal.wav");
                    MainFightPanel.append(MainFightPanel.user,"\n\n+8",Color.GREEN,20,true);
                    MainFightPanel.append(MainFightPanel.user," HP\n");
                    Player.health = Player.health + 8;
                    if(Player.health > Player.maxHealth)
                        Player.health = Player.maxHealth;
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"+8",Color.GREEN,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP\n");
                     pause(2000);
                     MainFightPanel.clearDisplay();
                     MainFightPanel.clearEnemyDisplay();
                    monsters.MonsterManager.enemies.get(0).setHealth(monsters.MonsterManager.enemies.get(0).getHealth() + 8);
                    statusEffect.Player.startDisable(2,0);
                    statusEffect.Player.startSilence(2,0);
                    pause(1000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;
                }
                else if(threshold <=100 && threshold >= 85 && eTurn == true && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == false && monsters.MonsterManager.enemyStatuses.get(0).fortifyActive == false)
                {
                   MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan: ",Color.CYAN,20,true);
                   MainFightPanel.textEffect(MainFightPanel.enemyStatOutput,"Holy Angel protect me!\n\n",Color.WHITE,20,false);
                    pause(2000);
                    Playlist.playEffect("/sounds/ForceField.wav");
                    append("Summoned a protective aura:\n");
                    pause(1500);
                    append("Def: +35\n");
                    pause(1500);
                    monsters.MonsterManager.enemyStatuses.get(0).startFortify(2,35);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                 }
                else if( eTurn == true && monsters.MonsterManager.enemyStatuses.get(0).silenceActive == true && threshold < 50)
                {
                	Ability.Passives.Evade.use();
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+monsters.MonsterManager.enemies.get(0).getName() + ": attacks\n");
                    pause(1500);
                    if(Player.getEvade())
                    {
                                               Playlist.playEffect("/sounds/Miss.wav");
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput,""+monsters.MonsterManager.enemies.get(0).getName());
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput," missed",Color.BLUE,20,true);
                                               MainFightPanel.append(MainFightPanel.enemyStatOutput,"!");
                                               pause(2000);
                                               MainFightPanel.clearDisplay();
                                               MainFightPanel.clearEnemyDisplay();
                    Ability.Passives.Evade.evade = false;
                    pTurn = true;
                    eTurn = false;
                    }
                    else if(Ability.Passives.Evade.evade == false)
                    {
                    Player.getDamage(monsters.MonsterManager.enemies.get(0));
                    Player.getResist();
                    Player.loseHealth();
                    int ran = (int)(Math.random() * 3);
                                           Playlist.playEffect("/sounds/MultiHit.wav");
                                           MainFightPanel.append(MainFightPanel.enemyStatOutput,monsters.MonsterManager.enemies.get(0).getName() + ": " + monsters.MonsterManager.enemies.get(0).getAttackNames()[ran] + " you.\n");
                                           pause(1500);
                                           MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
                                           MainFightPanel.append(MainFightPanel.user,player.dmgTaken+"",Color.RED,20,true);
                                         MainFightPanel.append(MainFightPanel.user, " HP\n");
                                             pause(2000);
                                          MainFightPanel.clearDisplay();
                                         MainFightPanel.clearEnemyDisplay();
                    pTurn = true;
                    eTurn = false;   
                   }
                    
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nArchangel Ryan charges up his ");
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,"mana",Color.BLUE,20,true);
                    pause(2000);
                    MainFightPanel.clearDisplay();
                    MainFightPanel.clearEnemyDisplay();
                     pTurn = true;
                    eTurn = false;
                }
                }
            
            
        }
         round++;
           
            eTurn = false;
            pTurn = true;
            Player.mana = Player.mana + (Player.maxMana / 8);
            if(Ability.Passives.Guardian.use() == true && Player.health <= 0)
            {
            	 output.setText("");
                 textPanel.setVisible(true);
             	fightGUI.setVisible(false);
             	input.grabFocus();
                 Ability.Passives.Guardian.battleUse = true;
                 Player.health = 1;
                 Player.alive = true;
                 append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
                 output.setText("");
                 pause(3000);
                  Playlist.playEffect("/sounds/Heal.wav");
                 append("*You feel a fire growing inside you*\n");
                 pause(2500);
                 append("You can't give up now!\n\n",Color.GREEN,30,true);
                 userWait();
                 output.setText("");
                 MainFightPanel.clearDisplay();
                 MainFightPanel.clearEnemyDisplay();
                 textPanel.setVisible(false);
             	fightGUI.setVisible(true);
            }
            }
        Playlist.stopSong();
          if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
        	  output.setText("");
        	  textPanel.setVisible(true);
            	fightGUI.setVisible(false);
            	append("Archangel Ryan: ",Color.CYAN,20,true);
            	Story.textEffect("ARHUGGHUGH..!\n\n",Color.WHITE,20,false);
           
            pause(1000);
            output.setText("");
            	          append("Archangel Ryan: ",Color.CYAN,20,true);
        		Story.textEffect("I refuse.... To go out like this....\n",Color.WHITE,20,false);
            pause(2000);
        		Story.textEffect("                I still had so many theories and experiments to conduct...\n",Color.WHITE,20,false);
            pause(2000);
            	Story.textEffect("                You may have won. However...\n",Color.WHITE,20,false);
            pause(3000);
            	Story.textEffect("                You won't live!\n",Color.RED,25,true);
            Story.userWait();
            output.setText("");
            Playlist.playEffect("/sounds/BloodBoom.wav");
            append("Archangel Ryan exploded into feathers and white matter\n");
            pause(2000);
            MainFightPanel.append(MainFightPanel.user,"\n\nYou lost ");
            MainFightPanel.append(MainFightPanel.user,"32",Color.RED,20,true);
          MainFightPanel.append(MainFightPanel.user, " HP\n");
            Player.health = Player.health - 32;
            pause(3000);
            output.setText("");
        }
            
          if(Player.health <= 0)
          {
          	textPanel.setVisible(true);
          	fightGUI.setVisible(false);
              player.alive = false;
              input.grabFocus();
              Player.health = Player.maxHealth;
              append("\n\n\n                           ~YOU ARE DEAD~\n",Color.RED,30,true);
              pause(3000);
              output.setText("");
              append("" + Story.deathMsg,Color.WHITE,22,false);
              userWait();
              output.setText("");
              MainFightPanel.clearDisplay();
              MainFightPanel.clearEnemyDisplay();
          }
        
        else if(monsters.MonsterManager.enemies.get(0).getHealth() <= 0)
        {
            textPanel.setVisible(true);
        	fightGUI.setVisible(false);
        	input.grabFocus();
        	MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
            output.setText("");
            append(monsters.MonsterManager.enemies.get(0).getName() + " has been destroyed!\n");
            monsters.MonsterManager.enemies.get(0).getDeath();
        }
        Ability.Actives.Manager.resetAbility();
        statusEffect.Reset.reset();
        round = 1;
        textPanel.setVisible(true);
    	fightGUI.setVisible(false);
      }

    
    
    
    
    
    
    
    
    public void attackSound()
    {
       if(!(Player.weapons[Player.equippedWeapon].name.equals("Fists")))
       {
        int ran = (int)(Math.random() * 3);
        if(ran == 0)
         Playlist.playEffect("/sounds/Attack1.wav");
        else if(ran == 1)
         Playlist.playEffect("/sounds/Attack2.wav");
        else if(ran == 2)
         Playlist.playEffect("/sounds/Attack3.wav");
        }
       else
        Playlist.playEffect("/sounds/Punch.wav");
    }
    
    
    
    
    
    
    
    
    
    
    
     
   
       

    
    
    
    public void userWait() throws InterruptedException
    {
       getReset();
        append("'Press Enter to Continue'\n");
        getString();
    }


    public void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void getReset() throws InterruptedException
    {
        actionHandler.reset();
    }
    
    public int getInt() throws InterruptedException {
        synchronized (actionHandler.holderInt) {
            while (actionHandler.holderInt.isEmpty())
            {
                actionHandler.holderInt.wait();
            }
            return actionHandler.holderInt.remove(0);
        }
    }
    
    public String getString() throws InterruptedException {
        synchronized (actionHandler.holderString) {
            while (actionHandler.holderString.isEmpty())
            {
                actionHandler.holderString.wait();
            }

            return actionHandler.holderString.remove(0);
        }
    }
   
    public void fontSize(int s)
    {
       output.setFont(new Font("Monospaced", Font.PLAIN, s));
    }
    
 public static void append(String n) {
    	
    	StyledDocument doc = output.getStyledDocument();

    SimpleAttributeSet keyWord = new SimpleAttributeSet();
    StyleConstants.setForeground(keyWord, Color.WHITE);
       try
    	{
    	   doc.insertString(doc.getLength(),n, keyWord);
    	} catch(Exception e) { 
    		System.out.println(e);}
    }
 
 public static void append(String n,String n2,String n3,Color c,Color cb) {
 	StyledDocument doc = output.getStyledDocument();
 	
 SimpleAttributeSet keyWord = new SimpleAttributeSet();
 
    try
 	{
    	StyleConstants.setForeground(keyWord,cb);
 	   doc.insertString(doc.getLength(),n, keyWord);
 	  StyleConstants.setForeground(keyWord,c);
 	  doc.insertString(doc.getLength(),n2, keyWord);
 	 StyleConstants.setForeground(keyWord,cb);
 	 doc.insertString(doc.getLength(),n3, keyWord);
 	} catch(Exception e) { 
 		System.out.println(e);}
 }
 
    public static void append(String n, Color c,int size, boolean bold) {
    	
    	StyledDocument doc = output.getStyledDocument();

    SimpleAttributeSet keyWord = new SimpleAttributeSet();
    StyleConstants.setForeground(keyWord,c);
    StyleConstants.setBold(keyWord, bold);
    if(size != 0)
    	StyleConstants.setFontSize(keyWord, size);
       try
    	{
    	   doc.insertString(doc.getLength(),n, keyWord);
    	} catch(Exception e) { 
    		System.out.println(e);}
    }
    
    
    public void newFight(String pic) throws Exception{
    	fightGUI = new MainFightPanel(pic);
    	frame.remove(inputPanel);
    	frame.add(fightGUI);
    	frame.add(inputPanel);
    	textPanel.setVisible(false);
    	fightGUI.setVisible(true);
    	}
    
    public void newLibra(MonsterManager m) throws Exception{
    	libraGUI = new LibraScreen(m);
    	frame.remove(inputPanel);
    	frame.add(libraGUI);
    	frame.add(inputPanel);
    	fightGUI.setVisible(false);
    	textPanel.setVisible(false);
    	libraGUI.setVisible(true);
    	LibraScreen.open();
    	if(battle == true) {
        	libraGUI.setVisible(false);
    		fightGUI.setVisible(true);
    	}else {
        	libraGUI.setVisible(false);
    		textPanel.setVisible(true);
    	}
    }

    
    public void initialize() throws Exception
    {
        frame = new JFrame("ManaQuest v1.6.1 ALPHA");
        setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout = new FlowLayout(FlowLayout.LEADING, 0, 0);
        layout.setVgap(0);
        frame.setLayout(layout);
        frame.setResizable(false);
        textPanel = new JPanel(true);
        fightPanel = new JPanel(true);
        fightPanel.setVisible(false);
        inputPanel = new JPanel();
        textPanel.setLayout(layout);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS));
        
        
        
        output = new JTextPane();
        output.setEditable(false);
        textPanel.add(output);
        output.addKeyListener(keyHandler);
        output.setPreferredSize(new Dimension(1270,600));
        output.setBackground(Color.black);
        output.setForeground(Color.white);
        output.setFont(new Font("Monospaced", Font.PLAIN, 20));
        
        
        input = new JTextField();
        input.addActionListener(actionHandler);
        input.addKeyListener(keyHandler);
        input.setBorder(null);
        input.setPreferredSize(new Dimension(1270,35));
        input.setBackground(Color.black);
        input.setForeground(Color.white);
        input.setFont(new Font("Monospaced", Font.PLAIN, 20));
        input.grabFocus();
        fightGUI = new MainFightPanel("trapdoor.png");

        frame.add(textPanel);
        frame.add(inputPanel);
        frame.setSize(1270,662);
       
        frame.setVisible(true);

        label = new JLabel();
        label.setText(">>");
        label.setBackground(Color.black);
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setPreferredSize(new Dimension(35,35));
        label.setMinimumSize(new Dimension(35, 35));
        label.setMaximumSize(new Dimension(35, 35));
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        
        textPanel.add(output);
        inputPanel.add(label);
        inputPanel.add(input);

        input.grabFocus();

        casino = new Casino(this);
        backpack = new backpack.Manager(this);
        shop = new Shop(this);
        story = new Story(this);
        player = new Player(this);
        level = new Level(this);
        item = new ItemManager(this);
        tutorial = new Tutorial(this);
        ability = new Ability.Actives.Manager(this);
        loot = new LootScreen(this);
        chest = new Chest(this);
        dungeon = new Dungeon(this);
        mine = new DungeonTwo(this);
        list = new crafting.List(this);
    }
}
