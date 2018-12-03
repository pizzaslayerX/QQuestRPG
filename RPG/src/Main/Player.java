package Main;
import Run.*;
import Weapon.*;
import Armor.*;
import Item.Consumable;
import Monsters.MonsterManager;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFileChooser;

import Ability.Actives.Special;

import java.nio.file.FileSystems;
import java.nio.file.Path;
public class Player implements Serializable
{
	private static final long serialVersionUID = -6434765809619401359L;
	
	public static String title = "Nooby";
    public static int maxHealth = 20;
    public static int health = 20;
    public static int level = 1;
    public static int gold = 0;
    public static int dmgTaken = 0;
    public static RPGRunner run;
    public static int exp = 0;
    public static int maxMana = 0;
    public static int mana = 0;
    public static boolean alive = true,checkReplace = false;
    public static int levelUpExp = 5;
    public static int scene = 1;
    public static int part = 1;
    public static String[] saveGameInfo = {"{Empty}","{Empty}","{Empty}","{Empty}","{Empty}"};
    public static String adifficulty;
    public static String directory;
    public static WeaponManager[] weapons = new WeaponManager[3];
    public static ArmorManager[] armor = new ArmorManager[3];
    public static ArrayList<Special> abilities = new ArrayList<Special>();
    public static ArrayList<Consumable> items = new ArrayList<Consumable>(Arrays.asList(null,null,null));
    public static int amtItems = 3; //amt of items allowed inside of list
    public static int equippedWeapon = 0;
    public static int equippedArmor = 0;
    public static int equippedPage = 0;
    private static int replacedWeapon = 2;
    private static int replacedArmor = 2;
    public static int baseIceR = 0;
    public static int baseShockR = 0;
    public static int baseFireR = 0;
    public static int baseDef = 0;
    public static int baseDmg = 0;
    public static int levelPoints = 0;
    public Player(RPGRunner r)
    {
        this.run = r;
    }
    
    private int sequippedWeapon;
    private int sequippedArmor;
    private WeaponManager[] sweapons;
    private ArmorManager[] sarmor;
    private String stitle;
    private int smaxHealth;
    private int shealth;
    private int slevel;
    private int sgold;
    private int sexp;
    private int smaxMana;
    private int smana;
    private int slevelUpExp;
    private int sscene;
    private int ppath;
    private int scarnivalFloor;
    private boolean sjokerDeal;
    private int smineFloor;
    private int scraftFloor;
    private String difficulty;
    private boolean sFirstTime;
    private int slotCount;
    private int abilityPageCount;   
    private boolean scan;
    private boolean evade;
    private boolean guardian;
    private boolean midas;
    private boolean lucky;    
    private int ppart;
    private int pstrPlus;
    private ArrayList<BackPack.Slot> inventory;
    private String[] itemSlot = new String[Item.ItemManager.itemSlot.length];
    private Special[][] abilitySlot = new Special[3][5];
    private ArrayList<Special> specials;
    private int ePage;
    private int levelP;
    
    public Player(String t,int mh,int h,int g,int e,int lue,int mm,int m,int l,int s,String[] is,boolean pas,boolean pae,int pp,ArrayList<BackPack.Slot> bi,boolean jd,int cf,boolean ft, int stp,boolean gay,String gd,int isc,boolean luck,boolean mida,int pa, int asc, int mf, int crf,WeaponManager[] wl,ArmorManager[] al,int ew,int ea,Special[][] as,ArrayList<Special> ss,int ep,int lp)
    {
       sweapons = wl;
       sarmor = al;
       sequippedWeapon = ew;
       sequippedArmor = ea;
       stitle = t;
       smaxHealth = mh;
       shealth = h;
       sgold = g;
       sexp = e;
       slevelUpExp = lue;
       smaxMana = mm;
       smana = m;
       slevel = l;
       sscene = s;
       ppath = pp;
       sjokerDeal = jd;
       scarnivalFloor = cf;
       smineFloor = mf;
       scraftFloor = crf;
       
       levelP = lp;
       ePage = ep;
       ppart = pa;
       difficulty = gd;
       pstrPlus = stp;
       sFirstTime = ft;
       slotCount = isc;
       abilityPageCount = asc;
       inventory = bi;
       guardian = gay;
       scan = pas;
       evade = pae;
       midas = mida;
       lucky = luck;     
       itemSlot = is;
       abilitySlot = as;
       specials = ss;
    }

    public static void save(int n) throws InterruptedException
    {
      Player p = new Player(title,maxHealth,health,gold,exp,levelUpExp,maxMana,mana,level,scene,
                            Item.ItemManager.itemSlot,Ability.Passives.Scan.unlock,Ability.Passives.Evade.unlock,Story.path,BackPack.Manager.inventory,
                            Dungeon.jokerDeal,Dungeon.carnivalFloor,Story.firstTime,WeaponManager.strPlus,Ability.Passives.Guardian.unlock,adifficulty,Item.ItemManager.slotCount,Ability.Passives.Lucky.unlock,Ability.Passives.Midas.unlock,part,
                            Ability.Actives.Manager.pageCount,Main.DungeonTwo.mineFloor,Main.DungeonTwo.craftFloor,weapons,armor,equippedWeapon,equippedArmor,Ability.Actives.Manager.pages,abilities,equippedPage,levelPoints);
      FileOutputStream fileOut = null;
      
      try {
         if(n == 1)
         fileOut = new FileOutputStream(SetUp.directory + "/saves/PlayerOne.ser");
         else if(n == 2)
         fileOut = new FileOutputStream(SetUp.directory + "/saves/PlayerTwo.ser");
         else if(n == 3)
         fileOut = new FileOutputStream(SetUp.directory + "/saves/PlayerThree.ser");
         else if(n == 4)
         fileOut = new FileOutputStream(SetUp.directory + "/saves/PlayerFour.ser");
         else if(n==5)
         fileOut = new FileOutputStream(SetUp.directory + "/saves/PlayerFive.ser");
         
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         
         out.writeObject(p);
         out.close();
         fileOut.close();
        
         System.out.printf("Game successfully saved!");
      }catch(IOException i) {
         i.printStackTrace();
      }
    }
    
    public static void load() throws InterruptedException
    {
        Player p = null;
        
       run.append("Which file would you like to load?\n");
       for(int i = 0;i<Player.saveGameInfo.length;i++)
        {
            run.append("[" + (i+1) + "] - " + Player.saveGameInfo[i] + "\n");
        }
        int n = run.getInt();
        
        //FileInputStream fileIn = null;
        InputStream fileIn = null;
      try {
         if(n == 1)
         fileIn = new FileInputStream(SetUp.directory + "/saves/PlayerOne.ser");
         else if(n == 2)
        	 fileIn =  new FileInputStream(SetUp.directory + "/saves/PlayerTwo.ser");
         else if(n == 3)
        	 fileIn =  new FileInputStream(SetUp.directory + "/saves/PlayerThree.ser");
         else if(n == 4)
        	 fileIn =  new FileInputStream(SetUp.directory + "/saves/PlayerFour.ser");
         else if(n == 5)
        	 fileIn =  new FileInputStream(SetUp.directory + "/saves/PlayerFive.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         p = (Player) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c) {
         System.out.println("Save data not found");
         c.printStackTrace();
         return;
      }
      RPGRunner.output.setText("");
      run.fontSize(50);
      RPGRunner.append("\n\n\n              Loading Game...");
      Story.pause(1000);
      Story.pause(2000);
      
      abilities = p.specials;
      Story.firstTime = p.sFirstTime;
      Dungeon.jokerDeal = p.sjokerDeal;
      Dungeon.carnivalFloor = p.scarnivalFloor;
      DungeonTwo.mineFloor = p.smineFloor;
      DungeonTwo.craftFloor = p.scraftFloor;
      
      
      equippedPage = p.ePage;
      BackPack.Manager.inventory = p.inventory;
      Ability.Passives.Scan.unlock = p.scan;
      Ability.Passives.Scan.use();
      Ability.Passives.Evade.unlock = p.evade;
      Ability.Passives.Evade.use();
       Ability.Passives.Scan.unlock = p.scan;
      Ability.Passives.Scan.use();
      Ability.Passives.Guardian.unlock = p.guardian;
      Ability.Passives.Guardian.use();
      Ability.Passives.Lucky.unlock = p.lucky;
      Ability.Passives.Lucky.use();
      Ability.Passives.Midas.unlock = p.midas;
      Ability.Passives.Midas.use();
      
      if(p.difficulty.equals("Easy"))
      {
          adifficulty = p.difficulty;
          Monsters.SetStats.setDifficulty("e");
          Monsters.SetStats.setStats();
        }
      else if(p.difficulty.equals("Medium"))
      {
          adifficulty = p.difficulty;
          Monsters.SetStats.setDifficulty("m");
          Monsters.SetStats.setStats();
        }
      else
      {
          adifficulty = p.difficulty;
          Monsters.SetStats.setDifficulty("h");
          Monsters.SetStats.setStats();
        }
      
       WeaponManager.strPlus = p.pstrPlus;
       title = p.stitle;
      
       maxHealth = p.smaxHealth;
       health = p.shealth;
       gold = p.sgold;
       exp = p.sexp;
       levelUpExp = p.slevelUpExp;
       maxMana = p.smaxMana;
       mana = p.smana;
       level = p.slevel;
       scene = p.sscene;
       part = p.ppart;
       equippedWeapon = p.sequippedWeapon;
       equippedArmor = p.sequippedArmor;
       weapons = p.sweapons;
       armor = p.sarmor;
       levelPoints = p.levelP;
       
        Story.path = p.ppath;
       
        Item.ItemManager.slotCount = p.slotCount;
        Ability.Actives.Manager.pageCount = p.abilityPageCount;
        if(Item.ItemManager.slotCount == 4)
        	Item.ItemManager.slot4unlock = true;
        else if(Item.ItemManager.slotCount == 5)
        {
        	Item.ItemManager.slot4unlock = true;
        	Item.ItemManager.slot5unlock = true;
        }
        
       for(int i = 0;i<Item.ItemManager.slotCount;i++)
       {
           if(p.itemSlot[i].equals("Potion | Heals 30% of health")) {
            Item.Potion.newItem();
            BackPack.Manager.remove("Item: Potion", 1);
           }
           if(p.itemSlot[i].equals("Mega-Potion | Heals 80% of health")) {
            Item.MegaPotion.newItem();
            BackPack.Manager.remove("Item: Mega-Potion", 1);
           }
           if(p.itemSlot[i].equals("Elixer | Maxes out Mana and HP. Re-Do Turn")) {
            Item.Elixer.newItem();
            BackPack.Manager.remove("Item: Elixer", 1);
           }
           if(p.itemSlot[i].equals("Hi-Potion | Heals 50% of health")) {
            Item.HighPotion.newItem();
            BackPack.Manager.remove("Item: Hi-Potion", 1);
           }
           if(p.itemSlot[i].equals("Power-Potion | Increase Damage by 20% for 1 fight")) {
            Item.PowerPotion.newItem();
            BackPack.Manager.remove("Item: Power-Potion", 1);
           }
           if(p.itemSlot[i].equals("Ultramarine | Restores 50% of mana. Re-Do Turn")) {
            Item.Ultramarine.newItem();
            BackPack.Manager.remove("Item: Ultramarine", 1);
           }
        }
       if(scene <= 9)
           Playlist.playSong("/sounds/CaveSound.wav");
        
       if(Player.scene > 13)
        Player.scene = 13;
       
       Ability.Actives.Manager.pages = p.abilitySlot;  
    }
    
    public static void newPlayer() throws InterruptedException
    {
        String title = "Nooby";

        maxHealth = 20;
        health = 20;
        level = 1;
        gold = 0;
        dmgTaken = 0;   
        RPGRunner run;
        exp = 0;
        maxMana = 0;
        mana = 0;
        alive = true;
        levelUpExp = 5;
        Fist.setWeapon();
        Armor.None.setArmor();
        
    }

    public static void getItems() throws InterruptedException
    {
    	System.out.println("Items Opened Success");
        MainFightPanel.clearDisplay();
        int slot = Item.ItemManager.fightPrintItems();
        MainFightPanel.clearDisplay();
        System.out.println(slot + "item slot chosen");
        if(slot != Item.ItemManager.slotCount) {
        	Item.ItemManager.useItems(slot+1);
        	 MainFightPanel.clearDisplay();
        }
       
    }

    public static void getAbilities() throws Exception
    {
    	System.out.println("Abilities Opened Success");
    	MainFightPanel.clearDisplay();
        int aSlot = Ability.Actives.Manager.fightPrint();
        MainFightPanel.clearDisplay();
        System.out.println(aSlot);
        if(aSlot < Ability.Actives.Manager.pages[equippedPage].length) {
        	Ability.Actives.Manager.useAbility(aSlot+1);
        	MainFightPanel.clearDisplay();
        }
        if(aSlot == 5) {
        	Ability.Actives.Manager.switchPage();
        }
    }
    
    public static void getInventory() throws InterruptedException
    {
        boolean leave = false;
       while(leave == false)
       {
        run.getReset();
        run.output.setText("");
        run.append("\n===============================================STATS==============================================================\n");
        run.append("Level " + level + ": " + title + "\n");
        run.append("Next Level: " + exp + "/" + levelUpExp + " EXP\n");
        run.append("Health: " + health + "/" + maxHealth);
        run.append("\nMana: " + mana + "/" + maxMana);
        run.append("\nStrength Bonus: " + WeaponManager.strPlus);
        run.append("\n===================================================================================================================");           
        run.append("\n\n=============================================INVENTORY============================================================");
        run.append("\nGold: " + gold);
        run.append("\nWeapon: " + weapons[equippedWeapon].modifier + weapons[equippedWeapon].name + " || Dmg: " + weapons[equippedWeapon].dmg + " | Crit: " + weapons[equippedWeapon].crit + " | " + weapons[equippedWeapon].desc);
        run.append("\nWeapon Ability: " + weapons[equippedWeapon].aName);
        run.append("\nArmor Set: " + armor[equippedArmor].name + " || Def: " + getDef() + " | " + armor[equippedArmor].desc);
        run.append("\n -Fire Resistance: %" + getFireR() + " | Frost Resistance: %" + getIceR() + " | Shock Resistance: %" + getShockR());
        run.append("\nChange Weapons[w]",Color.ORANGE,20,true);
        run.append("\nChange Armor[a]",Color.ORANGE,20,true);
        run.append("\nOpen Backpack[b]",Color.ORANGE,20,true);
        run.append("\n===================================================================================================================\n\n");
        run.append("'Press [Enter] to Continue'");
        String back = run.getString();
        if(back.equals("b"))
            BackPack.Manager.open();
        else if(back.equals("w"))
        	switchWeapon();
        else if(back.equals("a"))
        	switchArmor();
        else
        {
         leave = true;
         run.output.setText("");
       }
      }
    }

    public static void tryCrit(MonsterManager m)
    {
        int threshold =  1 + (int)(Math.random() * 100);
        if(threshold <= m.getCrit())
        {
            dmgTaken = dmgTaken * 2;
            MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nCRITICAL HIT!!! \n",Color.MAGENTA,22,true);
        }
    }

    public static void loseHealth()
    {
        health = health - dmgTaken;
    }

    public static void getDamage(MonsterManager m)
    {  
        if(m.getAttack() > 15)
        {
            double total =  (m.getAttack() - (m.getAttack() * (12.0/100.0))) + (double)(Math.random() * (m.getAttack() * (12.0/100.0)));
            dmgTaken = (int)total;
        }
        else
            dmgTaken = m.getAttack();
        tryCrit(m);
    }

    public static void getResist()
    {
        dmgTaken = dmgTaken - (int)(dmgTaken * (getDef() / 100.0));
        if(dmgTaken < 0)
        	dmgTaken = 0;
    }

    public static void userWait() throws InterruptedException
    {
        run.append("'Press Enter to Continue'");
        run.getString();
    }
    
    public static void printArmor() {
    	run.output.setText("");
    	run.append("===============================ARMOR======================================================================\n\n",Color.WHITE,30,false);
    	for(int i = 0;i<armor.length;i++) {
    		run.append("[" + (i+1) + "] ",Color.WHITE,25,false);
    		if(armor[i] != null) {
    			armor[i].print();
    			if(i == equippedArmor)
    				run.append(" [EQUIPPED]",Color.ORANGE,25,true);
    		} else 
    			run.append("EMPTY",Color.WHITE,25,false);
    		run.append("\n",Color.WHITE,30,false);
    	}
    	run.append("\n===================================================================================================\n",Color.WHITE,30,false);
    }
    
    public static void printWeapon() {
    	run.output.setText("");
    	run.append("==============================WEAPONS==================================================\n\n",Color.WHITE,30,false);
    	for(int i = 0;i<weapons.length;i++) {
    		run.append("[" + (i+1) + "] ",Color.WHITE,25,false);
    		if(weapons[i] != null) {
    			run.append(weapons[i].name,Color.WHITE,25,false);
    			run.append(" [dmg: " + weapons[i].dmg + "][crit: " + weapons[i].crit + "][" + weapons[i].aName + "][value: "+weapons[i].price+" gold]");
    			if(i == equippedWeapon)
    				run.append(" [EQUIPPED]",Color.ORANGE,25,true);
    		} else 
    			run.append("EMPTY",Color.WHITE,25,false);
    		run.append("\n",Color.WHITE,30,false);
    	}
    	run.append("\n===================================================================================================\n",Color.WHITE,30,false);
    	
    	
    }
    
    public static void switchWeapon() throws InterruptedException {
    		printWeapon();
    		run.append("\n'Enter slot number to equip or [4] to back'");
        	int choice = run.getInt();
        	if(choice == 1 || choice == 2 || choice == 3) {
        		if(choice-1 == equippedWeapon)
        			return;
        		equippedWeapon = choice-1;
        		if(weapons[equippedWeapon] == null) {
        			equippedWeapon = 0;
        			return;
        		}
        	}
        	if(choice > 3 || choice < 1) {
        		MainFightPanel.clearDisplay();
        		RPGRunner.output.setText("");
        		return;
        	}
        	RPGRunner.append("\nYou equipped " + weapons[equippedWeapon].name + "\n");
        	Story.userWait();
        	RPGRunner.output.setText("");
    	if(RPGRunner.battle == true && armor[equippedArmor].timeScore() < 3) {
    		RPGRunner.pTurn = false;
    		RPGRunner.eTurn = true;
    	}
    }
    
    public static void switchArmor() throws InterruptedException {
    		printArmor();
    		run.append("\n'Enter slot number to equip or [4] to back'");
        	int choice = run.getInt();
        	if(choice == 1 || choice == 2 || choice == 3) {
        		if(choice-1 == equippedArmor)
        			return;
        		equippedArmor = choice-1;
        		if(armor[equippedArmor] == null) {
        			equippedArmor = 0;
        			return;
        		}
        	}
        	if(choice > 3 || choice < 1) {
        		MainFightPanel.clearDisplay();
        		RPGRunner.output.setText("");
        		return;
        	}
        	RPGRunner.append("\nYou equipped " + armor[equippedArmor].name + "\n");
        	Story.userWait();
        	RPGRunner.output.setText("");
        	if(RPGRunner.battle == true && armor[equippedArmor].timeScore() < 6) {
        		RPGRunner.pTurn = false;
        		RPGRunner.eTurn = true;
        	}
        	
    }
    
    public static boolean checkAbility(Class<? extends Special> a) {
    	for(Special s : abilities)
    		if(s.getClass().equals(a))
    			return true;
    	return false;
    }
    
    public static boolean checkWeapon(String n) {
    	for(WeaponManager w : weapons)
    		if(w.name.equals(n))
    			return true;
    	return false;
    }
    
    public static void addArmor(ArmorManager a) throws InterruptedException {
    	int choice = 0;
    	run.getReset();
    	for(int i = 0;i<armor.length;i++) {
    		if(armor[i] == null) {
    			armor[i] = a;
    			return;
    		}
    	}
    	checkReplace = true;
    	printArmor();
    	run.getReset();
    	run.append("\n'Enter slot number to replace or [4] to discard " + a.name+"'");
    	choice = run.getInt();
    	if(choice == 1 || choice == 2 || choice == 3) {
    		armor[choice-1] = a;
    	}
		replacedArmor = choice-1;
    }
    
    public static int getShockR() {
    	return (armor[equippedArmor].shockR + baseShockR);
    }
    
    public static int getFireR() {
    	return (armor[equippedArmor].fireR + baseFireR);
    }
    
    public static int getIceR() {
    	return (armor[equippedArmor].iceR + baseIceR);
    }
    
    public static int getDef() {
    	return baseDef + armor[equippedArmor].def;
    }
    
    public static int getDmg() {
    	return weapons[equippedWeapon].dmg + baseDmg;
    }
    
    public static  void addWeapon(WeaponManager w) throws InterruptedException {
    	int choice = 0;
    	run.getReset();
    	for(int i = 0;i<weapons.length;i++) {
    		if(weapons[i] == null) {
    			weapons[i] = w;
    			return;
    		}
    	}
    	checkReplace = true;
    	printWeapon();
    	run.getReset();
    	run.append("\n'Enter slot number to replace or [4] to discard " + w.name +"'");
    	choice = run.getInt();
    	if(choice == 1 || choice == 2 || choice == 3) {
    		if(!(weapons[choice-1].name.equals("Fists")))
    			BackPack.Manager.remove("Weapon: " + weapons[choice-1].name, 1);
    		weapons[choice-1] = w;
    	}
    	replacedWeapon = choice-1;
    	if(choice >= 4 || choice <= 0)
    	  if(!(weapons[choice-1].name.equals("Fists")))
    		BackPack.Manager.remove("Weapon: " + w.name, 1);
    	
    }
    
    public static void equipWeapon() throws InterruptedException{
    	run.getReset();
    	if(replacedWeapon >= 3 || replacedWeapon < 0) {
    		replacedWeapon = 0;
    		return;
    	}
    		
    	RPGRunner.append("\nPress [e] to equip ");
    	String choice = run.getString();
    	if(choice.equals("e")) {
    		System.out.println("\nEquipping");
    		for(int i = 0;i<weapons.length;i++) {
    			if(weapons[i] == null) {
    				equippedWeapon = i-1;
    				RPGRunner.append("\nYou equipped " + weapons[equippedWeapon].name);
    				Story.pause(1500);
    				return;
    			}
    		}
        	equippedWeapon = replacedWeapon;
        	RPGRunner.append("\nYou equipped " + weapons[equippedWeapon].name);
        	Story.pause(1500);
        	return;
    	}
    	else {
    		System.out.println("\nEquipped Weapon =" + equippedWeapon);
    		return;
    	}

    	
    }
    
    public static void equipArmor() throws InterruptedException{
    	run.getReset();
    	if(replacedArmor >= 3 || replacedArmor < 0) {
    		replacedArmor = 0;
    		return;
    	}
    	RPGRunner.append("\nPress [e] to equip");
    	String choice = run.getString();
    	if(choice.equals("e")) {
    		for(int i = 0;i<armor.length;i++) {
    			if(armor[i] == null) {
    				equippedArmor = i-1;
    				run.append("\nYou equipped " + armor[equippedArmor].name);
    				return;
    			}
    		}
    		equippedArmor = replacedArmor;
    	}
    	else {
    		return;
    	}
    	
    }
}

    
