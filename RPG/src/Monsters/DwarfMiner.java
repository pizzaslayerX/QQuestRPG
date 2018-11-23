package Monsters;

import Main.LootScreen;

public class DwarfMiner extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    // instance variables - replace the example below with your own
    private int evades;
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Dwarf Miner";
    private boolean smarts = false;

    private String songs = "RowdyRumble.wav";
    private int totals = 0;
    private int[] triggerRates = {0,0};
    private String[] atkMsgs = {""};
    private int[] dmgs = {0};
    private boolean[] useTurns = {true};
    private int[] useCounters = {0};
    private String[] sounds = {""};
   // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    private int[] statusEffects = {0};
	private int fireRs;
	private int iceRs = 33;
	private int shockRs;
	private String pics = "Dwarf.png";
	private String[] movess = {"Specializes in physical attacks.","Attacks in groups."};
	private String descs = "A sad individual who has lost the will to fight back against his oppressors. No amount of talking will prevent him from carrying out his mission of eliminating intruders.";
	public DwarfMiner() {
		super();
		setStats();
		summon();
		maxHealth = health;
		id=11;
		moves = movess;
		desc = descs;
	}
	
     private void setStats()
    {
        if(easy == true)
        	
        {
            evades = 10;
            crits = 10;
            defs = 25;
            healths = 170;
            attacks= 9;
        }
        else if(med == true)
        {
            evades = 15;
            crits = 10;
            defs = 25;
            healths = 175;
            attacks = 9;
        }
        
        else if(hard == true)
        {
            evades = 15;
            crits = 11;
            defs = 25;
            healths = 182;
            attacks = 10;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Flails its arms at", "Hits","Yells at",crits,evades,fireRs,iceRs,shockRs,pics);
        moveSet(totals,triggerRates,atkMsgs,dmgs,useTurns,sounds,statusEffects,useCounters,songs);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 10 + (int)(Math.random() * 10);
        Main.LootScreen.setGold(gold);
        int exp = 20 + (int)(Math.random() * 5);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 80)
            Main.LootScreen.setLootMisc("Iron Bar",1);
        threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Item.Potion.lootItem();
        threshold = (int)(Math.random() * 101);
        if(threshold < 16)
        {
        	threshold = (int)(Math.random() * 101);
        	if(threshold < 51)
              Armor.MiningHelmet.lootArmor();
        	else if(threshold >= 51 && threshold < 76)
        	{
        		LootScreen.setModifier("Chilled");
        		Armor.MiningHelmet.lootArmor();
        		
        	}
        	else if(threshold >= 76 && threshold < 101)
        	{
        		LootScreen.setModifier("Insulated");
        		Armor.MiningHelmet.lootArmor();
        		
        	}
        	
        }
        threshold = (int)(Math.random() * 101);
    	if(threshold < 10)
    		Main.LootScreen.setLootMisc("Magic Powder",1);
        threshold = (int)(Math.random() * 101);
        if(threshold < 20)
            Weapon.Pickaxe.lootWeapon();
        
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


