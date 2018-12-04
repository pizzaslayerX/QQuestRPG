package monsters;

import gameplay.LootScreen;

public class DwarfMaster extends MonsterManager
{
   
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    
    private String ssong = "RowdyRumble.wav";
    private int stotal = 0;
    private int[] striggerRate = {0,0};
    private String[] satkMsg = {""};
    private int[] sdmg = {0};
    private boolean[] suseTurn = {true};
    private int[] suseCounter = {0};
    private String[] ssound = {""};
    private int[] sstatusEffect = {0};
    private String[] movess = {"Employs powerful physical attacks."};
	private String descs = "A tall, muscular, and imposing man. The hostility and oppression present in this foe easily explains how the dwarves are kept in their position of servitude.";
    public DwarfMaster() {
    	super("Whips","Bullies","Smacks");
    	setStats();
    	summon();
    	name = "Dwarf Slavemaster";
    	smart = false;
    	iceR = 33;
    	pic = "DwarfMaster.jpg";
    	maxHealth = health;
    	id=10;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evade = 5;
            crit = 10;
            def = 20;
            health = 220;
            attack = 12;
        }
        else if(med == true)
        {
            evade = 5;
            crit = 10;
            def = 20;
            health = 250;
            attack = 13;
        }
        
        else if(hard == true)
        {
            evade = 5;
            crit = 11;
            def = 20;
            health = 278;
            attack = 14;
        }    
        }
    
    private void summon()
    {
        moveSet(stotal,striggerRate,satkMsg,sdmg,suseTurn,ssound,sstatusEffect,suseCounter,ssong);
    }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 50 + (int)(Math.random() * 20);
        gameplay.LootScreen.setGold(gold);
        int exp = 30 + (int)(Math.random() * 16);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 34)
            consumables.HighPotion.lootItem();
        threshold = (int)(Math.random() * 101);
        if(threshold < 16)
        {
        	threshold = (int)(Math.random() * 101);
        	if(threshold < 65)
              armor.Quartermaster.lootArmor();
        	else if(threshold >= 65 && threshold < 101)
        	{
        		LootScreen.setModifier("Insulated");
        		armor.Quartermaster.lootArmor();
        	}
        	
        }
        threshold = (int)(Math.random() * 101);
    	if(threshold < 26)
    		weapon.Whip.lootWeapon();
    		else
    			weapon.Pickaxe.lootWeapon();
    	threshold = (int)(Math.random() * 101);
    	if(threshold < 10)
    		weapon.Brutalizer.lootWeapon();
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


